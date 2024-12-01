package com.example.project.presentation.view.screens.aboutApp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class AboutAppScreen:Screen {
    @Composable
    override fun Content() {
        Text(text = "About App Screen")
    }
}