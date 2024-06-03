package com.takasima.bankpapuamb.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.takasima.bankpapuamb.screen.BottomBarScreen
import com.takasima.bankpapuamb.screen.common.ScreenContent
import com.takasima.bankpapuamb.screen.main.HomeScreen
import com.takasima.bankpapuamb.screen.main.TarikTunaiScreen

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun HomeNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
//            ScreenContent(
//                name = BottomBarScreen.Home.route,
//                onClick = {
//                    navController.navigate(Graph.DETAILS)
//                }
//
//            )
            HomeScreen(name = BottomBarScreen.Home.route, onClick = { navController.navigate(Graph.DETAILS) }, navController)
        }

        composable(route = "tarik_tunai_screen") {
            TarikTunaiScreen()
        }
        composable(route = BottomBarScreen.Mutation.route) {
            ScreenContent(name = BottomBarScreen.Mutation.route, onClick = {})
        }

        composable(route = BottomBarScreen.History.route) {
            ScreenContent(name = BottomBarScreen.History.route, onClick = {})
        }
        composable(route = BottomBarScreen.Atm.route) {
            ScreenContent(name = BottomBarScreen.Atm.route, onClick = {})
        }

        detailsNavGraph(navController = navController)
    }

}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            ScreenContent(name = DetailsScreen.Information.route) {
                navController.navigate(DetailsScreen.Overview.route)
            }
        }
        composable(route = DetailsScreen.Overview.route) {
            ScreenContent(name = DetailsScreen.Overview.route) {
                navController.popBackStack(
                    route = DetailsScreen.Information.route,
                    inclusive = false
                )
            }
        }
    }
}

sealed class DetailsScreen(val route: String) {

    object Information : DetailsScreen(route = "INFORMATION")
    object Overview : DetailsScreen(route = "OVERVIEW")
}