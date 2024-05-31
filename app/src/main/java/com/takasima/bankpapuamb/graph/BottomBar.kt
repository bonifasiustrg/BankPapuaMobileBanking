package com.takasima.bankpapuamb.graph

import com.takasima.bankpapuamb.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val selectedIcon: Int,
//    val unselectedIcon: Int,
) {
    data object Home : BottomBarScreen(
        route = "HOME",
        title = "Home",
        selectedIcon = R.drawable.home_ic,
//        unselectedIcon = R.drawable.home_ic,
    )

    data object Mutasi : BottomBarScreen(
        route = "MUTASI",
        title = "Mutasi",
        selectedIcon = R.drawable.mutasi_ic,
//        unselectedIcon = R.drawable.heart_ic

    )
    data object History : BottomBarScreen(
        route = "HISTORY",
        title = "History",
        selectedIcon = R.drawable.history_ic,
//        unselectedIcon = R.drawable.notes_ic
    )
    data object Atm : BottomBarScreen(
        route = "ATM",
        title = "Atm",
        selectedIcon = R.drawable.atm_ic,
//        unselectedIcon = R.drawable.stethoscope_ic

    )

}