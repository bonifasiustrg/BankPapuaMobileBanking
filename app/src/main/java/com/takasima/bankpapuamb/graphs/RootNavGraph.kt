package com.takasima.bankpapuamb.graphs

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
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.screen.main.Dashboard

@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun RootNavGraph(
    navController: NavHostController,
    viewModel: MainViewModel,
) {
    val isLoggedIn by viewModel.isLoggedIn.collectAsState()
    val auth = viewModel.isLoggedIn
    val initialRoute =
        if (auth.value) Graph.HOME else Graph.AUTHENTICATION


    val startDestination = remember(isLoggedIn) {
        if (isLoggedIn) Graph.HOME else Graph.AUTHENTICATION
    }

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = /*Graph.AUTHENTICATION*/initialRoute
    ) {
        composable(route = Graph.HOME) {
            Dashboard()
        }
        authNavGraph(navController = navController, viewModel)

    }
//    // LaunchedEffect to handle subsequent changes in login state
//    LaunchedEffect(isLoggedIn) {
//        val currentRoute = navController.currentBackStackEntry?.destination?.route
//        val targetRoute = if (isLoggedIn) Graph.HOME else Graph.AUTHENTICATION
//        if (currentRoute != targetRoute) {
//            navController.navigate(targetRoute) {
//                popUpTo(Graph.ROOT) { inclusive = true }
//            }
//        }
//    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}