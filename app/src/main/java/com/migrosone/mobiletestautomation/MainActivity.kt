package com.migrosone.mobiletestautomation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.migrosone.mobiletestautomation.data.local.AuthManager
import com.migrosone.mobiletestautomation.data.repository.AuthRepository
import com.migrosone.mobiletestautomation.ui.navigation.AppNavigation
import com.migrosone.mobiletestautomation.ui.theme.AuthAppTheme
import com.migrosone.mobiletestautomation.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val authManager = AuthManager(applicationContext)
        val authRepository = AuthRepository(authManager)
        val authViewModel = AuthViewModel(authRepository)

        setContent {
            AuthAppTheme {
                AppNavigation(
                    navController = rememberNavController(),
                    authViewModel = authViewModel
                )
            }
        }
    }
}
