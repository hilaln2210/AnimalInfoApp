// File: CategorySelector.kt

package com.example.animalinfoapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun CategorySelector(viewModel: AnimalViewModel, isEnglish: Boolean) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Add "All" category option
        item {
            FilterChip(
                selected = viewModel.selectedCategory == null,
                onClick = { viewModel.selectCategory(null) },
                label = { Text(if (isEnglish) "All" else "הכל") }
            )
        }
        // Add filter chips for each category
        items(viewModel.getCategories()) { category ->
            FilterChip(
                selected = viewModel.selectedCategory == category,
                onClick = { viewModel.selectCategory(category) },
                label = { Text(category) }
            )
        }
    }
}