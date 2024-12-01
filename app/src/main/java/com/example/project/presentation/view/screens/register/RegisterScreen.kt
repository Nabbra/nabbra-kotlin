package com.example.project.presentation.view.screens.register

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.project.R
import com.example.project.presentation.view.screens.login.LoginScreen
import com.example.project.ui.theme.DarkSlateBlue
import com.example.project.ui.theme.LightGray
import com.example.project.ui.theme.LightGreen
import com.example.project.ui.theme.MidNightBlue
import com.example.project.ui.theme.WhiteOpacity20
import com.example.project.ui.theme.WhiteOpacity80
import com.example.project.ui.theme.centuryGothic
import com.example.project.ui.theme.inder

class RegisterScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var password by remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }
        var email by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }
        var isConfirmPasswordVisible by remember { mutableStateOf(false) }
        var errorMessage by remember { mutableStateOf("") }

        // Email validation function
        // Email validation function
        fun  isValidEmail (email : String): Boolean{
            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
            return email.matches(emailRegex)
        }

        // Password validation function
        fun isValidPassword(password: String): Boolean {
            val passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W)[A-Za-z\\d\\W]{8,}$"
            return password.matches(passwordPattern.toRegex())
        }


        // Validate inputs function
        fun validateInputs(): Boolean {
            return when {
                email.isEmpty() -> {
                    errorMessage = "Email cannot be empty"
                    false
                }
                !isValidEmail(email) -> {
                    errorMessage = "Invalid email format"
                    false
                }
                password.isEmpty() -> {
                    errorMessage = "Password cannot be empty"
                    false
                }
                !isValidPassword(password) -> {
                    errorMessage = "Password must be at least 8 characters long and include uppercase, lowercase, number, and special character"
                    false
                }
                confirmPassword.isEmpty() -> {
                    errorMessage = "Confirm password cannot be empty"
                    false
                }
                password != confirmPassword -> {
                    errorMessage = "Passwords do not match"
                    false
                }
                else -> {
                    errorMessage = ""
                    true
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MidNightBlue)
                .padding(top = 55.dp, start = 17.dp, end = 17.dp)
        ) {
            // Back Arrow
            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "Arrow Back",
                tint = LightGreen,
                modifier = Modifier
                    .size(height = 26.dp, width = 24.dp)
                    .clickable { navigator.pop() }
            )

            Spacer(modifier = Modifier.height(60.dp))

            // Welcome Text
            Text(
                text = "Welcome!",
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

            // SubHeader Text
            Text(
                text = "We are happy to see you! :)",
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

            // Email TextField
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = LightGreen,
                    focusedContainerColor = DarkSlateBlue,
                    unfocusedContainerColor = DarkSlateBlue,
                    focusedBorderColor = LightGray,
                    unfocusedBorderColor = LightGray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = "Email icon",
                        tint = WhiteOpacity20
                    )
                },
                placeholder = {
                    Text(
                        text = "Email",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = centuryGothic,
                            lineHeight = 17.sp,
                        )
                    )
                },
                value = email,
                onValueChange = { email = it }
            )

            Spacer(modifier = Modifier.height(21.dp))

            // Password TextField
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = LightGreen,
                    focusedContainerColor = DarkSlateBlue,
                    unfocusedContainerColor = DarkSlateBlue,
                    focusedBorderColor = LightGray,
                    unfocusedBorderColor = LightGray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.lock),
                        contentDescription = "Password icon",
                        tint = WhiteOpacity20
                    )
                },
                placeholder = {
                    Text(
                        text = "Password",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = centuryGothic,
                            lineHeight = 17.sp
                        )
                    )
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            painter = painterResource(
                                id = if (isPasswordVisible) R.drawable.eye_open else R.drawable.eye_closed
                            ),
                            contentDescription = "Password visibility toggle",
                            tint = WhiteOpacity20
                        )
                    }
                },
                value = password,
                onValueChange = { password = it }
            )

            Spacer(modifier = Modifier.height(21.dp))

            // Confirm Password TextField
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = LightGreen,
                    focusedContainerColor = DarkSlateBlue,
                    unfocusedContainerColor = DarkSlateBlue,
                    focusedBorderColor = LightGray,
                    unfocusedBorderColor = LightGray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.lock),
                        contentDescription = "Password icon",
                        tint = WhiteOpacity20
                    )
                },
                placeholder = {
                    Text(
                        text = "Confirm Password",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = centuryGothic,
                            lineHeight = 17.sp
                        )
                    )
                },
                visualTransformation = if (isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { isConfirmPasswordVisible = !isConfirmPasswordVisible }) {
                        Icon(
                            painter = painterResource(
                                id = if (isConfirmPasswordVisible) R.drawable.eye_open else R.drawable.eye_closed
                            ),
                            contentDescription = "Confirm password visibility toggle",
                            tint = WhiteOpacity20
                        )
                    }
                },
                value = confirmPassword,
                onValueChange = { confirmPassword = it }
            )

            Spacer(modifier = Modifier.height(65.dp))

            // Login Button
            Button(
                onClick = {
                    if (validateInputs()) {
                        navigator.push(LoginScreen())
                    }
                },
                shape = RoundedCornerShape(38.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGray,
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
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

            Spacer(modifier = Modifier.height(20.dp))

            // Error Message
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    style = TextStyle(
                        color = LightGreen,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            // Login Link Text
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontFamily = centuryGothic,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = WhiteOpacity80
                        )
                    ){
                        append("Already have an account")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontFamily = inder,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = WhiteOpacity80
                        )
                    ){
                        append("? ")
                    }
                })

                ClickableText(
                    text = AnnotatedString("Log In"),
                    onClick = { navigator.push(LoginScreen()) },
                    style = TextStyle(
                        fontFamily = centuryGothic,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = LightGreen
                    )
                )
            }
        }
    }
}
