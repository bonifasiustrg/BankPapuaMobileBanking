package com.takasima.bankpapuamb.screen.main.homemenu.kur

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

@Composable
fun SnKKURScreen(homeNavController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {

            Scaffold(modifier = Modifier, containerColor = Color.Transparent,
                topBar = {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.1f)
                            .background(color = Color(0xB3AAE4F6))
                            .padding(vertical = 16.dp)
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
                        .padding(it)
                        .background(Color.White)
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 48.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Pengajuan Kredit Usaha Rakyat", color = terniary, modifier = Modifier.padding(top = 24.dp), fontSize = 18.sp)
                    Text(text = "1. Individu (perorangan) yang melakukan usaha produktif dan layak\n" +
                            "2. Berusia 21 tahun keatas atau sudah menikah\n" +
                            "3. Tidak sedang menerima kredit/pembiayaan modal yang tidak sedang menerima kredit program Pemerintah kecuali KUR pada penyalur yang sama,\n" +
                            "KPR, KKB, Kredit jaminan surat pensiun, kartu kredit, resi gudang, kredit konsumsi\n" +
                            "4. KUR Supermikro dapat diberikan bagi usaha yang berjalan kurang dari 6 bulan, dengan memenuhi salah satu syarat, antara lain :\n" +
                            "• a. Mengikuti pendampingan\n" +
                            "• b. Mengikuti pelatihan kewirausahaan atau pelatihan Iainnya\n" +
                            "• c. Tergabung dalam kelompok usaha\n" +
                            "• d. Memiliki anggota keluarga yang mempunyai usaha produktif\n" +
                            "5. KUR Mikro dan Kecil bagi yang menjalankan usaha secara aktif minimal 6 bulan\n" +
                            "6. Tempat usaha milik sendiri dan/atau sewa dilengkapi surat kuasa sewa mengetahui pemerintah setempat\n" +
                            "7. penyediaan agunan tambahan minimal 30% dari plafon, berupa SHM, SHGB, SHGU, BPKB kendaraan, Cash Collateral (Tabungan/giro/deposito)"
                    )

                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        shape = RoundedCornerShape(25),

                        modifier = modifier.align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = secondary,
                            contentColor = Color.White
                        ),
                        onClick = {
                            homeNavController.navigate("pangajuanKUR")

                        }) {
                        Text(
                            modifier = Modifier.padding(horizontal = 32.dp),

                            text = "SETUJU",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(64.dp))

                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun SnKKURScreenPrev() {
    SnKKURScreen(rememberNavController())
}