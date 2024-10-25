package com.takasima.bankpapuamb.screen.main

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.screen.common.CustomTopBar
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.main.homemenu.BukuKeuanganItem
import com.takasima.bankpapuamb.screen.main.homemenu.TabItem
import com.takasima.bankpapuamb.ui.theme.circle
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HistoryScreen(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember {
        mutableIntStateOf(1)
    }

    val tabItem = listOf(
        "April", "Mei", "Juni", "Juli", "Agustus"
    )

    val pagerState = rememberPagerState {
        tabItem.size
    }

    LaunchedEffect(key1 = selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(key1 = pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress)
            selectedTabIndex = pagerState.currentPage
    }

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
                    CustomTopBar("AKTIVITAS", {
                        homeNavController.popBackStack()
                        homeNavController.navigate(MainRouteScreens.Home.route)
                    })

                }
            ) {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .background(White)
                        .fillMaxSize()
                        .padding(vertical = 8.dp, horizontal = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Transaksi", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        TextButton(onClick = { homeNavController.navigate("estatement") }
                        ) {
                            Text(
                                text = "e-statement",
                                color = terniary,
                                fontWeight = FontWeight.Bold
                            )

                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        TabRow(
                            modifier = Modifier.fillMaxWidth(0.85f),
                            selectedTabIndex = selectedTabIndex,
                            indicator = { tabPositions ->
                                TabRowDefaults.Indicator(
                                    Modifier
                                        .tabIndicatorOffset(tabPositions[selectedTabIndex]),
                                    color = terniary // Change this to any color you want
                                )
                            }) {
                            tabItem.forEachIndexed { index, tabItem ->

                                Tab(
                                    selected = index == selectedTabIndex,
                                    onClick = {
                                        selectedTabIndex = index
                                    },
                                    icon = {
                                        Text(
                                            text = tabItem,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 14.sp
                                        )
                                        /*if (selectedTabIndex == index) {

                                            Button(
                                                onClick = { selectedTabIndex = index },
                                                colors = ButtonDefaults.buttonColors(
                                                    containerColor = circle,
                                                    contentColor = White,

                                                    ),
                                                contentPadding = PaddingValues(),
                                                modifier = Modifier
                                                    .height(24.dp)
                                                    .padding(horizontal = 16.dp),
                                                shape = RoundedCornerShape(50),
                                                border = BorderStroke(2.dp, circle)
                                            ) {
                                                Text(
                                                    text = "Pengeluaran",
                                                    modifier = Modifier.padding(horizontal = 24.dp),
                                                    fontSize = 14.sp
                                                )

                                            }
                                        } else {
                                            OutlinedButton(
                                                onClick = { selectedTabIndex = index },
                                                colors = ButtonDefaults.buttonColors(
                                                    containerColor = White,
                                                    contentColor = circle,

                                                    ),
                                                contentPadding = PaddingValues(),
                                                modifier = Modifier
                                                    .height(24.dp)
                                                    .padding(horizontal = 16.dp),
                                                shape = RoundedCornerShape(50),
                                                border = BorderStroke(2.dp, circle)
                                            ) {
                                                Text(
                                                    text = "Pemasukan",
                                                    modifier = Modifier.padding(horizontal = 24.dp),
                                                    fontSize = 14.sp

                                                )

                                            }
                                        }*/
                                    }

                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        VerticalDivider(color = LightGray, height = 36.dp)
                        IconButton(onClick = { /*TODO*/ }, modifier.weight(1f)) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        }
                    }


                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)

                    ) { index ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 16.dp)
                        ) {
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                items(5) {
                                    HistoryItem2(homeNavController, status = if (it == 1) false else true)
                                }
                            }
                            /*when (tabItem[index]) {
                                "April" -> {
                                    Column(
                                        modifier = Modifier
                                            .verticalScroll(rememberScrollState())

                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(8.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                "Jumat, 19 Mar 2024",
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                "Rp200.OOO",
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                        Divider(thickness = 1.dp, color = Black)

                                        *//*LazyColumn(
                                            Modifier
                                                .fillMaxSize()
                                                .padding(it)
                                                .background(Color.White, shape = RoundedCornerShape(16.dp))
                                                .padding(horizontal = 16.dp),
                                            verticalArrangement = Arrangement.Top,
                                            horizontalAlignment = Alignment.Start
                                        ) {
                                            items(15) {

                                                HistoryItem()
                                            }
                                        }*//*
                                    }

                                }

                                "Mei" -> {


                                }

                                "Juni" -> {}
                                "Juli" -> {}
                                "Agustus" -> {}
                            }*/
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun HistoryItem(modifier: Modifier = Modifier) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), colors = CardDefaults.cardColors(
            containerColor = Color(0x66C5C5C5)
        )
    ) {
        Row(Modifier.padding(16.dp)) {
            Icon(
                imageVector = Icons.Default.CheckCircle, contentDescription = null, tint = Color(
                    0xFF009688
                )
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(Modifier.weight(2f)) {
                Text("Dompetku", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "DANA - 0813228796")
                Text(text = "No.ref: 873483723123")
                Text(text = "Tanggal Transaksi : 29 Aug 2024")
            }

            Column() {
                Button(
                    onClick = { /*TODO*/ },
                    contentPadding = PaddingValues(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688)),
                    modifier = Modifier
//                        .defaultMinSize(1.dp)
                        .size(width = 100.dp, height = 24.dp)
//                        .shadow(
//                        elevation = 8.dp,
//                        ambientColor = Gray,
//                        shape = RoundedCornerShape(16.dp)
//                    )
                ) {
                    Text(text = "Berhasil", color = White)
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { /*TODO*/ },
                    contentPadding = PaddingValues(),
                    colors = ButtonDefaults.buttonColors(containerColor = White),
                    modifier = Modifier
                        .size(width = 100.dp, height = 24.dp)
//                        .shadow(
//                        elevation = 8.dp,
//                        ambientColor = Gray,
//                        shape = RoundedCornerShape(48.dp)
//                    )
                ) {
                    Text(text = "Detail", color = Color(0xFFFDB807))
                }
            }
        }
    }
    Divider(thickness = 1.dp, color = Black, modifier = Modifier.padding(vertical = 8.dp))
}

