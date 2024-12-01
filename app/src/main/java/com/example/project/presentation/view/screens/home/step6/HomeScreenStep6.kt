package com.example.project.presentation.view.screens.home.step6

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.project.R
import com.example.project.presentation.view.screens.help.HelpScreen
import com.example.project.presentation.view.screens.home.BottomBar
import com.example.project.presentation.view.screens.home.step7.HomeScreenStep7
import com.example.project.ui.theme.LightGray
import com.example.project.ui.theme.LightGreen
import com.example.project.ui.theme.MidNightBlue
import com.example.project.ui.theme.alexandria

class HomeScreenStep6:Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val activeTab = remember { mutableIntStateOf(0) } // Track active tab

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomBar(
                    activeTab = activeTab.intValue, // Pass active tab
                    onHomeClick = {
                        activeTab.intValue = 0
                        // Handle Home Click (e.g., navigate)
                    },
                    onSearchClick = {
                        activeTab.intValue = 1
                        // Handle Search Click (e.g., navigate)
                    },
                    onSettingsClick = {
                        activeTab.intValue = 2
                        // Handle Settings Click (e.g., navigate)
                    }
                )
            },
            content = { contentPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MidNightBlue)
                        .padding(contentPadding)
                        .padding(horizontal = 17.dp)
                ) {
                    // Header Section (Back button, Help, etc.)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "Arrow Back",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(height = 26.dp, width = 24.dp)
                                .clickable {
                                    navigator.pop()
                                }
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.help),
                            contentDescription = "Help",
                            tint = LightGreen,
                            modifier = Modifier
                                .size(height = 33.dp, width = 29.dp)
                                .clickable {
                                    navigator.push(HelpScreen())
                                }
                        )
                    }

                    Spacer(modifier = Modifier.height(51.dp))

                    Text(
                        text = "، مرحبا محمد",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = alexandria,
                            color = Color.White,
                            lineHeight = 14.sp,
                        ),
                        modifier = Modifier.align(Alignment.End)
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(text = "! اهلا بك في نــبـــرة",
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = alexandria,
                            color = LightGreen,
                            lineHeight = 31.sp,
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(70.dp))


                    Text(
                        text = "!مبارك لك",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = alexandria,
                            color = LightGreen,
                            lineHeight = 24.sp,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(268.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "!لقد أتممت جميع خطواتك بنجاح\nيمكنك الآن استخدام التطبيق كما\nتحب واستكشاف المزيد",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = alexandria,
                            color = Color.White,
                            lineHeight = 21.sp,
                            textAlign = TextAlign.End
                        ),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )


                    Spacer(modifier = Modifier.height(44.dp))

                    Image(
                        painter = painterResource(id = R.drawable.home_step_6),
                        contentDescription = "Home Step 6 Image",
                        modifier = Modifier.align(Alignment.Start)
                            .size(height = 207.dp, width = 180.dp))

                    Spacer(modifier = Modifier.height(60.dp))

                    Button(
                        onClick = {
                            navigator.push(HomeScreenStep7())
                        },
                        shape = RoundedCornerShape(38.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LightGray,
                        ),
                        modifier = Modifier.align(Alignment.End)
                    )
                    {
                        Text(
                            text = "الإنتقال للصفحة الرئيسية",
                            style = TextStyle(
                                color = MidNightBlue,
                                fontFamily = alexandria,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.W400,
                                lineHeight = 22.sp,
                            ),
                        )
                    }
                }
            }
        )
    }
}