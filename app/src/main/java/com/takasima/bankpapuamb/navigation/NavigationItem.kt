package com.takasima.bankpapuamb.navigation

import com.takasima.bankpapuamb.R

/**
 * @author Coding Meet
 * Created 17-01-2024 at 01:53 pm
 */


val bottomNavigationItemsList = listOf(
    NavigationItem(
        title = "Home",
        route = MainRouteScreens.Home.route,
        selectedIcon = /*Icons.Filled.Home*/R.drawable.home_ic,
        unSelectedIcon = /*Icons.Outlined.Home*/R.drawable.home_ic,
    ),
    NavigationItem(
        title = "Keuangan",
        route = MainRouteScreens.Keuangan.route,
        selectedIcon = /*Icons.Filled.Person*/R.drawable.buku_keuangan_ic,
        unSelectedIcon = /*Icons.Outlined.Person*/R.drawable.buku_keuangan_ic,
    ),
    NavigationItem(
        title = "QRIS",
        route = MainRouteScreens.QRIS.route,
        selectedIcon = /*Icons.Filled.Person*/R.drawable.mutasi_ic,
        unSelectedIcon = /*Icons.Outlined.Person*/R.drawable.mutasi_ic,
    ),
    NavigationItem(
        title = "History",
        route = MainRouteScreens.History.route,
        selectedIcon = /*Icons.Filled.Notifications*/R.drawable.history_ic,
        unSelectedIcon = /*Icons.Outlined.Notifications*/R.drawable.history_ic,
//        badgeCount = 9
    ),
    NavigationItem(
        title = "Atm",
        route = MainRouteScreens.Atm.route,
        selectedIcon = /*Icons.Filled.Settings*/R.drawable.atm_ic,
        unSelectedIcon = /*Icons.Outlined.Settings*/R.drawable.atm_ic,
//        hasBadgeDot = true
    ),
)
data class NavigationItem(
    val title : String,
    val route : String,
    val selectedIcon : /*ImageVector*/Int,
    val unSelectedIcon : /*ImageVector*/Int,
    val hasBadgeDot: Boolean = false,
    val badgeCount : Int? = null
)

