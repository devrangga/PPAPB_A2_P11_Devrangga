package com.example.retrofittest.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiService {
    val BASE_URL: String = "https://demo.lazday.com/rest-api-sample/"
    val endPoint :apiEndPoint
    get() {
//        Melihat Error
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(apiEndPoint::class.java)
    }
}