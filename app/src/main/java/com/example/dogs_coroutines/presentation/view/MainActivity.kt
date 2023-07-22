package com.example.dogs_coroutines.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dogs_coroutines.databinding.ActivityMainBinding
import com.example.dogs_coroutines.presentation.viewmodel.MainActivityViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }
    private lateinit var binding: ActivityMainBinding
    private val scope = CoroutineScope(Dispatchers.IO)
    private var dogJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            dogJob?.cancel()
            dogJob = scope.launch {
                val dogUrl = viewModel.getDogFacts().imageURL
                withContext(Dispatchers.Main) {
                    Picasso.get()
                        .load(dogUrl)
                        .into(binding.image)
                }
            }
        }
    }
}