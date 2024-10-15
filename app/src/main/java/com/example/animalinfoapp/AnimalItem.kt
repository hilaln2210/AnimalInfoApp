// File: AnimalItem.kt

package com.example.animalinfoapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun AnimalItem(animal: AnimalInfo, isEnglish: Boolean, onSelect: (AnimalInfo) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect(animal) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Display animal image
            AsyncImage(
                model = animal.imageUrl,
                contentDescription = if (isEnglish) animal.englishName else animal.hebrewName,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                // Display animal name
                Text(
                    text = if (isEnglish) animal.englishName else animal.hebrewName,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                // Display animal category
                Text(
                    text = if (isEnglish) animal.englishcategory else animal.hebrewcategory,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}