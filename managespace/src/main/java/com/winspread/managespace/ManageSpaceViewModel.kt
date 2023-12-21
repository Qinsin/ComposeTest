package com.winspread.managespace

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *Author: Amin
 *Data: 2023/12/13 11:13
 *
 *Description:
 *
 */
class ManageSpaceViewModel constructor(val context: Application) : AndroidViewModel(context) {

    private val repository = ManageSpaceRepository(context)

    private val _viewState: MutableState<ManageSpaceState> = mutableStateOf(ManageSpaceState.Loading)
    val state: MutableState<ManageSpaceState> = _viewState

    private val _effect = MutableSharedFlow<ManageSpaceEffet>()
    val effect: SharedFlow<ManageSpaceEffet> by lazy { _effect.asSharedFlow() }


    fun sendAction(manageSpaceAction: ManageSpaceAction) {
        when (manageSpaceAction) {
            ManageSpaceAction.LoadSpaceData -> {
                viewModelScope.launch {
                    withContext(Dispatchers.IO) {
                        repository.getAppSiez()
                    }.onSuccess {
                        _viewState.value = it
                    }.onFailure {
                        _effect.tryEmit(ManageSpaceEffet.ShowToast("free space load error"))
                    }

                }
            }

            ManageSpaceAction.ClearCache -> {
                viewModelScope.launch {
                    _viewState.value = ManageSpaceState.Loading
                    withContext(Dispatchers.IO) {
                        repository.clearCache()
                        repository.getAppSiez()
                    }.onSuccess {
                        _viewState.value = it
                    }.onFailure {
                        _effect.tryEmit(ManageSpaceEffet.ShowToast("clear cache error"))
                    }
                }

            }
        }


    }

    fun ces() {
        _effect.tryEmit(ManageSpaceEffet.ShowToast("ces"))

    }


}