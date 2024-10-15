// File: AddContributionDialog.kt

package com.example.animalinfoapp

import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun AddContributionDialog(onDismiss: () -> Unit, onContribute: (String) -> Unit) {
    var contributionText by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Information") },
        text = {
            // Text field for entering new information
            OutlinedTextField(
                value = contributionText,
                onValueChange = { contributionText = it },
                label = { Text("Your Information") }
            )
        },
        confirmButton = {
            // Button to confirm and add the information
            Button(onClick = { onContribute(contributionText) }) {
                Text("Add")
            }
        },
        dismissButton = {
            // Button to cancel and close the dialog
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}