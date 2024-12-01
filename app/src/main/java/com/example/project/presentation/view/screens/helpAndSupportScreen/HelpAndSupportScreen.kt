package com.example.project.presentation.view.screens.helpAndSupportScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class HelpAndSupportScreen:Screen {
    @Composable
    override fun Content() {
        Text(text = "Help and Support")
    }
}