package com.takasima.bankpapuamb.screen.auth.settingaccount

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
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
import com.takasima.bankpapuamb.ui.theme.lightgrey
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

@Composable
fun SnKScreen(profileNavController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {
            Scaffold(modifier = Modifier, containerColor = lightgrey,
                topBar = {
                    Row(
                        Modifier
                            .background(terniary2.copy(alpha = 0.6f))
                            .fillMaxWidth()
                            .fillMaxHeight(0.08f)
                            .background(color = lightgrey)
                            .padding(top = 16.dp)
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            profileNavController.navigateUp()

                        }) {

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                                contentDescription = null,
                                Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = "Syarat dan Ketentuan  ",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp
                        )
                    }
                }
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(it)
                        .padding(vertical = 8.dp, horizontal = 32.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Registrasi dan Ketentuan mobile Banking", color = terniary, modifier = Modifier.padding(top = 24.dp), fontSize = 18.sp)
                    Text(text = "1. Nasabah harus memiliki rekening di Bank Papua untuk mendaftar layanan Mobile Banking.\n" +
                            "2. Proses registrasi dilakukan melalui aplikasi Mobile Banking Bank Papua atau melalui cabang Bank Papua terdekat.\n" +
                            "3. Nasabah wajib memberikan data pribadi yang valid dan akurat selama proses registrasi.\n" +
                            "4. Setelah berhasil mendaftar, nasabah akan menerima notifikasi konfirmasi melalui SMS atau email yang terdaftar.")


                    Text(text = "Registrasi dan Ketentuan mobile Banking", color = terniary, modifier = Modifier.padding(top = 24.dp), fontSize = 18.sp)

                    Text(text = "1. Tabungan perorangan untuk warga negara Indonesia.\n" +
                            "2. Mengisi formulir permohonan pembukaan rekening TabunganKu.\n" +
                            "3. Menyerahkan fotocopy Kartu Identitas diri (KTP/SIM) yang masih berlaku.\n" +
                            "4. 1 (satu) orang hanya memiliki satu rekening di 1 (satu) Bank untuk produk yang sama, kecuali bagi orang tua yang membuka rekening untuk anak yang masih dibawah perwalian sesuai Kartu Keluarga (KK) yang bersangkutan.\n" +
                            "5. Tidak diperkenankan untuk rekening bersama dengan status “dan/atau”.\n" +
                            "6. Transaksi penarikan tunai dan pemindahbukuan melalui counter dapat dilakukan pada seluruh jaringan Kantor Bank Papua.\n" +
                            "7. Rekening yang tidak ada transaksi selama 6 bulan berturut-turut dikenakan biaya Rp.2.000,-/bulan.\n" +
                            "8. Rekening pasif dengan saldo ≤ Rp.20.000,-, maka rekening akan ditutup oleh sistem.\n" +
                            "9. Jumlah minimum penarikan di counter sebesar Rp.100.000,- kecuali pada saat nasabah ingin menutup rekening.")
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun SnKScreenPrev() {
    SnKScreen(rememberNavController())
}