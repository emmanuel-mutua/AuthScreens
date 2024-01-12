package com.emmutua.authscreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emmutua.authscreens.ui.theme.AuthScreensTheme

@Composable
fun SignUpScreen(
    onLoginButtonClicked: () -> Unit,
    onSignUpButtonClicked: () -> Unit,
    onArrowBackClicked: () -> Unit
) {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var username by remember {
            mutableStateOf("")
        }
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        AuthScreenUpperSection(
            onArrowBackClicked = { onArrowBackClicked.invoke() },
            text1 = "Hi!",
            text2 = "Create an account",
        )
        TextField(value = username, onValueChange = { username = it }, singleLine = true, label = {
            Text(
                text = "Username",
            )
        })
        TextField(value = email, onValueChange = { email = it }, singleLine = true, label = {
            Text(
                text = "Email",
            )
        })
        TextField(value = password, onValueChange = { password = it }, label = {
            Text(
                text = "Password",
            )
        })
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyFilledButton(text = "SIGN UP") {
                onSignUpButtonClicked.invoke()
            }
            OrSection(modifier = Modifier.padding(top = 25.dp))
        }
        AuthScreenLowerSection(

        )
        AuthAnnotatedString(
            text1 = "Already have an account? ",
            text2 = "SignIn"
        ){
            onLoginButtonClicked.invoke()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignUpScreenPrev() {
    AuthScreensTheme {
        SignUpScreen({}, {}) {}
    }
}
