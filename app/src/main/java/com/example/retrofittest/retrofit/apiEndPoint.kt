package com.example.retrofittest.retrofit


import com.example.retrofittest.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface apiEndPoint {

    @GET("data.php")
    fun getData() : Call<MainModel>
}