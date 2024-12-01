package com.example.project.presentation.view.screens.loginOrRegister

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.project.R
import com.example.project.presentation.view.screens.login.LoginScreen
import com.example.project.presentation.view.screens.register.RegisterScreen
import com.example.project.ui.theme.DarkSlateBlue
import com.example.project.ui.theme.GainsBoro
import com.example.project.ui.theme.LightGray
import com.example.project.ui.theme.LightGreen
import com.example.project.ui.theme.LightGreenWithOpacity18
import com.example.project.ui.theme.MidNightBlue
import com.example.project.ui.theme.WhiteOpacity80
import com.example.project.ui.theme.centuryGothic
import com.example.project.ui.theme.inder
import com.example.project.ui.theme.mulish

class LoginOrRegisterScreen:Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MidNightBlue)
                .padding(top = 55.dp, start = 17.dp, end = 17.dp)
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

            Spacer(modifier = Modifier.height(60.dp))

            Text(
                text = "Let's get you in",
                style = TextStyle(
                    fontFamily = inder,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 45.sp,
                    color = Color.White,
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Register now!",
                style = TextStyle(
                    fontFamily = inder,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 22.7.sp,
                    color = WhiteOpacity80,
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(60.dp))

            Button(
                onClick = {
                /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkSlateBlue,
                ),
                border = BorderStroke(0.8.dp, GainsBoro),
                contentPadding = PaddingValues(0.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google) ,
                        contentDescription = "Google Logo",
                        modifier = Modifier.size(height = 33.dp, width = 29.dp)
                    )
                    Spacer(modifier = Modifier.size(7.dp))
                    Text(
                        text = "Continue with Google",
                        style = TextStyle(
                            fontFamily = centuryGothic,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W700,
                            lineHeight = 17.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    )

                }
            }

            Spacer(modifier = Modifier.height(17.dp))

            Button(
                onClick = {
                    /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkSlateBlue,
                ),
                border = BorderStroke(0.8.dp, GainsBoro),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 23.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Facebook Logo",
                        modifier = Modifier.size(height = 33.dp, width = 29.dp)
                    )
                    Spacer(modifier = Modifier.size(7.dp))
                    Text(
                        text = "Continue with Facebook",
                        style = TextStyle(
                            fontFamily = centuryGothic,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W700,
                            lineHeight = 17.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    )

                }

            }

            Spacer(modifier = Modifier.height(17.dp))

            Button(
                onClick = {
                        /*TODO*/
                     },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkSlateBlue,
                ),
                border = BorderStroke(0.8.dp, GainsBoro)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.apple),
                        contentDescription = "Apple Logo",
                        modifier = Modifier.size(height = 33.dp, width = 29.dp),
                    )
                    Spacer(modifier = Modifier.size(7.dp))
                    Text(
                        text = "Continue with Apple",
                        style = TextStyle(
                            fontFamily = centuryGothic,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W700,
                            lineHeight = 17.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(35.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .background(LightGreenWithOpacity18)
                )
                Text(
                    text = "or",
                    style = TextStyle(
                        color = LightGreen,
                        fontFamily = mulish,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        lineHeight = 17.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(horizontal = 15.dp)
                    )
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .background(LightGreenWithOpacity18)
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Button(
                onClick = {
                        navigator.push(RegisterScreen())
                          },
                shape = RoundedCornerShape(38.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGray,
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            {
                Text(
                    text = "Sign Up",
                    style = TextStyle(
                        color = MidNightBlue,
                        fontFamily = inder,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 22.sp,
                    )
                    )
            }

            Spacer(modifier = Modifier.height(55.dp))

            val annotatedText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        fontFamily = inder,
                    )
                ) {
                    append("Already have an account? ")
                }
                pushStringAnnotation(tag = "login", annotation = "login_action")
                withStyle(
                    style = SpanStyle(
                        color = LightGreen,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        fontFamily = inder,
                    )
                ) {
                    append("Log In")
                }
                pop()
            }

            ClickableText(
                text = annotatedText,
                onClick = { offset ->
                    annotatedText.getStringAnnotations(offset, offset).firstOrNull()?.let { annotation ->
                        if (annotation.tag == "login") {
                            navigator.push(LoginScreen())
                        }
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}