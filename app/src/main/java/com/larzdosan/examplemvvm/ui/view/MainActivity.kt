package com.larzdosan.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.larzdosan.examplemvvm.databinding.ActivityMainBinding
import com.larzdosan.examplemvvm.ui.view.viewModel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQoute.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })
        quoteViewModel.isLoading.observe(this, {
            binding.progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}