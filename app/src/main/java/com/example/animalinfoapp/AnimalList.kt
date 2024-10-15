// File: AnimalList.kt

package com.example.animalinfoapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun AnimalList(
    animals: List<AnimalInfo>,
    isEnglish: Boolean,
    onAnimalSelect: (AnimalInfo) -> Unit
) {
    // Create a vertical scrollable list of animals
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Iterate through the list of animals and create a list item for each
        items(animals) { animal ->
            AnimalItem(animal, isEnglish, onAnimalSelect)
        }
    }
}