package com.winspread.compose.bean

import androidx.compose.ui.graphics.Color
import com.winspread.compose.ui.theme.beepBlue
import com.winspread.compose.ui.theme.blue
import com.winspread.compose.ui.theme.brown
import com.winspread.compose.ui.theme.cyan
import com.winspread.compose.ui.theme.gray
import com.winspread.compose.ui.theme.green
import com.winspread.compose.ui.theme.magenta
import com.winspread.compose.ui.theme.orange
import com.winspread.compose.ui.theme.purple
import com.winspread.compose.ui.theme.red

/**
 *Author: Amin
 *Data: 2023/12/7 15:01
 *
 *Description: 主题类型
 *
 */
enum class ThemeType(var type: Int, var color: Color, var title: String) {
    SKY_BLUE_THEME(0, blue, "天蓝色"),
    GRAY_THEME(1, gray, "灰色"),
    DEEP_BLUE_THEME(2, beepBlue, "深蓝色"),
    GREEN_THEME(3, green, "绿色"),
    PURPLE_THEME(4, purple, "紫色"),
    ORANGE_THEME(5, orange, "橘黄色"),
    BROWN_THEME(6, brown, "棕色"),
    RED_THEME(7, red, "红色"),
    CYAN_THEME(8, cyan, "青色"),
    MAGENTA_THEME(9, magenta, "品红色")

}