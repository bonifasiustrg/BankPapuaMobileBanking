package com.takasima.bankpapuamb.navigation.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.navigation.ProfileRouteScreens
import com.takasima.bankpapuamb.screen.auth.SettingKreditScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.KursScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.ProfileScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.SettingScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.Simanja
import com.takasima.bankpapuamb.screen.auth.settingaccount.Simpeda
import com.takasima.bankpapuamb.screen.auth.settingaccount.SnKScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.UbahEmailScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.UbahNoHPScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.UbahPINScreen
import com.takasima.bankpapuamb.screen.auth.settingaccount.UbahPasswordScreen
import com.takasima.bankpapuamb.screen.common.KodeOTPScreen
import com.takasima.bankpapuamb.screen.common.ScreenContent
import com.takasima.bankpapuamb.screen.common.SecurityScreen
import com.takasima.bankpapuamb.screen.common.SecurityScreen2

@RequiresApi(Build.VERSION_CODES.S)
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
//            ScreenContent(name = ProfileRouteScreens.UbahEmail.route) {}
            UbahEmailScreen(profileNavController)

        }
        /**/

        composable(route = ProfileRouteScreens.SettingKredit.route){
            SettingKreditScreen(profileNavController)
        }
        composable(route = ProfileRouteScreens.Kurs.route){
            KursScreen(profileNavController = profileNavController)
        }
        composable(route = ProfileRouteScreens.Lokasi.route){
            ScreenContent(name = ProfileRouteScreens.Lokasi.route) {}
        }
        composable(route = ProfileRouteScreens.SnK.route){
            SnKScreen(profileNavController)
        }
        composable(route = ProfileRouteScreens.Help.route){
            ScreenContent(name = ProfileRouteScreens.Help.route) {}
        }

        composable(FeatureRouteScreens.Security.route){
            SecurityScreen(profileNavController, ProfileRouteScreens.SettingAkun.route)
        }
        composable(FeatureRouteScreens.Simanja.route){
            Simanja(profileNavController)
        }
        composable(FeatureRouteScreens.Simpeda.route){
            Simpeda(profileNavController)
        }
        composable(
            route = "${FeatureRouteScreens.Security2.route}/{route}",
            arguments = listOf(navArgument("route") { type = NavType.StringType })
        ) { backStackEntry ->{}
            // Ambil nilai navLink dari argument
            val route = backStackEntry.arguments?.getString("route") ?: ProfileRouteScreens.SettingAkun.route

            // Panggil SecurityScreen dengan navLink yang didapat
            SecurityScreen2(profileNavController, route)
        }
//        composable(FeatureRouteScreens.KodeOTP.route){
//            KodeOTPScreen(profileNavController, ProfileRouteScreens.SettingAkun.route)
//        }
        composable(
            route = "${FeatureRouteScreens.KodeOTP.route}/{route}",
            arguments = listOf(navArgument("route") { type = NavType.StringType })
        ) { backStackEntry ->
            // Ambil nilai navLink dari argument
            val route = backStackEntry.arguments?.getString("route") ?: ProfileRouteScreens.SettingAkun.route

            // Panggil SecurityScreen dengan navLink yang didapat
//            (if (route!="") route  else ProfileRouteScreens.SettingAkun.route)?.let {
//                KodeOTPScreen(profileNavController,
//                    it
//                )
//            }
            KodeOTPScreen(profileNavController, route)
        }
    }
}
