package com.umutatakul.jsonplaceholder.Hilt

import android.widget.ImageView
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ImageLoaderModule {
    @Provides
    fun providesImageLoader():Picasso{
        return Picasso.get()

    }
}

