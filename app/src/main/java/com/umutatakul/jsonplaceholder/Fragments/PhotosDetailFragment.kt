package com.umutatakul.jsonplaceholder.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.umutatakul.jsonplaceholder.ImageLoaderClass
import com.umutatakul.jsonplaceholder.ImageLoaderHiltClass
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_photos_detail.*
import javax.inject.Inject

@AndroidEntryPoint
class PhotosDetailFragment : Fragment() {

    @Inject
    lateinit var imageLoader: ImageLoaderHiltClass



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Picasso.get().load(SingletonClass.gonderilenPhotoUrl).into(photosDetailImageId)
        //var imageLoader = ImageLoaderClass()
        SingletonClass.gonderilenPhotoUrl?.let {
            imageLoader.imageLoader(it,photosDetailImageId)
        }


        //imageLoader.imageLoader(SingletonClass.gonderilenPhotoUrl!!,photosDetailImageId)

    }

}