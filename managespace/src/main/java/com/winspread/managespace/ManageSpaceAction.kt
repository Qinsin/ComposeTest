package com.winspread.managespace

/**
 *Author: Amin
 *Data: 2023/12/13 11:40
 *
 *Description:  密封类
 *
 */
sealed class ManageSpaceAction {
    object LoadSpaceData : ManageSpaceAction()
    object ClearCache : ManageSpaceAction()
}


sealed class ManageSpaceState {
    object Loading : ManageSpaceState()
    data class StorageSpace(
        val apkBytes: Long,
        val dataBytes: Long,
        val cacheBytes: Long,
        val apkSize: String,
        val dataSize: String,
        val cacheSize: String
    ) : ManageSpaceState()
}

sealed class ManageSpaceEffet{
    data class ShowToast(val message: String): ManageSpaceEffet()
}