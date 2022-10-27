package com.umutatakul.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_photos_detail.*

class PhotosDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos_detail)

        Picasso.get().load(SingletonClass.gonderilenPhotoUrl).into(photosDetailImageId)


    }
}