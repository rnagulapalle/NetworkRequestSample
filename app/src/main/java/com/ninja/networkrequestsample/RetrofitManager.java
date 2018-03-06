package com.ninja.networkrequestsample;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 3/6/2018.
 * Description :
 */

public class RetrofitManager {

    private static OkHttpClient getOkHttpClient(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(provideLogger()).build();
        return client;
    }

    private static HttpLoggingInterceptor provideLogger() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return interceptor;
    }

    private static Retrofit getRetrofit(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static <T>T getService(Class<T> service){
       return getRetrofit("https://api.github.com").create(service);
    }
}
