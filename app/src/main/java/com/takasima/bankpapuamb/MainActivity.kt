package com.takasima.bankpapuamb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.takasima.bankpapuamb.screen.auth.LoginScreen
import com.takasima.bankpapuamb.screen.auth.RegisterScreen
import com.takasima.bankpapuamb.screen.auth.RegisterScreenSection1
import com.takasima.bankpapuamb.screen.main.Dashboard
import com.takasima.bankpapuamb.ui.theme.BankPapuaMobileBankingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankPapuaMobileBankingTheme {
                SetBarColor(color = MaterialTheme.colorScheme.background)

//                LoginScreen()
//                RegisterScreenSection1()
                Dashboard()
            }
        }
    }

    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}
