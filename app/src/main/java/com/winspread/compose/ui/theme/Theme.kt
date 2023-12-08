package com.winspread.compose.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.winspread.compose.bean.ThemeType

//深色主题颜色
private val DarkColorScheme = darkColorScheme(
    primary = Purple80, secondary = PurpleGrey80, tertiary = Pink80
)


//浅色主题颜色集合
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

@Composable
fun ComposeTestTheme(
    themeType: Int, darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, content: @Composable () -> Unit
) {

    //配色方案
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> getThemeForThemeId(themeType)
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


    MaterialTheme(
        colorScheme = colorScheme, typography = Typography, content = content
    )
}

fun getThemeForThemeId(themeType: Int): ColorScheme = when (themeType) {
    ThemeType.SKY_BLUE_THEME.type -> {
        lightColorScheme(
            primary = blue
        )
    }

    ThemeType.GRAY_THEME.type -> {
        lightColorScheme(
            primary = gray
        )
    }

    ThemeType.DEEP_BLUE_THEME.type -> {
        lightColorScheme(
            primary = beepBlue
        )
    }

    ThemeType.GREEN_THEME.type -> {
        lightColorScheme(
            primary = green
        )
    }

    ThemeType.PURPLE_THEME.type -> {
        lightColorScheme(
            primary = purple
        )
    }

    ThemeType.ORANGE_THEME .type-> {
        lightColorScheme(
            primary = orange
        )
    }

    ThemeType.BROWN_THEME.type -> {
        lightColorScheme(
            primary = brown
        )
    }

    ThemeType.RED_THEME.type -> {
        lightColorScheme(
            primary = red
        )
    }

    ThemeType.CYAN_THEME.type -> {
        lightColorScheme(
            primary = cyan
        )
    }

    ThemeType.MAGENTA_THEME.type -> {
        lightColorScheme(
            primary = magenta
        )
    }

    else -> {
        lightColorScheme(
            primary = Color.LightGray
        )
    }
}
