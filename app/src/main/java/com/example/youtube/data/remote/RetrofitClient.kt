package com.example.youtube.data.remote

import com.example.youtube.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object{
        fun create():ApiService{
            val interceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttClient = OkHttpClient.Builder()
                .readTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .writeTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build()

           val retrofit = Retrofit.Builder()
               .baseUrl(BuildConfig.BASE_URL)
               .client(okHttClient)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}