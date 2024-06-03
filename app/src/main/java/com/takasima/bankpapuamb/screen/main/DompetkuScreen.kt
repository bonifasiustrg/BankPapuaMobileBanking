package com.takasima.bankpapuamb.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.SingleSelectionCard
import com.takasima.bankpapuamb.data.PaymentMethodOption
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import com.takasima.bankpapuamb.data.viewmodel.DompetkuViewModel

@Composable
fun DompetkuScreen(modifier: Modifier = Modifier, dompetkuViewModel: DompetkuViewModel = viewModel()) {


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
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
//                    DompetSection1(dompetkuViewModel)
//                    DompetSection2(dompetkuViewModel)
                    DompetSection3(dompetkuViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DompetkuScreenPrev() {
    DompetkuScreen()
}

@Composable
fun ColumnScope.DompetSection1(dompetkuViewModel: DompetkuViewModel, modifier: Modifier = Modifier) {
    val options = dompetkuViewModel.options
    val noTelp = remember { mutableStateOf("") }
    val nominal = remember { mutableIntStateOf(0) }

    TextField(modifier = Modifier.fillMaxWidth(), value = noTelp.value, onValueChange = { noTelp.value = it }, leadingIcon = {
        Icon(
            imageVector = Icons.Default.Contacts,
            contentDescription = null
        )
    }, shape = RoundedCornerShape(16.dp), placeholder = { Text(text = "(+62) 8124 5678 910") })

    Spacer(modifier = Modifier.height(16.dp))
    Text(text = "Pilih")
    Spacer(modifier = Modifier.height(8.dp))
    SingleSelectionList(options,  onOptionClicked = { dompetkuViewModel.selectionOptionSelected(it) })

    Spacer(modifier = Modifier.height(16.dp))
    TextField(modifier = Modifier.fillMaxWidth(), value = noTelp.value, onValueChange = { noTelp.value = it }, leadingIcon = {
        Icon(
            imageVector = Icons.Default.Money,
            contentDescription = null
        )
    }, shape = RoundedCornerShape(16.dp), placeholder = { Text(text = "Masukkan Nominal") })

    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "Minimal Top-Up 10.000")

    Spacer(modifier = Modifier.height(50.dp))
    Button(
        modifier = Modifier
            .width(200.dp)
            .align(Alignment.CenterHorizontally),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = secondary)
    ) {
        Text(text = "Konfirmasi")
    }
}

@Composable
fun SingleSelectionList(options: List<PaymentMethodOption>, onOptionClicked: (PaymentMethodOption) -> Unit) {

    LazyColumn {
        items(options) { option -> SingleSelectionCard(option, onOptionClicked) }
    }
}


@Composable
fun ColumnScope.DompetSection2(dompetkuViewModel: DompetkuViewModel, modifier: Modifier = Modifier) {
    val options = dompetkuViewModel.options
    val noTelp = remember { mutableStateOf("") }
    val nominal = remember { mutableIntStateOf(0) }

    TextField(modifier = Modifier.fillMaxWidth(), value = noTelp.value, onValueChange = { noTelp.value = it }, leadingIcon = {
        Icon(
            imageVector = Icons.Default.Contacts,
            contentDescription = null
        )
    }, shape = RoundedCornerShape(16.dp), placeholder = { Text(text = "(+62) 8124 5678 910") })

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
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = secondary)
    ) {
        Text(text = "Konfirmasi")
    }
}

@Composable
fun ColumnScope.DompetSection3(dompetkuViewModel: DompetkuViewModel, modifier: Modifier = Modifier) {
    val options = dompetkuViewModel.options
    val noTelp = remember { mutableStateOf("") }
    val nominal = remember { mutableIntStateOf(0) }

    Text(text = "TRANSAKSI BERHASIL", fontWeight = FontWeight.Bold, fontSize = 32.sp)

    Spacer(modifier = Modifier.height(16.dp))
    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(text = "Detail", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(text = "Tanggal : DD/MM/YYYY")
            Text(text = "Nomor Referensi : xxxxxxxxxxxxx")

            Spacer(modifier = Modifier.height(24    .dp))

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
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = secondary),
    ) {
        Icon(imageVector = Icons.Default.Share, contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "BAGIKAN")
    }
}
