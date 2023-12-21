package com.amin.soldier

import android.app.Application
import android.content.Context
import com.amin.soldier.utils.DataStoreUtils
import com.amin.soldier.utils.SoundUtil
import com.winspread.solidierlib.bluetooth.commed.BtUtils
import dagger.hilt.android.HiltAndroidApp

/**
 *Author: Amin
 *Data: 2023/12/15 14:40
 *
 *Description:
 *
 */
@HiltAndroidApp
class MyApp:Application() {

    companion object{
        lateinit var mContext:Context
    }


    override fun onCreate() {
        super.onCreate()
        mContext = this
        BtUtils.init(this.applicationContext, BtUtils.DEVICE_UUID, true)
        DataStoreUtils.init(mContext)
        SoundUtil.instance.init(this)
    }


}