package com.alvaro.samplemodularization.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alvaro.samplemodularization.data.datasource.local.daos.CharacterDao
import com.alvaro.samplemodularization.data.datasource.local.models.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class SampleModularizationDatabase : RoomDatabase() {
    abstract fun characterDAO(): CharacterDao
}