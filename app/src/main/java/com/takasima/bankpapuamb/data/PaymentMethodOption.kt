package com.takasima.bankpapuamb.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PaymentMethodOption(val option: String, val logo: Int, var initialSelectedValue: Boolean) {
    var selected by mutableStateOf(initialSelectedValue)
}