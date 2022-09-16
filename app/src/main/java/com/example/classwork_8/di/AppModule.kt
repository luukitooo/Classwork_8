package com.example.classwork_8.di

import android.content.Context
import com.example.classwork_8.common.constants.OutfitsApiUtil
import com.example.classwork_8.data.remote.api.OutfitsApi
import com.example.classwork_8.data.remote.client.OkHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(OutfitsApiUtil.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.getInstance(context))
            .build()
    }

    @Provides
    @Singleton
    fun provideOutfitsApi(retrofit: Retrofit): OutfitsApi {
        return retrofit.create(OutfitsApi::class.java)
    }

}