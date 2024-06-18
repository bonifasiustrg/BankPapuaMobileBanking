package com.takasima.bankpapuamb.navigation.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.navigation.ProfileRouteScreens
import com.takasima.bankpapuamb.screen.main.HistoryScreen
import com.takasima.bankpapuamb.screen.main.HomeScreen
import com.takasima.bankpapuamb.screen.main.MutationScreen

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun MainNavGraph(rootNavController: NavHostController, homeNavController: NavHostController, mainViewModel: MainViewModel, openPayBottomSheet: MutableState<Boolean>) {

    NavHost(
        navController = homeNavController,
        route = Graph.HOME,
        startDestination = /*BottomBarScreen.Home.route*/MainRouteScreens.Home.route
    ) {
        composable(route = MainRouteScreens.Home.route) {
            HomeNavHost(rootNavController = rootNavController, /*homeNavController = homeNavController,*/ openPayBottomSheet = openPayBottomSheet)
        }

        composable(route = MainRouteScreens.Mutation.route) {
//            ScreenContent(name = MainRouteScreens.Mutation.route, onClick = {})
            MutationScreen(homeNavController = homeNavController)
        }

        composable(route = MainRouteScreens.History.route) {
//            ScreenContent(name = MainRouteScreens.History.route, onClick = {})
            HistoryScreen(rootNavController, homeNavController)
        }
        composable(route = MainRouteScreens.Atm.route) {
            HomeScreen(rootNavController, homeNavController, openPayBottomSheet = openPayBottomSheet)
        }
        composable(route = ProfileRouteScreens.Profile.route) {
//            ProfileScreen(name = MainRouteScreens.Profile.route, rootNavController = rootNavController)
//            profileNavGraph(rootNavController, mainViewModel)
            ProfileNavHost(rootNavController=rootNavController, viewModel = mainViewModel)
        }


    }

}
