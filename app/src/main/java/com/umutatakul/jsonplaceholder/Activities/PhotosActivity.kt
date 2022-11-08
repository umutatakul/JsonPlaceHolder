package com.umutatakul.jsonplaceholder.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.umutatakul.jsonplaceholder.API.ApiInterface
import com.umutatakul.jsonplaceholder.Constants.Constants
import com.umutatakul.jsonplaceholder.ModelItems.PhotosModelItem
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.RecyclerAdapters.RecyclerAdapterPhotos
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import kotlinx.android.synthetic.main.activity_photos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotosActivity : AppCompatActivity() {

    //lateinit var recyclerAdapterPhotos: RecyclerAdapterPhotos
    //lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        //recyclerViewPhotos.setHasFixedSize(true)
        //linearLayoutManager = LinearLayoutManager(this)

        //recyclerViewPhotos.layoutManager = linearLayoutManager

        //getPhotosData()
    }

    /*fun getPhotosData(){
        val retrofitBuilder = SingletonClass.retrofitBuilderTemplate

        val retrofitData = retrofitBuilder.getPhotosDataFromWS(SingletonClass.gonderilenAlbumId.toString())


        retrofitData.enqueue(object : Callback<List<PhotosModelItem>?> {
            override fun onResponse(
                call: Call<List<PhotosModelItem>?>,
                response: Response<List<PhotosModelItem>?>
            ) {
                val responseBody = response.body()!!

                recyclerAdapterPhotos = RecyclerAdapterPhotos(baseContext,responseBody)
                recyclerAdapterPhotos.notifyDataSetChanged()
                recyclerViewPhotos.adapter = recyclerAdapterPhotos


            }

            override fun onFailure(call: Call<List<PhotosModelItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

     */
}