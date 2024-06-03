package com.takasima.bankpapuamb.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.takasima.bankpapuamb.data.UserPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val userPreferences: UserPreferences) : ViewModel() {

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
