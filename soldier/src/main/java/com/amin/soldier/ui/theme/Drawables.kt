package com.amin.soldier.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.amin.soldier.R

@Stable
class Drawables(
    themeSwitch: Int,
    themeSwitch2: Int,
    BtImageno: Int,
    BtImageoff: Int,
    IndicatorCenter: Int,
    IndicatorPoint: Int,
    SyncImageoff: Int,
    SyncImageon: Int,
    emptyImage: Int,
    fanImage:Int,
    closeImage:Int,
    bluetooImage:Int

) {
    var themeSwitch: Int by mutableStateOf(themeSwitch)
        internal set
    var themeSwitch2: Int by mutableStateOf(themeSwitch2)
        internal set
    var BtImageno: Int by mutableStateOf(BtImageno)
        internal set
    var BtImageoff: Int by mutableStateOf(BtImageoff)
        internal set
    var IndicatorCenter: Int by mutableStateOf(IndicatorCenter)
        internal set
    var IndicatorPoint: Int by mutableStateOf(IndicatorPoint)
        internal set
    var SyncImageoff: Int by mutableStateOf(SyncImageoff)
        internal set
    var SyncImageon: Int by mutableStateOf(SyncImageon)
        internal set
    var emptyImage: Int by mutableStateOf(emptyImage)
        internal set
    var fanImage: Int by mutableStateOf(fanImage)
        internal set
    var closeImage: Int by mutableStateOf(closeImage)
        internal set
    var bluetooImage: Int by mutableStateOf(bluetooImage)
        internal set


}

val darkDrawable by lazy {
    Drawables(
        themeSwitch = R.mipmap.icon_dark,
        themeSwitch2 = R.mipmap.icon_dark_light,
        BtImageno = R.drawable.ic_bt_no,
        BtImageoff = R.drawable.ic_bt_off,
        IndicatorCenter = R.drawable.ic_dial_0,
        IndicatorPoint = R.drawable.ic_point,
        SyncImageoff = R.drawable.ic_sync_off,
        SyncImageon = R.drawable.ic_sync_on,
        emptyImage = R.mipmap.icon_empty,
        fanImage = R.mipmap.icon_fan,
        closeImage = R.mipmap.icon_close,
        bluetooImage = R.drawable.ic_device_bt
    )
}

val lightDrawable by lazy {
    Drawables(
        themeSwitch = R.mipmap.icon_light,
        themeSwitch2 = R.mipmap.icon_light_light,
        BtImageno = R.mipmap.ic_bt_no_light,
        BtImageoff = R.mipmap.ic_bt_off_light,
        IndicatorCenter = R.drawable.ic_dial_0_light,
        IndicatorPoint = R.drawable.ic_point_light,
        SyncImageoff = R.mipmap.ic_sync_off_light,
        SyncImageon = R.mipmap.ic_sync_on_light,
        emptyImage = R.mipmap.icon_empty_light,
        fanImage = R.mipmap.icon_fan_light,
        closeImage = R.mipmap.icon_close_light,
        bluetooImage = R.mipmap.ic_device_bt_light
    )
}