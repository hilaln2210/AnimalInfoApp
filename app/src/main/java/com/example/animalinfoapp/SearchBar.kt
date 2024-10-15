// File: SearchBar.kt

package com.example.animalinfoapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ViewModule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    isEnglish: Boolean,
    onLanguageToggle: () -> Unit,
    onViewToggle: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Search icon
        Icon(
            Icons.Default.Search,
            contentDescription = "Search",
            modifier = Modifier.padding(start = 16.dp)
        )
        // Search text field
        TextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = { Text(if (isEnglish) "Search animals" else "חפש חיות") },
            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        // View toggle button
        IconButton(onClick = onViewToggle) {
            Icon(
                imageVector = Icons.Default.ViewModule,
                contentDescription = if (isEnglish) "Toggle view" else "שנה תצוגה"
            )
        }
        // Language toggle button
        Button(
            onClick = onLanguageToggle,
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Text(if (isEnglish) "עברית" else "English")
        }
    }
}