package com.amin.soldier.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amin.soldier.ui.bt.BtScreen
import com.amin.soldier.ui.home.HomeScreen
import com.amin.soldier.ui.route.RouteName

/**
 *Author: Amin
 *Data: 2023/12/22 11:18
 *
 *Description:
 *
 */


@Composable
fun AppScaffold() {

    //创建一个 NavHostController 来处理ComposeNavigator和DialogNavigator的添加
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = RouteName.HOME){
        composable(RouteName.HOME){
            HomeScreen(navController)
        }
        composable(RouteName.BT){
            BtScreen(navController)
        }
    }




}

