package com.umutatakul.jsonplaceholder.Hilt

import com.umutatakul.jsonplaceholder.API.ApiInterface
import com.umutatakul.jsonplaceholder.Constants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.baseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun ProvideService(retrofit: Retrofit):ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }


}