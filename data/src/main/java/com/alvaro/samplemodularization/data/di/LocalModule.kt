package com.alvaro.samplemodularization.data.di

import android.content.Context
import androidx.room.Room
import com.alvaro.samplemodularization.data.datasource.local.SampleModularizationDatabase
import com.alvaro.samplemodularization.data.datasource.local.daos.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): SampleModularizationDatabase =
        Room.databaseBuilder(
            context,
            SampleModularizationDatabase::class.java,
            "database-sample"
        )
            .build()

    @Provides
    fun providesCharacterDAO(database: SampleModularizationDatabase): CharacterDao = database.characterDAO()
}