package com.takasima.bankpapuamb

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.takasima.bankpapuamb.data.UserPreferences
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.graphs.Graph
import com.takasima.bankpapuamb.graphs.RootNavGraph
import com.takasima.bankpapuamb.ui.theme.BankPapuaMobileBankingTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SetBarColor(color = /*MaterialTheme.colorScheme.background*/Color.Transparent)

            val userPreferences = UserPreferences(applicationContext)
            val factory = LoginViewModelFactory(userPreferences)
            val mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)


            val navController = rememberNavController()
            BankPapuaMobileBankingTheme {

                RootNavGraph(navController, mainViewModel)

            }

        }

    }

    private fun launchLoginObserver(navController: NavHostController) {
        lifecycleScope.launch(Dispatchers.Main) {
            mainViewModel.isLoggedIn.collect { isLoggedInState ->
                if (!isLoggedInState) {
                    navController.navigate(Graph.AUTHENTICATION) {
                        popUpTo(0) // reset stack
                    }
                }
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
