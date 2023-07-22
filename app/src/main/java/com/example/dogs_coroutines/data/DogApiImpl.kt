package com.example.dogs_coroutines.data

import com.example.dogs_coroutines.data.model.Result
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.RuntimeException
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class DogApiImpl : DogApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val dogService = retrofit.create(DogService::class.java)

    override suspend fun getDogFacts(quantity: Int): Result = suspendCoroutine {
        dogService.getDogFacts(quantity).execute().body()?.let { result ->
            it.resume(result)
        } ?: it.resumeWithException(RuntimeException())
    }
}