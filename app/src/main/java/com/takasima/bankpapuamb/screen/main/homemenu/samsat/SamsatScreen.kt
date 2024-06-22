package com.takasima.bankpapuamb.screen.main.homemenu.samsat

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.takasima.bankpapuamb.data.model.Invoice
import com.takasima.bankpapuamb.screen.common.BottomSheetContentSamsat
import com.takasima.bankpapuamb.screen.common.ExposedDropdownMenu
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.VehicleNumberTextField
import com.takasima.bankpapuamb.screen.main.InvoiceScreen
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ESamsatScreen(homeNavController: NavHostController, modifier: Modifier = Modifier) {
    var openBottomSheet = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)
    val samsatNavController = rememberNavController()

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
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                            contentDescription = null,
                            Modifier.size(32.dp)
                        )
                        Text(
                            text = "E-Samsat Papua",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp
                        )
                    }
                }
            ) { paddingValues ->
//                ESamsatSection1(paddingValues = it)
                NavHost(navController = samsatNavController, startDestination = "samsatsection1") {
                    composable("samsatsection1") {
                        ESamsatSection1(
                            paddingValues = paddingValues,
                            homeNavController = homeNavController,
                            samsatNavController = samsatNavController,
                            openBottomSheet = openBottomSheet
                        )
                    }
                    composable("invoice") {
                        InvoiceScreen(
                            paddingValues = paddingValues,
                            menuNavController = samsatNavController,
                            homeNavController = homeNavController,
                            invoice = Invoice(
                                "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
                                rekAsal = " 9102232123", jenisTransaksi = "",
                                nominal = 500_000
                            )
                        )
                    }

                }

                if (openBottomSheet.value) {
                    ModalBottomSheet(
                        sheetState = bottomSheetState,
                        onDismissRequest = { openBottomSheet.value = false },
                        dragHandle = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                                    .background(color = Color.White)
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
                        },
                    ) {
                        BottomSheetContentSamsat(
                            onHideButtonClick = {
                                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) openBottomSheet.value = false
                                }
                            },
                            modifier,
                            samsatNavController,
                            openBottomSheet
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ESamsatSection1(
    paddingValues: PaddingValues,
    homeNavController: NavHostController,
    samsatNavController: NavHostController,
    modifier: Modifier = Modifier,
    openBottomSheet: MutableState<Boolean>
) {
    var kodeBayar by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .wrapContentHeight()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,

        ) {
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "PILIH PROVINSI", fontWeight = FontWeight.Bold)
            ExposedDropdownMenu("province")

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "MASUKKAN NOMOR KENDARAAN", fontWeight = FontWeight.Bold)
            VehicleNumberTextField()

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "MASUKKAN KODE BAYAR", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = kodeBayar,
                onValueChange = { newText ->
                    // Filter to allow only alphanumeric characters and limit to 12 characters
                    val filteredText = newText.filter { it.isLetterOrDigit() }.take(12)
                    kodeBayar = filteredText
                },
                label = { Text("Kode Bayar") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Ascii
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Button(
                modifier = Modifier
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = {
                    openBottomSheet.value = !openBottomSheet.value
                },
                colors = ButtonDefaults.buttonColors(containerColor = secondary)
            ) {
                Text(text = "Konfirmasi")
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .wrapContentHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row {
                Text(text = "Informasi")
                Icon(
                    imageVector = Icons.Outlined.Info,
                    tint = Color.Yellow,
                    contentDescription = null
                )
            }
            Text(
                text = "1. Pastikan nomor kendaraan anda terdaftar di daerah anda\n" +
                        "2. Jika kendaraan anda terdaftar di daerah yang dipilih maka kode bayar akan berlaku \n" +
                        "3. Kode bayar akan berlaku pada kendaraan anda selama tidak dalam status ranmor tidak terblokir atau blokir data kepemilikan\n" +
                        "4. Aplikasi Mobile Banking hanya menanggung Pajak Tahunan\n" +
                        "5. Setelah pembayaran harap mengantarkan bukti pembayaran kepada polantas setempat",
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
        Spacer(modifier = Modifier.height(64.dp))

    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun ESamsatPrev() {
    ESamsatScreen(rememberNavController())
}

@Preview(showBackground = true)
@Composable
private fun ESamsatPrev2() {
    ESamsatSection1(
        paddingValues = PaddingValues(),
        rememberNavController(),
        rememberNavController(),
        openBottomSheet = remember {
            mutableStateOf(true)
        })
}
