package com.takasima.bankpapuamb.screen.main

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.navigation.AuthRouteScreens
import com.takasima.bankpapuamb.navigation.BottomNavigationBar
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.navigation.graphs.MainNavGraph
import com.takasima.bankpapuamb.navigation.bottomNavigationItemsList
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.ui.theme.terniary2


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(
//    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    rootNavController: NavHostController,
    mainNavController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    var openPayBottomSheet = remember { mutableStateOf(false) }

    val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
    val currentRoute by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry?.destination?.route
        }
    }
    val topBarTitle by remember(currentRoute) {
        derivedStateOf {
            if (currentRoute != null) {
                bottomNavigationItemsList[bottomNavigationItemsList.indexOfFirst {
                    it.route == currentRoute
                }].title
            } else {
//                bottomNavigationItemsList[0].title
            }
        }
    }
    val bottomBarItems = listOf<String>(
        MainRouteScreens.Home.route,
        MainRouteScreens.Mutation.route,
        MainRouteScreens.History.route
    )

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
//                    BottomAppBar(
//                        containerColor = /*Color(0xB83D9EF8)*/Color.White,
////                        contentPadding = PaddingValues(),
//                        windowInsets = WindowInsets.systemBars.exclude(WindowInsets.navigationBars),
//                    ) {
//
//
//                    }
                    BottomNavigationBar(
                        items = bottomNavigationItemsList,
                        currentRoute = currentRoute
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
    Dashboard(rememberNavController())
}