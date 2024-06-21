package com.uolimzhanov.kattabozortest.di

import coil3.ImageLoader
import coil3.disk.DiskCache
import coil3.disk.directory
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.uolimzhanov.kattabozortest.BuildConfig
import com.uolimzhanov.kattabozortest.model.network.OffersApiService
import com.uolimzhanov.kattabozortest.model.repository.OffersRepository
import com.uolimzhanov.kattabozortest.model.repository.OffersRepositoryImpl
import com.uolimzhanov.kattabozortest.ui.screens.OffersViewModel
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by uolimzhanov on 21.06.2024
 */
const val BASE_URL = "https://www.kattabozor.uz/hh/test/api/v1/"
val appModule = module {
    single<Json> {
        Json { ignoreUnknownKeys = true }
    }

    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addNetworkInterceptor(
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            )
            .build()
    }

    single {
        val cacheSize: Long = 1024L * 1024L * 150L // 150 MB
        DiskCache.Builder()
            .directory(get<File>(named("imageCacheDir")))
            .maxSizeBytes(cacheSize)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(get<Json>().asConverterFactory("application/json".toMediaType()))
            .build()
    }

    single<OffersApiService> {
        get<Retrofit>().create(OffersApiService::class.java)
    }

    singleOf(::OffersRepositoryImpl) { bind<OffersRepository>() }

    viewModelOf(::OffersViewModel)
}