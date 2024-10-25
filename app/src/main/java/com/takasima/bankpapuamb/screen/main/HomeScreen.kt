package com.takasima.bankpapuamb.screen.main

import android.annotation.SuppressLint
import android.os.Build
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Straight
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import com.takasima.bankpapuamb.data.model.menuItems
import com.takasima.bankpapuamb.navigation.AuthRouteScreens
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.screen.common.BottomSheetContent
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.Visibility
import com.takasima.bankpapuamb.screen.common.VisibilityOff
import com.takasima.bankpapuamb.ui.theme.circle
import com.takasima.bankpapuamb.ui.theme.terniary
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    modifier: Modifier = Modifier,
    openPayBottomSheet: MutableState<Boolean>
) {
//    var openBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier.background(Color(0xFF3eaed8))
        ) {
            MainBg()

            Scaffold(modifier = Modifier, containerColor = Color.Transparent,
                topBar = {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.10f)
                            .background(color = Color.Transparent)
                            .padding(top = 16.dp)
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = {
                                rootNavController.navigate(Graph.PROFILE) {
                                    popUpTo(MainRouteScreens.Home.route) {
                                        inclusive = true
                                    }
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = null,
                                    Modifier.size(40.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = "Selamat Datang",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.LightGray,
                                    fontSize = 16.sp
                                )
                                Text(
                                    text = "userTest1",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Keluar",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            IconButton(onClick = {
                                rootNavController.navigate(AuthRouteScreens.Login.route) {
                                    popUpTo(Graph.HOME) {
                                        inclusive = true
                                    }

                                    launchSingleTop = true
                                }
                            }) {

                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                    contentDescription = null,
                                    Modifier.size(40.dp)
                                )
                            }
                        }
                    }
                }
            ) { paddingValues ->

                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
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
                        var isSaldoHidden by rememberSaveable { mutableStateOf(true) }

                        Text(
                            text = if (isSaldoHidden) "Rp***********" else "Rp1.000.000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black
                        )

                        IconButton(onClick = { isSaldoHidden = !isSaldoHidden }) {
                            val visibilityIcon =
                                if (isSaldoHidden) Visibility else VisibilityOff
                            // Please provide localized description for accessibility services
                            val description =
                                if (isSaldoHidden) "Show saldo" else "Hide saldo"
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
                            .padding(top = 16.dp)
                    ) {
                        /**/
                        var expanded by remember { mutableStateOf(false) }
//                        val items = List(10) { "Item ${it + 1}" }
                        val displayedItems = if (expanded) menuItems else menuItems.take(6)
                        LazyVerticalGrid(
                            modifier = Modifier
//                                .height(IntrinsicSize) // Set a fixed height for the grid
//                                .wrapContentHeight()
//                                .background(Color.Gray)
                                .requiredHeightIn(min = 100.dp, max = 500.dp)
                                .padding(8.dp)
                                .fillMaxWidth(),
                            userScrollEnabled = false,
                            columns = GridCells.Fixed(3),
                        ) {
                            items(displayedItems) {
                                Box(
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .aspectRatio(1f)
                                        .fillMaxWidth()
                                        .clickable {
                                            if (it.route != "") homeNavController.navigate(it.route)
                                            if (it.title == "Transfer") {
                                                openPayBottomSheet.value = true
                                            }
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Image(
                                            painter = painterResource(id = it.icon),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .height(48.dp)
                                                .padding(bottom = 4.dp),
                                            contentScale = ContentScale.Crop

                                        )
                                        Text(
                                            text = it.title,
                                            textAlign = TextAlign.Center,
                                            fontSize = 13.sp
                                        )
                                    }
                                }
                            }
                        }

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            thickness = 1.dp,
                            color = Color.Black
                        )

                        TextButton(
                            onClick = { expanded = !expanded },
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text(if (expanded) "Tutup" else "Lainnya", color = terniary)
                            Icon(
                                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                tint = terniary,
                                contentDescription = null
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(
                                Color(0xCCFFFFFF), shape = RoundedCornerShape(8.dp)
                            ),
                    ) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Button(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = circle,
                                    contentColor = Color.White,

                                    ),
                                contentPadding = PaddingValues(),
                                modifier = Modifier
                                    .height(24.dp)
                                    .padding(horizontal = 16.dp),
                                shape = RoundedCornerShape(8.dp),
                                border = BorderStroke(2.dp, circle)
                            ) {
                                Text(
                                    text = "Bulan ini",
                                    modifier = Modifier.padding(horizontal = 24.dp),
                                    fontSize = 10.sp
                                )

                            }
                            OutlinedButton(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = circle,

                                    ),
                                contentPadding = PaddingValues(),
                                modifier = Modifier
                                    .height(24.dp)
                                    .padding(horizontal = 16.dp),
                                shape = RoundedCornerShape(8.dp),
                                border = BorderStroke(2.dp, circle)
                            ) {
                                Text(
                                    text = "Bulan lalu",
                                    modifier = Modifier.padding(horizontal = 24.dp),
                                    fontSize = 10.sp

                                )

                            }

                        }
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                Modifier.weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row {

                                    Text(
                                        text = "Pemasukan",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp,
                                        color = Color(0xFF80CB0D),
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Straight,
                                        contentDescription = null,
                                        tint = Color(0xFF80CB0D),
                                        modifier = Modifier.rotate(180f)
                                    )
                                }
                                Text(
                                    text = "Rp45.000.000",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14.sp,
                                    color = Color(0xFF80CB0D),

                                    )
                                Divider(color = Color.Gray)
                            }
                            Box(
                                modifier = Modifier
                                    .size(120.dp)
                                    .padding(8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .size(130.dp),
                                    progress = 1f,
                                    strokeWidth = 20.dp,
                                    color = circle,
                                    trackColor = Color.LightGray,

                                    )
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "100%",
                                        fontWeight = FontWeight.Bold,
                                        color = circle
                                    )
                                    Text(
                                        text = "Pengeluaran",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Gray
                                    )
                                }
                            }

                            Column(
                                Modifier.weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Row {
                                    Text(
                                        text = "Pengeluaran",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp,
                                        color = Color(0xFFD86251)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Straight,
                                        contentDescription = null,
                                        tint = Color(0xFFD86251)
                                    )

                                }
                                Text(
                                    text = "Rp45.000.000",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14.sp,
                                    color = Color(0xFFD86251)
                                )
                                Divider(color = Color.Gray)
                            }
                        }
                        Row(
                            modifier = Modifier
                                .background(
                                    Color.White,
                                    shape = RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp)
                                )
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)

                        ) {
                            Icon(
                                imageVector = Icons.Default.Money,
                                contentDescription = null,
                                tint = circle,
                                modifier = Modifier
                                    .size(32.dp)
                            )
                            Column(Modifier.weight(2f)) {
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "Pengeluaran")
                                    Text(text = "Rp45.000.000")
                                }
                                LinearProgressIndicator(
                                    progress = 0.8f,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(16.dp),
                                    color = circle,
                                    trackColor = Color.LightGray,


                                    )


                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "Pemasukan")
                                    Text(text = "Rp45.000.000")
                                }
                                LinearProgressIndicator(
                                    progress = 0.8f,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(16.dp),
                                    color = circle,
                                    trackColor = Color.LightGray,


                                    )

                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(82.dp))
                }
                /**/
                if (openPayBottomSheet.value) {
                    ModalBottomSheet(
                        sheetState = bottomSheetState,
                        onDismissRequest = { openPayBottomSheet.value = false },
                        /*dragHandle = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                            ) {
                                BottomSheetDefaults.DragHandle()
                                Text(
                                    text = "TRANSFER",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 32.sp
                                )
                                Spacer(modifier = modifier.height(10.dp))
                                Divider()
                            }
                        }*/
                    ) {
                        BottomSheetContent(
                            onHideButtonClick = {
                                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) openPayBottomSheet.value =
                                        false
                                }
                            },
                            homeNavController = homeNavController,
                            modifier
                        )
                    }
                }


            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen(rememberNavController(), rememberNavController(), openPayBottomSheet = remember {
        mutableStateOf(true)
    })
}


