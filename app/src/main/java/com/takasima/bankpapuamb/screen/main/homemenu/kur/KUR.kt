package com.takasima.bankpapuamb.screen.main.homemenu.kur

import android.annotation.SuppressLint
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
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
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.screen.common.CustomTopBar
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun KURScreen(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    modifier: Modifier = Modifier
) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {

            Scaffold(modifier = Modifier, containerColor = Transparent,
                topBar = {
                    CustomTopBar("KREDIT USAHA RAKYAT", {
                        homeNavController.popBackStack()
                        homeNavController.navigate(MainRouteScreens.Home.route)
                    })

                }
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .background(
                                Color(0xFF6285a6),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .padding(64.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable {
                                homeNavController.navigate("snkKUR")

                            }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ajukan_kur),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(48.dp)
                                    .padding(bottom = 4.dp),
                                contentScale = ContentScale.Crop

                            )
                            Text(
                                text = "Pengajuan KUR",
                                textAlign = TextAlign.Center,
                                fontSize = 13.sp
                            )
                        }
                        Spacer(modifier = Modifier.width(64.dp))

                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable {
                                homeNavController.navigate("pembayaranKUR")

                            }
                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.bayar_kur2),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(48.dp)
                                    .padding(bottom = 4.dp),
                                contentScale = ContentScale.Crop

                            )
                            Text(
                                text = "Pembayaran KUR",
                                textAlign = TextAlign.Center,
                                fontSize = 13.sp
                            )
                        }

                    }
                    Spacer(modifier = Modifier.height(32.dp))

                    Column(
                        Modifier
                            .fillMaxSize()
                            .background(White), horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "KREDIT USAHA RAKYAT YANG TERPAKAI",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(text = "Rp.XXXXXX", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Daftar Kredit Usaha Rakyat",
                            color = terniary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Divider(
                            color = Black,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }
                }

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun KURScreenPrev() {
    KURScreen(rememberNavController(), rememberNavController())
}