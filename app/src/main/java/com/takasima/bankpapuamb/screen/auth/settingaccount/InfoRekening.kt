package com.takasima.bankpapuamb.screen.auth.settingaccount

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.navigation.ProfileRouteScreens
import com.takasima.bankpapuamb.screen.common.CustomTopBar
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.ui.theme.terniary2

@Composable
fun Simpeda(profileNavController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {

            Scaffold(modifier = Modifier, containerColor = Color.Transparent, topBar = {
                CustomTopBar("Rekening SIMPEDA", {
                    profileNavController.navigateUp()
                })
            }) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(Color.White)
                ) {
                    Spacer(Modifier.height(32.dp))
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .background(color = Color(0xFFf6f0f0))
                            .padding(vertical = 16.dp)
                            .padding(end = 16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .background(
                                    color = Color(0xFF71b5f6), shape = RoundedCornerShape(8.dp)
                                )
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) { // Simpeda
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                modifier = Modifier

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ornamen),
                                    contentDescription = "ornamen",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .wrapContentHeight()
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ornamen),
                                    contentDescription = "ornamen",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .wrapContentHeight()
                                )
                            }
                            Spacer(Modifier.width(24.dp))
                            Image(
                                painter = painterResource(id = R.drawable.bankpapua5),
                                contentDescription = "simpeda",
                                modifier = Modifier.size(width = 100.dp, height = 64.dp)
                            )


                        }
                        Spacer(Modifier.width(16.dp))
                        Column {
                            Text(
                                text = "9123 8345 2534 523",
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Frederikus Mahuze",
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(72.dp))
                            Text(
                                text = "47565 754658 283",
                                Modifier.fillMaxWidth(),
                                textAlign = TextAlign.End,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Simanja(profileNavController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {

            Scaffold(modifier = Modifier, containerColor = Color.Transparent, topBar = {
                CustomTopBar("Rekening SIMANJA", {
                    profileNavController.navigateUp()
                })
            }) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(Color.White)
                ) {
                    Spacer(Modifier.height(32.dp))
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .background(color = Color(0xFFf6f0f0))
                            .padding(vertical = 16.dp)
                            .padding(end = 16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .background(
                                    color = Color.LightGray, shape = RoundedCornerShape(8.dp)
                                )
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) { // Simpeda
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                modifier = Modifier

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ornamen),
                                    contentDescription = "ornamen",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .wrapContentHeight()
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ornamen),
                                    contentDescription = "ornamen",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .wrapContentHeight()
                                )
                            }
                            Spacer(Modifier.width(24.dp))
                            Image(
                                painter = painterResource(id = R.drawable.bankpapua5),
                                contentDescription = "simpeda",
                                modifier = Modifier.size(width = 100.dp, height = 64.dp)
                            )


                        }
                        Spacer(Modifier.width(16.dp))
                        Column {
                            Text(
                                text = "9123 8345 2534 523",
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Frederikus Mahuze",
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(72.dp))
                            Text(
                                text = "47565 754658 283",
                                Modifier.fillMaxWidth(),
                                textAlign = TextAlign.End,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(Modifier.height(24.dp))
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .background(color = Color(0xFFf6f0f0))
                            .padding(vertical = 16.dp)
                            .padding(end = 16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .background(
                                    color = Color.LightGray, shape = RoundedCornerShape(8.dp)
                                )
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) { // Simpeda
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                modifier = Modifier

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ornamen),
                                    contentDescription = "ornamen",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .wrapContentHeight()
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ornamen),
                                    contentDescription = "ornamen",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .wrapContentHeight()
                                )
                            }
                            Spacer(Modifier.width(24.dp))
                            Image(
                                painter = painterResource(id = R.drawable.bankpapua5),
                                contentDescription = "simpeda",
                                modifier = Modifier.size(width = 100.dp, height = 64.dp)
                            )


                        }
                        Spacer(Modifier.width(16.dp))
                        Column {
                            Text(
                                text = "5687 7547 8572 231",
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Frederikus Mahuze",
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(72.dp))
                            Text(
                                text = "47565 754658 283",
                                Modifier.fillMaxWidth(),
                                textAlign = TextAlign.End,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SimpedaPrev() {
    Simpeda(rememberNavController())
}

@Preview(showBackground = true)
@Composable
private fun SimanjaPrev() {
    Simanja(rememberNavController())
}