package com.takasima.bankpapuamb.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.takasima.bankpapuamb.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: /*ImageVector*/Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = /*Icons.Default.Home*/R.drawable.home_ic
    )

    object Mutation : BottomBarScreen(
        route = "mutasi",
        title = "Mutation",
        icon = R.drawable.mutasi_ic
    )

    object History : BottomBarScreen(
        route = "history",
        title = "History",
        icon = R.drawable.history_ic
    )

    object Atm : BottomBarScreen(
        route = "atm",
        title = "Atm",
        icon = R.drawable.atm_ic
    )
}
