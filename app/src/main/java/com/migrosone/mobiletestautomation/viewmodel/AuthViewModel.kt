package com.migrosone.mobiletestautomation.viewmodel

import androidx.lifecycle.ViewModel
import com.migrosone.mobiletestautomation.data.model.User
import com.migrosone.mobiletestautomation.data.repository.AuthRepository

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    fun signUp(email: String, password: String, name: String) {
        authRepository.signUp(email, password, name)
    }

    fun signIn(email: String, password: String): Boolean {
        return authRepository.signIn(email, password)
    }

    fun getUser(): User? {
        return authRepository.getUser()
    }
}
