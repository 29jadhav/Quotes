package com.vivek.quotes.data.api

import com.vivek.quotes.domain.models.QuoteListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface QuotesAPI {
    @GET("v3/b/6704eccdacd3cb34a89332f8?meta=false")
    suspend fun getQuotes(@Header("X-JSON-Path") category: String): Response<List<QuoteListItem>>

    @GET("v3/b/6704eccdacd3cb34a89332f8?meta=false")
    @Headers("X-JSON-Path: quotes..category")
    suspend fun getCategories(): Response<List<String>>
}