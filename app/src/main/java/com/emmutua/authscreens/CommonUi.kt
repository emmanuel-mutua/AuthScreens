package com.emmutua.authscreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.emmutua.authscreens.ui.theme.CustomButtonShape

@Composable
fun MyOutlinedButton(
    text: String,
    onClick: () -> Unit
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

@Preview(showBackground = true)
@Composable
fun AuthScreenUpperSection(
    onArrowBackClicked: () -> Unit = {},
    text1: String = "Text1",
    text2: String = "Random text"
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
    ) {
        ClickableIconButton(
            onClick = { onArrowBackClicked.invoke() },
            painterResourceId = R.drawable.arrow_back
        )
        Text(text = text1, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp))
        Text(text = text2, style = TextStyle(fontWeight = FontWeight.ExtraLight, fontSize = 20.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenLowerSection(
    text: String = "Social Media Login",
    onGoogleIconClick: () -> Unit = {},
    onFaceBookIconClick: () -> Unit = {},
    onAppleIconClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = text, style = TextStyle(fontWeight = FontWeight.ExtraLight, fontSize = 20.sp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 30.dp, end = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ClickableIconButton(
                onClick = { onGoogleIconClick.invoke() },
                painterResourceId = R.drawable.google
            )
            ClickableIconButton(
                onClick = { onGoogleIconClick.invoke() },
                painterResourceId = R.drawable.facebook
            )
            ClickableIconButton(
                onClick = { onGoogleIconClick.invoke() },
                painterResourceId = R.drawable.apple
            )
        }
    }
}

@Composable
fun ClickableIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    painterResourceId: Int = R.drawable.money
) {
    IconButton(onClick = { onClick.invoke() }) {
        Image(
            painter = painterResource(id = painterResourceId),
            contentDescription = "Clickable Icon"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MyHorinzontalLine()
        Text(text = "or")
        MyHorinzontalLine()
    }
}

@Composable
private fun MyHorinzontalLine() {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(height = 1.dp)
            .background(color = Color.Black.copy(alpha = 0.6f))
    )
}

@Composable
fun AuthAnnotatedString(text1: String, text2: String, onClick: () -> Unit) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black)) {
            append(text1)
        }
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Light
            )
        ) {
            pushStringAnnotation(tag = "", annotation = "")
            append(text2)
        }
    }
    Text(
       modifier = Modifier.clickable {onClick.invoke()  },
        text = annotatedString,
        style = TextStyle(fontWeight = FontWeight.ExtraLight, fontSize = 15.sp)
    )
}
