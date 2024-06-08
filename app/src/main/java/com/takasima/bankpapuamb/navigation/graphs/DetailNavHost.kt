package com.takasima.bankpapuamb.navigation.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.navigation.PaymentMenuScreens
import com.takasima.bankpapuamb.screen.common.ScreenContent
import com.takasima.bankpapuamb.screen.main.DompetkuScreen
import com.takasima.bankpapuamb.screen.main.FavoriteScreen
import com.takasima.bankpapuamb.screen.main.HomeScreen
import com.takasima.bankpapuamb.screen.main.TarikTunaiScreen
import com.takasima.bankpapuamb.screen.main.payment.AirScreen
import com.takasima.bankpapuamb.screen.main.payment.InternetScreen
import com.takasima.bankpapuamb.screen.main.payment.PaymentMainSection
import com.takasima.bankpapuamb.screen.main.payment.PembayaranScreen
import com.takasima.bankpapuamb.screen.main.payment.PendidikanScreen
import com.takasima.bankpapuamb.screen.main.samsat.ESamsatScreen

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun HomeNavHost(rootNavController: NavHostController, openPayBottomSheet: MutableState<Boolean>) {

    val homeNavController = rememberNavController()
    NavHost(
        navController = homeNavController,
        startDestination = MainRouteScreens.Home.route
    ) {
        composable(route = MainRouteScreens.Home.route) {
            HomeScreen(rootNavController, homeNavController, openPayBottomSheet = openPayBottomSheet)
        }
        composable(route = FeatureRouteScreens.TarikTunai1.route) {
            TarikTunaiScreen(homeNavController = homeNavController)
        }
        composable(route = FeatureRouteScreens.DompetkuScreen.route) {
            DompetkuScreen(homeNavController = homeNavController)
        }
        composable(route = FeatureRouteScreens.PembayaranScreen.route) {
            PembayaranScreen(homeNavController = homeNavController)
        }
        composable(route = FeatureRouteScreens.FavoriteScreen.route) {
            FavoriteScreen(homeNavController = homeNavController)
        }
        composable(route = FeatureRouteScreens.BPJSScreen.route) {
            ScreenContent("BPJS", {})
        }
        composable(route = FeatureRouteScreens.ESamsatScreen.route) {
//            ScreenContent("Esamsat", {})
            ESamsatScreen(homeNavController = homeNavController)
        }
        composable(route = FeatureRouteScreens.PACE.route) {
            ScreenContent("PACE", {})
        }
    }
}
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun PaymentNavHost(homeNavController: NavHostController, openBottomSheet: MutableState<Boolean>) {

    val paymentNavController = rememberNavController()
    NavHost(
        navController = paymentNavController,
        startDestination = FeatureRouteScreens.PembayaranMainSection.route
    ) {
        composable(route = FeatureRouteScreens.PembayaranMainSection.route) {
            PaymentMainSection(homeNavController = homeNavController, paymentNavController = paymentNavController, openBottomSheet = openBottomSheet)
        }
        composable(route = PaymentMenuScreens.AirScreen.route) {
            AirScreen(paymentNavController)
        }
        composable(route = PaymentMenuScreens.InternetScreen.route) {
            InternetScreen(homeNavController = homeNavController, paymentNavController = paymentNavController)
        }
        composable(route = PaymentMenuScreens.Pendidikan.route) {
            PendidikanScreen(homeNavController = homeNavController, paymentNavController = paymentNavController)
        }
        composable(route = PaymentMenuScreens.GameScreen.route) {
//            PendidikanScreen(homeNavController = homeNavController, paymentNavController = paymentNavController)
            ScreenContent(name = "Game") {
                
            }
        }
        composable(route = PaymentMenuScreens.PulsaScreen.route) {
            
            ScreenContent(name = "Pulsa/Data") {
                
            }
        }
    }
}