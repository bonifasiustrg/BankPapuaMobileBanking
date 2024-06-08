package com.takasima.bankpapuamb.screen.main

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Money
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.SingleSelectionCard
import com.takasima.bankpapuamb.data.PaymentMethodOption
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import com.takasima.bankpapuamb.data.viewmodel.DompetkuViewModel
import com.takasima.bankpapuamb.screen.common.TagihanSection1
import com.takasima.bankpapuamb.screen.common.TagihanSection2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DompetkuScreen(
    homeNavController: NavHostController,
    modifier: Modifier = Modifier,
    dompetkuViewModel: DompetkuViewModel = viewModel(),
) {
    val dompetkuNavController = rememberNavController()

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
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = null,
                            Modifier.size(32.dp)
                        )
                        Text(
                            text = "DOMPETKU",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 32.sp
                        )
                    }
                }
            ) {

                NavHost(navController = dompetkuNavController, startDestination = "dompetsection1") {
                    composable("dompetsection1"){
                        DompetSection1(homeNavController = homeNavController, dompetkuNavController = dompetkuNavController, dompetkuViewModel = dompetkuViewModel)
                    }
                    composable("dompetsection2"){
                        TagihanSection1(homeNavController, dompetkuNavController, dompetkuViewModel)
                    }
                    composable("dompetsection3"){
                        TagihanSection2(homeNavController, dompetkuNavController, dompetkuViewModel)
                    }

                }
//                Column(
//                    Modifier
//                        .fillMaxSize()
//                        .padding(it)
//                        .padding(24.dp),
//                    verticalArrangement = Arrangement.Top,
//                    horizontalAlignment = Alignment.Start
//                ) {
////                    DompetSection1(dompetkuViewModel)
////                    DompetSection2(dompetkuViewModel)
//                    DompetSection3(dompetkuViewModel)
//                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DompetkuScreenPrev() {
    DompetkuScreen(homeNavController = rememberNavController())
}

@Composable
fun DompetSection1(dompetkuNavController: NavHostController, homeNavController: NavHostController, dompetkuViewModel: DompetkuViewModel, modifier: Modifier = Modifier) {
    val options = dompetkuViewModel.options
    val noTelp = remember { mutableStateOf("") }
    val nominal = remember { mutableIntStateOf(0) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
            .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.1f)
            /*.verticalScroll(rememberScrollState())*/,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = noTelp.value,
            onValueChange = { noTelp.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Contacts,
                    contentDescription = null
                )
            },
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(text = "(+62) 8124 5678 910") })

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Pilih")
        Spacer(modifier = Modifier.height(8.dp))
        SingleSelectionList(
            options,
            onOptionClicked = { dompetkuViewModel.selectionOptionSelected(it) })

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = noTelp.value,
            onValueChange = { noTelp.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Money,
                    contentDescription = null
                )
            },
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(text = "Masukkan Nominal") })

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Minimal Top-Up 10.000")

        Spacer(modifier = Modifier.height(50.dp))
        Button(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                      dompetkuNavController.navigate("dompetsection2")
            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary)
        ) {
            Text(text = "Konfirmasi")
        }
    }
}

@Composable
fun SingleSelectionList(options: List<PaymentMethodOption>, onOptionClicked: (PaymentMethodOption) -> Unit) {

    LazyColumn {
        items(options) { option -> SingleSelectionCard(option, onOptionClicked) }
    }
}


