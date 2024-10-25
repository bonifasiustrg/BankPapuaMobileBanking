package com.takasima.bankpapuamb.screen.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
import com.takasima.bankpapuamb.screen.main.homemenu.BukuKeuanganItem
import com.takasima.bankpapuamb.ui.theme.circle
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

@Composable
fun EStatementScreen(homeNavController: NavHostController, modifier: Modifier = Modifier) {
    var selectedTabIndex by remember {
        mutableIntStateOf(4)
    }

    val tabItem = listOf("2020", "2021", "2022", "2023", "2024")
    val monthList = listOf("Agustus", "Juli", "Juni", "Mei", "April", "Maret")

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

            Scaffold(modifier = Modifier, containerColor = Color.Transparent,
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
                        .background(Color.White)
                        .fillMaxSize()
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Download", fontWeight = FontWeight.Bold, fontSize = 18.sp)

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

                                    }

                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        VerticalDivider(color = Color.LightGray, height = 36.dp)
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
                                .padding(top = 16.dp, bottom = 48.dp)
                        ) {
                            LazyColumn {
                                items(monthList) {
                                    Column(
                                        modifier = Modifier
                                            .border(
                                                width = 1.dp,
                                                color = Color.Black,
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            .padding(horizontal = 8.dp, vertical = 16.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(8.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                it,
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Button(
                                                    onClick = {  },
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = Color.White,
                                                        contentColor = terniary,

                                                        ),
                                                    contentPadding = PaddingValues(),
                                                    modifier = Modifier
                                                        .shadow(
                                                            4.dp,
                                                            RoundedCornerShape(8.dp),
                                                            ambientColor = Color.Gray
                                                        )
                                                        .height(24.dp),
                                                    shape = RoundedCornerShape(8.dp),
                                                ) {
                                                    Text(
                                                        text = "PDF",
                                                        modifier = Modifier.padding(horizontal = 24.dp),
                                                        fontSize = 10.sp
                                                    )
                                                }
                                                Spacer(modifier = Modifier.width(8.dp))

                                                Button(
                                                    onClick = {  },
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = Color.White,
                                                        contentColor = terniary,

                                                        ),
                                                    contentPadding = PaddingValues(),
                                                    modifier = Modifier
                                                        .shadow(
                                                            4.dp,
                                                            RoundedCornerShape(8.dp),
                                                            ambientColor = Color.Gray
                                                        )
                                                        .height(24.dp),
                                                    shape = RoundedCornerShape(8.dp),
                                                ) {
                                                    Text(
                                                        text = "Excel",
                                                        modifier = Modifier.padding(horizontal = 24.dp),
                                                        fontSize = 10.sp
                                                    )
                                                }
                                            }

                                        }
                                    }
                                        Spacer(modifier = Modifier.height(16.dp))
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
                                        Divider(thickness = 1.dp, color = Color.Black,)

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
                                        Divider(thickness = 1.dp, color = Color.Black,)

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
                                        Divider(thickness = 1.dp, color = Color.Black,)

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

@Preview(showBackground = true)
@Composable
private fun EStatementPrev() {
    EStatementScreen(rememberNavController())
}