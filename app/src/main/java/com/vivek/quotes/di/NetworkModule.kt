package com.vivek.quotes.di

import com.vivek.quotes.data.api.QuotesAPI
import com.vivek.quotes.data.repository.QuotesRepositoryImpl
import com.vivek.quotes.domain.repository.QuotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io")
            .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Singleton
    @Provides
    fun provideQuoteAPI(retrofit: Retrofit): QuotesAPI {
        return retrofit.create(QuotesAPI::class.java)
    }
}