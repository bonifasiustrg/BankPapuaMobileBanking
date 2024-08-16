package com.takasima.bankpapuamb.screen.main.homemenu

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Money
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.data.NominalMethodOption
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.SingleSelectionCard
import com.takasima.bankpapuamb.data.PaymentMethodOption
import com.takasima.bankpapuamb.data.model.Invoice
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import com.takasima.bankpapuamb.data.viewmodel.DompetkuViewModel
import com.takasima.bankpapuamb.screen.common.SingleSelectionCard3
import com.takasima.bankpapuamb.screen.common.TagihanSection1
import com.takasima.bankpapuamb.screen.main.InvoiceScreen
import com.takasima.bankpapuamb.screen.main.InvoiceScreen2
import com.takasima.bankpapuamb.ui.theme.secondaryDisabled
import com.takasima.bankpapuamb.ui.theme.whiteTextDisabled

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
                                Modifier.size(24.dp)
                            )
                        }
                        Text(
                            text = "DOMPETKU  ",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                    }
                }
            ) {

                NavHost(
                    navController = dompetkuNavController,
                    startDestination = "dompetsection1",
                    modifier = Modifier.padding(it)
                ) {
                    composable("dompetsection1") {
                        DompetSection1(
                            homeNavController = homeNavController,
                            dompetkuNavController = dompetkuNavController,
                            dompetkuViewModel = dompetkuViewModel
                        )
                    }
                    composable("dompetsection2") {
                        TagihanSection1(homeNavController, dompetkuNavController, onConfirm = {
                            dompetkuNavController.popBackStack()
                            dompetkuNavController.navigate("invoice2")
                        }, dompetkuViewModel)
                    }
//                    composable("dompetsection3"){
//                        TagihanSection2(homeNavController, dompetkuNavController, dompetkuViewModel)
//                    }

                    composable("invoice2") {
                        InvoiceScreen2(
                            paddingValues = PaddingValues(),
                            menuNavController = dompetkuNavController,
                            homeNavController = homeNavController,
                            invoice = Invoice(
                                "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
                                rekAsal = " 9102232123", jenisTransaksi = "Dana",
                                nominal = 500_000
                            )
                        )
                    }
                }
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
fun DompetSection1(
    dompetkuNavController: NavHostController,
    homeNavController: NavHostController,
    dompetkuViewModel: DompetkuViewModel,
    modifier: Modifier = Modifier
) {
    val options = dompetkuViewModel.options
    val noTelp = remember { mutableStateOf("") }
    val nominal = remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
//            .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.06f)
        /*.verticalScroll(rememberScrollState())*/,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Nomor Telepon", fontWeight = FontWeight.SemiBold)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            value = noTelp.value,
            onValueChange = { noTelp.value = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Contacts,
                    contentDescription = null
                )
            },
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(text = "(+62) 8124 5678 910") },
            visualTransformation = VisualTransformation.None,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(56.dp))
        Text(text = "Pilih Dompet", fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))

        var optionClicked by remember {
            mutableStateOf(false)
        }
        SingleSelectionList(
            options,
            onOptionClicked = {
                dompetkuViewModel.selectionOptionSelected(it)
                optionClicked = true
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            value = nominal.value,
            onValueChange = { nominal.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Money,
                    contentDescription = null
                )
            },
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(text = "Masukkan Nominal") },
            visualTransformation = VisualTransformation.None,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Minimal Top-Up 10.000")

        Spacer(modifier = Modifier.height(50.dp))
        Button(
            enabled = if (noTelp.value != "" && nominal.value != "" && optionClicked) true else false,
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {

                dompetkuNavController.navigate("dompetsection2")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = secondary,
                disabledContainerColor = secondaryDisabled,
                contentColor = Color.White,
                disabledContentColor = whiteTextDisabled
            )
        ) {
            Text(text = "Konfirmasi")
        }
    }
}

@Composable
fun SingleSelectionList(
    options: List<PaymentMethodOption>,
    onOptionClicked: (PaymentMethodOption) -> Unit
) {

    LazyColumn {
        items(options) { option -> SingleSelectionCard(option, onOptionClicked) }
    }
}

@Composable
fun SingleSelectionList2(
    options: List<NominalMethodOption>,
    onOptionClicked: (NominalMethodOption) -> Unit
) {

//    LazyColumn {
//        items(options) { option -> SingleSelectionCard3(option, onOptionClicked) }
//    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(options.size) { option ->
            SingleSelectionCard3(options[option], onOptionClicked, option)
        }
    }
}

