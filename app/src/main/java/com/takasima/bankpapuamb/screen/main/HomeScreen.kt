package com.takasima.bankpapuamb.screen.main

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.navigation.AuthRouteScreens
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.Visibility
import com.takasima.bankpapuamb.screen.common.VisibilityOff
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    modifier: Modifier = Modifier,
    openPayBottomSheet: MutableState<Boolean>
) {
//    var openBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier.background(Color(0xFF3eaed8))
        ) {
            MainBg()

            Scaffold(modifier = Modifier, containerColor = Color.Transparent,
                topBar = {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.10f)
                            .background(color = Color.Transparent)
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = {
                                rootNavController.navigate(Graph.PROFILE) {
                                    popUpTo(MainRouteScreens.Home.route) {
                                        inclusive = true
                                    }
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = null,
                                    Modifier.size(40.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = "Selamat Datang",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.LightGray,
                                    fontSize = 16.sp
                                )
                                Text(
                                    text = "userTest1",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Keluar",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            IconButton(onClick = {
                                rootNavController.navigate(AuthRouteScreens.Login.route) {
                                    popUpTo(Graph.HOME) {
                                        inclusive = true
                                    }

                                    launchSingleTop = true
                                }
                            }) {

                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                    contentDescription = null,
                                    Modifier.size(40.dp)
                                )
                            }
                        }
                    }
                }
            ) {

                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .padding(top = 100.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logobankpapua_2),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(100.dp)
                    )

                    Text(
                        text = "Saldo Rekening Anda",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Rp.************",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black
                        )

                        var passwordHidden by rememberSaveable { mutableStateOf(true) }
                        IconButton(onClick = { passwordHidden = !passwordHidden }) {
                            val visibilityIcon =
                                if (passwordHidden) Visibility else VisibilityOff
                            // Please provide localized description for accessibility services
                            val description =
                                if (passwordHidden) "Show password" else "Hide password"
                            Icon(imageVector = visibilityIcon, contentDescription = description)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Column(
                        verticalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Color(0x33063E71), shape = RoundedCornerShape(16.dp)
                            )
                            .padding(horizontal = 12.dp, vertical = 48.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.clickable {
                                    homeNavController.navigate(FeatureRouteScreens.TarikTunai1.route)
                                }
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.tarik_tunai),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)

                                )
                                Text(text = "Tarik Tunai", fontSize = 12.sp)
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.clickable {
                                    homeNavController.navigate(FeatureRouteScreens.DompetkuScreen.route)
                                }
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.dompetku),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)

                                )
                                Text(text = "Dompetku", fontSize = 12.sp)
                            }


                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.clickable {
                                    openPayBottomSheet.value = true
                                }) {

                                Image(
                                    painter = painterResource(id = R.drawable.transfer),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)

                                )
                                Text(text = "Transfer", fontSize = 12.sp)
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {
                                homeNavController.navigate(FeatureRouteScreens.PembayaranScreen.route)
                            }) {

                                Image(
                                    painter = painterResource(id = R.drawable.pembayaran),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)

                                )
                                Text(text = "Pembayaran", fontSize = 12.sp)
                            }
                        }

                        Spacer(modifier = Modifier.height(32.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp), verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.clickable {
                                homeNavController.navigate(FeatureRouteScreens.FavoriteScreen.route)
                            }
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)
                                )
                                Text(text = "Favorit", fontSize = 12.sp)
                            }


                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {
                                homeNavController.navigate(FeatureRouteScreens.BPJSScreen.route)
                            }) {

                                Image(
                                    painter = painterResource(id = R.drawable.travel),
                                    contentDescription = null,
                                    modifier = Modifier.size(64.dp)
                                )
                                Text(text = "BPJS", fontSize = 12.sp)
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {
                                homeNavController.navigate(FeatureRouteScreens.ESamsatScreen.route)
                            }
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.esamsat),
                                    contentDescription = null,
                                    modifier = Modifier.size(width = 110.dp, height = 64.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Text(text = "E-Samsat Papua", fontSize = 12.sp)
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {
                                homeNavController.navigate(FeatureRouteScreens.PACE.route)
                            }
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.pace_wa),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)

                                )
                                Text(text = "PACE", fontSize = 12.sp)
                            }
                        }
                    }


                }

                if (openPayBottomSheet.value) {
                    ModalBottomSheet(
                        sheetState = bottomSheetState,
                        onDismissRequest = { openPayBottomSheet.value = false },
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
                        BottomSheetContent(
                            onHideButtonClick = {
                                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) openPayBottomSheet.value =
                                        false
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

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen(rememberNavController(), rememberNavController(), openPayBottomSheet = remember {
        mutableStateOf(true)
    })
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BottomSheetContent(
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

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(
                    onClick = { /*TODO*/ }, modifier = Modifier
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
                    onClick = { /*TODO*/ }, modifier = Modifier
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
                    onClick = { /*TODO*/ }, modifier = Modifier
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
            modifier = Modifier
        )
    }
}
