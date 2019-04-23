package com.example.sneakeryard.logic

import android.content.Context
import android.preference.PreferenceManager

class SharedPreferencesHelper {
    fun isUserLoggedIn(context: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)

        return prefs.getBoolean("isUserLoggedIn", false)
    }

    fun setUserLoggedIn(context: Context, isLoggedIn: Boolean?) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        editor.putBoolean("isUserLoggedIn", isLoggedIn!!)
        editor.apply()
    }

    fun logout(context: Context) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        editor.putBoolean("isUserLoggedIn", false)
        editor.apply()
    }

    fun saveUsernameAndPassword(context: Context, username: String, password: String) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }
}