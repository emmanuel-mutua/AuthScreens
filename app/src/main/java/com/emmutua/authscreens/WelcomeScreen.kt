package com.emmutua.authscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emmutua.authscreens.ui.theme.AuthScreensTheme

@Composable
fun WelcomeScreen(
    onLoginButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            Image(
                modifier = Modifier.size(50.dp),
                painter = painterResource(id = R.drawable.money),
                contentScale = ContentScale.Crop,
                contentDescription = "win image"
            )
            Text(
                text = "Jishindie",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
            )
        }
        Box(contentAlignment = Alignment.CenterStart) {
            Image(
                modifier = Modifier.size(300.dp),
                painter = painterResource(id = R.drawable.win),
                contentScale = ContentScale.Crop,
                contentDescription = "win image"
            )
        }
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello !",
                style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Participate and win millions of cash prizes and grand prize of 10M",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(50.dp))
            MyFilledButton(text = "SIGN IN", onClick = onLoginButtonClicked)
            MyOutlinedButton(
                onClick = onSignUpButtonClicked,
                text = "SIGN UP"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPrev() {
    AuthScreensTheme {
        WelcomeScreen()
    }
}