package com.secondworld.clickernew.di

import android.content.Context
import androidx.room.Room
import com.secondworld.clickernew.animations.Animators
import com.secondworld.clickernew.data.repository.Repository
import com.secondworld.clickernew.data.room.AppDatabase
import com.secondworld.clickernew.domain.DamageCase
import com.secondworld.clickernew.domain.DamagePriceCase
import com.secondworld.clickernew.domain.EnemyCase
import com.secondworld.clickernew.domain.ScoreCase
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

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app.db").build()

    @Provides
    @Singleton
    fun provideWeaponDao(appDatabase : AppDatabase) = appDatabase.weaponDao()

    @Provides
    @Singleton
    fun provideEnemyCase() = EnemyCase()

    @Provides
    @Singleton
    fun provideScoreCase() = ScoreCase()

    @Provides
    @Singleton
    fun provideDamagePriceCase(repository: Repository) = DamagePriceCase(repository)

    @Provides
    @Singleton
    fun provideDamageCase(repository: Repository, @ApplicationContext context: Context, animators: Animators) =
        DamageCase(repository, context, animators)
}