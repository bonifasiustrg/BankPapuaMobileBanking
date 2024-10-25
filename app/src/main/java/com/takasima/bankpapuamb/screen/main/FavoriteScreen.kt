package com.takasima.bankpapuamb.screen.main

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.screen.common.CustomTopBar
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.Visibility
import com.takasima.bankpapuamb.screen.common.VisibilityOff
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import com.takasima.bankpapuamb.utils.banks

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoriteScreen(homeNavController: NavHostController, modifier: Modifier = Modifier) {
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
                    CustomTopBar("FAVORITE", { homeNavController.navigateUp() })

//                    Row(
//                        Modifier
//                            .fillMaxWidth()
//                            .fillMaxHeight(0.08f)
//                            .background(color = Color(0xB3AAE4F6))
//                            .padding(top = 16.dp)
//                            .padding(horizontal = 16.dp),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        IconButton(onClick = {
//                            homeNavController.navigateUp()
//                        }) {
//                            Icon(
//                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
//                                contentDescription = null,
//                                Modifier.size(32.dp)
//                            )
//                        }
//                        Text(
//                            text = "FAVORITE",
//                            color = terniary,
//                            fontWeight = FontWeight.ExtraBold,
//                            modifier = Modifier.fillMaxWidth(),
//                            textAlign = TextAlign.Center,
//                            fontSize = 24.sp
//                        )
//                    }
                }
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(Color(0xFFebe8e8))
                        .padding(vertical = 16.dp)

                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .wrapContentHeight()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Aktivitas Terakhir",
                            fontWeight = FontWeight.Bold,
                            color = terniary,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White
                                ),
                                border = BorderStroke(width = 1.dp, color = Color.Black)
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)

                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.bankbri_ic),
                                        contentDescription = null,
                                        modifier = Modifier.size(48.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = "BRI - Raynaldi",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 18.sp
                                        )
                                        Text(
                                            text = "3784 3647 8495 364",
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White
                                ),
                                border = BorderStroke(width = 1.dp, color = Color.Black)
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.dana),
                                        contentDescription = null,
                                        modifier = Modifier.size(48.dp)

                                    )
                                    Spacer(modifier = Modifier.width(8.dp))

                                    Column {
                                        Text(
                                            text = "Dana - Tasya",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 18.sp
                                        )
                                        Text(text = "0812233345", fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                        }



                        Spacer(modifier = Modifier.height(32.dp))

                        Button(
                            shape = RoundedCornerShape(25),

                            modifier = modifier.align(Alignment.CenterHorizontally),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = secondary,
                                contentColor = Color.White
                            ),
                            onClick = {
                                homeNavController.navigate("favoritesect2")
                            }) {
                            Text(
                                modifier = Modifier.padding(horizontal = 32.dp),

                                text = "Tambah Favorit Baru",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = RoundedCornerShape(16.dp))
                            .wrapContentHeight()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Daftar Favorite",
                            fontWeight = FontWeight.Bold,
                            color = terniary,
                            fontSize = 24.sp
                        )
                        Spacer(modifier = Modifier.height(24.dp))


                        var text by remember { mutableStateOf("") }
                        var active by remember { mutableStateOf(false) }
                        var items = remember {
                            mutableStateListOf<String>(
                                "Bank BRI",
                                "BCA"
                            )
                        }

                        SearchBar(
                            colors = SearchBarDefaults.colors(
                                containerColor = Color.White
                            ),
                            query = text,
                            onQueryChange = { text = it },
                            onSearch = {
                                items.add(text)
                                active = false
                                text = ""
                            },
                            active = false,
                            onActiveChange = { active = it },
                            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
                            trailingIcon = {
                                if (active) {
                                    Icon(modifier = modifier.clickable {
                                        if (text.isNotEmpty()) {
                                            text = ""
                                        } else active = false
                                    }, imageVector = Icons.Default.Close, contentDescription = null)
                                }
                            },
                            modifier = modifier
                                .fillMaxWidth()
                                .border(
                                    width = 1.dp,
                                    color = Color.Black,
                                    shape = RoundedCornerShape(16.dp)
                                )
                        ) {
                            /*items.forEach {
                                Row(modifier = modifier.padding(14.dp)) {
                                    Icon(
                                        modifier = modifier.padding(end = 10.dp),
                                        imageVector = Icons.Default.History,
                                        contentDescription = null
                                    )

                                    Text(text = it)
                                }
                            }*/
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn(
                            Modifier
                                .fillMaxSize()
                                .background(Color.White, shape = RoundedCornerShape(16.dp))
                                .padding(vertical = 16.dp, horizontal = 8.dp)) {
                            items(2) {
                                Row(modifier = modifier
                                    .fillMaxWidth()
                                    .clickable {
                                    }
                                    .padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        modifier = modifier
                                            .size(48.dp)
                                            .padding(end = 10.dp),
//                    imageVector = Icons.Default.AccountBalance,
                                        painter = painterResource(id = R.drawable.bankbri_ic),
                                        contentDescription = null
                                    )

                                    Column {
                                    Text(text = "BANK RAKYAT INDONESIA", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                        Text(text = "3784 3647 8495 364", fontSize = 12.sp, fontWeight = FontWeight.Bold)

                                    }
                                    Spacer(modifier = Modifier.weight(1f))

                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(imageVector = Icons.Outlined.Delete, contentDescription = null)
                                    }
                                }
                                Divider(thickness = 1.dp, color = Color.Black)
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }
                        Spacer(modifier = Modifier.height(32.dp))
                    }


                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun FavoriteScreenPrev() {
    FavoriteScreen(rememberNavController())
}