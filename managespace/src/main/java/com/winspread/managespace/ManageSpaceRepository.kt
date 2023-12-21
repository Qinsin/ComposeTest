package com.winspread.managespace

import android.app.usage.StorageStatsManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.storage.StorageManager
import android.text.format.Formatter
import java.io.File
import kotlin.system.measureTimeMillis

class ManageSpaceRepository(private val context: Context) {

    private val filesDir: File
        get() = context.filesDir

    fun getAppSiez() = kotlin.runCatching {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val storageStatsManager = context.getSystemService(Context.STORAGE_STATS_SERVICE) as StorageStatsManager
            val uid = context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA).uid
            val storageStats = storageStatsManager.queryStatsForUid(StorageManager.UUID_DEFAULT, uid)
            ManageSpaceState.StorageSpace(
                dataBytes = storageStats.dataBytes,
                cacheBytes = storageStats.cacheBytes,
                apkBytes = storageStats.appBytes,
                dataSize = Formatter.formatFileSize(context, storageStats.dataBytes),
                cacheSize = Formatter.formatFileSize(context, storageStats.cacheBytes),
                apkSize = Formatter.formatFileSize(context, storageStats.appBytes)
            )
        } else {
            TODO()
        }
    }


    fun clearCache() = kotlin.runCatching {
        val time = measureTimeMillis {
            filesDir.deleteRecursively()
        }
        println(2500 - time)
    }


}
