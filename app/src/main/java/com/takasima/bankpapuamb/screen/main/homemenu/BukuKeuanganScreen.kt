package com.takasima.bankpapuamb.screen.main.homemenu

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.screen.common.CustomTopBar
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.ui.theme.circle
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BukuKeuanganScreen(rootNavController: NavHostController, homeNavController: NavHostController, modifier: Modifier = Modifier ) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val tabItem = listOf(
        TabItem(
            title = "Pengeluaran", unSelectedItem = Icons.Outlined.Home, selectedIcon = Icons.Filled.Home
        ), TabItem(
            title = "Pemasukan",
            unSelectedItem = Icons.Outlined.ShoppingCart,
            selectedIcon = Icons.Filled.ShoppingCart
        ),
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
                    CustomTopBar("BUKU KEUANGAN", {
                        homeNavController.popBackStack()
                        homeNavController.navigate(MainRouteScreens.Home.route)
                    })
                }
            ) {

                Column(modifier = Modifier
                    .padding(it)
                    .background(White)
                    .fillMaxSize()
                    .padding(vertical = 8.dp, horizontal = 8.dp)
                ) {

                    TabRow(selectedTabIndex = selectedTabIndex,
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                Modifier
                                    .tabIndicatorOffset(tabPositions[selectedTabIndex]),
                                color = terniary // Change this to any color you want
                            )
                        }) {
                        tabItem.forEachIndexed { index, tabItem ->

                            androidx.compose.material3.Tab(
                                selected = index == selectedTabIndex,
                                onClick = {
                                    selectedTabIndex = index
                                },
                                icon = {
                                    if (selectedTabIndex == index) {

                                        Button(
                                            onClick = { selectedTabIndex = index },
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = circle,
                                                contentColor = Color.White,

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
                                    }
                                }

                            )
                        }
                    }

                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)

                    ) { index ->
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp, bottom = 48.dp)
                        ) {
                            when (tabItem[index].title) {
                                "Pengeluaran" -> {
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
                                        Divider(thickness = 1.dp, color = Black,)

                                        LazyColumn(
                                            modifier = Modifier
                                                .wrapContentHeight()
                                                .requiredHeightIn(min = 100.dp, max = 500.dp),

                                            userScrollEnabled = false
                                        ) {
                                            items(4) {

                                                BukuKeuanganItem()
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(24.dp))

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
                                        Divider(thickness = 1.dp, color = Black,)

                                        LazyColumn(
                                            modifier = Modifier
                                                .wrapContentHeight()
                                                .requiredHeightIn(min = 100.dp, max = 500.dp),

                                            userScrollEnabled = false
                                        ) {
                                            items(4) {

                                                BukuKeuanganItem()
                                            }
                                        }
                                    }

                                }

                                "Pemasukan" -> {
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
                                        Divider(thickness = 1.dp, color = Black,)

                                        LazyColumn(
                                            modifier = Modifier
                                                .wrapContentHeight()
                                                .requiredHeightIn(min = 100.dp, max = 500.dp),
                                            userScrollEnabled = false
                                        ) {
                                            items(4) {

                                                BukuKeuanganItem()
                                            }
                                        }

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
                                        Divider(thickness = 1.dp, color = Black,)

                                        LazyColumn(
                                            modifier = Modifier
                                                .wrapContentHeight()
                                                .requiredHeightIn(min = 100.dp, max = 500.dp),
                                            userScrollEnabled = false
                                        ) {
                                            items(4) {

                                                BukuKeuanganItem()
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun BukuKeuanganItem(modifier: Modifier = Modifier) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 8.dp), colors = CardDefaults.cardColors(
            containerColor = Transparent
        )) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Payments, contentDescription = null,
                tint = terniary
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(Modifier.weight(2f)) {
                Text("Transfer Sesama Bank", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "34374568589453322344556877")
            }
            Text(text = "Rp.50.OOO")
        }
    }
    Divider(thickness = 1.dp, color = Black,)
}

// Data Class to handle items
data class TabItem(
    val title: String, val unSelectedItem: ImageVector, val selectedIcon: ImageVector
)
@Preview(showBackground = true)
@Composable
private fun BukuKeuanganPrev() {
    BukuKeuanganScreen(rememberNavController(), rememberNavController())
}