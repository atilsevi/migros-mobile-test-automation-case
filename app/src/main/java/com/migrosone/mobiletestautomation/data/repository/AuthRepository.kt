package com.migrosone.mobiletestautomation.data.repository

import com.migrosone.mobiletestautomation.data.local.AuthManager
import com.migrosone.mobiletestautomation.data.model.User

class AuthRepository(private val authManager: AuthManager) {

    fun signUp(email: String, password: String, name: String) {
        authManager.signUp(email, password, name)
    }

    fun signIn(email: String, password: String): Boolean {
        return authManager.signIn(email, password)
    }

    fun getUser(): User? {
        return authManager.getUser()
    }
}