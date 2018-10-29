package com.susz.dojoartisan.suszfontsample

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import me.myatminsoe.mdetect.MDetect
import me.myatminsoe.mdetect.Rabbit

class MainActivity : AppCompatActivity() {


    lateinit var typeface: Typeface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        if (MDetect.isUnicode()) run {
            this.typeface = MainApplication.typefaceManager.getUni()
            txt.text = getString(R.string.sample_text)
            txt.typeface = typeface

            txt_2.text = "တစ်ခါတစ်လေ ကြံမယ် အကောင်း၊ အဆိုးလည်းတွေ့ရမယ် ၊ အလိုက်အထိုက်ပေါ့လေ"
            txt_2.typeface =typeface

        } else run {
            this.typeface = MainApplication.typefaceManager.getZgyi()
            txt.text = Rabbit.uni2zg(getString(R.string.sample_text))
            txt.typeface = typeface

            txt_2.text = Rabbit.uni2zg("တစ်ခါတစ်လေ ကြံမယ် အကောင်း၊ အဆိုးလည်းတွေ့ရမယ် ၊ အလိုက်အထိုက်ပေါ့လေ")
            txt_2.typeface = typeface


        }
    }
}
