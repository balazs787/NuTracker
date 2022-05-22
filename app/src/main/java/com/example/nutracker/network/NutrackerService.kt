package com.example.nutracker.network

import com.example.nutracker.model.Fruit
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import com.skydoves.sandwich.ApiResponse

interface NutrackerService {
    @GET("fruit/all")
    fun getFruits(): Call<List<Fruit>>

    @GET("fruit/{name}")
    fun getFruit(@Path("name") name : String?): ApiResponse<ResponseBody>

    @PUT("fruit/{name}")
    fun updateFruit(@Path("name") name: String?, @Body fruit: Fruit): ApiResponse<ResponseBody>

    @POST("fruit")
    fun createFruit(@Body fruit: Fruit): ApiResponse<ResponseBody>

    @DELETE("fruit/{name}")
    fun deleteFruit(@Path("name") name: String?): ApiResponse<ResponseBody>
}