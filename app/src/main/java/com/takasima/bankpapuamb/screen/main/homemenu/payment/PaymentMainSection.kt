package com.takasima.bankpapuamb.screen.main.homemenu.payment

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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.navigation.PaymentMenuScreens
import com.takasima.bankpapuamb.navigation.ProfileRouteScreens
import com.takasima.bankpapuamb.screen.common.BottomSheetContentPembayaran
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.Visibility
import com.takasima.bankpapuamb.screen.common.VisibilityOff
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMainSection(
    homeNavController: NavHostController,
    paymentNavController: NavHostController,
    modifier: Modifier = Modifier,

) {
    var openBottomSheet = remember { mutableStateOf(false) }
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
                            .padding(top = 16.dp)
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = {
                                homeNavController.navigate(ProfileRouteScreens.Profile.route) {
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
                                    text = "PEMBAYARAN",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Halaman\nUtama",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            IconButton(onClick = {
                                homeNavController.navigate(MainRouteScreens.Home.route)
                            }) {

                                Icon(
                                    imageVector = Icons.Default.Home,
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
                        .padding(it)
                        .padding(horizontal = 16.dp),
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
                            .padding(vertical = 32.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.clickable {
                                    paymentNavController.navigate(PaymentMenuScreens.AirScreen.route)
                                }
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.water),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)

                                )
                                Text(text = "Pembayaran Air", fontSize = 12.sp)
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally,

                                modifier = Modifier.clickable {
//                                    paymentNavController.navigate(PaymentMenuScreens.InternetScreen.route)
                                    openBottomSheet.value = !openBottomSheet.value
                                }
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.internet),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)

                                )
                                Text(text = "Pembayaran\nTV/Internet\nberlangganan", fontSize = 12.sp)
                            }


                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.clickable {
                                    paymentNavController.navigate(PaymentMenuScreens.ListrikScreen.route)
                                }) {

                                Image(
                                    painter = painterResource(id = R.drawable.listrik),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)

                                )
                                Text(text = "Pembayaran\nListrik", fontSize = 12.sp, textAlign = TextAlign.Center)
                            }
                        }

                        Spacer(modifier = Modifier.height(32.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp), verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.clickable {
                                    paymentNavController.navigate(PaymentMenuScreens.Pendidikan.route)
                                }
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.pendidikan),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)
                                )
                                Text(text = "Pendidikan", fontSize = 12.sp)
                            }


                            Column(horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.clickable {
                                    paymentNavController.navigate(PaymentMenuScreens.GameScreen.route)
                                }
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.game),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)
                                )
                                Text(text = "Voucher Game", fontSize = 12.sp)
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.clickable {
                                    paymentNavController.navigate(PaymentMenuScreens.PulsaScreen.route)
                                }
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.pulsa),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)
                                )
                                Text(text = "Pulsa", fontSize = 12.sp)
                            }
                        }
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
                        BottomSheetContentPembayaran(
                            homeNavController = homeNavController,
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