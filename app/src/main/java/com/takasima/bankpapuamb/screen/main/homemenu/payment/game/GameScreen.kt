package com.takasima.bankpapuamb.screen.main.homemenu.payment.game

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.data.model.Invoice
import com.takasima.bankpapuamb.navigation.PaymentMenuScreens
import com.takasima.bankpapuamb.screen.common.BottomSheetGame
import com.takasima.bankpapuamb.screen.common.CustomTopBar
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.main.InvoiceScreen
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import com.takasima.bankpapuamb.utils.gameWallet
import kotlinx.coroutines.launch
import androidx.compose.runtime.remember as remember

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GameScreen(paymentNavController: NavHostController, modifier: Modifier = Modifier) {
    val gameNavController = rememberNavController()
    var openBottomSheet = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {

            Scaffold(modifier = Modifier, containerColor = Color(0xA1063E71),
                topBar = {
                    CustomTopBar("Voucher Game", {
                        paymentNavController.navigateUp()
                    })
                    
                }
            ) { paddingValues ->
                NavHost(navController = gameNavController, startDestination = "gamesection1") {
                    composable("gamesection1") {
                        GameSection1(
                            homeNavController = paymentNavController,
                            gameNavController = gameNavController
                        )
                    }

                    composable("gamesection2") {
                        GameSection2(
                            paymentNavController = paymentNavController,
                            gameNavController = gameNavController,
                            onClick = { openBottomSheet.value = true },
                        )
                    }
//
//                    composable("invoice") {
//                        InvoiceScreen(
//                            paddingValues = paddingValues,
//                            menuNavController = gameNavController,
//                            homeNavController = paymentNavController,
//                            invoice = Invoice(
//                                "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
//                                rekAsal = " 9102232123", jenisTransaksi = "",
//                                nominal = 500_000
//                            )
//                        )
//                    }
                }

                if (openBottomSheet.value) {
                    ModalBottomSheet(
                        sheetState = bottomSheetState,
                        onDismissRequest = { openBottomSheet.value = false },
                        dragHandle = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                            ) {
                                BottomSheetDefaults.DragHandle()
                                Text(
                                    text = "TRANSFER",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 32.sp
                                )
                                Spacer(modifier = modifier.height(10.dp))
                                Divider()
                            }
                        }
                    ) {
                        BottomSheetGame(
                            onHideButtonClick = {
                                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) openBottomSheet.value = false
                                }
                            },
                            modifier,
                            paymentNavController,
                            openBottomSheet
                        )
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun GameScreenPrev() {
    GameScreen(rememberNavController())
}


@Composable
fun GameSection1(
    homeNavController: NavHostController,
    gameNavController: NavHostController,
    modifier: Modifier = Modifier
) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
            .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(3) {
                WalletCard(gameWallet[it], onClick = { gameNavController.navigate("gamesection2") })
            }

        }


    }
}

@Preview(showBackground = true)
@Composable
private fun GameSection1Prev() {
    GameSection1(rememberNavController(), rememberNavController())
}

@Composable
fun GameSection2(
    paymentNavController: NavHostController,
    gameNavController: NavHostController,
    onClick: () -> Unit,
    gameWallet: Pair<String, Int> = Pair("Voucher Google Play", R.drawable.google_play),
    modifier: Modifier = Modifier
) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
            .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WalletCard(gameWallet, onClick = {}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(4) {
                Card(
                    modifier.clickable {

                }) {
                    Column(
                        modifier = modifier
                            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                        /*colors = CardDefaults.cardColors(containerColor = Color.White)*/
                    ) {
                        Text(text = "KODE VOUCHER GOOGLE PLAY (IDR)", fontSize = 14.sp, textAlign = TextAlign.Center)

                        Spacer(modifier = Modifier.height(48.dp))
                        Text(text = "Rp5.000", fontWeight = FontWeight.ExtraBold)

                    }
                }
            }

        }

        Spacer(modifier = Modifier.height(16.dp))
        Card {

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
                    .clickable {

                    },
                /*colors = CardDefaults.cardColors(containerColor = Color.White)*/
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Total Pembayaran")
                    Text(text = "Rp5000", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.weight(2f))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = secondary
                    ),
                    onClick = {
                        onClick()
//                        paymentNavController.navigate(PaymentMenuScreens.PaymentSummary.route)
//                        paymentNavController.popBackStack()
//                        gameNavController.popBackStack()
                    }) {
                    Text(text = "Pembayaran")
                }
            }
        }

        TextButton(onClick = { 

        }) {
            Text(text = "SYARAT DAN KETENTUAN", fontWeight = FontWeight.Bold, color = Color.White)
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun GameSection2Prev() {
    GameSection2(rememberNavController(), rememberNavController(), onClick = {})
}

@Composable
fun WalletCard(
    gameWallet: Pair<String, Int>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        /*colors = CardDefaults.cardColors(containerColor = Color.White)*/
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = gameWallet.second),
            contentDescription = null,
            modifier = modifier.height(80.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = gameWallet.first)
    }
}

@Preview(showBackground = true)
@Composable
private fun WallletCardPrev() {
    WalletCard(onClick = {}, gameWallet = Pair("Tes", R.drawable.steam))
}


