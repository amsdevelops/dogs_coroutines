package com.example.dogs_coroutines.data

import com.example.dogs_coroutines.data.model.Result

interface DogApi {
    suspend fun getDogFacts(quantity: Int): Result
}