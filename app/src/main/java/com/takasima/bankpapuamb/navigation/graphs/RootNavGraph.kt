package com.takasima.bankpapuamb.navigation.graphs

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.screen.main.Dashboard

@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun RootNavGraph(
    mainViewModel: MainViewModel,
    isAuth: Boolean
) {
    val rootNavController = rememberNavController()


    val isLoggedIn by mainViewModel.isLoggedIn.collectAsState()
    val auth = mainViewModel.isLoggedIn
    val initialRoute =
        if (isAuth) Graph.HOME else Graph.AUTHENTICATION


//    val startDestination = remember(isLoggedIn) {
//        if (isLoggedIn) Graph.HOME else Graph.AUTHENTICATION
//    }

    NavHost(
        navController = rootNavController,
        route = Graph.ROOT,
        startDestination = /*Graph.AUTHENTICATION*/initialRoute
    ) {
        authNavGraph(rootNavController = rootNavController, mainViewModel)
        composable(route = Graph.HOME) {
            Dashboard(rootNavController, mainViewModel = mainViewModel)
        }
        composable(route = Graph.PROFILE) {
            ProfileNavHost(rootNavController, mainViewModel)
        }
    }
}

