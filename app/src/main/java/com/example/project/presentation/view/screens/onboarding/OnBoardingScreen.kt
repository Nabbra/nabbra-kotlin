package com.example.project.presentation.view.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.project.presentation.view.screens.loginOrRegister.LoginOrRegisterScreen
import com.example.project.ui.theme.LightGray
import com.example.project.ui.theme.MidNightBlue
import com.example.project.ui.theme.inder
import kotlinx.coroutines.launch

class OnBoardingScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val pagerState = rememberPagerState(pageCount = { 2 }) // Total pages (e.g., 2 pages)
        val coroutineScope = rememberCoroutineScope() // Remember coroutine scope for launching coroutines

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MidNightBlue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.wrapContentSize()
                ) { page ->
                    when (page) {
                        0 -> PageContent1() // Content for page 1
                        1 -> PageContent2() // Content for page 2
                    }
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Box(
                modifier = Modifier.padding(top = 25.dp)
            ) {
                PageIndicator(
                    numberOfPages = 2,
                    selectedPage = pagerState.currentPage,
                    defaultRadius = 10.dp,
                    selectedLength = 10.dp,
                    space = 10.dp
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            // The button text changes depending on the current page
            Button(
                onClick = {
                    // Navigate to the next page on click within a coroutine scope
                    coroutineScope.launch {
                        if (pagerState.currentPage < 1) { // Check if it's not the last page
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        } else {
                            navigator.push(LoginOrRegisterScreen())
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGray,
                    contentColor = MidNightBlue
                ),
                shape = RoundedCornerShape(34.dp),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .height(34.dp)
                    .width(115.dp)
            ) {
                Text(
                    text = if (pagerState.currentPage == 0) "Continue" else "Start Now",
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontFamily = inder,
                        fontWeight = FontWeight.W400,
                        lineHeight = 22.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}
