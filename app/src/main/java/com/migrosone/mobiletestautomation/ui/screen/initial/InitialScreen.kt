package com.migrosone.mobiletestautomation.ui.screen.initial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.migrosone.mobiletestautomation.R
import com.migrosone.mobiletestautomation.ui.navigation.Screen

@Composable
fun InitialScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Migros Logo
        Image(
            painter = painterResource(id = R.drawable.migrosone_logo_2), // Migros logosu
            contentDescription = "Migros Logo",
            modifier = Modifier.size(120.dp) // Boyutu ihtiyaca göre ayarlayın
        )

        Spacer(modifier = Modifier.height(24.dp)) // Logo ile başlık arasında boşluk

        // Sign In Butonu
        Button(
            onClick = {
                navController.navigate(Screen.SignIn.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6600), // Turuncu arka plan
                contentColor = Color.White          // Beyaz yazı
            )
        ) {
            Text(text = "Sign In")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign Up Butonu
        Button(
            onClick = { navController.navigate(Screen.SignUp.route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFFFF6600)
            ),
            border = BorderStroke(2.dp, Color(0xFFFF6600))
        ) {
            Text(text = "Sign Up")
        }
    }
}
