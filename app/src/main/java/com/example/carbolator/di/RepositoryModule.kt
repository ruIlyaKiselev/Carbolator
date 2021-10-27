package com.example.carbolator.di

import com.example.carbolator.repository.CarbolatorRepository
import com.example.carbolator.repository.CarbolatorRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCarbolatorRepository(
//        carbolatorService: CarbolatorService
    ): CarbolatorRepository {
        return CarbolatorRepositoryImpl()
    }
}