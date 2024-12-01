package com.example.project.presentation.view.screens.advancedSettings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class AdvancedSettings:Screen {
    @Composable
    override fun Content() {
        Text(text = "Advanced Settings")
    }
}