package com.takasima.bankpapuamb.screen.common

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.data.model.Invoice
import com.takasima.bankpapuamb.data.viewmodel.DompetkuViewModel
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.screen.main.InvoiceScreen2
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

@Composable
fun TagihanSection1(
    homeNavController: NavHostController,
    menuNavController: NavHostController,
    onConfirm: () -> Unit,
    detailViewModel: DompetkuViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val options = detailViewModel.options
    val noTelp = remember { mutableStateOf("") }
    val nominal = remember { mutableIntStateOf(0) }


    /*Box(
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
                            text = "TRANSFER ANTAR BANK",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp
                        )
                    }
                }
            ) {*/

                Column(
                    Modifier
                        .fillMaxSize()
//                        .padding(it)
                        .padding(24.dp)
                        .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.1f)
                    /*.verticalScroll(rememberScrollState())*/,
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Nomor Rekening Anda", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = noTelp.value,
                        onValueChange = { noTelp.value = it },
                        colors = TextFieldDefaults.colors(
                            disabledContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.CreditCard,
                                contentDescription = null
                            )
                        },
                        shape = RoundedCornerShape(16.dp),
                        placeholder = { Text(text = "9012232123") })

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(modifier = Modifier, colors = CardDefaults.cardColors(containerColor = Color.White)) {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text(text = "Detail", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                            Text(text = "Anda akan melakukan transaksi ke nomor tujuan (+62) 8124 5678 910")
                            Text(text = "Dengan jumlah:", fontWeight = FontWeight.Bold)
                            Text(text = "Nominal: RP60.000")
                            Text(text = "Nominal: RP0")
                        }
                        Spacer(modifier = Modifier.height(64.dp))
                    }


                    Spacer(modifier = Modifier.height(50.dp))
                    Button(
                        modifier = Modifier
                            .width(200.dp)
                            .align(Alignment.CenterHorizontally),
                        onClick = onConfirm,
                        colors = ButtonDefaults.buttonColors(containerColor = secondary)
                    ) {
                        Text(text = "Konfirmasi")
                    }
                }
//            }
//        }
//    }

}

@Composable
fun TagihanSection2(
    menuNavController: NavHostController,
    detailNavController: NavHostController,
    detailViewModel: DompetkuViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val options = detailViewModel.options
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
        Text(text = "TRANSAKSI BERHASIL", fontWeight = FontWeight.Bold, fontSize = 32.sp)

        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text(text = "Detail", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text(text = "Tanggal : DD/MM/YYYY")
                Text(text = "Nomor Referensi : xxxxxxxxxxxxx")

                Spacer(modifier = Modifier.height(24.dp))

                Text(text = "Dari Rekening   : 9102232123")
                Text(text = "Jenis Transaksi : DANA ")
                Text(text = "Nomor Tujuan    : (+62) 8124 5678 910 ")
                Text(text = "Nama            :  XXXXXXX")
                Text(text = "Nominal         :   RP.60.000")
                Text(text = "Biaya Admin     :   Rp.0")
                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "TOTAL             : RP.60.000", fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.height(64.dp))
        }


        Spacer(modifier = Modifier.height(50.dp))
        Button(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
//                menuNavController.popBackStack()
//                detailNavController.popBackStack()
                detailNavController.navigate(FeatureRouteScreens.Security.route)
            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary),
        ) {
            Icon(imageVector = Icons.Default.Share, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "BAGIKAN")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TagihanPrev1() {
    TagihanSection1(rememberNavController(), rememberNavController(), {})
}


@Composable
fun TagihanSection3(
    homeNavController: NavHostController,
    onConfirm: () -> Unit,
    detailViewModel: DompetkuViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val options = detailViewModel.options
    val noTelp = remember { mutableStateOf("") }
    val nominal = remember { mutableIntStateOf(0) }


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
                            text = "TRANSFER ANTAR BANK",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp
                        )
                    }
                }
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .padding(24.dp)
                        .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.1f)
                    /*.verticalScroll(rememberScrollState())*/,
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Nomor Rekening Anda", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = noTelp.value,
                        onValueChange = { noTelp.value = it },
                        colors = TextFieldDefaults.colors(
                            disabledContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.CreditCard,
                                contentDescription = null
                            )
                        },
                        shape = RoundedCornerShape(16.dp),
                        placeholder = { Text(text = "9012232123") })

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(modifier = Modifier, colors = CardDefaults.cardColors(containerColor = Color.White)) {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text(text = "Detail", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                            Text(text = "Anda akan melakukan transaksi ke nomor tujuan (+62) 8124 5678 910")
                            Text(text = "Dengan jumlah:", fontWeight = FontWeight.Bold)
                            Text(text = "Nominal: RP60.000")
                            Text(text = "Nominal: RP0")
                        }
                        Spacer(modifier = Modifier.height(64.dp))
                    }


                    Spacer(modifier = Modifier.height(50.dp))
                    Button(
                        modifier = Modifier
                            .width(200.dp)
                            .align(Alignment.CenterHorizontally),
                        onClick = onConfirm,
                        colors = ButtonDefaults.buttonColors(containerColor = secondary)
                    ) {
                        Text(text = "Konfirmasi")
                    }
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
private fun TagihanPrev3() {
    TagihanSection3(rememberNavController(), {})
}
