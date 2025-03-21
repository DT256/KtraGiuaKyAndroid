package com.giuaky.ktragiuakyandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.giuaky.ktragiuakyandroid.R;
import com.giuaky.ktragiuakyandroid.model.ProductModel;

import java.util.List;

/*
 * @Author 22110422 - Bui Duc Thang
 * */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    Context context;
    List<ProductModel> array;

    public ProductAdapter(Context context, List<ProductModel> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductModel product = array.get(position);
        holder.tenSp.setText(product.getName());

        // Load ảnh với Glide
        Glide.with(context)
                .load(product.getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return array == null ? 0 : array.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView tenSp;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgProduct);
            tenSp = itemView.findViewById(R.id.txtProductName);

            // Bắt sự kiện click vào item trong RecyclerView
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Bạn đã chọn category: " + tenSp.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}