package com.vivek.quotes.data.repository

import com.vivek.quotes.data.api.QuotesAPI
import com.vivek.quotes.domain.models.QuoteListItem
import com.vivek.quotes.domain.repository.QuotesRepository
import javax.inject.Inject

class QuotesRepositoryImpl @Inject constructor(private val quotesAPI: QuotesAPI) :
    QuotesRepository {


    override suspend fun getQuotes(category: String): List<QuoteListItem> {
        val result = quotesAPI.getQuotes("quotes[?(@.category==\"$category\")]")

        if (result.isSuccessful && result.body() != null) {
            return result.body()!!
        }
        return emptyList()
    }

    override suspend fun getCategories(): List<String> {
        val result = quotesAPI.getCategories()
        if (result.isSuccessful && result.body() != null) {
            return result.body()!!
        }
        return emptyList()
    }
}