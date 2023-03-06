package com.example.beer.di

import android.content.Context
import com.example.beer.data.network.api.BeerAPI
import com.example.beer.data.network.repo.BeerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import com.example.beer.BuildConfig
import com.example.beer.usecase.GetBeerUseCase

@Module
@InstallIn(SingletonComponent::class)
object BeerModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    fun provideBeerAPI(retrofit: Retrofit): BeerAPI = retrofit.create(BeerAPI::class.java)

    @Singleton
    @Provides
    fun providesBeerDataRepository(api: BeerAPI) = BeerRepository(api)

    @Singleton
    @Provides
    fun providesGetBeerUseCase(repository: BeerRepository) = GetBeerUseCase(repository)

}