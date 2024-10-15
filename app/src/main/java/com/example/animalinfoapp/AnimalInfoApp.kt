// File: AnimalInfoApp.kt

package com.example.animalinfoapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalInfoApp(viewModel: AnimalViewModel = viewModel()) {
    // State variables
    var isEnglish by remember { mutableStateOf(viewModel.isEnglish) }
    var searchQuery by remember { mutableStateOf(viewModel.searchQuery) }
    var selectedAnimal by remember { mutableStateOf<AnimalInfo?>(null) }
    var showAddContributionDialog by remember { mutableStateOf(false) }
    var isGridView by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp).weight(1f)) {
            // App title
            Text(
                text = if (isEnglish) "Animal Encyclopedia" else "אנציקלופדיית חיות",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Search bar
            SearchBar(
                query = searchQuery,
                onQueryChange = {
                    searchQuery = it
                    viewModel.updateSearchQuery(it)
                },
                isEnglish = isEnglish,
                onLanguageToggle = {
                    isEnglish = !isEnglish
                    viewModel.toggleLanguage()
                },
                onViewToggle = { isGridView = !isGridView }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Category selector
            CategorySelector(viewModel, isEnglish)

            Spacer(modifier = Modifier.height(16.dp))

            // Display either the animal list/grid or the details of a selected animal
            if (selectedAnimal == null) {
                if (isGridView) {
                    AnimalGrid(
                        animals = viewModel.getFilteredAnimals(),
                        isEnglish = isEnglish,
                        onAnimalSelect = {
                            selectedAnimal = it
                            viewModel.selectAnimal(it)
                        }
                    )
                } else {
                    AnimalList(
                        animals = viewModel.getFilteredAnimals(),
                        isEnglish = isEnglish,
                        onAnimalSelect = {
                            selectedAnimal = it
                            viewModel.selectAnimal(it)
                        }
                    )
                }
            } else {
                AnimalDetails(
                    animal = selectedAnimal!!,
                    isEnglish = isEnglish,
                    context = context,
                    onAddContribution = { showAddContributionDialog = true },
                    onBack = { selectedAnimal = null }
                )
            }
        }
    }

    // Show the add contribution dialog when necessary
    if (showAddContributionDialog) {
        AddContributionDialog(
            onDismiss = { showAddContributionDialog = false },
            onContribute = { contribution ->
                selectedAnimal?.let {
                    viewModel.addContribution(if (isEnglish) it.englishName else it.hebrewName, contribution)
                }
                showAddContributionDialog = false
            }
        )
    }
}