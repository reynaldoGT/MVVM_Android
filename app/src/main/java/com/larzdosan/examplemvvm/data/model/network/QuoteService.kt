package com.larzdosan.examplemvvm.data.model.network

import com.larzdosan.examplemvvm.core.RetrofitHelper
import com.larzdosan.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = RetrofitHelper.getRetroFit()

    suspend fun getQuote(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}