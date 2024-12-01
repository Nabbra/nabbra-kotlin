package com.example.project.presentation.view.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.min
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.project.R
import com.example.project.presentation.view.screens.onboarding.OnBoardingScreen
import com.example.project.ui.theme.MidNightBlue
import kotlinx.coroutines.delay

class SplashScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        // Responsive Box to handle different screen sizes
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MidNightBlue),
            contentAlignment = Alignment.Center
        ) {
            // Using BoxWithConstraints for responsive design
            BoxWithConstraints(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                val imageSize = min(maxWidth, maxHeight) * 0.6f // 40% of the smaller dimension

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Splash Logo",
                    modifier = Modifier.size(imageSize), // Dynamically size the image
                    contentScale = ContentScale.Fit
                )
            }
        }

        // Navigate to OnboardingScreen after a delay
        LaunchedEffect(Unit) {
            delay(3000) // Wait for 3 seconds
            navigator.replace(OnBoardingScreen()) // Replace SplashScreen with OnboardingScreen
        }
    }
}
