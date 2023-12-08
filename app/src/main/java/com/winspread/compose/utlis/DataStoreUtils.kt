package com.winspread.compose.utlis

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import java.io.IOException


/**
 *Author: Amin
 *Data: 2022/4/21 15:38
 *
 *Description:  DataStore 工具类
 *
 *
 * 异步获取数据
 * [getData] [readBooleanFlow] [readFloatFlow] [readIntFlow] [readLongFlow] [readStringFlow]
 * 同步获取数据
 * [getSyncData] [readBooleanData] [readFloatData] [readIntData] [readLongData] [readStringData]
 *
 * 异步写入数据
 * [putData]
 * 同步写入数据
 * [putSyncData]
 *
 * 异步清除数据
 * [clear]
 * 同步清除数据
 * [clearSync]
 *
 *
 */
object DataStoreUtils {

    private const val DATASTORE_PREFERENCE_NAME = "DataStore"

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATASTORE_PREFERENCE_NAME)

    private lateinit var dataStore: DataStore<Preferences>


    /**
     * init Context
     * @param context Context
     */
    fun init(context: Context) {
        dataStore = context.dataStore
    }


    /**
     *
     *同步获取数据(堵塞获取)
     *
     * @param key String
     * @param default U
     * @return U
     */
    @JvmStatic
    fun <U> getSyncData(key: String, default: U): U {
        val data = when (default) {
            is Long -> readLongData(key, default)
            is String -> readStringData(key, default)
            is Int -> readIntData(key, default)
            is Boolean -> readBooleanData(key, default)
            is Float -> readFloatData(key, default)
            else -> throw IllegalArgumentException("This type can be saved into DataStore")
        }
        return data as U
    }


    /**
     * 异步获取数据（可能报错 io错误）
     *
     * @param key String
     * @param default U
     * @return Flow<U>
     */
    @JvmStatic
    fun <U> getData(key: String, default: U): Flow<U> {
        val data = when (default) {
            is Long -> readLongFlow(key, default)
            is String -> readStringFlow(key, default)
            is Int -> readIntFlow(key, default)
            is Boolean -> readBooleanFlow(key, default)
            is Float -> readFloatFlow(key, default)
            else -> throw IllegalArgumentException("This type can be saved into DataStore")
        }
        return data as Flow<U>
    }

    /**
     * 异步保存数据
     *
     * @param key String
     * @param value U
     */
    @JvmStatic
    suspend fun <U> putData(key: String, value: U) {
        dataStore.edit {
            when (value) {
                is Long -> {
                    it[longPreferencesKey(key)] = value
                }
                is String -> {
                    it[stringPreferencesKey(key)] = value
                }
                is Int -> {
                    it[intPreferencesKey(key)] = value
                }
                is Boolean -> {
                    it[booleanPreferencesKey(key)] = value

                }
                is Float -> {
                    it[floatPreferencesKey(key)] = value
                }
                else -> throw IllegalArgumentException("This type can be saved into DataStore")
            }
        }
    }

    /**
     * 同步保存数据
     *
     * @param key String
     * @param value U
     */
    @JvmStatic
    fun <U> putSyncData(key: String, value: U) {
        runBlocking {
            putData(key, value)
        }

    }


    private fun readFloatFlow(key: String, default: Float): Flow<Float> = dataStore.data.catch {
        if (it is IOException) {
            it.printStackTrace()
            emit(emptyPreferences())
        } else {
            throw  it
        }
    }.map {
        it[floatPreferencesKey(key)] ?: default
    }

    private fun readBooleanFlow(key: String, default: Boolean): Flow<Boolean> = dataStore.data.catch {
        if (it is IOException) {
            it.printStackTrace()
            emit(emptyPreferences())
        } else
            throw  it

    }.map {
        it[booleanPreferencesKey(key)] ?: default
    }

    private fun readIntFlow(key: String, default: Int): Flow<Int> = dataStore.data.catch {
        if (it is IOException) {
            it.printStackTrace()
            emit(emptyPreferences())
        } else {
            throw  it
        }
    }.map {
        it[intPreferencesKey(key)] ?: default
    }

    private fun readStringFlow(key: String, default: String): Flow<String> = dataStore.data.catch {
        if (it is IOException) {
            it.printStackTrace()
            emit(emptyPreferences())
        } else {
            throw it
        }
    }.map {
        it[stringPreferencesKey(key)] ?: default
    }

    private fun readLongFlow(key: String, default: Long): Flow<Long> = dataStore.data.catch {
        if (it is IOException) {
            it.printStackTrace()
            emit(emptyPreferences())
        } else {
            throw  it
        }
    }.map {
        it[longPreferencesKey(key)] ?: default
    }


    private fun readFloatData(key: String, default: Float): Float {
        var value = 0f
        runBlocking {
            dataStore.data.first {
                value = it[floatPreferencesKey(key)] ?: default
                true
            }
        }
        return value
    }

    private fun readBooleanData(key: String, default: Boolean): Boolean {
        var value = false
        runBlocking {
            dataStore.data.first {
                value = it[booleanPreferencesKey(key)] ?: default
                true
            }
        }
        return value

    }


    private fun readIntData(key: String, default: Int): Int {
        var value = 0
        runBlocking {
            dataStore.data.first {
                value = it[intPreferencesKey(key)] ?: default
                true
            }
        }
        return value
    }

    private fun readStringData(key: String, default: String): String {
        var value = ""
        runBlocking {
            dataStore.data.first {
                value = it[stringPreferencesKey(key)] ?: default
                true
            }
        }
        return value
    }

    private fun readLongData(key: String, default: Long): Long {
        var value = 0L
        runBlocking {
            dataStore.data.first {
                value = it[longPreferencesKey(key)] ?: default
                true
            }
        }
        return value
    }

    /**
     * 异步清除数据
     */
    @JvmStatic
    suspend fun clear() {
        dataStore.edit {
           it.clear()
        }
    }

    /**
     * 同步清除数据
     */
    @JvmStatic
    fun clearSync(){
        runBlocking {
            clear()
        }
    }





}