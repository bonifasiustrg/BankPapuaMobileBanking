package com.takasima.bankpapuamb.data.model

import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens

data class MainManuItem(
    val route: String="",
    val icon: Int,
    val title: String
)

// Create a list of sample menu items
val menuItems = listOf(
    MainManuItem(
        route = FeatureRouteScreens.TarikTunai1.route,
        icon = R.drawable.tarik_tunai,
        title = "Tarik Tunai"
    ),
    MainManuItem(
        route = FeatureRouteScreens.DompetkuScreen.route,
        icon = R.drawable.dompetku,
        title = "Dompetku"
    ),
    MainManuItem(
        icon = R.drawable.transfer,
        title = "Transfer",
    ),

    MainManuItem(
        route = FeatureRouteScreens.FavoriteScreen.route,
        icon = R.drawable.star_ic,
        title = "Favorit"
    ),
    MainManuItem(
        route = FeatureRouteScreens.BPJSScreen.route,
        icon = R.drawable.bpjs,
        title = "BPJS"
    ),
    MainManuItem(
        route = FeatureRouteScreens.ESamsatScreen.route,
        icon = R.drawable.esamsat,
        title = "E-Samsat Papua"
    ),

    MainManuItem(
        route = FeatureRouteScreens.KUR.route,
        icon = R.drawable.kur_ic,
        title = "Kredit Usaha Rakyat"
    ),
    MainManuItem(
        route = FeatureRouteScreens.BukuKeuangan.route,
        icon = R.drawable.buku_keuangan_ic,
        title = "Buku Keuangan"
    ),
    MainManuItem(
        route = FeatureRouteScreens.PACE.route,
        icon = R.drawable.pace_wa,
        title = "PACE"
    ),

    MainManuItem(
        route = FeatureRouteScreens.PembayaranMainSection.route,
        icon = R.drawable.pembayaran,
        title = "Pembayaran"
    ),




)