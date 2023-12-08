package com.winspread.compose.utlis

import android.util.Log

/**
 *Author: Amin
 *Data: 2023/12/8 14:09
 *
 *Description:
 *
 */
var isLog = true



// 给方法变量添加默认值,使用方法时,可以不传值
fun String.i(tag: String = ">>>>") {
    if (isLog)
        Log.i(tag, this)
}


fun String.d(tag: String? = ">>>>") {
    if (isLog)
        Log.d(tag ?: ">>>>", this)
}

fun String.loge(tag: String = "----->>>>>") {
    if (isLog)
        Log.e(tag, this)
}