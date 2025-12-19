package com.migrosone.mobiletestautomation.ui.screen.sign_in

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.migrosone.mobiletestautomation.ui.component.AuthForm
import com.migrosone.mobiletestautomation.ui.navigation.Screen
import com.migrosone.mobiletestautomation.viewmodel.AuthViewModel


@Composable
fun SignInScreen(navController: NavController, authViewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Hata mesajları
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var signInError by remember { mutableStateOf("") } // Yeni hata mesajı

    // Sign In fonksiyonu
    val onSignIn = {
        // İlk önce, eğer email ya da şifre boşsa, hata mesajı verelim.
        emailError = if (email.isEmpty()) "Email is required" else ""
        passwordError = if (password.isEmpty()) "Password is required" else ""

        // Eğer her iki alan da doluysa giriş yapalım
        if (email.isNotEmpty() && password.isNotEmpty()) {
            val isSuccess = authViewModel.signIn(email, password)
            if (isSuccess) {
                navController.navigate(Screen.Profile.route)
            } else {
                signInError =
                    "User not found or incorrect credentials" // Kullanıcı bulunamadı hatası
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sign In", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Email alanı ve hata mesajı
        AuthForm(
            email = email,
            password = password,
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onSubmit = onSignIn,
            buttonText = "Sign In"
        )

        // Hata mesajlarını göster
        if (emailError.isNotEmpty()) {
            Text(
                text = emailError,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        if (passwordError.isNotEmpty()) {
            Text(
                text = passwordError,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        // Kullanıcı bulunamadığında hata mesajı göster
        if (signInError.isNotEmpty()) {
            Text(
                text = signInError,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
