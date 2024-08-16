package com.takasima.bankpapuamb.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.data.model.Invoice
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.ui.theme.secondary


@Composable
fun PaymentSummaryScreen(
//    invoice: Invoice,
    onNext:()->Unit,
    purpose:String,
    modifier: Modifier = Modifier
) {
    val noTelp = remember { mutableStateOf("") }


    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xA1063E71))
            .padding(24.dp)
            .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.1f)
        /*.verticalScroll(rememberScrollState())*/,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth(),
            value = noTelp.value,
            onValueChange = { noTelp.value = it },
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

                Text(text = "TOTAL PEMBAYARAN", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = modifier.align(Alignment.CenterHorizontally))
                Text(text = "Anda akan melakukan Transaksi Pembayaran Tagihan")
                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Dengan Detail:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "Nomor Pelanggan      : 1456433")
                Text(text = "Nominal                        : RP60.000")
                Text(text = "Pajak                             : RP0")
            }
            Spacer(modifier = Modifier.height(64.dp))
        }


        Spacer(modifier = Modifier.height(50.dp))
        Button(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick =  onNext,
            colors = ButtonDefaults.buttonColors(containerColor = secondary)
        ) {
            Text(text = "Konfirmasi")
        }
    }


}

@Preview(showBackground = true)
@Composable
private fun PaymentSummaryPrev() {
    PaymentSummaryScreen({}, /*invoice = Invoice(
        "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
        rekAsal = " 9102232123", jenisTransaksi = "",
        nominal = 500_000
    ),*/ "Tagihan Pembayaran Token Listrik"
    )
}
