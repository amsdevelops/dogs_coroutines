package com.example.dogs_coroutines.data

import com.example.dogs_coroutines.data.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface DogService {
    @GET("random")
    fun getDogFacts(@Query("number") quantity : Int): Call<Result>
}