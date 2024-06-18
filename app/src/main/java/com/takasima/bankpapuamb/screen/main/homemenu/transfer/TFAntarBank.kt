package com.takasima.bankpapuamb.screen.main.homemenu.transfer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import com.takasima.bankpapuamb.ui.theme.secondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TFAntarBankScreen(homeNavController: NavHostController, modifier: Modifier = Modifier) {
    var openBottomSheet = remember { mutableStateOf(false) }
    val scope = rememberModalBottomSheetState()
    val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)


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
                            text = "TRANSFER ANTAR BANK",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
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
                    TFAntarBankSection1(homeNavController = homeNavController)
//                    PilihBankSection()
                }

                if (openBottomSheet.value) {
                    ModalBottomSheet(
                        sheetState = bottomSheetState,
                        onDismissRequest = { openBottomSheet.value = false },
                        dragHandle = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                            ) {
                                BottomSheetDefaults.DragHandle()
                                Text(
                                    text = "Pembayaran",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 32.sp
                                )
                                Spacer(modifier = modifier.height(10.dp))
                                Divider()
                            }
                        },
                    ) {
                        PilihBankSection()
                    }
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TFAntarBankScreenPrev() {
    TFAntarBankScreen(rememberNavController())
}

@Composable
fun ColumnScope.TFAntarBankSection1(homeNavController: NavHostController, modifier: Modifier = Modifier) {
    val noRek = remember { mutableStateOf("") }
    val nominal = remember { mutableIntStateOf(0) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.bank_tujuan_ic2),
            contentDescription = null,
            modifier = modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "PILIH BANK TUJUAN",
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.weight(1f)
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
        }
    }

    Spacer(modifier = Modifier.height(24.dp))

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = noRek.value,
        onValueChange = { noRek.value = it },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.norekk_ic),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .size(48.dp)
            )
        },
        shape = RoundedCornerShape(16.dp),
        placeholder = { Text(text = "Masukkan Nomor Rekening ") })


    Spacer(modifier = Modifier.height(24.dp))

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = noRek.value,
        onValueChange = { noRek.value = it },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.nominal_ic),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .size(48.dp)
            )
        },
        shape = RoundedCornerShape(16.dp),
        placeholder = { Text(text = "Masukkan Nominal ") })


    Spacer(modifier = Modifier.height(24.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.sumberrek_ic),
            contentDescription = null,
            modifier = modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Pilih Sumber Nomor Rekening",
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.weight(1f)
        )
    }
    Spacer(modifier = Modifier.weight(2f))

    Button(
        modifier = Modifier
            .width(200.dp)
            .align(Alignment.CenterHorizontally),
        onClick = {
//            homeNavController.navigate(MainRouteScreens.Home.route)
//            homeNavController.popBackStack()
            homeNavController.navigate("invoice")

        },
        colors = ButtonDefaults.buttonColors(containerColor = secondary)
    ) {
        Text(text = "Konfirmasi")
    }

    Spacer(modifier = Modifier.height(64.dp))

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnScope.PilihBankSection(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items = remember {
        mutableStateListOf<String>(
            "Bank BRI",
            "BCA"
        )
    }
    var bankList = remember {
        mutableStateListOf<String>(
            "BANK RAKYAT INDONESIA",
            "BANK NEGARA INDONESIA",
            "BANK MANDIRI",
            "BANK BPD DAERAH ISTIMEWA YOGYAKARTA",
            "BANK Tabungan Negara",
            "BANK BCA",
            "BANK SYARIAH INDONESIA",
            "BANK NOBU",
        )
    }


    SearchBar(
        query = text,
        onQueryChange = { text = it },
        onSearch = {
            items.add(text)
            active = false
            text = ""
        },
        active = false,
        onActiveChange = { active = it },
        placeholder = { Text("Cari bank...") },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        trailingIcon = {
            if (active) {
                Icon(modifier = modifier.clickable {
                    if (text.isNotEmpty()) {
                        text = ""
                    } else active = false
                }, imageVector = Icons.Default.Close, contentDescription = null)
            }
        },
        modifier = modifier.fillMaxWidth()
    ) {
        items.forEach {
            Row(modifier = modifier.padding(14.dp)) {
                Icon(
                    modifier = modifier.padding(end = 10.dp),
                    imageVector = Icons.Default.History,
                    contentDescription = null
                )

                Text(text = it)
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 16.dp, horizontal = 8.dp)) {
        items(bankList) {
            Row(modifier = modifier
                .fillMaxWidth()
                .background(Color(0x61CACACA), shape = RoundedCornerShape(8.dp))
                .padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = modifier.padding(end = 10.dp),
                    imageVector = Icons.Default.AccountBalance,
                    contentDescription = null
                )

                Text(text = it, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}