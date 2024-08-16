package com.takasima.bankpapuamb.screen.main.homemenu.transfer

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
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

@Composable
fun TFSesamaBankScreen( homeNavController: NavHostController, modifier: Modifier = Modifier) {


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
                            text = "TRANSFER SESAMA BANK",
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
                    TFSesamaScreenSection1(homeNavController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TFAntarBankScreenPrev() {
    TFSesamaBankScreen(rememberNavController())
}

@Composable
fun ColumnScope.TFSesamaScreenSection1(homeNavController: NavHostController, modifier: Modifier = Modifier) {
    val noRek = remember { mutableStateOf("") }
    val nominal = remember { mutableIntStateOf(0) }

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
        placeholder = { Text(text = "Masukkan Nomor Rekening ") },
        visualTransformation = VisualTransformation.None,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next)
    )


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
        placeholder = { Text(text = "Masukkan Nominal ") },
        visualTransformation = VisualTransformation.None,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next)
    )


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
        colors = ButtonDefaults.buttonColors(containerColor = secondary, contentColor = Color.White),
    ) {
        Text(text = "Konfirmasi")
    }

    Spacer(modifier = Modifier.height(64.dp))
}