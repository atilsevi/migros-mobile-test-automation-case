package com.migrosone.mobiletestautomation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

// Tema renkleri
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC5),
    tertiary = Color(0xFF018786),
    background = Color(0xFFF5F5F5),
    surface = Color(0xFFFFFFFF),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC5),
    tertiary = Color(0xFF018786),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
)

// Tipografi tanımları (Material3 TypographyTokens ile)
val Typography = Typography(
    displayLarge = TextStyle(fontSize = 57.sp),
    displayMedium = TextStyle(fontSize = 45.sp),
    displaySmall = TextStyle(fontSize = 36.sp),
    headlineLarge = TextStyle(fontSize = 32.sp),
    headlineMedium = TextStyle(fontSize = 28.sp),
    headlineSmall = TextStyle(fontSize = 24.sp),
    titleLarge = TextStyle(fontSize = 22.sp),
    titleMedium = TextStyle(fontSize = 20.sp),
    titleSmall = TextStyle(fontSize = 18.sp),
    bodyLarge = TextStyle(fontSize = 16.sp),
    bodyMedium = TextStyle(fontSize = 14.sp),
    bodySmall = TextStyle(fontSize = 12.sp),
    labelLarge = TextStyle(fontSize = 14.sp),
    labelMedium = TextStyle(fontSize = 12.sp),
    labelSmall = TextStyle(fontSize = 10.sp)
)

@Composable
fun AuthAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,  // Typography burada doğru şekilde kullanılıyor
        content = content
    )
}
