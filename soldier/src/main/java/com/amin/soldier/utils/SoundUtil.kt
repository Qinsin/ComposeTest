package com.amin.soldier.utils

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Build
import android.util.Log
import android.util.SparseIntArray
import androidx.annotation.RequiresApi
import com.amin.soldier.R
import com.amin.soldier.config.VOICE_STATE

class SoundUtil {
    lateinit var mContext: Context

    companion object {
        val instance: SoundUtil by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SoundUtil()
        }
    }

    private var sp: SoundPool? = null
    var soundIdMap: SparseIntArray? = null

    private var mp: MediaPlayer? = null

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    fun init(context: Context) {
        mContext = context
        val sb = SoundPool.Builder()
        sb.setMaxStreams(10)
        val audioAttributesBuilder = AudioAttributes.Builder()
        audioAttributesBuilder.setLegacyStreamType(AudioManager.STREAM_MUSIC)
        val aa = audioAttributesBuilder.build()
        sb.setAudioAttributes(aa)
        sp = sb.build()
        soundIdMap = SparseIntArray()
        for (i in soundResArray.indices) {
            soundIdMap!!.put(i, -1)
        }
        mp = MediaPlayer()
        mp!!.setVolume(1f, 1f)
    }

    private var isLoading = false

    @Synchronized
    fun play(soundPos: Int) {
        if (!DataStoreUtils.getSyncData(VOICE_STATE,false)) {
            return
        }
        Log.d("play", "sound:::$soundPos")
        if (sp != null) {
            val soundId = soundIdMap!![soundPos]
            if (soundId == -1) {
                if (!isLoading) {
                    isLoading = true
                    val id = sp!!.load(mContext, soundResArray[soundPos], 1)
                    sp!!.setOnLoadCompleteListener { soundPool, sampleId, status ->
                        isLoading = false
                        sp!!.play(id, 1f, 1f, 1, 0, 1f)
                        soundIdMap!!.put(soundPos, id)
                    }
                }
            } else {
                sp!!.play(soundId, 1f, 1f, 1, 0, 1f)
            }
        }
    }

    @Synchronized
    fun playValue(soundPos: Int) {
        if (!DataStoreUtils.getSyncData(VOICE_STATE,false)) {
            return
        }
        Log.d("", "sound:::$soundPos")
        if (mp!!.isPlaying) {
            return
        }
        val file: AssetFileDescriptor = mContext.getResources().openRawResourceFd(
            soundResArray[soundPos]
        )
        try {
            mp!!.setDataSource(
                file.fileDescriptor, file.startOffset,
                file.length
            )
            file.close()
            mp!!.prepare()
            mp!!.start()
            mp!!.setOnCompletionListener { mp -> mp.reset() }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun release() {
        if (sp != null) {
            sp!!.release()
            sp = null
        }
        if (mp != null) {
            mp!!.release()
            mp = null
        }
    }

    private val soundResArray = intArrayOf(
        R.raw.raw_000,
        R.raw.raw_001,
        R.raw.raw_002,
        R.raw.raw_003,
        R.raw.raw_004,
        R.raw.raw_005,
        R.raw.raw_006,
        R.raw.raw_007,
        R.raw.raw_008,
        R.raw.raw_009,
        R.raw.raw_010,
        R.raw.raw_011,
        R.raw.raw_012,
        R.raw.raw_013,
        R.raw.raw_014,
        R.raw.raw_015,
        R.raw.raw_016,
        R.raw.raw_017,
        R.raw.raw_018,
        R.raw.raw_019,
        R.raw.raw_020,
        R.raw.raw_021,
        R.raw.raw_022,
        R.raw.raw_023,
        R.raw.raw_024,
        R.raw.raw_025,
        R.raw.raw_026,
        R.raw.raw_027,
        R.raw.raw_028,
        R.raw.raw_029,
        R.raw.raw_030,
        R.raw.raw_031,
        R.raw.raw_032,
        R.raw.raw_033,
        R.raw.raw_034,
        R.raw.raw_035,
        R.raw.raw_036,
        R.raw.raw_037,
        R.raw.raw_038,
        R.raw.raw_039,
        R.raw.raw_040,
        R.raw.raw_041,
        R.raw.raw_042,
        R.raw.raw_043,
        R.raw.raw_044,
        R.raw.raw_045,
        R.raw.raw_046,
        R.raw.raw_047,
        R.raw.raw_048,
        R.raw.raw_049,
        R.raw.raw_050,
        R.raw.raw_051,
        R.raw.raw_052,
        R.raw.raw_053,
        R.raw.raw_054,
        R.raw.raw_055,
        R.raw.raw_056,
        R.raw.raw_057,
        R.raw.raw_058,
        R.raw.raw_059,
        R.raw.raw_060,
        R.raw.raw_061,
        R.raw.raw_062,
        R.raw.raw_063,
        R.raw.raw_064,
        R.raw.raw_065,
        R.raw.raw_066,
        R.raw.raw_067,
        R.raw.raw_068,
        R.raw.raw_069,
        R.raw.raw_070,
        R.raw.raw_071,
        R.raw.raw_072,
        R.raw.raw_073,
        R.raw.raw_074,
        R.raw.raw_075,
        R.raw.raw_076,
        R.raw.raw_077,
        R.raw.raw_078,
        R.raw.raw_079,
        R.raw.raw_080,
        R.raw.raw_081,
        R.raw.raw_082,
        R.raw.raw_083,
        R.raw.raw_084,
        R.raw.raw_085,
        R.raw.raw_086,
        R.raw.raw_087,
        R.raw.raw_088,
        R.raw.raw_089,
        R.raw.raw_090,
        R.raw.raw_091,
        R.raw.raw_092,
        R.raw.raw_093,
        R.raw.raw_094,
        R.raw.raw_095,
        R.raw.raw_096,
        R.raw.raw_097,
        R.raw.raw_098,
        R.raw.raw_099,
        R.raw.raw_100,
        R.raw.raw_101,
        R.raw.raw_102,
        R.raw.raw_103,
        R.raw.raw_104,
        R.raw.raw_105,
        R.raw.raw_106,
        R.raw.raw_107,
        R.raw.raw_108,
        R.raw.raw_109,
        R.raw.raw_110,
        R.raw.raw_111,
        R.raw.raw_112,
        R.raw.raw_113,
        R.raw.raw_114,
        R.raw.raw_115,
        R.raw.raw_116,
        R.raw.raw_117,
        R.raw.raw_118,
        R.raw.raw_119,
        R.raw.raw_120,
        R.raw.raw_121,
        R.raw.raw_122,
        R.raw.raw_123,
        R.raw.raw_124,
        R.raw.raw_125,
        R.raw.raw_126,
        R.raw.raw_127,
        R.raw.raw_128,
        R.raw.raw_129,
        R.raw.raw_130,
        R.raw.raw_131,
        R.raw.raw_132,
        R.raw.raw_133,
        R.raw.raw_134,
        R.raw.raw_135,
        R.raw.raw_136,
        R.raw.raw_137,
        R.raw.raw_138,
        R.raw.raw_139,
        R.raw.raw_140,
        R.raw.raw_141,
        R.raw.raw_142,
        R.raw.raw_143,
        R.raw.raw_144,
        R.raw.raw_145,
        R.raw.raw_146,
        R.raw.raw_147,
        R.raw.raw_148,
        R.raw.raw_149,
        R.raw.raw_150,
        R.raw.raw_151,
        R.raw.raw_152,
        R.raw.raw_153,
        R.raw.raw_154,
        R.raw.raw_155,
        R.raw.raw_156,
        R.raw.raw_157,
        R.raw.raw_158,
        R.raw.raw_159,
        R.raw.raw_160,
        R.raw.raw_161,
        R.raw.raw_162,
        R.raw.raw_163,
        R.raw.raw_164,
        R.raw.raw_165,
        R.raw.raw_166,
        R.raw.raw_167,
        R.raw.raw_168,
        R.raw.raw_169,
        R.raw.raw_170,
        R.raw.raw_171,
        R.raw.raw_172,
        R.raw.raw_173,
        R.raw.raw_174,
        R.raw.raw_175,
        R.raw.raw_176,
        R.raw.raw_177,
        R.raw.raw_178,
        R.raw.raw_179,
        R.raw.raw_180,
        R.raw.raw_181,
        R.raw.raw_182,
        R.raw.raw_183,
        R.raw.raw_184,
        R.raw.raw_185,
        R.raw.raw_186,
        R.raw.raw_187,
        R.raw.raw_188,
        R.raw.raw_189,
        R.raw.raw_190,
        R.raw.raw_191,
        R.raw.raw_192,
        R.raw.raw_193,
        R.raw.raw_194,
        R.raw.raw_195,
        R.raw.raw_196,
        R.raw.raw_197,
        R.raw.raw_198,
        R.raw.raw_199,
        R.raw.raw_200,
        R.raw.raw_201,
        R.raw.raw_202,
        R.raw.raw_203,
        R.raw.raw_204,
        R.raw.raw_205,
        R.raw.raw_206,
        R.raw.raw_207,
        R.raw.raw_208,
        R.raw.raw_209,
        R.raw.raw_210,
        R.raw.raw_211,
        R.raw.raw_212,
        R.raw.raw_213,
        R.raw.raw_214,
        R.raw.raw_215,
        R.raw.raw_216,
        R.raw.raw_217,
        R.raw.raw_218,
        R.raw.raw_219,
        R.raw.raw_220,
        R.raw.raw_221,
        R.raw.raw_222,
        R.raw.raw_223,
        R.raw.raw_224,
        R.raw.raw_225,
        R.raw.raw_226,
        R.raw.raw_227,
        R.raw.raw_228,
        R.raw.raw_229,
        R.raw.raw_230,
        R.raw.raw_231,
        R.raw.raw_232,
        R.raw.raw_233,
        R.raw.raw_234,
        R.raw.raw_235,
        R.raw.raw_236,
        R.raw.raw_237,
        R.raw.raw_238,
        R.raw.raw_239,
        R.raw.raw_240,
        R.raw.raw_241,
        R.raw.raw_242,
        R.raw.raw_243,
        R.raw.raw_244,
        R.raw.raw_245,
        R.raw.raw_246,
        R.raw.raw_247,
        R.raw.raw_248,
        R.raw.raw_249,
        R.raw.raw_250,
        R.raw.raw_251,
        R.raw.raw_252,
        R.raw.raw_253,
        R.raw.raw_254,
        R.raw.raw_255,
        R.raw.raw_tuo_biao,
        R.raw.jin_ru_mu_biao_xiao_qu,
        R.raw.li_kai_mu_biao_xiao_qu


    )

}