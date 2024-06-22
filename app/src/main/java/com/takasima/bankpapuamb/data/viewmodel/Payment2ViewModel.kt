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
import androidx.compose.runtime.toMutableStateList
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.data.ListrikMethodOption

class Payment2ViewModel() : ViewModel() {
    private val _options = listOf(
        ListrikMethodOption("Token Listrik", R.drawable.listrik_ic, false),
        ListrikMethodOption("Non Tagihan Listrik", R.drawable.listrik_ic, false),
        ListrikMethodOption("Tagihan Listrik", R.drawable.listrik_ic, false)
    ).toMutableStateList()
    val options: List<ListrikMethodOption>
        get() = _options

    fun selectionOptionSelected(selectedOption: ListrikMethodOption) {
        _options.forEach { it.selected = false }
        _options.find { it.option == selectedOption.option }?.selected = true
    }
}
