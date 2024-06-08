package com.takasima.bankpapuamb.screen.main.payment

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.icons.outlined.ContactMail
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.PaymentMenuScreens
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.SecurityScreen
import com.takasima.bankpapuamb.screen.common.TagihanSection1
import com.takasima.bankpapuamb.screen.common.TagihanSection2
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AirScreen(
    paymentNavController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val airNavController = rememberNavController()

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
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.08f)
                            .background(color = Color(0xB3AAE4F6))
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = null,
                            Modifier.size(32.dp)
                        )
                        Text(
                            text = "PEMBAYARAN AIR",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 32.sp
                        )
                    }
                }
            ) {
                NavHost(navController = airNavController, startDestination = "airsection1") {
                    composable("airsection1"){
                        AirScreenSection1(paymentNavController = paymentNavController, airNavController = airNavController, openBottomSheet = openBottomSheet)
                    }
                    composable("airtagihan1"){
                        TagihanSection1(paymentNavController, airNavController)
                    }
                    composable("airtagihan2"){
                        TagihanSection2(paymentNavController, airNavController)
                    }
                    composable(FeatureRouteScreens.Security.route){
                        SecurityScreen(paymentNavController, airNavController)
                    }

                }
                if (openBottomSheet.value) {
                    ModalBottomSheet(
                        sheetState = bottomSheetState,
                        onDismissRequest = { openBottomSheet.value = false },
                        dragHandle = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)) {
                                BottomSheetDefaults.DragHandle()
                                Text(text = "TRANSFER", fontWeight = FontWeight.ExtraBold, fontSize = 32.sp)
                                Spacer(modifier = modifier.height(10.dp))
                                Divider()
                            }
                        }
                    ) {
                        BottomSheetLocation(
                            onHideButtonClick = {
                                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) openBottomSheet.value = false
                                }
                            },
                            modifier
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AirScreenSection1(
    modifier: Modifier = Modifier,
    paymentNavController: NavHostController,
    airNavController: NavHostController,
    openBottomSheet: MutableState<Boolean>
) {
    val noRek = remember { mutableStateOf("") }


    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = "BAYAR AIR",
            color = terniary,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable {
                    openBottomSheet.value = !openBottomSheet.value
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = null,
                modifier = modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "PILIH LOKASI",
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.weight(1f)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))


        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = noRek.value,
            onValueChange = { noRek.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.ContactMail,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .size(48.dp)
                )
            },
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(text = "NOMOR PELANGGAN ") }
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                      airNavController.navigate("airtagihan1")
            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary)
        ) {
            Text(text = "Konfirmasi")
        }
    }
}



@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BottomSheetLocation(
    onHideButtonClick: () -> Unit,
    modifier: Modifier
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
            Text(text = "LIST LOKASI", fontSize = 10.sp)

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier
                    .width(90.dp)
                    .background(Color(0xFF3D9EF8), shape = RoundedCornerShape(8.dp))
                    .padding(vertical = 8.dp)) {
                    Icon(imageVector = Icons.Default.Wifi, contentDescription = null, modifier = Modifier.fillMaxSize())
                }
            }



        }

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun AirScreenPrev() {
    AirScreen(rememberNavController()/*, rememberNavController()*/)
}
