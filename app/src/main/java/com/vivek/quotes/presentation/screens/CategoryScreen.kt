package com.vivek.quotes.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vivek.quotes.R
import com.vivek.quotes.presentation.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(onClick: (category: String) -> Unit) {
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val categories = categoryViewModel.categories.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        items(categories.value.distinct()) { category ->
            CategoryItem(category, onClick)
        }
    }
}

@Composable
fun CategoryItem(category: String, onClick: (category: String) -> Unit) {

    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(160.dp)
            .clickable {
                onClick(category)
            }
            .clip(
                shape = RoundedCornerShape(8.dp)
            )
            .paint(
                painter = painterResource(id = R.drawable.bg_category),
                contentScale = ContentScale.Crop
            )
            .shadow(elevation = 4.dp),

        //.aspectRatio(1f),
        contentAlignment = Alignment.BottomCenter,

        ) {
        Text(
            text = category,
            fontSize = 18.sp,
            modifier = Modifier.padding(4.dp, 16.dp),
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
    }
}