@Composable
fun HistoryItem2(homeNavController: NavHostController, status: Boolean = true, modifier: Modifier = Modifier) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Transparent
        )
    ) {
        Row(verticalAlignment = Alignment.Top) {
            if (status) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = Color(
                        0xFF4caf50

                    ),
                    modifier = Modifier.size(32.dp)

                )
            } else {
                Icon(
                    imageVector = Icons.Default.Cancel, contentDescription = null, tint = Red,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Column(Modifier.weight(2f)) {
                Text("Transfer Antar Bank", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "Bank BNI - 06354254123")
                Text(text = "No.ref: 8237377212")
                Text(text = "Tanggal Transaksi : 29 Jul 2024")
            }
            Column() {
                Button(
                    onClick = { /*TODO*/ },
                    contentPadding = PaddingValues(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (status) Color(
                            0xFF4caf50
                        ) else Red
                    ),
                    modifier = Modifier
//                        .defaultMinSize(1.dp)
                        .size(width = 100.dp, height = 24.dp)
//                        .shadow(
//                        elevation = 8.dp,
//                        ambientColor = Gray,
//                        shape = RoundedCornerShape(16.dp)
//                    ),
                    , shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = if (status) "Berhasil" else "Gagal", color = White)
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        homeNavController.navigate("invoice3")
                    },
                    contentPadding = PaddingValues(),
                    colors = ButtonDefaults.buttonColors(containerColor = White),
                    modifier = Modifier
                        .shadow(2.dp, RoundedCornerShape(8.dp))
                        .size(width = 100.dp, height = 24.dp)
//                        .shadow(
//                        elevation = 8.dp,
//                        ambientColor = Gray,
//                        shape = RoundedCornerShape(48.dp)
//                    )
                    , shape = RoundedCornerShape(8.dp)

                ) {
                    Text(text = "Detail", color = Color(0xFFFDB807))
                }
            }
        }
    }
    Divider(thickness = 1.dp, color = Black)
}

@Preview(showBackground = true)
@Composable
private fun TesPrev() {
    Column {
        HistoryItem()
        Spacer(modifier = Modifier.height(32.dp))
        HistoryItem2(rememberNavController())

    }
}

@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
    thickness: Dp = 1.dp,
    height: Dp = 50.dp
) {
    Divider(
        color = color,
        modifier = modifier
            .width(thickness)
            .height(height)
    )
}

@Preview(showBackground = true)
@Composable
private fun HistoryPrev() {
    HistoryScreen(
        rememberNavController(),
        rememberNavController()
    )
}