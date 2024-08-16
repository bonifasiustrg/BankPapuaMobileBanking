package com.takasima.bankpapuamb.screen.main.homemenu

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.data.viewmodel.DompetkuViewModel
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.OptTextField
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.secondaryDisabled
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import com.takasima.bankpapuamb.ui.theme.whiteTextDisabled

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TarikTunaiScreen(homeNavController: NavHostController, modifier: Modifier = Modifier) {
    val ttNavController = rememberNavController()

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
                            text = "Tarik Tunai  ",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp
                        )
                    }
                }
            ) {

                NavHost(navController = ttNavController, startDestination = "ttsection1") {
                    composable("ttsection1") {
                        TTSection1(
                            homeNavController = homeNavController,
                            ttNavController = ttNavController
                        )
                    }
                    composable("ttsection2") {
                        TTSection2(
                            homeNavController = homeNavController,
                            ttNavController = ttNavController
                        )
                    }

                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TarikTunaiScreenPrev() {
    TarikTunaiScreen(rememberNavController())
}

@Composable
fun TTSection1(
    homeNavController: NavHostController,
    ttNavController: NavHostController,
    modifier: Modifier = Modifier,
    dompetkuViewModel: DompetkuViewModel = viewModel()
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.1f)
            /*.verticalScroll(rememberScrollState())*/,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//                    TTSection1(homeNavController, modifier)
        val noKartu = remember { mutableStateOf("") }

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = noKartu.value,
            onValueChange = { noKartu.value = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            leadingIcon = {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null
            )
        }, shape = RoundedCornerShape(16.dp),
            label = { Text(text = "Masukkan Nomor Kartu") },
            visualTransformation = VisualTransformation.None,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next)
        )

        val options = dompetkuViewModel.optionsNominal
        var optionClicked by remember {
            mutableStateOf(false)
        }
        SingleSelectionList2(
            options,
            onOptionClicked = {
                dompetkuViewModel.selectionOptionSelected(it)
                optionClicked = true
            }
        )

        Spacer(modifier = Modifier.height(100.dp))
        Button(
            enabled = if (noKartu.value != "" && optionClicked) true else false,
            modifier = Modifier.width(200.dp),
            onClick = {
                ttNavController.navigate("ttsection2")
            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary, disabledContainerColor = secondaryDisabled, contentColor = Color.White, disabledContentColor = whiteTextDisabled)
        ) {
            Text(text = "Konfirmasi")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TTSection1Prev() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TTSection1(rememberNavController(), rememberNavController())
    }
}

@Composable
fun TTSection2(
    homeNavController: NavHostController,
    ttNavController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.1f)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//                    TTSection1(homeNavController, modifier)
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = "Silahkan Masukkan Inputan ke dalam \nMesin ATM",
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        OptTextField(bgColor = Color.White)
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "01:20",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.height(100.dp))
        Button(
            modifier = Modifier.width(200.dp),
            onClick = {
                ttNavController.popBackStack()
                homeNavController.popBackStack()
                homeNavController.navigate(MainRouteScreens.Home.route) {
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary)
        ) {
            Text(text = "Konfirmasi")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "Kirim ulang kode", color = Color.White, style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,

                    )
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TTSection2Prev() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TTSection2(rememberNavController(), rememberNavController())
    }
}