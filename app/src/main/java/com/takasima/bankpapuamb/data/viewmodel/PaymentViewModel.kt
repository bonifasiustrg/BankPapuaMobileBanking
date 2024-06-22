//package com.takasima.bankpapuamb.data.viewmodel
//
//import androidx.compose.runtime.toMutableStateList
//import androidx.lifecycle.ViewModel
//import com.takasima.bankpapuamb.R
//import com.takasima.bankpapuamb.data.ListrikMethodOption
//
//class ListrikViewModel() : ViewModel() {
//    private val _options = listOf(
//        ListrikMethodOption("Token Listrik", R.drawable.listrik, false),
//        ListrikMethodOption("Non Tagihan Listrik",R.drawable.listrik, false),
//        ListrikMethodOption("Tagihan Listrik",R.drawable.listrik, false)
//    ).toMutableStateList()
//    val options: List<ListrikMethodOption>
//        get() = _options
//
//    fun selectionOptionSelected(selectedOption: ListrikMethodOption) {
//        _options.forEach { it.selected = false }
//        _options.find { it.option == selectedOption.option }?.selected = true
//    }
//}