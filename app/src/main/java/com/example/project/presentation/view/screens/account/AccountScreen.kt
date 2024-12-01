package com.example.project.presentation.view.screens.account

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class AccountScreen:Screen {
    @Composable
    override fun Content() {
        Text(text = "Account Screen")
    }
}