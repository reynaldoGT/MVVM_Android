package com.larzdosan.examplemvvm.data.model

import com.larzdosan.examplemvvm.data.model.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
) {
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuote()
        quoteProvider.quotes = response
        return response
    }
}