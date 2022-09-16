package com.example.classwork_8.di

import com.example.classwork_8.data.repository.OutfitsRepositoryImpl
import com.example.classwork_8.domain.repository.OutfitsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindOutfitsRepositoryImpl(
        outfitsRepositoryImpl: OutfitsRepositoryImpl
    ) : OutfitsRepository

}