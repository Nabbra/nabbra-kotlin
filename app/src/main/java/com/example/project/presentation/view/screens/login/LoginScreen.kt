package com.example.project.presentation.view.screens.login

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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.project.R
import com.example.project.presentation.view.screens.forgotpassword.ForgotPasswordScreen1
import com.example.project.presentation.view.screens.home.step1.HomeScreenStep1
import com.example.project.presentation.view.screens.register.RegisterScreen
import com.example.project.ui.theme.DarkSlateBlue
import com.example.project.ui.theme.LightGray
import com.example.project.ui.theme.LightGreen
import com.example.project.ui.theme.LightGreenWithOpacity18
import com.example.project.ui.theme.MidNightBlue
import com.example.project.ui.theme.WhiteOpacity20
import com.example.project.ui.theme.WhiteOpacity80
import com.example.project.ui.theme.centuryGothic
import com.example.project.ui.theme.inder
import com.example.project.ui.theme.mulish

class LoginScreen:Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var password by remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }
        var email by remember { mutableStateOf("") }
        var errorMessage by remember { mutableStateOf("") }

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
                text = "Welcome Back!",
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
                text = "We are happy to see you again!:)",
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

            Spacer(modifier = Modifier.height(30.dp))

            val annotatedText1 = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = LightGreen,
                        fontWeight = FontWeight.W700,
                        fontSize = 14.sp,
                        fontFamily = centuryGothic,
                    )
                ) {
                    append("Forgot the Password ")
                }
                withStyle(
                    style = SpanStyle(
                        color = LightGreen,
                        fontSize = 14.sp,
                        fontFamily = inder,
                    )
                ){
                    append("?") // Append the "?" outside the clickable annotation.
                }
            }

            ClickableText(
                text = annotatedText1,
                style = TextStyle(
                    color = LightGreen,
                    fontFamily = centuryGothic,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W700,
                    lineHeight = 15.5.sp,
                ),
                onClick = {
                    navigator.push(ForgotPasswordScreen1())
                },
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(45.dp))

            Button(
                onClick = {
                    if (validateInputs()) {
                        navigator.push(HomeScreenStep1())
                    }
                },
                shape = RoundedCornerShape(38.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGray,
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            {
                Text(
                    text = "Login",
                    style = TextStyle(
                        color = MidNightBlue,
                        fontFamily = inder,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 22.sp,
                    )
                )
            }

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

            Spacer(modifier = Modifier.height(45.dp))

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

            Row(
                modifier = Modifier
                    .width(220.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Surface(
                    modifier = Modifier
                        .size(54.dp),
                    shape = CircleShape,
                    color = DarkSlateBlue,
                    shadowElevation = 18.dp
                ){
                    IconButton(
                        modifier = Modifier.fillMaxSize(),
                        onClick = {
                            /*TOD0*/
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp), // Adjust icon size within the circle
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .size(54.dp),
                    shape = CircleShape,
                    color = DarkSlateBlue,
                    shadowElevation = 18.dp
                ){
                    IconButton(
                        modifier = Modifier.fillMaxSize(),
                        onClick = {
                            /*TOD0*/
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp), // Adjust icon size within the circle
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .size(54.dp),
                    shape = CircleShape,
                    color = DarkSlateBlue,
                    shadowElevation = 18.dp
                ){
                    IconButton(
                        modifier = Modifier.fillMaxSize(),
                        onClick = {
                            /*TOD0*/
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.apple),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp), // Adjust icon size within the circle
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

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
                    append("Sign Up")
                }
                pop()
            }

            ClickableText(
                text = annotatedText,
                onClick = { offset ->
                    annotatedText.getStringAnnotations(offset, offset).firstOrNull()?.let { annotation ->
                        if (annotation.tag == "login") {
                            navigator.push(RegisterScreen())
                        }
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}