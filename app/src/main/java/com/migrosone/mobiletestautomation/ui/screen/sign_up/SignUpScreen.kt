package com.migrosone.mobiletestautomation.ui.screen.sign_up

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
fun SignUpScreen(navController: NavController, authViewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    val onSignUp = {
        authViewModel.signUp(email, password, name)
        navController.navigate(Screen.SignUpSuccess.route)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sign Up", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        AuthForm(
            email = email,
            password = password,
            name = name,
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onNameChange = { name = it },
            onSubmit = onSignUp,
            buttonText = "Sign Up"
        )
    }
}