package com.amin.soldier.ui.theme

import android.app.Activity
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.amin.soldier.MyApp
import com.amin.soldier.R
import com.amin.soldier.config.THEME_STATE
import com.amin.soldier.utils.DataStoreUtils

private val DarkColorScheme = darkColorScheme(
    primary = Purple80, secondary = PurpleGrey80, tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40, secondary = PurpleGrey40, tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

//是否为深色
val isDarkTheme = mutableStateOf(DataStoreUtils.getSyncData(THEME_STATE, false))


private val LightTheme = AppTheme(
    themeColor = lightColor,
    themeDrawable = lightDrawable,
)
private val DarkTheme = AppTheme(
    themeColor = lightColor,
    themeDrawable = lightDrawable,
)

val LocalSpacing = staticCompositionLocalOf<AppTheme> {
    error("No theme provided")
}


//指定要主题内容
object CustomTheme {
    val appTheme: AppTheme
        @Composable get() = LocalSpacing.current

}


@Composable
fun ComposeTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true, content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()//状态栏透明
            window.navigationBarColor = Color.Transparent.toArgb()//导航栏透明
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
            WindowCompat.setDecorFitsSystemWindows(window,false)//沉浸式

        }
    }

    CompositionLocalProvider(LocalSpacing provides if (isDarkTheme.value) DarkTheme else LightTheme) {
        MaterialTheme(
            colorScheme = colorScheme, typography = Typography, content = content
        )
    }
}