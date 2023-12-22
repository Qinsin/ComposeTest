package com.amin.soldier.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amin.soldier.ui.theme.CustomTheme

/**
 *Author: Amin
 *Data: 2023/12/22 15:22
 *
 *Description: 主界面
 *
 */
@Composable
fun HomeScreen(navController: NavHostController) {

    val homeVM = hiltViewModel<HomeVM>()
    val themeDrawable = CustomTheme.appTheme.themeDrawable
    val themeColor = CustomTheme.appTheme.themeColor
    Box() {
        Column(
            modifier = Modifier.wrapContentSize(Alignment.TopCenter),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeTopTitle(navController)


        }

    }


}
