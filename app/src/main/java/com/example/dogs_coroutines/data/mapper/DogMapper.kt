package com.example.dogs_coroutines.data.mapper

import com.example.dogs_coroutines.data.model.Result
import com.example.dogs_coroutines.model.Dog

object DogMapper {
    fun Result.toDog() = Dog(this.message)
}