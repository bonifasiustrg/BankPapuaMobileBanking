package com.takasima.bankpapuamb.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.navigation.AuthRouteScreens
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.ui.theme.secondary


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CongratsScreen(rootNavController: NavHostController, modifier: Modifier = Modifier) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val pswdConfirm = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current


    /*CONTENT*/
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Image(
            painter = painterResource(id = R.drawable.congrats_ic),
            contentDescription = null,
            modifier = modifier.size(width = 187.dp, height = 213.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = modifier
                .fillMaxWidth(0.8f),
            text = "Selamat anda telah berhasil\n" +
                    "melakukan Transaksi KUR dari Bank\n" +
                    "Papua",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                rootNavController.popBackStack()
                rootNavController.navigate(MainRouteScreens.Home.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = secondary
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(200.dp)

        ) {
            Text(text = "BERANDA", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.fillMaxHeight(0.1f))

    }
}

@Preview(showBackground = true)
@Composable
private fun CongratesScreenPrev4() {
    CongratsScreen(rememberNavController())
}