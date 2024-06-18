package com.takasima.bankpapuamb.screen.main

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

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
                            homeNavController.navigateUp()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                                contentDescription = null,
                                Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = "FAVORITE",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp
                        )
                    }
                }
            ) {
                LazyColumn(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
//                    TFSesamaScreenSection1()
//                    items(15) {
//                        HistoryItem()
//                    }
                }
            }
        }
    }
}

//@Composable
//fun FavoriteItem(modifier: Modifier = Modifier) {
//    Card(modifier.fillMaxWidth()) {
//        Row(Modifier.padding(16.dp)) {
//            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null)
//            Spacer(modifier = Modifier.width(16.dp))
//
//            Column(Modifier.weight(2f)) {
//                Text("Dompetku", fontSize = 16.sp, fontWeight = FontWeight.Bold)
//                Text(text = "DANA - 0813228796")
//                Text(text = "No.ref: 873483723123")
//                Text(text = "Tanggal Transaksi : 29 Aug 2024")
//            }
//
//            Column() {
//                Button(
//                    onClick = { /*TODO*/ },
//                    contentPadding = PaddingValues(),
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
//                    modifier = Modifier
////                        .defaultMinSize(1.dp)
//                        .size(width = 100.dp, height = 24.dp)
////                        .shadow(
////                        elevation = 8.dp,
////                        ambientColor = Gray,
////                        shape = RoundedCornerShape(16.dp)
////                    )
//                ) {
//                    Text(text = "Berhasil", color = Color.White)
//                }
//                Spacer(modifier = Modifier.height(24.dp))
//                Button(
//                    onClick = { /*TODO*/ },
//                    contentPadding = PaddingValues(),
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
//                    modifier = Modifier
//                        .size(width = 100.dp, height = 24.dp)
////                        .shadow(
////                        elevation = 8.dp,
////                        ambientColor = Gray,
////                        shape = RoundedCornerShape(48.dp)
////                    )
//                ) {
//                    Text(text = "Berhasil", color = Color.Magenta)
//                }
//            }
//        }
//    }
//    Divider(thickness = 1.dp, color = Color.Black, modifier = Modifier.padding(vertical = 8.dp))
//}

@Preview(showBackground = true)
@Composable
private fun FavoriteScreenPrev() {
    FavoriteScreen(rememberNavController())
}