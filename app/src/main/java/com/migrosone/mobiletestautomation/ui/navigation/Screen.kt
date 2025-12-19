package com.migrosone.mobiletestautomation.ui.navigation

sealed class Screen(val route: String) {
    object Initial : Screen("initial")
    object SignIn : Screen("sign_in")
    object SignUp : Screen("sign_up")
    object SignUpSuccess : Screen("signup_success")
    object Profile : Screen("profile")
}
