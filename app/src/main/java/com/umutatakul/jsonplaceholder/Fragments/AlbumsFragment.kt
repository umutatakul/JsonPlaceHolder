package com.umutatakul.jsonplaceholder.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umutatakul.jsonplaceholder.ModelItems.AlbumsModelItem
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.RecyclerAdapters.RecyclerAdapterAlbums
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import kotlinx.android.synthetic.main.activity_album.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AlbumsFragment : Fragment() {
    lateinit var  recyclerAdapterAlbums: RecyclerAdapterAlbums


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_albums.setHasFixedSize(true)
        getDataAlbums()
    }
    fun getDataAlbums() {
        var selectedUserId = SingletonClass.gonderilenUsersId.toString()
        var albumsUserId = selectedUserId



        val retrofitBuilder = SingletonClass.retrofitBuilderTemplate


        val retrofitData = retrofitBuilder.getAlbumsDataFromWS(albumsUserId) //.getWhichDataFromWS(give the path of user ID or etc.)

        //retrofitData.enqueue () yazdıktan sonra ctrl+shift+space ile çağırdım
        retrofitData.enqueue(object : Callback<List<AlbumsModelItem>?> {
            override fun onResponse(
                call: Call<List<AlbumsModelItem>?>,
                response: Response<List<AlbumsModelItem>?>
            ) {

                val responseBody = response.body()!!


                recyclerAdapterAlbums = RecyclerAdapterAlbums(requireContext(),responseBody)
                recyclerAdapterAlbums.notifyDataSetChanged()
                recyclerView_albums.adapter = recyclerAdapterAlbums
            }

            override fun onFailure(call: Call<List<AlbumsModelItem>?>, t: Throwable) {
            }


        })
    }


}