package com.giuaky.ktragiuakyandroid.network;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitClientLogin {
    private static Retrofit retrofit;
    private  static String BASE_URL = "http://172.23.144.1:8080/api/";
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    // đường dẫn API
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
