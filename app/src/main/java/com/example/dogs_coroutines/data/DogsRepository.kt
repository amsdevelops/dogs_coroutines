package com.example.dogs_coroutines.data

import com.example.dogs_coroutines.model.Dog

interface DogsRepository {
    suspend fun getDogFacts(quantity: Int): Dog
}