package com.vivek.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vivek.quotes.presentation.screens.CategoryScreen
import com.vivek.quotes.presentation.screens.QuotesByCategoryScreen
import com.vivek.quotes.ui.theme.QuotesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()
        setContent {
            QuotesTheme {
                App()
            }
        }
    }
}


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable(route = "category") {
            CategoryScreen { category ->
                navController.navigate(route = "quoteListScreen/$category")

            }
        }
        composable(
            route = "quoteListScreen/{category}",
            arguments = listOf(navArgument(name = "category") {
                type = NavType.StringType
            })
        ) {
            val category = it.arguments?.getString("category")
            if (category != null)
                QuotesByCategoryScreen(category = category)
        }

    }
}

