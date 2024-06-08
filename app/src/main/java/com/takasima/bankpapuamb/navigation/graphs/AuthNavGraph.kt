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
            RegisterScreen()
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
