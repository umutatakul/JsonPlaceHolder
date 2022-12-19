package com.umutatakul.jsonplaceholder

import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageLoaderClass {

    //Picasso.get().load(photoList[position].thumbnailUrl).into(holder.photosThumbnailVH)
    //Photo Url : String , holder.photosThumbnail:ImageView
    fun imageLoader( photoUri : String ,  photoVH: ImageView){
        Picasso.get()
            .load(photoUri)
            .into(photoVH)
    }
}