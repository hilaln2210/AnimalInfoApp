// File: AnimalGrid.kt

package com.example.animalinfoapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun AnimalGrid(
    animals: List<AnimalInfo>,
    isEnglish: Boolean,
    onAnimalSelect: (AnimalInfo) -> Unit
) {
    // Create a grid layout for displaying animals
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Iterate through the list of animals and create a grid item for each
        items(animals) { animal ->
            AnimalGridItem(animal, isEnglish, onAnimalSelect)
        }
    }
}