package com.takasima.bankpapuamb.screen.main.payment

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Wifi
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.Visibility
import com.takasima.bankpapuamb.screen.common.VisibilityOff
import com.takasima.bankpapuamb.screen.main.BottomBar
import com.takasima.bankpapuamb.screen.main.BottomSheetContent
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PembayaranScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    var openBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()


        var openBottomSheet by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()
        val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)

        Box(
            modifier = Modifier
        ) {

            Scaffold(modifier = Modifier, containerColor = Color.Transparent,
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
                            text = "PEMBAYARAN",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 32.sp
                        )
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
                            .padding(horizontal = 12.dp, vertical = 32.dp)
                    ) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                                Image(
                                    painter = painterResource(id = R.drawable.water),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)

                                )
                                Text(text = "Pembayaran Air")
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                                Image(
                                    painter = painterResource(id = R.drawable.internet),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)

                                )
                                Text(text = "Pembayaran\nTV/Internet\nberlangganan")
                            }


                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {
                                openBottomSheet = true
                            }) {

                                Image(
                                    painter = painterResource(id = R.drawable.listrik),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)

                                )
                                Text(text = "Pembayaran\nListrik")
                            }
                        }

                        Spacer(modifier = Modifier.height(32.dp))

                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp), verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = R.drawable.pendidikan),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)
                                )
                                Text(text = "Pendidikan")
                            }


                            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                                Image(
                                    painter = painterResource(id = R.drawable.game),
                                    contentDescription = null,
                                    modifier = Modifier.size(48.dp)
                                )
                                Text(text = "Voucher Game")
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {

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


                if (openBottomSheet) {
                    ModalBottomSheet(
                        sheetState = bottomSheetState,
                        onDismissRequest = { openBottomSheet = false },
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
                            onHideButtonClick = {
                                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) openBottomSheet = false
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
@Composable
fun BottomSheetContentPembayaran(
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
private fun PembayaranScreenPrev() {
    PembayaranScreen()
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun BtSheetPrev() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        BottomSheetContentPembayaran(
            onHideButtonClick = { },
            modifier= Modifier
        )
    }
}