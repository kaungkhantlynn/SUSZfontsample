package com.susz.dojoartisan.suszfontsample.utils

import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.content.res.AssetManager
import android.graphics.Typeface
import android.util.LruCache

public class TypefaceManager {

    companion object {
        val PYIDAUNGSU = "pyidaungsu.ttf"
        val ZAWGYIONE = "zawgyi_one.ttf"
    }

    lateinit var manager : AssetManager
    lateinit var am : ActivityManager
    lateinit var mCache : LruCache<String,Typeface>

    constructor(manager : AssetManager, context : Context){
        this.manager = manager
        am = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val availMemInBytes = am.memoryClass * 1024 * 1024
        mCache = LruCache(availMemInBytes / 8)

    }


    fun getTypeface(filename: String): Typeface {
        var typeface: Typeface? = mCache.get(filename)
        if (typeface == null) {
            typeface = Typeface.createFromAsset(manager, filename)
        }
        return typeface!!
    }

    fun getUni(): Typeface {
        return getTypeface(PYIDAUNGSU)
    }

    fun getZgyi(): Typeface {
        return getTypeface(ZAWGYIONE)
    }

}