package com.winspread.compose.config

import com.winspread.compose.bean.ThemeBean
import com.winspread.compose.bean.ThemeType

/**
 *Author: Amin
 *Data: 2023/12/7 15:15
 *
 *Description:
 *
 */

const val CHANGED_THEME = "CHANGED_THEME"



// 主题列表
 val themeList = mutableListOf(
    ThemeBean(ThemeType.SKY_BLUE_THEME),
    ThemeBean(ThemeType.GRAY_THEME),
    ThemeBean(ThemeType.DEEP_BLUE_THEME),
    ThemeBean(ThemeType.GREEN_THEME),
    ThemeBean(ThemeType.PURPLE_THEME),
    ThemeBean(ThemeType.ORANGE_THEME),
    ThemeBean(ThemeType.BROWN_THEME),
    ThemeBean(ThemeType.RED_THEME),
    ThemeBean(ThemeType.CYAN_THEME),
    ThemeBean(ThemeType.MAGENTA_THEME)
)
