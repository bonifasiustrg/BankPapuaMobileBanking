package com.takasima.bankpapuamb.data.viewmodel

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.takasima.bankpapuamb.data.UserPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

class MainViewModel(private val userPreferences: UserPreferences) : ViewModel() {
    /*QR SCAN*/
//    var textResult = mutableStateOf("")
    var textResult: MutableState<String> = mutableStateOf("")
        private set

    private lateinit var barCodeLauncher: ActivityResultLauncher<ScanOptions>
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

    fun setBarCodeLauncher(barCodeLauncher: ActivityResultLauncher<ScanOptions>) {
        this.barCodeLauncher = barCodeLauncher
    }

    fun setRequestPermissionLauncher(requestPermissionLauncher: ActivityResultLauncher<String>) {
        this.requestPermissionLauncher = requestPermissionLauncher
    }

    fun showCamera() {
        val options = ScanOptions()
        options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        options.setPrompt("Scan a QR Code")
        options.setCameraId(0)
        options.setBeepEnabled(false)
        options.setOrientationLocked(false)

        barCodeLauncher.launch(options)
    }

    fun checkCameraPermission(context: Context) {
        if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED) {
            showCamera()
        } else if (shouldShowRequestPermissionRationale(context as Activity, android.Manifest.permission.CAMERA)) {
            Toast.makeText(context, "Camera required", Toast.LENGTH_SHORT).show()
        } else {
            requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }

    private fun shouldShowRequestPermissionRationale(activity: Activity, permission: String): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
    }

    /*LOGIN*/
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    init {
        viewModelScope.launch {
            userPreferences.isLoggedIn.collect { loggedIn ->
                _isLoggedIn.value = loggedIn
            }
        }
    }

    fun login() {
        viewModelScope.launch {
            userPreferences.setLoggedIn(true)
        }
    }

    fun logout() {
        viewModelScope.launch {
            userPreferences.setLoggedIn(false)
        }
    }
}
