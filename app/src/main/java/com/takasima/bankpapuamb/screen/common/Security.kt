package com.takasima.bankpapuamb.screen.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.ui.theme.secondary

@Composable
fun SecurityScreen(menuNavController: NavHostController, detailNavController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.1f)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//                    TTSection1(homeNavController, modifier)
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = "Silahkan Masukkan PIN Anda",
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        OptTextFieldPIN(bgColor = Color.White)

        Spacer(modifier = Modifier.height(100.dp))
        Button(
            modifier = Modifier.width(200.dp),
            onClick = {
                detailNavController.popBackStack()
                menuNavController.navigate(FeatureRouteScreens.PembayaranMainSection.route) {
                menuNavController.popBackStack()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = secondary)
        ) {
            Text(text = "Konfirmasi")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "Kirim ulang kode", color = Color.White, style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,

                    )
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SecurityScreenPrev() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SecurityScreen(
            rememberNavController(),
            rememberNavController()
        )
    }
}