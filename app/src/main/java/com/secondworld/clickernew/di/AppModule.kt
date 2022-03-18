package com.secondworld.clickernew.di

import android.content.Context
import com.secondworld.clickernew.animations.Animators
import com.secondworld.clickernew.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepository(@ApplicationContext context: Context) = Repository(context)

    @Singleton
    @Provides
    fun provideAnimators(@ApplicationContext context: Context) = Animators(context)
}