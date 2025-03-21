package com.giuaky.ktragiuakyandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide; // Import Glide
import com.giuaky.ktragiuakyandroid.adapter.CategoryAdapter;
import com.giuaky.ktragiuakyandroid.adapter.ProductAdapter;
import com.giuaky.ktragiuakyandroid.dto.ProductResponse;
import com.giuaky.ktragiuakyandroid.model.CategoryModel;
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
    private int page = 1;
    private boolean isLoading = false;
    private boolean hasMoreData = true;
    private String category;

    ProductAdapter productAdapter;
    CategoryAdapter categoryAdapter;
    ProductAPIService apiProductService;
    List<ProductModel> productList = new ArrayList<>();
    List<CategoryModel> categoryList = new ArrayList<>();

    // Thêm các view để hiển thị fullName và urlAvatar
    TextView tvFullName;
    ImageView ivAvatar;

    SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "UserPrefs"; // Tên file SharedPreferences

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Initialize Product RecyclerView
        rcProduct = findViewById(R.id.rvLastProducts);
        productAdapter = new ProductAdapter(this, productList);
        rcProduct.setLayoutManager(new GridLayoutManager(this, 2)); // 2 cột
        rcProduct.setAdapter(productAdapter);

        // Initialize Category RecyclerView
        rcCategories = findViewById(R.id.rv_categories);
        categoryAdapter = new CategoryAdapter(this, categoryList);
        rcCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rcCategories.setAdapter(categoryAdapter);

        // Initialize views for fullName and avatar
        tvFullName = findViewById(R.id.tv_user_name); // Đảm bảo bạn có TextView này trong layout
        ivAvatar = findViewById(R.id.iv_user_avatar); // Đảm bảo bạn có ImageView này trong layout

        // Load fullName và urlAvatar từ SharedPreferences
        loadUserInfo();

        // Setup scroll listener for products
        rcProduct.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                int lastVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
                int totalItemCount = layoutManager.getItemCount();

                if (!isLoading && hasMoreData && lastVisibleItemPosition >= totalItemCount - 2) {
                    loadMoreProducts();
                    Log.d("ccc", String.valueOf(page));
                }
            }
        });

        // Load initial data
        loadCategories();
        loadMoreProducts();
    }

    private void loadUserInfo() {
        // Lấy dữ liệu từ SharedPreferences
        String fullName = sharedPreferences.getString("fullName", ""); // Giá trị mặc định là chuỗi rỗng
        String urlAvatar = sharedPreferences.getString("urlAvatar", ""); // Giá trị mặc định là chuỗi rỗng

        // Hiển thị fullName
        if (tvFullName != null) {
            tvFullName.setText(fullName.isEmpty() ? "Chưa có tên" : fullName);
        }

        // Hiển thị avatar nếu có URL
        if (ivAvatar != null && !urlAvatar.isEmpty()) {
            Glide.with(this)
                    .load(urlAvatar)
                    .placeholder(R.drawable.thinh) // Hình ảnh placeholder khi đang load
                    .error(R.drawable.thinh) // Hình ảnh hiển thị nếu load lỗi
                    .into(ivAvatar);
        } else if (ivAvatar != null) {
            ivAvatar.setImageResource(R.drawable.thinh); // Hình ảnh mặc định nếu không có urlAvatar
        }
    }

    private void loadCategories() {
        apiProductService = RetrofitClient.getRetrofit().create(ProductAPIService.class);
        apiProductService.getCategories().enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    categoryList.clear();
                    categoryList.addAll(response.body());
                    categoryAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {
                Log.e("API Error", "Failed to load categories: " + t.getMessage());
            }
        });
    }

    private void loadMoreProducts() {
        isLoading = true;
        apiProductService = RetrofitClient.getRetrofit().create(ProductAPIService.class);
        apiProductService.getProducts(1L, page, 4).enqueue(new Callback<ProductResponse>() {
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