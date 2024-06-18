package com.takasima.bankpapuamb.screen.main.homemenu.payment

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
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.outlined.ContactMail
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.navigation.PaymentMenuScreens
import com.takasima.bankpapuamb.screen.common.ExposedDropdownMenu
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2


@Composable
fun PendidikanScreen(
    paymentNavController: NavHostController,
    modifier: Modifier = Modifier
) {


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
                            paymentNavController.navigateUp()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                                contentDescription = null,
                                Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = "PENDIDIKAN",
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
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    PendidikanScreenSection1(paymentNavController)
                }
            }
        }
    }
}

@Composable
fun ColumnScope.PendidikanScreenSection1(paymentNavController:NavHostController, modifier: Modifier = Modifier) {
    val noRek = remember { mutableStateOf("") }

    Text(
        text = "BAYAR PENDIDIKAN",
        color = terniary,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 20.sp
    )

    Spacer(modifier = Modifier.height(32.dp))

//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.White, RoundedCornerShape(16.dp))
//            .padding(horizontal = 16.dp, vertical = 8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Image(
//            imageVector = Icons.Outlined.School,
//            contentDescription = null,
//            modifier = modifier.size(48.dp)
//        )
//        Spacer(modifier = Modifier.width(16.dp))
//        Text(
//            text = "PILIH UNIVERSITAS",
//            style = MaterialTheme.typography.titleMedium,
//            modifier = modifier.weight(1f)
//        )
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
//        }
//    }
    ExposedDropdownMenu("universitas")

    Spacer(modifier = Modifier.height(24.dp))


    TextField(
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White
        ),
        modifier = Modifier.fillMaxWidth(),
        value = noRek.value,
        onValueChange = { noRek.value = it },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.ContactMail,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp)
            )
        },
        shape = RoundedCornerShape(16.dp),
        placeholder = { Text(text = "NOMOR PELANGGAN ") }
    )
    Spacer(modifier = Modifier.height(100.dp))
    Button(
        modifier = Modifier
            .width(200.dp)
            .align(Alignment.CenterHorizontally),
        onClick = {
            paymentNavController.navigate(PaymentMenuScreens.PaymentSummary.route)
        },
        colors = ButtonDefaults.buttonColors(containerColor = secondary)
    ) {
        Text(text = "Konfirmasi")
    }
}


@Preview(showBackground = true)
@Composable
private fun PendidikanScreenPrev() {
    PendidikanScreen(
        paymentNavController = rememberNavController()
    )
}
