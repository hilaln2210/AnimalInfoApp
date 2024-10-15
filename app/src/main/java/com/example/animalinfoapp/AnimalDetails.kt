// File: AnimalDetails.kt

package com.example.animalinfoapp

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun AnimalDetails(
    animal: AnimalInfo,
    isEnglish: Boolean,
    context: Context,
    onAddContribution: () -> Unit,
    onBack: () -> Unit
) {
    Column {
        // Back button
        IconButton(onClick = onBack) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }

        // Animal image
        AsyncImage(
            model = animal.imageUrl,
            contentDescription = if (isEnglish) animal.englishName else animal.hebrewName,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Animal name
        Text(
            text = if (isEnglish) animal.englishName else animal.hebrewName,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // Animal information
        Text(
            text = if (isEnglish) animal.englishInfo else animal.hebrewInfo,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Button to add new information
            Button(onClick = onAddContribution) {
                Text(if (isEnglish) "Add Information" else "הוסף מידע")
            }
            // Button to share animal information
            Button(onClick = { shareAnimalInfo(context, animal, isEnglish) }) {
                Text(if (isEnglish) "Share" else "שתף")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Section for user contributions
        Text(
            text = if (isEnglish) "More information from users:" else "מידע נוסף מהמשתמשים:",
            style = MaterialTheme.typography.titleLarge
        )
        LazyColumn {
            items(animal.userContributions) { contribution ->
                Text(contribution)
            }
        }
    }
}