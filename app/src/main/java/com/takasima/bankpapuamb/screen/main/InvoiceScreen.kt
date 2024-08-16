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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
fun InvoiceScreen(
    paddingValues: PaddingValues,
    menuNavController: NavHostController,
    homeNavController: NavHostController,
    invoice: Invoice,
    modifier: Modifier = Modifier
) {
    var kodeBayar by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = Color(0xA1063E71))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            Modifier
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "TRANSAKSI BERHASIL", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
//                    .padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {

                    Text(text = "Detail", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Nomor Referensi      : ${invoice.noReferensi}")
                    Text(text = "Dari Rekening            : ${invoice.rekAsal}")
                    Text(text = "Jenis Transaksi        : ${invoice.jenisTransaksi}")

                    if (invoice.jenisTransaksi == "Pembayaran pajak tahunan") {
                        Text(text = "Nomor Kendaraan    : PA7215KX")
                    }
                    Text(text = "Nama                     : ${invoice.nama}")
                    Text(text = "Nominal                : Rp${invoice.nominal}")
                    Text(text = "Biaya Admin           : Rp${invoice.adminFee}")
                    Text(
                        text = "TOTAL             : Rp${invoice.nominal+invoice.adminFee}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                homeNavController.popBackStack()
                homeNavController.navigate(MainRouteScreens.Home.route)
//                menuNavController.popBackStack()
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
private fun InvoicePrev() {
    InvoiceScreen(paddingValues = PaddingValues(), rememberNavController(), rememberNavController(), invoice = Invoice(
        "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
        rekAsal = " 9102232123", jenisTransaksi = "",
        nominal = 500_000
    )
    )
}


@Composable
fun InvoiceScreen2(
    paddingValues: PaddingValues,
    menuNavController: NavHostController,
    homeNavController: NavHostController,
    invoice: Invoice,
    modifier: Modifier = Modifier
) {
    var kodeBayar by remember { mutableStateOf("") }

    Column(
        Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(color = Color(0xA1063E71))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            Modifier
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "TRANSAKSI BERHASIL", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
//                    .padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {

                    Text(text = "Detail", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Tanggal           : DD/MM/YYYY", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Nomor Referensi      : ${invoice.noReferensi}")
                    Text(text = "Dari Rekening            : ${invoice.rekAsal}")
                    Text(text = "Jenis Transaksi        : ${invoice.jenisTransaksi}")

                    if (invoice.jenisTransaksi == "Pembayaran pajak tahunan") {
                        Text(text = "Nomor Kendaraan    : PA7215KX")
                    }
                    Text(text = "Nama                     : ${invoice.nama}")
                    Text(text = "Nominal                : Rp${invoice.nominal}")
                    Text(text = "Biaya Admin           : Rp${invoice.adminFee}")
                    Text(
                        text = "TOTAL             : Rp${invoice.nominal+invoice.adminFee}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                homeNavController.popBackStack()
                homeNavController.navigate(MainRouteScreens.Home.route)
//                menuNavController.popBackStack()
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
private fun InvoicePrev2() {
    InvoiceScreen2(paddingValues = PaddingValues(), rememberNavController(), rememberNavController(), invoice = Invoice(
        "xxxxxxxxxxxxx", "FREDERIKUS MAHUZE", "DD/MM/YYYY",
        rekAsal = " 9102232123", jenisTransaksi = "",
        nominal = 500_000
    )
    )
}
