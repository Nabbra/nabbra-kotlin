package com.example.project.presentation.view.screens.help

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class HelpScreen:Screen {
    @Composable
    override fun Content() {
        Text(text = "Help Screen")
    }
}