package com.amin.soldier.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


/**
 *Author: Amin
 *Data: 2023/12/15 15:25
 *
 *Description:自定义主题
 *
 * 仿  ColorScheme
 *
 *
 */
class AppTheme(
    themeColor: APPColors,
    themeDrawable: Drawables
) {
    var themeColor: APPColors by mutableStateOf(themeColor)
        internal set
    var themeDrawable: Drawables by mutableStateOf(themeDrawable)
        internal set
}

