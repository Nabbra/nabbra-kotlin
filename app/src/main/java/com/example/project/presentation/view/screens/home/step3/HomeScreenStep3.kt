package com.example.project.presentation.view.screens.home.step3

import android.Manifest
import android.graphics.Bitmap
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
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
import com.example.project.ui.theme.LightGreen
import com.example.project.ui.theme.MidNightBlue
import com.example.project.ui.theme.alexandria

class HomeScreenStep3:Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val activeTab = remember { mutableIntStateOf(0) } // Track active tab
        val context = LocalContext.current
        // Bitmap state to hold the captured photo
        var capturedImage by remember { mutableStateOf<Bitmap?>(null) }
        var showPermissionDeniedToast by remember { mutableStateOf(false) }

        // Camera launcher to capture the image
        val cameraLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.TakePicturePreview()
        ) { bitmap ->
            capturedImage = bitmap // Save the captured photo
        }

        // Permission launcher for requesting camera permission
        val permissionLauncher = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                cameraLauncher.launch() // Launch the camera if permission is granted
            } else {
                showPermissionDeniedToast = true // Trigger a toast message
            }
        }

        // Handle permission denial toast
        LaunchedEffect(showPermissionDeniedToast) {
            if (showPermissionDeniedToast) {
                Toast.makeText(
                    context,
                    "Camera permission is required to use this feature.",
                    Toast.LENGTH_SHORT
                ).show()
                showPermissionDeniedToast = false // Reset the flag
            }
        }

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

                    Spacer(modifier = Modifier.height(58.dp))

                    Text(text = ":خطوة رقم 3",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = alexandria,
                            color = Color.White,
                            lineHeight = 17.sp,
                        ),
                        modifier = Modifier.align(Alignment.End))

                    Spacer(modifier = Modifier.height(22.dp))

                    Text(
                        text = """
        من فضلك، قم بالضغط على 
        الأيقونة بالأسفل ثم وضع معلومات
        المقياس السمعي حتى نقوم
        بتعديل السماعة حتى تناسب
        !سمعك
    """.trimIndent(),
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
                            .width(268.dp)
                    )


                    Spacer(modifier = Modifier.height(45.dp))
                    // Display captured image if available
                    capturedImage?.let { bitmap ->
                        Image(
                            bitmap = bitmap.asImageBitmap(),
                            contentDescription = "Captured Photo",
                            modifier = Modifier
                                .size(200.dp)
                                .align(Alignment.CenterHorizontally)
                                .padding(bottom = 20.dp)
                        )
                    }
                    Button(
                        onClick = {
                            permissionLauncher.launch(Manifest.permission.CAMERA)                                  },
                        shape = RoundedCornerShape(38.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .size(220.dp)
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.qr_code),
                            contentDescription = "QR Code",
                            modifier = Modifier.size(114.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                            )
                    }
                }
            }
        )
    }
}