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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.takasima.bankpapuamb.common.MainBg
import com.takasima.bankpapuamb.common.OptTextField
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

@Composable
fun TarikTunaiScreen(modifier: Modifier = Modifier) {


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
                            text = "TARIK TUNAI",
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
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    TTSection1()
                    TTSection2()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TarikTunaiScreenPrev() {
    TarikTunaiScreen()
}

@Composable
fun ColumnScope.TTSection1(modifier: Modifier = Modifier) {
    val noKartu = remember { mutableStateOf("") }

    TextField(value = noKartu.value, onValueChange = { noKartu.value = it }, leadingIcon = { Icon(
        imageVector = Icons.Default.DateRange,
        contentDescription = null
    )}, shape = RoundedCornerShape(16.dp), label = { Text(text = "Masukkan Nomor Kartu")})

    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextButton(modifier = Modifier
            .weight(2f)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
            onClick = { /*TODO*/ }) {
            Text(text = "100.000")
        }
        TextButton(modifier = Modifier
            .weight(2f)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
            onClick = { /*TODO*/ }) {
            Text(text = "200.000")
        }
    }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextButton(modifier = Modifier
            .weight(2f)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
            onClick = { /*TODO*/ }) {
            Text(text = "300.000")
        }
        TextButton(modifier = Modifier
            .weight(2f)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
            onClick = { /*TODO*/ }) {
            Text(text = "400.000")
        }
    }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextButton(modifier = Modifier
            .weight(2f)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
            onClick = { /*TODO*/ }) {
            Text(text = "500.000")
        }
        TextButton(modifier = Modifier
            .weight(2f)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
            onClick = { /*TODO*/ }) {
            Text(text = "600.000")
        }
    }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextButton(modifier = Modifier
            .weight(2f)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
            onClick = { /*TODO*/ }) {
            Text(text = "700.000")
        }
        TextButton(modifier = Modifier
            .weight(2f)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
            onClick = { /*TODO*/ }) {
            Text(text = "800.000")
        }
    }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextButton(modifier = Modifier
            .weight(2f)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
            onClick = { /*TODO*/ }) {
            Text(text = "900.000")
        }
        TextButton(modifier = Modifier
            .weight(2f)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
            onClick = { /*TODO*/ }) {
            Text(text = "1.000.000")
        }
    }


    Spacer(modifier = Modifier.height(100.dp))
    Button(modifier = Modifier.width(200.dp), onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = secondary)) {
        Text(text = "Konfirmasi")
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
        TTSection1()
    }
}

@Composable
fun ColumnScope.TTSection2(modifier: Modifier = Modifier) {
    Text(text = "Silahkan Masukkan Inputan ke dalam \nMesin ATM", textAlign = TextAlign.Center)

    OptTextField()

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
        TTSection2()
    }
}