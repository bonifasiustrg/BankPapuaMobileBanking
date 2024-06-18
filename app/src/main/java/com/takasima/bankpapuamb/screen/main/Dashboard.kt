package com.takasima.bankpapuamb.screen.main

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.navigation.BottomNavigationBar
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.navigation.bottomNavigationItemsList
import com.takasima.bankpapuamb.navigation.graphs.MainNavGraph
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.ui.theme.terniary2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(
    rootNavController: NavHostController,
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val mainNavController = rememberNavController()
    var openPayBottomSheet = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
    val currentRoute by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry?.destination?.route
        }
    }
    val textResult by remember { mainViewModel.textResult }
    LaunchedEffect(textResult) {
        // Lakukan sesuatu saat textResult berubah
        println("Nilai textResult berubah menjadi: $textResult")
    }

    if (textResult != "") {
        Log.e("qrcode", textResult)
        Toast.makeText(context, "Scan result: ${textResult}",Toast.LENGTH_SHORT)
    } else {
        Log.e("qrcode", textResult)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {

            Scaffold(modifier = Modifier, containerColor = Color.Transparent,
                bottomBar = {
                    BottomNavigationBar(
                        items = bottomNavigationItemsList,
                        currentRoute = currentRoute,
                        onClickQRScan = { mainViewModel.checkCameraPermission(context = context)

                        },
                        mainNavController
                    ) { currentNavigationItem ->
                        Log.e("currentRoute", currentRoute.toString())
                        if (currentNavigationItem.route == MainRouteScreens.Atm.route) {
                            mainNavController.navigate(MainRouteScreens.Home.route)
                            openPayBottomSheet.value = true

                        } else {

                            mainNavController.navigate(currentNavigationItem.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                mainNavController.graph.startDestinationRoute?.let { startDestinationRoute ->
                                    // Pop up to the start destination, clearing the back stack
                                    popUpTo(startDestinationRoute) {
                                        // Save the state of popped destinations
                                        saveState = true
                                    }
                                }

                                // Configure navigation to avoid multiple instances of the same destination
                                launchSingleTop = true

                                // Restore state when re-selecting a previously selected item
                                restoreState = true
                            }
                        }
                    }
                }


            ) {
                MainNavGraph(
                    rootNavController = rootNavController,
                    homeNavController = mainNavController,
                    mainViewModel,
                    openPayBottomSheet
                )
            }
        }

    }
}

/*

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Mutation,
        BottomBarScreen.History,
        BottomBarScreen.Atm
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar(
            containerColor = Color(0xB83D9EF8),
//            contentColor = Color.Black
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = Color.Black,
            unselectedTextColor = Color.Black,
            selectedIconColor = Color.White,
            selectedTextColor = Color.White,
            indicatorColor = biru2
        ),
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
//                imageVector = screen.icon,
                painter = painterResource(id = screen.icon),
                contentDescription = "Navigation Icon"
            )
        },

        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,

//        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

*/



@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun DashboardPrev() {
    Dashboard(rememberNavController(), mainViewModel = viewModel())
}