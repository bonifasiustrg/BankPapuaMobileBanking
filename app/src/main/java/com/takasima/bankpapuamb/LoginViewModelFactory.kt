package com.takasima.bankpapuamb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.takasima.bankpapuamb.data.UserPreferences
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel

class LoginViewModelFactory(private val userPreferences: UserPreferences) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(userPreferences) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
