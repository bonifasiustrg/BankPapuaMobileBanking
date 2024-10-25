package com.takasima.bankpapuamb.navigation

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val PROFILE = "profile_graph"
    const val PAYMENT = "payment_graph"
}

sealed class MainRouteScreens(var route: String) {

    object  Home : MainRouteScreens("home")
    object  Mutation : MainRouteScreens("mutation")
    object  Keuangan : MainRouteScreens("keuangan")
    object  History : MainRouteScreens("history")
    object  Atm : MainRouteScreens("atm")
    object  Profile : MainRouteScreens("profile")

    object  BIFast : MainRouteScreens("bifast")
    object  QRIS : MainRouteScreens("qris")
    object  TfSesamaBank : MainRouteScreens("tfsesamabank")
    object  TfAntarBank : MainRouteScreens("tfantarbank")
}

sealed class AuthRouteScreens(var route: String) {

    object  Login : MainRouteScreens("login")
    object  SignUp : MainRouteScreens("signup")
    object  Forget : MainRouteScreens("forget")
}

sealed class ProfileRouteScreens(var route: String) {

    object Profile : ProfileRouteScreens("profile")
    object SettingKredit : ProfileRouteScreens("setting_kredit")
    object Kurs : ProfileRouteScreens("kurs")
    object Lokasi : ProfileRouteScreens("lokasi")
    object SnK : ProfileRouteScreens("snk")
    object Help : ProfileRouteScreens("help")

    /*SETTING AKUN*/
    object SettingAkun : ProfileRouteScreens("setting_akun")
    object UbahPass : ProfileRouteScreens("ubah_pass")
    object UbahPIN : ProfileRouteScreens("ubah_pin")
    object UbahNoHP : ProfileRouteScreens("ubah_nohp")
    object UbahEmail : ProfileRouteScreens("ubah_email")
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
    object  KUR : FeatureRouteScreens("kur")
    object  BukuKeuangan : FeatureRouteScreens("buku_keuangan")


    object  Security : FeatureRouteScreens("security")
    object  Security2 : FeatureRouteScreens("security2")
    object  KodeOTP : FeatureRouteScreens("kode_otp")

    object  Simpeda : FeatureRouteScreens("simpeda")
    object  Simanja : FeatureRouteScreens("simanja")
}
sealed class PaymentMenuScreens(var route: String) {

    object  AirScreen : PaymentMenuScreens("air")
    object  InternetScreen : PaymentMenuScreens("internet")
    object  TVScreen : PaymentMenuScreens("tv")
    object  Pendidikan : PaymentMenuScreens("pendidikan")
    object  GameScreen : PaymentMenuScreens("game")
    object  PulsaScreen : PaymentMenuScreens("pulsa")
    object  PaymentSummary : PaymentMenuScreens("summary")
    object  ListrikScreen : PaymentMenuScreens("listrik")
}