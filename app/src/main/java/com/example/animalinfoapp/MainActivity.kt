// File: MainActivity.kt

package com.example.animalinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Typography
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalInfoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var showSplash by remember { mutableStateOf(true) }

                    if (showSplash) {
                        // Show splash screen
                        SplashScreen {
                            showSplash = false
                        }
                    } else {
                        // Show main app content
                        AnimalInfoApp()
                    }
                }
            }
        }
    }
}

@Composable
fun AnimalInfoTheme(content: @Composable () -> Unit) {
    // Set up the app theme
    MaterialTheme(
        colorScheme = dynamicLightColorScheme(LocalContext.current),
        typography = Typography(),
        content = content
    )
}