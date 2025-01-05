package com.alvaro.samplemodularization.data.di

import com.alvaro.samplemodularization.core.common.BuildConfig
import com.alvaro.samplemodularization.data.datasource.remote.apis.StarWarsApi
import com.alvaro.samplemodularization.data.datasource.remote.characters.CharactersRemoteDataSource
import com.alvaro.samplemodularization.data.datasource.remote.characters.CharactersRemoteDataSourceImpl
import com.alvaro.samplemodularization.data.repository.CharactersRepositoryImpl
import com.alvaro.samplemodularization.domain.repositories.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): StarWarsApi {
        return retrofit.create(StarWarsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.swapi.tech/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        var client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
        return client.build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
}

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideNoteLocalDataSource(api: StarWarsApi): CharactersRemoteDataSource =
        CharactersRemoteDataSourceImpl(api)
}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharactersRepository(charactersRemoteDataSource: CharactersRemoteDataSource): CharactersRepository = CharactersRepositoryImpl(charactersRemoteDataSource)
}