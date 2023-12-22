package com.amin.soldier.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amin.soldier.R
import com.amin.soldier.config.VOICE_STATE
import com.amin.soldier.ui.theme.color_0x00E7ECF1
import com.amin.soldier.ui.theme.color_0x3B0075FF
import com.amin.soldier.ui.theme.dp_120
import com.amin.soldier.ui.theme.dp_16
import com.amin.soldier.ui.theme.dp_20
import com.amin.soldier.utils.DataStoreUtils

/**
 *Author: Amin
 *Data: 2023/12/22 16:41
 *
 *Description:主页头部页面
 *
 */
@Composable
fun HomeTopTitle(navController: NavHostController) {

    val hiltViewModel = hiltViewModel<HomeVM>()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dp_120)
            .background(
                Brush.verticalGradient(
                    listOf(
                        color_0x3B0075FF, color_0x00E7ECF1
                    )
                )
            )
            .statusBarsPadding(),
    ) {
        Image(painter = painterResource(id = R.mipmap.icon_scan_light),
            contentDescription = "扫码配置",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = dp_16)
                .clickable {

                })

        Image(
            painter = painterResource(id = R.mipmap.ic_top_tilte_light), contentDescription = "头部标题", modifier = Modifier.align(Alignment.Center)

        )

        Image(painter = painterResource(id = if (hiltViewModel.voiceState.value) R.mipmap.ic_sound_light else R.mipmap.ic_sound_close_light),
            contentDescription = "声音开关",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = dp_16)
                .clickable(indication = null, interactionSource = remember {
                    MutableInteractionSource()
                }) {


                    hiltViewModel.voiceState.value = !hiltViewModel.voiceState.value
                    DataStoreUtils.putSyncData(VOICE_STATE, hiltViewModel.voiceState.value)
                })
    }
}


@Preview(showBackground = true)
@Composable
fun HomeTopTitlePreview() {
    HomeTopTitle(navController = NavHostController(context = LocalContext.current))
}