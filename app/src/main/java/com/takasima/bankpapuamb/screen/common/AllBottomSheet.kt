package com.takasima.bankpapuamb.screen.common

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.navigation.PaymentMenuScreens
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.utils.jenisBpjs

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BottomSheetContent(
    onHideButtonClick: () -> Unit,
    homeNavController: NavHostController,
    modifier: Modifier = Modifier
) {

    Column(
        modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(
                    onClick = {
                        onHideButtonClick()
                        homeNavController.navigate(MainRouteScreens.TfAntarBank.route)
                    }, modifier = Modifier
                        .width(90.dp)
                        .background(Color(0xFF3D9EF8), shape = RoundedCornerShape(8.dp))
                        .padding(vertical = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bank_tujuan_ic),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(text = "TRANSFER ANTAR BANK", fontSize = 10.sp)
            }


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(
                    onClick = {
                        onHideButtonClick()
                        homeNavController.navigate(MainRouteScreens.TfSesamaBank.route)

                    }, modifier = Modifier
                        .width(90.dp)
                        .background(Color(0xFF3D9EF8), shape = RoundedCornerShape(8.dp))
                        .padding(vertical = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bank_sesama_ic),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(text = "TRANSFER SESAMA BANK", fontSize = 10.sp)
            }


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(
                    onClick = {
                        homeNavController.navigate(MainRouteScreens.BIFast.route)
                              
                    }, modifier = Modifier
                        .width(90.dp)
                        .background(Color(0xFF3D9EF8), shape = RoundedCornerShape(8.dp))
                        .padding(vertical = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bifast_ic),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(text = "BI FAST", fontSize = 10.sp)
            }
        }

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun BtSheetPrev() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        BottomSheetContent(
            onHideButtonClick = { },
            modifier = Modifier,
            homeNavController = rememberNavController()
        )
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BottomSheetGame(
    onHideButtonClick: () -> Unit,
    modifier: Modifier,
    paymentNavController: NavHostController,
    openBottomSheet: MutableState<Boolean>
) {

    Column(
        modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Anda akan membeli voucher google play dengan metode masukkan kode voucher google play pada aplikasi google play maupun website google play")
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Nominal                            : Rp20.000")
        Text(text = "Biaya Admin                    : Rp0")


        Spacer(modifier = Modifier.height(48.dp))

        Button(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                openBottomSheet.value = false
                paymentNavController.navigate(PaymentMenuScreens.PaymentSummary.route)
            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary)
        ) {
            Text(text = "Konfirmasi")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun BottomSheetGamePrev() {
    BottomSheetGame({}, Modifier, rememberNavController(), remember {
        mutableStateOf(true)
    })
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BottomSheetPulsa(
    onHideButtonClick: () -> Unit,
    modifier: Modifier,
    pulsaNavController: NavHostController,
    openBottomSheet: MutableState<Boolean>
) {

    Column(
        modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxWidth().background(color = Color.White),
//        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Row(Modifier.fillMaxWidth()) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.telkomsel_icon), contentDescription = null, modifier = Modifier.fillMaxWidth(0.1f))
            Text(text = "Telkomsel")
        }
        Row(Modifier.fillMaxWidth()) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.xl), contentDescription = null, modifier = Modifier.fillMaxWidth(0.3f))
            Text(text = "XL")
        }
        Row(Modifier.fillMaxWidth()) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.indosat), contentDescription = null, modifier = Modifier.fillMaxWidth(0.3f))
            Text(text = "Indosat")
        }
        Row(Modifier.fillMaxWidth()) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.smartfren), contentDescription = null, modifier = Modifier.fillMaxWidth(0.3f))
            Text(text = "Smartfren")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                openBottomSheet.value = false
//                pulsaNavController  .navigate("invoice")
            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary)
        ) {
            Text(text = "Konfirmasi")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun BottomSheetPulsaPrev() {
    BottomSheetPulsa({}, Modifier, rememberNavController(), remember {
        mutableStateOf(true)
    })
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BottomSheetJenisBpjs(
    onHideButtonClick: () -> Unit,
    modifier: Modifier,
    bpjsNavController: NavHostController,
    openBSJenisBpjs: MutableState<Boolean>
) {

    Column(
        modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        jenisBpjs.forEach {
            Row(Modifier.fillMaxWidth()) {
                Icon(painter = painterResource(id = R.drawable.bpjs), contentDescription = null, modifier = Modifier.fillMaxWidth(0.1f))

                Text(text = it)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                openBSJenisBpjs.value = false
//                pulsaNavController  .navigate("invoice")
            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary)
        ) {
            Text(text = "Konfirmasi")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun BottomSheetBpjsPrev() {
    BottomSheetJenisBpjs({}, Modifier, rememberNavController(), remember {
        mutableStateOf(true)
    })
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BottomSheetContentPembayaran(
    homeNavController: NavHostController,
    onHideButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier
                    .width(90.dp)
                    .background(Color(0xFF3D9EF8), shape = RoundedCornerShape(8.dp))
                    .padding(vertical = 8.dp)) {
                    Icon(imageVector = Icons.Default.Wifi, contentDescription = null, modifier = Modifier.fillMaxSize())
                }
                Text(text = "INTERNET BERLANGGANAN", fontSize = 10.sp)
            }


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier
                    .width(90.dp)
                    .background(Color(0xFF3D9EF8), shape = RoundedCornerShape(8.dp))
                    .padding(vertical = 8.dp)) {
                    Icon(imageVector = Icons.Default.ConnectedTv, contentDescription = null, modifier = Modifier.fillMaxSize())

                }
                Text(text = "TV BERLANGGANAN", fontSize = 10.sp)
            }

        }

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun BottomSheetPaymentPrev() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        BottomSheetContentPembayaran(
            rememberNavController(),
            onHideButtonClick = { },
            modifier= Modifier
        )
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BottomSheetContentSamsat(
    onHideButtonClick: () -> Unit,
    modifier: Modifier,
    samsatNavController: NavHostController,
    openBottomSheet: MutableState<Boolean>
) {

    Column(
        modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Anda akan membayar Pajak Tahunan kendaraan Bermotor dengan detail :")
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "PROVINSI                       : PAPUA SELATAN")
        Text(text = "NOMOR KENDARAAN                : PA7215KX")
        Text(text = "NAMA PEMILIK                   : Frederikus Mahuze")
        Text(text = "Nominal                        : 550.000")


        Spacer(modifier = Modifier.height(48.dp))

        Button(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                samsatNavController.navigate("invoice")
                openBottomSheet.value = false
            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary)
        ) {
            Text(text = "Konfirmasi")
        }
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun ESamsatPrev4() {
    BottomSheetContentSamsat({}, Modifier, rememberNavController(), remember {
        mutableStateOf(true)
    })
}