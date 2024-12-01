package com.example.project.presentation.view.screens.savedData

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class SavedDataScreen:Screen {
    @Composable
    override fun Content() {
        Text(text = "Saved Data Screen")
    }
}