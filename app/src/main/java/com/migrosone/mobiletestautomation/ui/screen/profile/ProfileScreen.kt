package com.migrosone.mobiletestautomation.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.migrosone.mobiletestautomation.ui.navigation.Screen
import com.migrosone.mobiletestautomation.viewmodel.AuthViewModel

@Composable
fun ProfileScreen(navController: NavController, authViewModel: AuthViewModel) {
    val user = authViewModel.getUser()

    // Kullanıcı bilgilerini al
    val userName = user?.name // Kullanıcının adı
    val userEmail = user?.email // Kullanıcının e-posta adresi
    val userImage = user?.profileImage // Kullanıcının profil fotoğrafı (eğer varsa)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profil Fotoğrafı Placeholder
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            if (userImage.isNullOrEmpty()) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile picture",
                    modifier = Modifier.size(60.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            } else {
                // Profil fotoğrafı varsa burada görüntülenebilir
                //Image(painter = rememberImagePainter(userImage), contentDescription = "Profile Image")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Kullanıcı adı
        Text(
            text = "Welcome, $userName",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Kullanıcı e-posta adresi
        if (userEmail != null) {
            Text(
                text = "email: $userEmail",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Sign Out Butonu
        Button(
            onClick = {
                navController.navigate(Screen.SignIn.route) {
                    popUpTo(Screen.Profile.route) { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6600), // Turuncu arka plan
                contentColor = Color.White          // Beyaz yazı
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Out")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Ekstra bilgiler veya kullanıcıya özel içerik eklenebilir
        Text(
            text = "Additional Info",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

