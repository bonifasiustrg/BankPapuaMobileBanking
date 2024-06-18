package com.takasima.bankpapuamb

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.journeyapps.barcodescanner.ScanContract
import com.takasima.bankpapuamb.data.UserPreferences
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.navigation.graphs.RootNavGraph
import com.takasima.bankpapuamb.screen.main.homemenu.payment.game.GameScreen
import com.takasima.bankpapuamb.ui.theme.BankPapuaMobileBankingTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

//    /*QR*/
//    private var textResult = mutableStateOf("")
//
//    private var barCodeLauncher = registerForActivityResult(ScanContract()) {result ->
//        if (result.contents == null) {
//            Toast.makeText(this@MainActivity, "Cancelled", Toast.LENGTH_SHORT).show()
//        } else {
//            textResult.value = result.contents
//        }
//    }
//
//    private fun showCamera() {
//        val options = ScanOptions()
//        options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
//        options.setPrompt("Scan a QR Code")
//        options.setCameraId(0)
//        options.setBeepEnabled(false)
//        options.setOrientationLocked(false)
//
//        barCodeLauncher.launch(options)
//    }
//
//    private val requestPermissionLauncher = registerForActivityResult(
//        ActivityResultContracts.RequestPermission()
//    ) { isGranted ->
//        if (isGranted) {
//            showCamera()
//        }
//    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        WindowCompat.setDecorFitsSystemWindows(window, false)

        val barCodeLauncher = registerForActivityResult(ScanContract()) { result ->
            if (result.contents == null) {
                Toast.makeText(this@MainActivity, "Cancelled", Toast.LENGTH_SHORT).show()
            } else {
                mainViewModel.textResult.value = result.contents
            }
        }

        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                mainViewModel.showCamera()
            }
        }

        setContent {
            SetBarColor(color = /*MaterialTheme.colorScheme.background*/Color.Transparent)

            val userPreferences = UserPreferences(applicationContext)
            val factory = ViewModelFactory(userPreferences)
            val mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
            mainViewModel.setBarCodeLauncher(barCodeLauncher)
            mainViewModel.setRequestPermissionLauncher(requestPermissionLauncher)
            val isAuth = mainViewModel.isLoggedIn.collectAsState().value


            BankPapuaMobileBankingTheme {
                RootNavGraph(mainViewModel, true)
//                GameScreen(homeNavController = rememberNavController())
            }

        }

    }

//    private fun checkCameraPermission(context : Context) {
//        if (ContextCompat.checkSelfPermission(
//            context,
//            android.Manifest.permission.CAMERA
//        ) == PackageManager.PERMISSION_GRANTED) {
//            showCamera()
//        }
//        else if (shouldShowRequestPermissionRationale(android.Manifest.permission.CAMERA)) {
//            Toast.makeText(this@MainActivity, "Camera required", Toast.LENGTH_SHORT).show()
//        } else {
//            requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
//        }
//
//    }



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
