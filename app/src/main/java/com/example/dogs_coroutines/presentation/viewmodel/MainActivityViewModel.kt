package com.example.dogs_coroutines.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dogs_coroutines.data.DogApiImpl
import com.example.dogs_coroutines.data.DogsRepositoryImpl
import com.example.dogs_coroutines.model.Dog

class MainActivityViewModel : ViewModel() {

    private val repositoryImpl = DogsRepositoryImpl(DogApiImpl())

    suspend fun getDogFacts(quantity: Int = 10): Dog = repositoryImpl.getDogFacts(quantity)
}