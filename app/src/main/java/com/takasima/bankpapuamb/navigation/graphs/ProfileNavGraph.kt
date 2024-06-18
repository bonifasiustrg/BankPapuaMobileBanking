package com.takasima.bankpapuamb.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.navigation.ProfileRouteScreens
import com.takasima.bankpapuamb.screen.auth.ProfileScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.SettingScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.UbahNoHPScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.UbahPINScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.UbahPasswordScreen
import com.takasima.bankpapuamb.screen.common.ScreenContent

@Composable
fun /*NavGraphBuilder.p*/ProfileNavHost(rootNavController: NavHostController, viewModel: MainViewModel) {
    val profileNavController = rememberNavController()
    NavHost(
        navController = profileNavController,
        route = Graph.PROFILE,
        startDestination = ProfileRouteScreens.Profile.route
    ) {
//        //for logout
//        composable(route = AuthRouteScreens.Login.route) {
//            LoginScreen(viewModel, rootNavController)
//        }

        composable(route = ProfileRouteScreens.Profile.route){
            ProfileScreen(name = ProfileRouteScreens.Profile.route, rootNavController = rootNavController, profileNavController = profileNavController)
        }

        /*Setting Route*/
        composable(route = ProfileRouteScreens.SettingAkun.route){
//            ScreenContent(name = ProfileRouteScreens.SettingAkun.route) {}
            SettingScreen(profileNavController)
        }

        composable(route = ProfileRouteScreens.UbahPass.route){
//            ScreenContent(name = ProfileRouteScreens.SettingAkun.route) {}
            UbahPasswordScreen(profileNavController)
        }

        composable(route = ProfileRouteScreens.UbahPIN.route){
//            ScreenContent(name = ProfileRouteScreens.SettingAkun.route) {}
            UbahPINScreen(profileNavController)
        }

        composable(route = ProfileRouteScreens.UbahNoHP.route){
//            ScreenContent(name = ProfileRouteScreens.SettingAkun.route) {}
            UbahNoHPScreen(profileNavController)
        }

        composable(route = ProfileRouteScreens.UbahEmail.route){
            ScreenContent(name = ProfileRouteScreens.UbahEmail.route) {}

        }
        /**/

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
