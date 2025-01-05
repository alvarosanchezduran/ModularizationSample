package com.alvaro.samplemodularization.core.di.modules

import com.alvaro.samplemodularization.core.di.navigation.Navigator
import com.alvaro.samplemodularization.core.di.navigation.NavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun provideNavigator(): Navigator = NavigatorImpl()
}