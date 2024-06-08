package com.takasima.bankpapuamb.navigation.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.screen.ProfileScreen
import com.takasima.bankpapuamb.screen.main.FavoriteScreen
import com.takasima.bankpapuamb.screen.main.HistoryScreen
import com.takasima.bankpapuamb.screen.main.HomeScreen
import com.takasima.bankpapuamb.screen.main.MutationScreen

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun MainNavGraph(rootNavController: NavHostController, homeNavController: NavHostController, openPayBottomSheet: MutableState<Boolean>) {

    NavHost(
        navController = homeNavController,
        route = Graph.HOME,
        startDestination = /*BottomBarScreen.Home.route*/MainRouteScreens.Home.route
    ) {
        composable(route = MainRouteScreens.Home.route) {
            HomeNavHost(rootNavController, openPayBottomSheet)
        }

        composable(route = MainRouteScreens.Mutation.route) {
//            ScreenContent(name = MainRouteScreens.Mutation.route, onClick = {})
            MutationScreen(homeNavController = homeNavController)
        }

        composable(route = MainRouteScreens.History.route) {
//            ScreenContent(name = MainRouteScreens.History.route, onClick = {})
            HistoryScreen()
        }
        composable(route = MainRouteScreens.Atm.route) {
            HomeScreen(rootNavController, homeNavController, openPayBottomSheet = openPayBottomSheet)
        }
        composable(route = MainRouteScreens.Profile.route) {
            ProfileScreen(name = MainRouteScreens.Profile.route, rootNavController = rootNavController)
        }
        composable(route = MainRouteScreens.QRIS.route) {
//            ScreenContent(name = MainRouteScreens.QRIS.route, onClick = {})

        }

//        /*Tarik Tunai*/
//        composable(route = FeatureRouteScreens.TarikTunai1.route) {
//            TarikTunaiScreen(homeNavController = homeNavController)
//        }
//        composable(route = FeatureRouteScreens.TarikTunai2.route) {
//            TTSection2(homeNavController = homeNavController, ttNavController = )
//        }
//        detailsNavGraph(navController = homeNavController)
    }

}

//fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
//    navigation(
//        route = Graph.DETAILS,
//        startDestination = DetailsScreen.Information.route
//    ) {
//        composable(route = DetailsScreen.Information.route) {
//            ScreenContent(name = DetailsScreen.Information.route) {
//                navController.navigate(DetailsScreen.Overview.route)
//            }
//        }
//        composable(route = DetailsScreen.Overview.route) {
//            ScreenContent(name = DetailsScreen.Overview.route) {
//                navController.popBackStack(
//                    route = DetailsScreen.Information.route,
//                    inclusive = false
//                )
//            }
//        }
//    }
//}

//sealed class DetailsScreen(val route: String) {
//
//    object Information : DetailsScreen(route = "INFORMATION")
//    object Overview : DetailsScreen(route = "OVERVIEW")
//}