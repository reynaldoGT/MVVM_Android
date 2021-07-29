package com.larzdosan.examplemvvm.domain

import com.larzdosan.examplemvvm.data.model.QuoteModel
import com.larzdosan.examplemvvm.data.model.QuoteProvider
import com.larzdosan.examplemvvm.data.model.QuoteRepository
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteProvider: QuoteProvider
) {

    /*private val repository = QuoteRepository()*/

    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null;
    }
}