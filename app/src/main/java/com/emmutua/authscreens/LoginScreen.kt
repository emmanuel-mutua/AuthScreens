package com.emmutua.authscreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emmutua.authscreens.ui.theme.AuthScreensTheme

@Composable
fun LoginScreen(
    onLoginButtonClicked: () -> Unit,
    onSignUpButtonClicked: () -> Unit,
    onArrowBackClicked: () -> Unit,
) {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }

            AuthScreenUpperSection(
            onArrowBackClicked = {onArrowBackClicked.invoke()},
            text1 = "Welcome!",
            text2 = "Sign In to continue",
        )
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
            MyFilledButton(text = "Login") {
                onLoginButtonClicked.invoke()
            }
            Text(
                modifier = Modifier
                    .clickable { }
                    .padding(top = 5.dp),
                text = "Forgot Password?",
                style = TextStyle(color = MaterialTheme.colorScheme.primary)
            )
            OrSection(modifier = Modifier.padding(top = 25.dp))
        }
        AuthScreenLowerSection(

        )
        AuthAnnotatedString(text1 = "Dont have an account? ", text2 = "SignUp"){
            onSignUpButtonClicked.invoke()
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPrev() {
    AuthScreensTheme {
     LoginScreen({},{},{})
    }
}
