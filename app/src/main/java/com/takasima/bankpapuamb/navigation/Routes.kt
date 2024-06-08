package com.takasima.bankpapuamb.navigation

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val PROFILE = "profile_graph"
    const val DETAILS = "details_graph"
}

sealed class MainRouteScreens(var route: String) {

    object  Home : MainRouteScreens("home")
    object  Mutation : MainRouteScreens("mutation")
    object  History : MainRouteScreens("history")
    object  Atm : MainRouteScreens("atm")
    object  Profile : MainRouteScreens("profile")
    object  QRIS : MainRouteScreens("qris")
}

sealed class AuthRouteScreens(var route: String) {

    object  Login : MainRouteScreens("login")
    object  SignUp : MainRouteScreens("signup")
    object  Forget : MainRouteScreens("forget")
}

sealed class ProfileRouteScreens(var route: String) {

    object Profile : ProfileRouteScreens("profile")
    object SettingAkun : ProfileRouteScreens("setting_akun")
    object SettingRekening : ProfileRouteScreens("setting_rekening")
    object Kurs : ProfileRouteScreens("kurs")
    object Lokasi : ProfileRouteScreens("lokasi")
    object SnK : ProfileRouteScreens("snk")
    object Help : ProfileRouteScreens("help")
}

/*FEATURE*/
sealed class FeatureRouteScreens(var route: String) {

    object  TarikTunai1 : FeatureRouteScreens("tt1")
    object  DompetkuScreen : FeatureRouteScreens("dompetku")
    object  PembayaranScreen : FeatureRouteScreens("pembayaran")
    object  PembayaranMainSection : FeatureRouteScreens("pembayaran_section")
    object  FavoriteScreen : FeatureRouteScreens("favorite")
    object  BPJSScreen : FeatureRouteScreens("bpjs")
    object  ESamsatScreen : FeatureRouteScreens("esamsat")
    object  PACE : FeatureRouteScreens("pace")
    object  Security : FeatureRouteScreens("security")
}
sealed class PaymentMenuScreens(var route: String) {

    object  AirScreen : PaymentMenuScreens("air")
    object  InternetScreen : PaymentMenuScreens("internet")
    object  Pendidikan : PaymentMenuScreens("pendidikan")
    object  GameScreen : PaymentMenuScreens("game")
    object  PulsaScreen : PaymentMenuScreens("pulsa")
}