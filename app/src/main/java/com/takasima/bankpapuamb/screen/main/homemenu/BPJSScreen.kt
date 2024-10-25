package com.takasima.bankpapuamb.screen.main.homemenu

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
import androidx.compose.material3.IconButton
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
import com.takasima.bankpapuamb.screen.common.BottomSheetJenisBpjs
import com.takasima.bankpapuamb.screen.common.CustomTopBar
import com.takasima.bankpapuamb.screen.common.ExposedDropdownMenu
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.main.InvoiceScreen
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BPJSScreen(homeNavController: NavHostController, modifier: Modifier = Modifier) {
    var openBSJenisBpjs = remember { mutableStateOf(false) }
    var openBottomSheet = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)
    val bottomSheetState2 = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)
    val bpjsNavController = rememberNavController()

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
                    CustomTopBar("BPJS", {
                        homeNavController.navigateUp()
                    })
                }
            ) { paddingValues ->
                NavHost(navController = bpjsNavController, startDestination = "samsatsection1") {
                    composable("samsatsection1") {
                        BPJSSection1(
                            paddingValues = paddingValues,
                            homeNavController = homeNavController,
                            samsatNavController = bpjsNavController,
                            openBottomSheet = openBottomSheet
                        )
                    }
                    composable("invoice") {
                        InvoiceScreen(
                            paddingValues = paddingValues,
                            menuNavController = bpjsNavController,
                            homeNavController = homeNavController,
                            invoice = Invoice(
                                "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
                                rekAsal = " 9102232123", jenisTransaksi = "",
                                nominal = 500_000
                            )
                        )
                    }

                }

                if (openBSJenisBpjs.value) {
                    ModalBottomSheet(
                        sheetState = bottomSheetState,
                        onDismissRequest = { openBSJenisBpjs.value = false },
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
                        },
                    ) {
                        BottomSheetJenisBpjs(
                            onHideButtonClick = {
                                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) openBSJenisBpjs.value = false
                                }
                            },
                            modifier,
                            bpjsNavController,
                            openBSJenisBpjs
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
//                                    .background(color = Color.White)
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
                        },
                        modifier = Modifier.background(Color.White)
                    ) {
                        BottomSheetContentSamsat(
                            onHideButtonClick = {
                                scope.launch { bottomSheetState2.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState2.isVisible) openBottomSheet.value = false
                                }
                            },
                            modifier,
                            bpjsNavController,
                            openBottomSheet
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BPJSSection1(
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
            Text(text = "PILIH JENIS BPJS", fontWeight = FontWeight.Bold)
            ExposedDropdownMenu("jenisBpjs")

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "NOMOR PEMBAYARAN", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = kodeBayar,
                onValueChange = { newText ->
                    // Filter to allow only alphanumeric characters and limit to 12 characters
                    val filteredText = newText.filter { it.isDigit() }.take(12)
                    kodeBayar = filteredText
                },
                label = { Text("Nomor Pembayaran") },
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
        Spacer(modifier = Modifier.height(36.dp))
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
                text = "1. Pilih jenis BPJS yang sesuai dengan kebutuhan pembayaran anda\n" +
                        "2. Pastikan nomor pembayaran anda sesuai dengan yang ada pada aplikasi BPJS Kesehatan\n" +
                        "3. Setelah konfirmasi harap untuk membuka Aplikasi BPJS Kesehatan untuk melakukan konfirmasi pembayaran\n",
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
private fun BPJSPrev() {
    BPJSScreen(rememberNavController())
}

@Preview(showBackground = true)
@Composable
private fun BPJSPrev2() {
    BPJSSection1(
        paddingValues = PaddingValues(),
        rememberNavController(),
        rememberNavController(),
        openBottomSheet = remember {
            mutableStateOf(true)
        })
}
