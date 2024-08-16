package com.takasima.bankpapuamb.data.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.data.NominalMethodOption
import com.takasima.bankpapuamb.data.PaymentMethodOption

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
    private val _optionsNominal = listOf(
        NominalMethodOption("100.000", false),
        NominalMethodOption("200.000", false),
        NominalMethodOption("300.000", false),
        NominalMethodOption("400.000", false),
        NominalMethodOption("500.000", false),
        NominalMethodOption("600.000", false),
        NominalMethodOption("700.000", false),
        NominalMethodOption("800.000", false),
        NominalMethodOption("900.000", false),
        NominalMethodOption("1.000.000", false),
    ).toMutableStateList()
    val optionsNominal: List<NominalMethodOption>
        get() = _optionsNominal

    fun selectionOptionSelected(selectedOption: NominalMethodOption) {
        _optionsNominal.forEach { it.selected = false }
        _optionsNominal.find { it.option == selectedOption.option }?.selected = true
    }
}