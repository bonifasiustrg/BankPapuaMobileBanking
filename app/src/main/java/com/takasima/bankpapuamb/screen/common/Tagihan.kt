package com.takasima.bankpapuamb.screen.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.takasima.bankpapuamb.data.viewmodel.DompetkuViewModel
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.ui.theme.secondary

@Composable
fun TagihanSection1(menuNavController: NavHostController, detailNavController: NavHostController, detailViewModel: DompetkuViewModel = viewModel(), modifier: Modifier = Modifier) {
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
    ){
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

        Card(modifier = Modifier, colors = CardDefaults.cardColors(containerColor = Color.White)) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text(text = "Detail", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text(text = "Anda akan melakukan transaksi ke nomor tujuan (+62) 8124 5678 910 \n\u2028Dengan jumlah : ")
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
            onClick = {
                detailNavController.navigate("airtagihan2")

            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary)
        ) {
            Text(text = "Konfirmasi")
        }
    }
}

@Composable
fun TagihanSection2(menuNavController: NavHostController, detailNavController: NavHostController, detailViewModel: DompetkuViewModel = viewModel(), modifier: Modifier = Modifier) {
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
    ){
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