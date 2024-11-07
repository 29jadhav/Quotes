package com.vivek.quotes.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.quotes.domain.models.QuoteListItem
import com.vivek.quotes.domain.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val quotesRepository: QuotesRepository,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private val _quotes = MutableStateFlow<List<QuoteListItem>>(emptyList())
    val quotes: StateFlow<List<QuoteListItem>>
        get() = _quotes

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category")
            Log.d("TAG", "Category=$category")
            if (category != null) {
                val quotes = quotesRepository.getQuotes(category)
                Log.d("TAG", "quotes of category=$quotes")
                _quotes.emit(quotes)
            }
        }
    }
}