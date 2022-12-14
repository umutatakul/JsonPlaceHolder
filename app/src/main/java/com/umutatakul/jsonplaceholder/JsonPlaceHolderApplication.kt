package com.umutatakul.jsonplaceholder

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JsonPlaceHolderApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Boş kalsada bir appliaction dosyası oluştur başlatmak için
        //Bu Hiltin tetiklenmesini sağlar
    }
}