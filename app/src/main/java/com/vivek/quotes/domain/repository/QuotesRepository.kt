package com.vivek.quotes.domain.repository

import com.vivek.quotes.domain.models.QuoteListItem

interface QuotesRepository {

    suspend fun getQuotes(category: String): List<QuoteListItem>

    suspend fun getCategories(): List<String>
}