package com.vivek.quotes.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vivek.quotes.presentation.viewmodel.QuotesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotesByCategoryScreen(category: String) {
    val quotesViewModel: QuotesViewModel = hiltViewModel()
    val quotes = quotesViewModel.quotes.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = { Text(text = category) }, modifier = Modifier.shadow(5.dp))
    }) {

        LazyColumn(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            items(quotes.value) { quote ->
                QuoteItem(quote.quote)

            }
        }
    }

}

@Composable
fun QuoteItem(quote: String) {
    Card(border = BorderStroke(1.dp, Color.Red), modifier = Modifier.padding(16.dp)) {
        Text(
            text = quote,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.titleMedium
        )
    }
}