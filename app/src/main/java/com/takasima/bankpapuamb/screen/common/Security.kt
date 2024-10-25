package com.takasima.bankpapuamb.screen.common

import androidx.compose.foundation.background
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

@Composable
fun SecurityScreen(menuNavController: NavHostController, rute: String = FeatureRouteScreens.PembayaranMainSection.route) {

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
                            menuNavController.navigateUp()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                                contentDescription = null,
                                Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = "Security  ",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp
                        )
                    }
                }
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(Color.Transparent)
                        .padding(horizontal = 24.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    TTSection1(homeNavController, modifier)
                    Spacer(modifier = Modifier.height(64.dp))
                    Text(
                        text = "Silahkan Masukkan PIN Anda",
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    OptTextFieldPIN(bgColor = Color.White)

                    Spacer(modifier = Modifier.height(100.dp))
                    Button(
                        modifier = Modifier.width(200.dp),
                        onClick = {
                            menuNavController.navigate(rute)
                            menuNavController.popBackStack()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = secondary)
                    ) {
                        Text(text = "Konfirmasi")
                    }
                    /*TextButton(onClick = { *//*TODO*//* }) {
                        Text(
                            text = "Kirim ulang kode", color = Color.White, style = TextStyle(
                                textDecoration = TextDecoration.Underline,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,

                                )
                        )

                    }*/
                }
            }
        }
    }

}
@Composable
fun SecurityScreen2(menuNavController: NavHostController, rute: String) {

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
                            menuNavController.navigateUp()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                                contentDescription = null,
                                Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = "Security  ",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp
                        )
                    }
                }
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(Color.Transparent)
                        .padding(horizontal = 24.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    TTSection1(homeNavController, modifier)
                    Spacer(modifier = Modifier.height(64.dp))
                    Text(
                        text = "Silahkan Masukkan PIN Anda",
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    OptTextFieldPIN(bgColor = Color.White)

                    Spacer(modifier = Modifier.height(100.dp))
                    Button(
                        modifier = Modifier.width(200.dp),
                        onClick = {
                            menuNavController.navigate(rute) {
                                menuNavController.popBackStack()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = secondary)
                    ) {
                        Text(text = "Konfirmasi")
                    }
                    /*TextButton(onClick = { *//*TODO*//* }) {
                        Text(
                            text = "Kirim ulang kode", color = Color.White, style = TextStyle(
                                textDecoration = TextDecoration.Underline,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,

                                )
                        )

                    }*/
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun SecurityScreenPrev() {
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SecurityScreen(
            rememberNavController(),
        )
    }
}