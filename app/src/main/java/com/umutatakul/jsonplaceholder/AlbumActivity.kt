package com.umutatakul.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_album.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class AlbumActivity : AppCompatActivity()  {

    lateinit var  recyclerAdapterAlbums:RecyclerAdapterAlbums
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        recyclerView_albums.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView_albums.layoutManager = linearLayoutManager

        getDataAlbums()
        
        
        

    }

    fun getDataAlbums() {
        var selectedUserId = SingletonClass.gonderilenUsersId.toString()
        var albumsUserId = selectedUserId



        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(ApiInterface::class.java)


        val retrofitData = retrofitBuilder.getAlbumsDataFromWS(albumsUserId) //.getWhichDataFromWS(give the path of user ID or etc.)

        //retrofitData.enqueue () yazdıktan sonra ctrl+shift+space ile çağırdım
        retrofitData.enqueue(object : Callback<List<AlbumsModelItem>?> {
            override fun onResponse(
                call: Call<List<AlbumsModelItem>?>,
                response: Response<List<AlbumsModelItem>?>
            ) {
                val responseBody = response.body()!!

                recyclerAdapterAlbums = RecyclerAdapterAlbums(baseContext,responseBody)
                recyclerAdapterAlbums.notifyDataSetChanged()
                recyclerView_albums.adapter = recyclerAdapterAlbums
            }

            override fun onFailure(call: Call<List<AlbumsModelItem>?>, t: Throwable) {
            }


        })
    }
}

