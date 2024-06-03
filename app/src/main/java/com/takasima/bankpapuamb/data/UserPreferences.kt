package com.takasima.bankpapuamb.data

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferences(private val context: Context) {
    private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "datastore_manager")
    private val USER_EMAIL = stringPreferencesKey(name = "user_email")
    private val USER_PASSWORD = stringPreferencesKey(name = "user_password")
    private val USER_TOKEN = stringPreferencesKey(name = "user_token")

    companion object {
        val LOGGED_IN_KEY = booleanPreferencesKey("logged_in")

        @SuppressLint("StaticFieldLeak")
        private var INSTANCE: UserPreferences? = null
        fun getInstance(context: Context): UserPreferences {
            if (INSTANCE == null) {
                synchronized(UserPreferences::class.java) {
                    INSTANCE = UserPreferences(context.applicationContext)
                }
            }
            return INSTANCE!!
        }
    }

    val isLoggedIn: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[LOGGED_IN_KEY] ?: false
        }

    suspend fun setLoggedIn(loggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[LOGGED_IN_KEY] = loggedIn
        }
    }

    suspend fun setUserToken(authToken: String) {
        withContext(Dispatchers.IO) {
            context.datastore.edit { preferences ->
                preferences[USER_TOKEN] = authToken
            }
        }
    }
    val getAuthToken: Flow<String?> = context.datastore.data.map { preferences ->
        preferences[USER_TOKEN] ?: ""
    }
    suspend fun clearUserToken() {
        context.datastore.edit { preferences ->
//            preferences.remove(USER_TOKEN)
            preferences.clear()
        }
    }
}