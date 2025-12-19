package com.migrosone.mobiletestautomation.data.local

import android.content.Context
import android.content.SharedPreferences
import com.migrosone.mobiletestautomation.data.model.User

class AuthManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_EMAIL = "email"
        private const val KEY_PASSWORD = "password"
        private const val KEY_NAME = "name"
        private const val KEY_PROFILE_IMAGE = "profile_image"
    }

    fun signUp(email: String, password: String, name: String) {
        sharedPreferences.edit()
            .putString(KEY_EMAIL, email)
            .putString(KEY_PASSWORD, password)
            .putString(KEY_NAME, name)
            .apply()
    }

    fun signIn(email: String, password: String): Boolean {
        val storedEmail = sharedPreferences.getString(KEY_EMAIL, null)
        val storedPassword = sharedPreferences.getString(KEY_PASSWORD, null)
        return email == storedEmail && password == storedPassword
    }

    fun getUser(): User? {
        val email = sharedPreferences.getString(KEY_EMAIL, null)
        val name = sharedPreferences.getString(KEY_NAME, null)
        val profileImage = sharedPreferences.getString(KEY_PROFILE_IMAGE, null)
        return if (email != null && name != null) {
            User(email, name, profileImage)
        } else {
            null
        }
    }
}
