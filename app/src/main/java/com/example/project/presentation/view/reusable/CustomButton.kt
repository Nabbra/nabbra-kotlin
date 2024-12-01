package com.example.project.presentation.view.reusable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project.ui.theme.LightGray
import com.example.project.ui.theme.MidNightBlue

/*
@Composable
fun CustomButton(onClick: () -> Unit,content: @Composable() (RowScope.() -> Unit)) {
    return Button(
        onClick = onClick,
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
        content
    }
}*/