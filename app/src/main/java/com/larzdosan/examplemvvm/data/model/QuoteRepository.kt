package com.larzdosan.examplemvvm.data.model

import com.larzdosan.examplemvvm.data.model.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuote()
        QuoteProvider.quotes = response
        return response
    }
}