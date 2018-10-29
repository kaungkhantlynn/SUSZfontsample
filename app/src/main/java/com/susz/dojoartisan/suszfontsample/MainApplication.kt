package com.susz.dojoartisan.suszfontsample

import android.app.Application
import com.susz.dojoartisan.suszfontsample.utils.TypefaceManager
import me.myatminsoe.mdetect.MDetect

public class MainApplication : Application() {

    companion object {
        lateinit var typefaceManager: TypefaceManager
    }

    override fun onCreate() {
        super.onCreate()
        MDetect.init(this)
        typefaceManager = TypefaceManager(assets, applicationContext)
    }
}
