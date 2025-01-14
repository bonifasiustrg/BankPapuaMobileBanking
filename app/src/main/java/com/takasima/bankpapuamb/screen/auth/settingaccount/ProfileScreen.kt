package com.takasima.bankpapuamb.screen.auth.settingaccount

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.navigation.AuthRouteScreens
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.navigation.ProfileRouteScreens
import com.takasima.bankpapuamb.screen.common.CustomTopBar
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.ui.theme.biru2
import com.takasima.bankpapuamb.ui.theme.lightgrey
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

@Composable
fun ProfileScreen(name: String, rootNavController: NavHostController, profileNavController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {

            Scaffold(modifier = Modifier, containerColor = Color.Transparent,
                topBar = {
                    CustomTopBar("Profile", {
                        rootNavController.navigateUp()
                    })
                }
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(Color.White)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Spacer(modifier = Modifier.height(32.dp))


                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = null,
                            modifier = Modifier
                                .size(64.dp)
                                .background(shape = RectangleShape, color = Color.LightGray)
                        )
                        Text(
                            text = "Frederikus Mahuze",
                            fontSize = 28.sp,
                            color = biru2,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(start = 12.dp)
                        )

                    }

                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 8.dp), thickness = 1.dp, color = Color.Black)

                    TextButton(
                        onClick = {
                            profileNavController.navigate(ProfileRouteScreens.SettingAkun.route) {

                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = lightgrey, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)

                    ) {
                        Text(
                            text = "Pengaturan Akun",
                            fontSize = 20.sp,
                            color = biru2,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            modifier= Modifier.fillMaxWidth()
                        )
                    }

                    TextButton(
                        onClick = {
                            profileNavController.navigate(ProfileRouteScreens.SettingKredit.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = lightgrey, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)

                    ) {
                        Text(
                            text = "Setting Kredit",
                            fontSize = 20.sp,
                            color = biru2,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            modifier= Modifier.fillMaxWidth()
                        )
                    }

                    Text(
                        text = "Pusat Informasi",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    )
                    TextButton(
                        onClick = {
                            profileNavController.navigate(ProfileRouteScreens.Kurs.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = lightgrey, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)

                    ) {
                        Text(
                            text = "Informasi Kurs",
                            fontSize = 20.sp,
                            color = biru2,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            modifier= Modifier.fillMaxWidth()
                        )
                    }

                    TextButton(
                        onClick = {
                            profileNavController.navigate(ProfileRouteScreens.Lokasi.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = lightgrey, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)

                    ) {
                        Text(
                            text = "Lokasi Kantor Bank Papua",
                            fontSize = 20.sp,
                            color = biru2,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            modifier= Modifier.fillMaxWidth()
                        )
                    }

                    Text(
                        text = "Tentang Kami",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    )
                    TextButton(
                        onClick = {
                            profileNavController.navigate(ProfileRouteScreens.SnK.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = lightgrey, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)

                    ) {
                        Text(
                            text = "Syarat dan ketentuan",
                            fontSize = 20.sp,
                            color = biru2,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            modifier= Modifier.fillMaxWidth()
                        )
                    }

                    TextButton(
                        onClick = {
                            profileNavController.navigate(ProfileRouteScreens.Help.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = lightgrey, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)

                    ) {
                        Text(
                            text = "Pusat Bantuan",
                            fontSize = 20.sp,
                            color = biru2,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            modifier= Modifier.fillMaxWidth()
                        )
                    }

                    Button(
                        shape = RoundedCornerShape(25),
                        modifier = modifier.align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = secondary,
                            contentColor = Color.White
                        ),
                        onClick = {
                            rootNavController.navigate(AuthRouteScreens.Login.route) {
                                popUpTo(Graph.HOME) {
                                    inclusive = true
                                }

                                launchSingleTop = true
                            }
                        }) {
                        Text(
                            modifier = Modifier.padding(horizontal = 32.dp),
                            text = "LOG OUT",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TFAntarBankScreenPrev() {
    ProfileScreen("Profile Screen", rememberNavController(), rememberNavController())
}