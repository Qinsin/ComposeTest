package com.amin.soldier.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.amin.soldier.MyApp
import com.amin.soldier.utils.DialogTwoBtn
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.winspread.solidierlib.utils.loge
import kotlinx.coroutines.runBlocking


/**
 *Author: Amin
 *Data: 2023/12/16 9:32
 *
 *Description:启动页
 *
 */
@SuppressLint("MissingPermission")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MySplashScreen(lifecycle: Lifecycle) {
    permissionRequest(lifecycle = lifecycle) {
        "授权:$it".loge()
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun permissionRequest(
    firstContent: String = "该权限对应用程序很重要，请授予权限。",
    secondRequest: String = "需要该权限才能使用此功能，请授予权限。",
    lifecycle: Lifecycle,
    success: (Boolean) -> Unit
) {
    var first by remember {
        mutableStateOf(true)
    }

    //权限是否"拒绝且不在访问"
    val isDenied = remember { mutableStateOf(false) }
    //是否在进行请求
    var isRequest = false
    //进行请求前shouldShowRationale状态
    var resumeShouldShowRationale = false

    val multiplePermissionsState = rememberMultiplePermissionsState(
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.R) {
            listOf(
                Manifest.permission.BLUETOOTH_ADMIN, Manifest.permission.BLUETOOTH
            )
        } else {
            listOf(
                Manifest.permission.BLUETOOTH_SCAN,
                Manifest.permission.BLUETOOTH_CONNECT,
                Manifest.permission.BLUETOOTH_ADVERTISE,
            )
        }
    )

    class AppLifeObserver : LifecycleEventObserver {
        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    if (isRequest) {
                        isDenied.value = resumeShouldShowRationale == multiplePermissionsState.shouldShowRationale
                        isRequest = false
                    }
                }

                else -> {}
            }
        }
    }
    lifecycle.addObserver(AppLifeObserver())
    when (multiplePermissionsState.allPermissionsGranted) {
        true -> {
            success.invoke(true)
        }

        false -> {
            var textToShow = ""
            var textToTip = ""
            var textToGo = ""
            resumeShouldShowRationale = multiplePermissionsState.shouldShowRationale

            if (resumeShouldShowRationale && !first) {
                textToShow = firstContent
                textToTip = "退出"
                textToGo = "去授权"
            } else if (isDenied.value) {
                textToShow = secondRequest
                textToTip = "退出"
                textToGo = "去设置"
            } else {
                LaunchedEffect(Unit) {
                    runBlocking {
                        multiplePermissionsState.launchMultiplePermissionRequest()
                        isRequest = true
                        first = false
                    }

                }
                return
            }

            DialogTwoBtn(textToShow, textToTip, textToGo, {
                android.os.Process.killProcess(android.os.Process.myPid())
            }, {
                if (isDenied.value) {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    intent.data = Uri.fromParts("package", MyApp.mContext.packageName, null)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    MyApp.mContext.startActivity(intent)
                    resumeShouldShowRationale = true
                } else {
                    multiplePermissionsState.launchMultiplePermissionRequest()
                    first = false
                }
                isRequest = true
            })

        }
    }


}


