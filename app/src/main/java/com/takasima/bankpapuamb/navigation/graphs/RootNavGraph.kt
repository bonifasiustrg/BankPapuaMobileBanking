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
    viewModel: MainViewModel,
    isAuth: Boolean
) {
    val rootNavController = rememberNavController()


    val isLoggedIn by viewModel.isLoggedIn.collectAsState()
    val auth = viewModel.isLoggedIn
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
        composable(route = Graph.HOME) {
            Dashboard(rootNavController)
        }
        authNavGraph(rootNavController = rootNavController, viewModel)
        profileNavGraph(rootNavController, viewModel)
    }
}
