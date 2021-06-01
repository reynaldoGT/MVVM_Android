package com.larzdosan.examplemvvm.domain

import com.larzdosan.examplemvvm.data.model.QuoteModel
import com.larzdosan.examplemvvm.data.model.QuoteProvider
import com.larzdosan.examplemvvm.data.model.QuoteRepository

class GetRandomQuoteUseCase {

    /*private val repository = QuoteRepository()*/

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null;
    }
}