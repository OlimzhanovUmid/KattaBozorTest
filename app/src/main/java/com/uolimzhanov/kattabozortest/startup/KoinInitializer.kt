package com.uolimzhanov.kattabozortest.startup

import android.content.Context
import androidx.startup.Initializer
import com.uolimzhanov.kattabozortest.BuildConfig
import com.uolimzhanov.kattabozortest.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by uolimzhanov on 21.06.2024
 */
class KoinInitializer : Initializer<Any> {

    override fun create(context: Context): Any {
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.NONE)
            androidContext(context)
            modules(appModule)
        }

        return Any()
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}