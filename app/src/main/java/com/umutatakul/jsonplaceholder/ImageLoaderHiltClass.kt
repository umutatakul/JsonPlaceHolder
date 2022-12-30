package com.umutatakul.jsonplaceholder

import android.widget.ImageView
import com.squareup.picasso.Picasso
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
class ImageLoaderHiltClass
@Inject constructor(private val picasso: Picasso )
{
    fun imageLoader(imageUrl:String,photoVH:ImageView){
        picasso.load(imageUrl).into(photoVH)
    }
}

