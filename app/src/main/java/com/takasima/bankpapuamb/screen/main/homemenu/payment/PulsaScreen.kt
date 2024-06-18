package com.takasima.bankpapuamb.screen.main.homemenu.payment

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
import com.takasima.bankpapuamb.screen.common.BottomSheetPulsa
import com.takasima.bankpapuamb.screen.common.ExposedDropdownMenu
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.main.InvoiceScreen
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import kotlinx.coroutines.launch
import androidx.compose.runtime.remember as remember

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PulsaScreen(paymentNavController: NavHostController, modifier: Modifier = Modifier) {
    val pulsaNavController = rememberNavController()
    var openBottomSheet = remember { mutableStateOf(false) }
    var openBSProvider = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)
    val bottomSheetState2 = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)

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
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.08f)
                            .background(color = Color(0xB3AAE4F6))
                            .padding(top = 16.dp)
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            paymentNavController.navigateUp()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                                contentDescription = null,
                                Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = "Pulsa",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 28.sp
                        )
                    }
                }
            ) { paddingValues ->
                NavHost(navController = pulsaNavController, startDestination = "pulsa_main") {
                    composable("pulsa_main") {
                        PulsaMainSection(
                            paymentNavController = paymentNavController,
                            pulsaNavController = pulsaNavController,)
                    }
                    composable("invoice") {
                        InvoiceScreen(
                            paddingValues = paddingValues,
                            menuNavController = pulsaNavController,
                            homeNavController = paymentNavController,
                            invoice = Invoice(
                                "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
                                rekAsal = " 9102232123", jenisTransaksi = "",
                                nominal = 500_000
                            )
                        )
                    }

                }

//                if (openBSProvider.value) {
//                    ModalBottomSheet(
//                        sheetState = bottomSheetState,
//                        onDismissRequest = { openBSProvider.value = false },
//                        dragHandle = {
//                            Column(
//                                horizontalAlignment = Alignment.CenterHorizontally,
//                                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
//                            ) {
//                                BottomSheetDefaults.DragHandle()
//                                Text(
//                                    text = "TRANSFER",
//                                    fontWeight = FontWeight.ExtraBold,
//                                    fontSize = 32.sp
//                                )
//                                Spacer(modifier = modifier.height(10.dp))
//                                Divider()
//                            }
//                        }
//                    ) {
//                        BottomSheetPulsa(
//                            onHideButtonClick = {
//                                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
//                                    if (!bottomSheetState.isVisible) openBSProvider.value = false
//                                }
//                            },
//                            modifier,
//                            pulsaNavController,
//                            openBSProvider
//                        )
//                    }
//                }

                if (openBottomSheet.value) {
                    ModalBottomSheet(
                        sheetState = bottomSheetState2,
                        onDismissRequest = { openBottomSheet.value = false },
                        dragHandle = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                            ) {
                                BottomSheetDefaults.DragHandle()
                                Text(
                                    text = "Pembayaran",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 32.sp
                                )
                                Spacer(modifier = modifier.height(10.dp))
                                Divider()
                            }
                        }
                    ) {
                        BottomSheetPulsa(
                            onHideButtonClick = {
                                scope.launch { bottomSheetState2.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState2.isVisible) openBottomSheet.value = false
                                }
                            },
                            modifier,
                            pulsaNavController,
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
private fun PulsaScreenPrev() {
    PulsaScreen(rememberNavController())
}


@Composable
fun PulsaMainSection(
    paymentNavController: NavHostController,
    pulsaNavController: NavHostController,
    modifier: Modifier = Modifier
) {
    var noTelp by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.1f)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 32.dp, horizontal = 8.dp)) {
            ExposedDropdownMenu("provider")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 24.dp, horizontal = 8.dp)) {

            OutlinedTextField(
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                ),
                value = noTelp,
                onValueChange = { newText ->
                    // Filter to allow only alphanumeric characters and limit to 12 characters
                    val filteredText = newText.filter { it.isDigit() }.take(12)
                    noTelp = filteredText
                },
//            label = { Text("No Telp") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Ascii
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Contacts,
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text(text = "Masukkan Nomor Telepon") }
            )

        }



        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextButton(modifier = Modifier
                .weight(2f)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
                onClick = { /*TODO*/ }) {
                Text(text = "300.000")
            }
            TextButton(modifier = Modifier
                .weight(2f)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
                onClick = { /*TODO*/ }) {
                Text(text = "400.000")
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextButton(modifier = Modifier
                .weight(2f)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
                onClick = { /*TODO*/ }) {
                Text(text = "500.000")
            }
            TextButton(modifier = Modifier
                .weight(2f)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
                onClick = { /*TODO*/ }) {
                Text(text = "600.000")
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextButton(modifier = Modifier
                .weight(2f)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
                onClick = { /*TODO*/ }) {
                Text(text = "700.000")
            }
            TextButton(modifier = Modifier
                .weight(2f)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
                onClick = { /*TODO*/ }) {
                Text(text = "800.000")
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextButton(modifier = Modifier
                .weight(2f)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
                onClick = { /*TODO*/ }) {
                Text(text = "900.000")
            }
            TextButton(modifier = Modifier
                .weight(2f)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
                onClick = { /*TODO*/ }) {
                Text(text = "1.000.000")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
//                openBottomSheet.value = !openBottomSheet.value
                paymentNavController.navigate(PaymentMenuScreens.PaymentSummary.route)

            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary)
        ) {
            Text(text = "Konfirmasi")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GameSection1Prev() {
    PulsaMainSection(rememberNavController(), rememberNavController())
}

@Composable
fun WalletCard(logo: Int, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable {

            },
        /*colors = CardDefaults.cardColors(containerColor = Color.White)*/
    ) {
        Image(imageVector = ImageVector.vectorResource(id = logo), contentDescription = null)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "STEAM WALLET IDR")
    }
}

@Preview(showBackground = true)
@Composable
private fun WallletCardPrev() {
    WalletCard(onClick = {}, logo = R.drawable.steam)
}


