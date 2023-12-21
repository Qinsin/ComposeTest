package com.amin.soldier.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.widget.Toast
import com.amin.soldier.MyApp

/**
 *Author: Amin
 *Data: 2022/5/10 11:55
 *
 *Description:
 *
 */

private var mToast: Toast? = null

/**
 * 显示时间较短的吐司
 *
 * @param text String，显示的内容
 */
fun showToast(text: String?) {
    showToast(context = MyApp.mContext, text = text)
}

fun showToast(context: Context = MyApp.mContext, text: String?) {
    if (TextUtils.isEmpty(text)) return
    if (Thread.currentThread() === Looper.getMainLooper().thread) {
        showToast(context, text, Toast.LENGTH_SHORT)
    } else {
        Handler(context.mainLooper).post { showToast(context, text, Toast.LENGTH_SHORT) }
    }
}

private fun showToast(context: Context? = MyApp.mContext, text: String?, duration: Int) {
    if (TextUtils.isEmpty(text)) return
    cancelToast()
    if (mToast == null) {
        mToast = Toast.makeText(context, null as CharSequence?, duration)
    }
    mToast?.apply {
        setText(text)
        this.duration = duration
        show()
    }
}

fun cancelToast() {
    mToast?.cancel()
}