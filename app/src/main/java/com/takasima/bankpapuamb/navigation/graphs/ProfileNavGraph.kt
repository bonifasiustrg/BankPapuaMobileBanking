package com.takasima.bankpapuamb.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.navigation.AuthRouteScreens
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.navigation.ProfileRouteScreens
import com.takasima.bankpapuamb.screen.ProfileScreen
import com.takasima.bankpapuamb.screen.auth.LoginScreen
import com.takasima.bankpapuamb.screen.auth.RegisterScreen
import com.takasima.bankpapuamb.screen.common.ScreenContent

fun NavGraphBuilder.profileNavGraph(rootNavController: NavHostController, viewModel: MainViewModel) {
    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileRouteScreens.Profile.route
    ) {
        //for logout
        composable(route = AuthRouteScreens.Login.route) {
            LoginScreen(viewModel, rootNavController)
        }

        composable(route = ProfileRouteScreens.Profile.route){
            ProfileScreen(name = ProfileRouteScreens.Profile.route, rootNavController = rootNavController)
        }
        composable(route = ProfileRouteScreens.SettingAkun.route){
            ScreenContent(name = ProfileRouteScreens.SettingAkun.route) {}
        }
        composable(route = ProfileRouteScreens.SettingRekening.route){
            ScreenContent(name = ProfileRouteScreens.SettingRekening.route) {}
        }
        composable(route = ProfileRouteScreens.Kurs.route){
            ScreenContent(name = ProfileRouteScreens.Kurs.route) {}
        }
        composable(route = ProfileRouteScreens.Lokasi.route){
            ScreenContent(name = ProfileRouteScreens.Lokasi.route) {}
        }
        composable(route = ProfileRouteScreens.SnK.route){
            ScreenContent(name = ProfileRouteScreens.SnK.route) {}
        }
        composable(route = ProfileRouteScreens.Help.route){
            ScreenContent(name = ProfileRouteScreens.Help.route) {}
        }
    }
}
