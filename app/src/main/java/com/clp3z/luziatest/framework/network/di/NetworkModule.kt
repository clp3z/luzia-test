package com.clp3z.network.di

import com.clp3z.luziatest.framework.network.datasource.RemotePlanetsDataSource
import com.clp3z.luziatest.framework.network.datasource.RemotePlanetsDataSourceImpl
import com.clp3z.luziatest.framework.network.service.PlanetsService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val APPLICATION_JSON = "application/json"
    private const val HOST = "https://swapi.dev"

    @Provides
    @Singleton
    fun provideJsonSerializer(): Json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideHttpInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        json: Json,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory(APPLICATION_JSON.toMediaType()))
            .baseUrl(HOST)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun providePlanetsService(retrofit: Retrofit): PlanetsService =
        retrofit.create<PlanetsService>()

    @Provides
    @Singleton
    fun provideRemoteDataSource(planetsService: PlanetsService): RemotePlanetsDataSource =
        RemotePlanetsDataSourceImpl(planetsService)
}