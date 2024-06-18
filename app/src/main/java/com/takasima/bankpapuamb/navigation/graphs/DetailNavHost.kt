package com.takasima.bankpapuamb.navigation.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.data.model.Invoice
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.navigation.PaymentMenuScreens
import com.takasima.bankpapuamb.screen.common.ScreenContent
import com.takasima.bankpapuamb.screen.main.homemenu.BPJSScreen
import com.takasima.bankpapuamb.screen.main.homemenu.DompetkuScreen
import com.takasima.bankpapuamb.screen.main.FavoriteScreen
import com.takasima.bankpapuamb.screen.main.HomeScreen
import com.takasima.bankpapuamb.screen.main.InvoiceScreen
import com.takasima.bankpapuamb.screen.main.PaymentSummaryScreen
import com.takasima.bankpapuamb.screen.main.homemenu.transfer.TFAntarBankScreen
import com.takasima.bankpapuamb.screen.main.homemenu.transfer.TFSesamaBankScreen
import com.takasima.bankpapuamb.screen.main.homemenu.TarikTunaiScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.game.GameScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.AirScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.InternetScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.PaymentMainSection
import com.takasima.bankpapuamb.screen.main.homemenu.payment.PendidikanScreen
import com.takasima.bankpapuamb.screen.main.homemenu.payment.PulsaScreen
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
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun PaymentNavHost(homeNavController: NavHostController) {

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
                homeNavController = homeNavController,
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
            ScreenContent(name = PaymentMenuScreens.ListrikScreen.route) {

            }
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