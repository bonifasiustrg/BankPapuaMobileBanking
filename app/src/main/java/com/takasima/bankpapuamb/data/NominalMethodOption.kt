package com.takasima.bankpapuamb.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class NominalMethodOption(val option: String, var initialSelectedValue: Boolean) {
    var selected by mutableStateOf(initialSelectedValue)
}
