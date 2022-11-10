package com.umutatakul.jsonplaceholder.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umutatakul.jsonplaceholder.ModelItems.PhotosModelItem
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.RecyclerAdapters.RecyclerAdapterPhotos
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import kotlinx.android.synthetic.main.activity_photos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PhotosFragment : Fragment() {
    lateinit var recyclerAdapterPhotos: RecyclerAdapterPhotos


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewPhotos.setHasFixedSize(true)
        getPhotosData()
    }
    fun getPhotosData(){
        val retrofitBuilder = SingletonClass.retrofitBuilderTemplate

        val retrofitData = retrofitBuilder.getPhotosDataFromWS(SingletonClass.gonderilenAlbumId.toString())


        retrofitData.enqueue(object : Callback<List<PhotosModelItem>?> {
            override fun onResponse(
                call: Call<List<PhotosModelItem>?>,
                response: Response<List<PhotosModelItem>?>
            ) {
                val responseBody = response.body()!!

                recyclerAdapterPhotos = RecyclerAdapterPhotos(requireContext(),responseBody)
                recyclerAdapterPhotos.notifyDataSetChanged()
                recyclerViewPhotos.adapter = recyclerAdapterPhotos


            }

            override fun onFailure(call: Call<List<PhotosModelItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


}