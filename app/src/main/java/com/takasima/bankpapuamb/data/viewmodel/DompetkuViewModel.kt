package com.takasima.bankpapuamb.data.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.data.PaymentMethodOption
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DompetkuViewModel : ViewModel() {
    private val _options = listOf(
        PaymentMethodOption("DANA", R.drawable.dana, false),
        PaymentMethodOption("OVO",R.drawable.ovo, false),
        PaymentMethodOption("GOPAY",R.drawable.gopay, false)
    ).toMutableStateList()
    val options: List<PaymentMethodOption>
        get() = _options

    fun selectionOptionSelected(selectedOption: PaymentMethodOption) {
        _options.forEach { it.selected = false }
        _options.find { it.option == selectedOption.option }?.selected = true
    }

    /*private val _uiState = MutableStateFlow("Initial State")
    val uiState: StateFlow<String> = _uiState

    fun changeState() {
        viewModelScope.launch {
            delay(1000) // Simulate a long-running task
            _uiState.value = "State Changed"
        }
    }*/
}