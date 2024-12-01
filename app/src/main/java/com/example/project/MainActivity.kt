package com.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.navigator.Navigator
import com.example.project.presentation.view.screens.home.step1.HomeScreenStep1
import com.example.project.presentation.view.screens.home.step2.HomeScreenStep2
import com.example.project.presentation.view.screens.home.step3.HomeScreenStep3
import com.example.project.presentation.view.screens.home.step4.HomeScreenStep4
import com.example.project.presentation.view.screens.home.step5.HomeScreenStep5
import com.example.project.presentation.view.screens.home.step6.HomeScreenStep6
import com.example.project.presentation.view.screens.home.step7.HomeScreenStep7
import com.example.project.presentation.view.screens.onboarding.OnBoardingScreen
import com.example.project.presentation.view.screens.profile.ProfileScreen
import com.example.project.presentation.view.screens.splash.SplashScreen
import com.example.project.ui.theme.ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                Navigator (screen = OnBoardingScreen())
            }
        }
    }
}