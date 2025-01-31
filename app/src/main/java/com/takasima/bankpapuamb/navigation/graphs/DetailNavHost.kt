package com.takasima.bankpapuamb.navigation.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.data.model.Invoice
import com.takasima.bankpapuamb.data.viewmodel.Payment2ViewModel
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.navigation.PaymentMenuScreens
import com.takasima.bankpapuamb.navigation.ProfileRouteScreens
import com.takasima.bankpapuamb.screen.auth.settingaccount.FavoriteSect2Screen
import com.takasima.bankpapuamb.screen.common.CongratsScreen
import com.takasima.bankpapuamb.screen.common.ScreenContent
import com.takasima.bankpapuamb.screen.common.SecurityScreen
import com.takasima.bankpapuamb.screen.common.TagihanSection3
import com.takasima.bankpapuamb.screen.main.EStatementScreen
import com.takasima.bankpapuamb.screen.main.homemenu.BPJSScreen
import com.takasima.bankpapuamb.screen.main.homemenu.DompetkuScreen
import com.takasima.bankpapuamb.screen.main.FavoriteScreen
import com.takasima.bankpapuamb.screen.main.HomeScreen
import com.takasima.bankpapuamb.screen.main.InvoiceScreen
import com.takasima.bankpapuamb.screen.main.InvoiceScreen2
import com.takasima.bankpapuamb.screen.main.InvoiceScreen3
import com.takasima.bankpapuamb.screen.main.PaymentSummaryScreen
import com.takasima.bankpapuamb.screen.main.homemenu.kur.SnKKURScreen
import com.takasima.bankpapuamb.screen.main.homemenu.BukuKeuanganScreen
import com.takasima.bankpapuamb.screen.main.homemenu.transfer.TFAntarBankScreen
import com.takasima.bankpapuamb.screen.main.homemenu.transfer.TFSesamaBankScreen
import com.takasima.bankpapuamb.screen.main.homemenu.TarikTunaiScreen
import com.takasima.bankpapuamb.screen.main.homemenu.kur.KURScreen
import com.takasima.bankpapuamb.screen.main.homemenu.kur.PembayaranKURScreen
import com.takasima.bankpapuamb.screen.main.homemenu.kur.PengajuanKURScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.game.GameScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.AirScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.InternetScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.ListrikScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.PaymentMainSection
import com.takasima.bankpapuamb.screen.main.homemenu.payment.PendidikanScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.PulsaScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.TVScreen
import com.takasima.bankpapuamb.screen.main.homemenu.samsat.ESamsatScreen

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun HomeNavHost(
    rootNavController: NavHostController,
//    homeNavController: NavHostController,
    openPayBottomSheet: MutableState<Boolean>
) {

    val homeNavController = rememberNavController()
    val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    }

    CompositionLocalProvider(LocalViewModelStoreOwner provides viewModelStoreOwner) {
        NavHost(
            navController = homeNavController,
            startDestination = MainRouteScreens.Home.route
        ) {
            composable(route = MainRouteScreens.Home.route) {
                HomeScreen(
                    rootNavController,
                    homeNavController,
                    openPayBottomSheet = openPayBottomSheet
                )
            }
            composable(route = FeatureRouteScreens.TarikTunai1.route) {
                TarikTunaiScreen(homeNavController = homeNavController)
            }
            composable(route = FeatureRouteScreens.DompetkuScreen.route) {
                DompetkuScreen(homeNavController = homeNavController)
            }
//        composable(route = FeatureRouteScreens.PembayaranScreen.route) {
//            PembayaranScreen(homeNavController = homeNavController)
//        }
            composable(route = FeatureRouteScreens.PembayaranMainSection.route) {
                PaymentNavHost(homeNavController = homeNavController)
            }
            composable(route = FeatureRouteScreens.FavoriteScreen.route) {
                FavoriteScreen(homeNavController = homeNavController)
            }
            composable(route = FeatureRouteScreens.BPJSScreen.route) {
//                ScreenContent(FeatureRouteScreens.BPJSScreen.route, {})
                BPJSScreen(homeNavController = homeNavController)
            }
            composable(route = FeatureRouteScreens.ESamsatScreen.route) {
                ESamsatScreen(homeNavController = homeNavController)
            }


            composable(route = FeatureRouteScreens.PACE.route) {
                ScreenContent(FeatureRouteScreens.PACE.route, {})
            }
            composable(route = FeatureRouteScreens.KUR.route) {
//                ScreenContent(FeatureRouteScreens.KUR.route, {})
                KURScreen(rootNavController = rootNavController, homeNavController = homeNavController)
            }
            composable(route = FeatureRouteScreens.BukuKeuangan.route) {
//                ScreenContent(FeatureRouteScreens.BukuKeuangan.route, {})
                BukuKeuanganScreen(rootNavController = rootNavController, homeNavController = homeNavController)
            }

            /*TRANSFER BOTTOM SHEET MENU*/
            composable(route = MainRouteScreens.TfAntarBank.route) {
                TFAntarBankScreen(homeNavController = homeNavController)
            }

            composable(route = MainRouteScreens.TfSesamaBank.route) {
                TFSesamaBankScreen(homeNavController = homeNavController)
            }

            composable(route = MainRouteScreens.BIFast.route) {
                ScreenContent(name = MainRouteScreens.BIFast.route) {

                }
            }
            composable(FeatureRouteScreens.Security.route){
                SecurityScreen(homeNavController, MainRouteScreens.Home.route)
            }
            composable("congrats"){
                CongratsScreen(homeNavController)
            }
            composable("invoice") {
                InvoiceScreen(
                    paddingValues = PaddingValues(),
                    menuNavController = rememberNavController(),
                    homeNavController = homeNavController,
                    invoice = Invoice(
                        "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
                        rekAsal = " 9102232123", jenisTransaksi = "",
                        nominal = 500_000
                    )
                )
            }
            composable("invoice2") {
                InvoiceScreen2(
                    paddingValues = PaddingValues(),
                    menuNavController = rememberNavController(),
                    homeNavController = homeNavController,
                    invoice = Invoice(
                        "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
                        rekAsal = " 9102232123", jenisTransaksi = "Dana",
                        nominal = 500_000
                    )
                )
            }


            composable("tagihan3sect") {
                TagihanSection3(homeNavController, onConfirm = {
                    homeNavController.navigate("invoice3")
                })
            }
//                    composable("dompetsection3"){
//                        TagihanSection2(homeNavController, dompetkuNavController, dompetkuViewModel)
//                    }

            composable("invoice3") {
                InvoiceScreen3(
                    paddingValues = PaddingValues(),
                    homeNavController = homeNavController,
                    invoice = Invoice(
                        "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
                        rekAsal = " 9102232123", jenisTransaksi = "Dana",
                        nominal = 500_000
                    )
                )
            }

            composable("favoritesect2") {
                FavoriteSect2Screen(homeNavController)
            }
            composable("snkKUR") {
                SnKKURScreen(homeNavController)
            }
            composable("pangajuanKUR") {
                PengajuanKURScreen(homeNavController)
            }

            composable("pembayaranKUR") {
                PembayaranKURScreen(homeNavController)
            }


        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun PaymentNavHost(homeNavController: NavHostController, paymentViewModel: Payment2ViewModel = viewModel()) {
    
    val paymentNavController = rememberNavController()
    NavHost(
        navController = paymentNavController,
//        route = FeatureRouteScreens.PembayaranMainSection.route,
        startDestination = FeatureRouteScreens.PembayaranMainSection.route
    ) {
        composable(route = FeatureRouteScreens.PembayaranMainSection.route) {
            PaymentMainSection(
                homeNavController = homeNavController,
                paymentNavController = paymentNavController
            )
        }
        composable(route = PaymentMenuScreens.AirScreen.route) {
            AirScreen(paymentNavController)
        }
        composable(route = PaymentMenuScreens.InternetScreen.route) {
            InternetScreen(
                paymentNavController = paymentNavController
            )
        }
        composable(route = PaymentMenuScreens.TVScreen.route) {
            TVScreen(
                paymentNavController = paymentNavController
            )
        }
        composable(route = PaymentMenuScreens.Pendidikan.route) {
            PendidikanScreen(
                paymentNavController = paymentNavController
            )
        }
        composable(route = PaymentMenuScreens.GameScreen.route) {
            GameScreen(paymentNavController = paymentNavController)
        }
        composable(route = PaymentMenuScreens.ListrikScreen.route) {
            ListrikScreen(paymentNavController = paymentNavController, paymentViewModel = paymentViewModel)
        }
        composable(route = PaymentMenuScreens.PulsaScreen.route) {
            PulsaScreen(paymentNavController = paymentNavController)
        }
        composable(route = PaymentMenuScreens.PaymentSummary.route) {
            PaymentSummaryScreen(onNext = {
                paymentNavController.navigate("invoice")
            }, "Tagihan Pembayaran Token Listrik")
        }

        composable("invoice") {
            InvoiceScreen(
                paddingValues = PaddingValues(),
                menuNavController = rememberNavController(),
                homeNavController = homeNavController,
                invoice = Invoice(
                    "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
                    rekAsal = " 9102232123", jenisTransaksi = "",
                    nominal = 500_000
                )
            )
        }
    }
}