package com.emmutua.authscreens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emmutua.authscreens.ui.theme.AuthScreensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthScreensTheme {
                // A surface container using the 'background' color from the theme
                NavGraph()
            }
        }
    }
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome_screen") {
        composable("welcome_screen") {
            WelcomeScreen(
                onLoginButtonClicked = {
                    navController.navigate("login")
                },
                onSignUpButtonClicked = {
                    navController.navigate("signup")
                }
            )
        }
        composable("login") {
            LoginScreen(
                onLoginButtonClicked = {

                },
                onSignUpButtonClicked = {
                    navController.navigate("signup")
                },
                onArrowBackClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable("signup") {
            SignUpScreen(
                onLoginButtonClicked = {
                    navController.navigate("login")
                },
                onSignUpButtonClicked = {

                },
                onArrowBackClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}


