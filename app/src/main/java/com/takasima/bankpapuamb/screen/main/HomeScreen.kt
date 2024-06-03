package com.takasima.bankpapuamb.screen.main

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
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.screen.common.Visibility
import com.takasima.bankpapuamb.screen.common.VisibilityOff
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(name: String, onClick: () -> Unit, navController: NavHostController, modifier: Modifier = Modifier) {
    var openBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(top = 32.dp),
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
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {
                        navController.navigate("tarik_tunai_screen")
                    }) {

                        Image(
                            painter = painterResource(id = R.drawable.tarik_tunai),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)

                        )
                        Text(text = "Tarik Tunai", fontSize = 12.sp)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

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
                            openBottomSheet = true
                        }) {

                        Image(
                            painter = painterResource(id = R.drawable.transfer),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)

                        )
                        Text(text = "Transfer", fontSize = 12.sp)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

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
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.bookmark),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                        Text(text = "Favorit", fontSize = 12.sp)
                    }


                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Image(
                            painter = painterResource(id = R.drawable.travel),
                            contentDescription = null,
                            modifier = Modifier.size(64.dp)
                        )
                        Text(text = "BPJS", fontSize = 12.sp)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Image(
                            painter = painterResource(id = R.drawable.esamsat),
                            contentDescription = null,
                            modifier = Modifier.size(width = 110.dp, height = 64.dp), contentScale = ContentScale.Fit
                        )
                        Text(text = "E-Samsat Papua", fontSize = 12.sp)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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

        if (openBottomSheet) {
            ModalBottomSheet(
                sheetState = bottomSheetState,
                onDismissRequest = { openBottomSheet = false },
                dragHandle = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                    ) {
                        BottomSheetDefaults.DragHandle()
                        Text(text = "TRANSFER", fontWeight = FontWeight.ExtraBold, fontSize = 32.sp)
                        Spacer(modifier = modifier.height(10.dp))
                        Divider()
                    }
                }
            ) {
                BottomSheetContent(
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

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen("home", {}, rememberNavController())
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
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier
                    .width(90.dp)
                    .background(Color(0xFF3D9EF8), shape = RoundedCornerShape(8.dp))
                    .padding(vertical = 8.dp)) {
                    Image(painter = painterResource(id = R.drawable.bank_tujuan_ic), contentDescription = null, modifier = Modifier.fillMaxSize())
                }
                Text(text = "TRANSFER ANTAR BANK", fontSize = 10.sp)
            }


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier
                    .width(90.dp)
                    .background(Color(0xFF3D9EF8), shape = RoundedCornerShape(8.dp))
                    .padding(vertical = 8.dp)) {
                    Image(painter = painterResource(id = R.drawable.bank_sesama_ic), contentDescription = null, modifier = Modifier.fillMaxSize())
                }
                Text(text = "TRANSFER SESAMA BANK", fontSize = 10.sp)
            }


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier
                    .width(90.dp)
                    .background(Color(0xFF3D9EF8), shape = RoundedCornerShape(8.dp))
                    .padding(vertical = 8.dp)) {
                    Image(painter = painterResource(id = R.drawable.bifast_ic), contentDescription = null, modifier = Modifier.fillMaxSize())
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
            modifier= Modifier
        )
    }
}
