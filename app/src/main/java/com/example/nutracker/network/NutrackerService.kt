package com.example.nutracker.network

import com.example.nutracker.model.Fruit
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface NutrackerService {
    @GET("fruits/all")
    fun getFruits(): Call<List<Fruit>>

    @GET("fruits/{name}")
    fun getFruit(@Path("name") name : String?): Call<ResponseBody>

    @PUT("fruits/{name}")
    fun updateFruit(@Path("name") name: String?, @Body fruit: Fruit): Call<ResponseBody>

    @POST("fruits")
    fun createFruit(@Body fruit: Fruit): Call<ResponseBody>

    @DELETE("fruits/{name}")
    fun deleteFruit(@Path("name") name: String?): Call<ResponseBody>
}