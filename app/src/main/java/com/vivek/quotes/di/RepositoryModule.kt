package com.vivek.quotes.di

import com.vivek.quotes.data.repository.QuotesRepositoryImpl
import com.vivek.quotes.domain.repository.QuotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindQuotesRepository(quotesRepositoryImpl: QuotesRepositoryImpl): QuotesRepository
}