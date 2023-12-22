package com.amin.soldier.ui.home

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.amin.soldier.config.VOICE_STATE
import com.amin.soldier.utils.DataStoreUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *Author: Amin
 *Data: 2023/12/22 16:07
 *
 *Description:
 *
 */
@HiltViewModel
class HomeVM @Inject constructor(application: Application) : AndroidViewModel(application) {

    // 喇叭开关
    var voiceState = mutableStateOf(DataStoreUtils.getSyncData(VOICE_STATE, false))


}