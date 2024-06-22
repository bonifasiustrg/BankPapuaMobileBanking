package com.takasima.bankpapuamb.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.navigation.AuthRouteScreens
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.screen.auth.LoginScreen
import com.takasima.bankpapuamb.screen.auth.RegisterScreen
import com.takasima.bankpapuamb.screen.auth.RegisterScreenSection1
import com.takasima.bankpapuamb.screen.auth.RegisterScreenSection2
import com.takasima.bankpapuamb.screen.auth.RegisterScreenSection3
import com.takasima.bankpapuamb.screen.auth.RegisterScreenSection4

fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController, viewModel: MainViewModel) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthRouteScreens.Login.route
    ) {
        composable(route = AuthRouteScreens.Login.route) {
            LoginScreen(viewModel, rootNavController)
//            LoginContent(
//                onClick = {
//                    navController.popBackStack()
//                    navController.navigate(Graph.HOME)
//                },
//                onSignUpClick = {
//                    navController.navigate(AuthScreen.SignUp.route)
//                },
//                onForgotClick = {
//                    navController.navigate(AuthScreen.Forgot.route)
//                }
//            )
        }

        composable(route = AuthRouteScreens.SignUp.route){
//            ScreenContent(name = AuthScreen.SignUp.route) {}
            RegisterScreen(viewModel, rootNavController)
        }
        composable(route = "registersect1"){
//            ScreenContent(name = AuthScreen.SignUp.route) {}
            RegisterScreenSection1(rootNavController)
        }
        composable(route = "registersect2"){
//            ScreenContent(name = AuthScreen.SignUp.route) {}
            RegisterScreenSection2(rootNavController)
        }
        composable(route = "registersect3"){
//            ScreenContent(name = AuthScreen.SignUp.route) {}
            RegisterScreenSection3(rootNavController)
        }
        composable(route = "registersect4"){
//            ScreenContent(name = AuthScreen.SignUp.route) {}
            RegisterScreenSection4(rootNavController)
        }



//        composable(route = AuthScreen.Forgot.route){
//            ScreenContent(name = AuthScreen.Forgot.route) {}
//        }
    }
}


/*
sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
    object Forgot : AuthScreen(route = "FORGOT")
}*/
