package com.example.dogs_coroutines.data

import com.example.dogs_coroutines.data.mapper.DogMapper.toDog
import com.example.dogs_coroutines.model.Dog

class DogsRepositoryImpl(private val dogFactsApi: DogApi) : DogsRepository {

    override suspend fun getDogFacts(quantity: Int): Dog = dogFactsApi.getDogFacts(quantity).toDog()
}