package com.larzdosan.examplemvvm.domain

import com.larzdosan.examplemvvm.data.model.QuoteModel
import com.larzdosan.examplemvvm.data.model.QuoteRepository

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>?  =  repository.getAllQuotes()
}