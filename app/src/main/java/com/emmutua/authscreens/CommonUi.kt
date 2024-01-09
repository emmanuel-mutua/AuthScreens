package com.emmutua.authscreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.emmutua.authscreens.ui.theme.CustomButtonShape

@Composable
fun MyOutlinedButton(
    text : String,
    onClick : () -> Unit
) {

    OutlinedButton(
        onClick = onClick,
        shape = CustomButtonShape,
        border = BorderStroke(width = 3.dp, color = MaterialTheme.colorScheme.primary),
        modifier = Modifier.width(250.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun MyFilledButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = CustomButtonShape,
        modifier = Modifier.width(250.dp)
    ) {
        Text(text = text)
    }
}