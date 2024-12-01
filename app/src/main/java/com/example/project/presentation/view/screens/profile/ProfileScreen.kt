package com.example.project.presentation.view.screens.profile

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.project.R
import com.example.project.presentation.view.screens.aboutApp.AboutAppScreen
import com.example.project.presentation.view.screens.account.AccountScreen
import com.example.project.presentation.view.screens.helpAndSupportScreen.HelpAndSupportScreen
import com.example.project.presentation.view.screens.home.BottomBar
import com.example.project.presentation.view.screens.logout.LogoutScreen
import com.example.project.presentation.view.screens.savedData.SavedDataScreen
import com.example.project.ui.theme.DarkGrey
import com.example.project.ui.theme.DarkSlateBlue
import com.example.project.ui.theme.LightGreen
import com.example.project.ui.theme.MidNightBlue
import com.example.project.ui.theme.inder

class ProfileScreen:Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val activeTab = remember { mutableIntStateOf(0) } // Track active tab
        var selectedIndex by remember { mutableIntStateOf(1) } // -1 means no selection


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
                        .padding(horizontal = 16.dp)
                ) {
                    // Header Section (Back button, Help, etc.)
                    Text(
                        text = "Profile",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W700,
                            fontFamily = inder,
                            color = LightGreen,
                            lineHeight = 21.sp,
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Surface(
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(89.dp),
                        color = DarkSlateBlue
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 18.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = CircleShape,
                                modifier = Modifier.size(53.dp),
                                border = BorderStroke(2.dp, LightGreen)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.user_image),
                                    contentDescription = "Person Image",
                                    contentScale = ContentScale.Crop,
                                )
                            }

                            Column (
                                modifier = Modifier
                                    .height(35.dp)
                                    .padding(start = 11.dp)
                            ){
                                Text(text = "Mohamed Fathy",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.W700,
                                        fontFamily = inder,
                                        color = LightGreen,
                                        lineHeight = 19.sp,
                                    ))
                                
                                Text(text = "@Itunuoluwa",
                                    style = TextStyle(
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.W400,
                                        fontFamily = inder,
                                        color = Color.White,
                                        lineHeight = 12.sp,
                                    )
                                )
                            }
                        }

                    }

                    Spacer(modifier = Modifier.height(22.dp))

                    Surface(
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp),
                        color = DarkSlateBlue
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 24.dp),
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .clickable { navigator.push(AccountScreen()) }
                            ) {
                                Surface(
                                    modifier = Modifier
                                        .size(50.dp),
                                    shape = CircleShape,
                                    color = MidNightBlue.copy(alpha = .3f),
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.profile),
                                        contentDescription = "Profile Icon",
                                        modifier = Modifier.padding(10.dp),
                                        tint = LightGreen)
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                Column(
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    modifier = Modifier.height(40.dp)
                                ) {
                                    Text(text = "My Account",
                                        style = TextStyle(
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.W500,
                                            fontFamily = inder,
                                            color = LightGreen,
                                            lineHeight = 19.sp,
                                        )
                                    )
                                    Text(text = "Make changes to your account",
                                        style = TextStyle(
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.W400,
                                            fontFamily = inder,
                                            color = DarkGrey,
                                            lineHeight = 12.sp,
                                        ))
                                }

                                Spacer(modifier = Modifier.width(44.dp))

                                Icon(
                                    painter = painterResource(id = R.drawable.warning),
                                    contentDescription = "Warning Icon",
                                    tint = Color.Red)
                                
                                Spacer(modifier = Modifier.weight(1f))

                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_forward),
                                    contentDescription = "Arrow Forward",
                                    tint = LightGreen,)


                            }
                            Spacer(modifier = Modifier.height(25.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .clickable { navigator.push(SavedDataScreen()) }
                            ) {
                                Surface(
                                    modifier = Modifier
                                        .size(50.dp),
                                    shape = CircleShape,
                                    color = MidNightBlue.copy(alpha = .3f),
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.checked),
                                        contentDescription = "Check Icon",
                                        modifier = Modifier.padding(10.dp),
                                        tint = LightGreen)
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                Column(
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    modifier = Modifier.height(40.dp)
                                ) {
                                    Text(text = "Saved Data",
                                        style = TextStyle(
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.W500,
                                            fontFamily = inder,
                                            color = LightGreen,
                                            lineHeight = 19.sp,
                                        )
                                    )
                                    Text(text = "Manage Your Audiometer Data",
                                        style = TextStyle(
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.W400,
                                            fontFamily = inder,
                                            color = DarkGrey,
                                            lineHeight = 12.sp,
                                        ))
                                }
                                Spacer(modifier = Modifier.weight(1f))

                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_forward),
                                    contentDescription = "Arrow Forward",
                                    tint = LightGreen,)

                            }
                            Spacer(modifier = Modifier.height(25.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .clickable { navigator.push(LogoutScreen()) }
                            ) {
                                Surface(
                                    modifier = Modifier
                                        .size(50.dp),
                                    shape = CircleShape,
                                    color = MidNightBlue.copy(alpha = .3f),
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.logout),
                                        contentDescription = "Logout Icon",
                                        modifier = Modifier.padding(10.dp),
                                        tint = LightGreen)
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                Column(
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    modifier = Modifier.height(40.dp)
                                ) {
                                    Text(text = "Log out",
                                        style = TextStyle(
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.W500,
                                            fontFamily = inder,
                                            color = LightGreen,
                                            lineHeight = 19.sp,
                                        )
                                    )
                                    Text(text = "Further secure your account for safety",
                                        style = TextStyle(
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.W400,
                                            fontFamily = inder,
                                            color = DarkGrey,
                                            lineHeight = 12.sp,
                                        ))
                                }
                                Spacer(modifier = Modifier.weight(1f))

                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_forward),
                                    contentDescription = "Arrow Forward",
                                    tint = LightGreen,)

                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "More",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            fontFamily = inder,
                            color = LightGreen,
                            lineHeight = 19.sp,
                        ))
                    Spacer(modifier = Modifier.height(12.dp))

                    Surface(
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(175.dp),
                        color = DarkSlateBlue
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 24.dp),
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .clickable { navigator.push(HelpAndSupportScreen()) }
                            ) {
                                Surface(
                                    modifier = Modifier
                                        .size(50.dp),
                                    shape = CircleShape,
                                    color = MidNightBlue.copy(alpha = .3f),
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.notification),
                                        contentDescription = "Notification Icon",
                                        modifier = Modifier.padding(10.dp),
                                        tint = LightGreen)
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                Column(
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    modifier = Modifier.height(40.dp)
                                ) {
                                    Text(text = "Help & Support",
                                        style = TextStyle(
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.W500,
                                            fontFamily = inder,
                                            color = LightGreen,
                                            lineHeight = 19.sp,
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.weight(1f))

                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_forward),
                                    contentDescription = "Arrow Forward",
                                    tint = LightGreen,)


                            }
                            Spacer(modifier = Modifier.height(25.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .clickable { navigator.push(AboutAppScreen()) }
                            ) {
                                Surface(
                                    modifier = Modifier
                                        .size(50.dp),
                                    shape = CircleShape,
                                    color = MidNightBlue.copy(alpha = .3f),
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.heart),
                                        contentDescription = "Heart Icon",
                                        modifier = Modifier.padding(10.dp),
                                        tint = LightGreen)
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                Column(
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    modifier = Modifier.height(40.dp)
                                ) {
                                    Text(text = "About App",
                                        style = TextStyle(
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.W500,
                                            fontFamily = inder,
                                            color = LightGreen,
                                            lineHeight = 19.sp,
                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))

                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_forward),
                                    contentDescription = "Arrow Forward",
                                    tint = LightGreen,)

                            }
                        }
                    }

                }
            }
        )
    }
}