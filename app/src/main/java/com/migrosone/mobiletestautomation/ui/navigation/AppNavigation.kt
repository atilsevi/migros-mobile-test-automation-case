package com.migrosone.mobiletestautomation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.migrosone.mobiletestautomation.ui.screen.initial.InitialScreen
import com.migrosone.mobiletestautomation.ui.screen.profile.ProfileScreen
import com.migrosone.mobiletestautomation.ui.screen.sign_in.SignInScreen
import com.migrosone.mobiletestautomation.ui.screen.sign_up.SignUpScreen
import com.migrosone.mobiletestautomation.ui.screen.signup_success.SignUpSuccessScreen
import com.migrosone.mobiletestautomation.viewmodel.AuthViewModel

@Composable
fun AppNavigation(navController: NavHostController, authViewModel: AuthViewModel) {
    NavHost(navController, startDestination = Screen.Initial.route) {
        composable(Screen.Initial.route) {
            InitialScreen(navController)  // İlk ekran (butonlar)
        }

        composable(Screen.SignIn.route) {
            SignInScreen(navController = navController, authViewModel = authViewModel)
        }
        composable(Screen.SignUp.route) {
            SignUpScreen(navController = navController, authViewModel = authViewModel)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController, authViewModel = authViewModel)
        }
        composable(Screen.SignUpSuccess.route) {
            SignUpSuccessScreen(navController = navController)
        }
    }
}
