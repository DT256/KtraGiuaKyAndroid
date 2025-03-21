package com.giuaky.ktragiuakyandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.giuaky.ktragiuakyandroid.adapter.CategoryAdapter;
import com.giuaky.ktragiuakyandroid.adapter.ProductAdapter;
import com.giuaky.ktragiuakyandroid.dto.ProductResponse;
import com.giuaky.ktragiuakyandroid.model.ProductModel;
import com.giuaky.ktragiuakyandroid.service.ProductAPIService;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcProduct;
    RecyclerView rcCategories;
    private int page = 0;
    private boolean isLoading = false;
    private boolean hasMoreData = true;
    private String category;

    ProductAdapter productAdapter;
    CategoryAdapter categoryAdapter;
    ProductAPIService apiProductService;
    List<ProductModel> productList;
    List<CategoryModel> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_Container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize Product RecyclerView
        rcProduct = findViewById(R.id.rvLastProducts);
        productAdapter = new ProductAdapter(this, productList);
        rcProduct.setLayoutManager(new LinearLayoutManager(this));
        rcProduct.setAdapter(productAdapter);

        // Initialize Category RecyclerView
        rcCategories = findViewById(R.id.rv_categories);
        categoryAdapter = new CategoryAdapter(this, categoryList);
        rcCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rcCategories.setAdapter(categoryAdapter);

        // Setup scroll listener for products
        rcProduct.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int lastVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
                int totalItemCount = layoutManager.getItemCount();

                if (!isLoading && hasMoreData && lastVisibleItemPosition == totalItemCount - 1) {
                    loadMoreProducts();
                }
            }
        });

        loadMoreProducts();
    }

    /*
     * @Author 22110422 - Bui Duc Thang
     * */
    private void loadMoreProducts() {
        isLoading = true;
        apiProductService = RetrofitClient.getRetrofit().create(ProductAPIService.class);
        apiProductService.getProducts(category,page,9).enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    productList.addAll(response.body().getData());
                    productAdapter.notifyDataSetChanged();
                    page++;
                    hasMoreData = page < response.body().getTotalPages();
                }
                isLoading = false;
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Log.e("API Error", t.getMessage());
                isLoading = false;
            }
        });
    }
}