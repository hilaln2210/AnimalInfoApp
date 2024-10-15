// File: ShareUtils.kt

package com.example.animalinfoapp

import android.content.Context
import android.content.Intent

fun shareAnimalInfo(context: Context, animal: AnimalInfo, isEnglish: Boolean) {
    // Prepare the text to be shared based on the selected language
    val shareText = if (isEnglish) {
        "Animal Info: ${animal.englishName}\n${animal.englishInfo}\n\nImage: ${animal.imageUrl}"
    } else {
        "מידע על חיה: ${animal.hebrewName}\n${animal.hebrewInfo}\n\nתמונה: ${animal.imageUrl}"
    }

    // Create an intent for sharing
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, shareText)
    }

    // Launch the share dialog
    context.startActivity(Intent.createChooser(shareIntent, if (isEnglish) "Share animal info" else "שתף מידע על חיה"))
}