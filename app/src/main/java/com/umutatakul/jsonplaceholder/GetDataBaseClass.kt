package com.umutatakul.jsonplaceholder

import com.umutatakul.jsonplaceholder.API.ApiInterface
import com.umutatakul.jsonplaceholder.ModelItems.AlbumsModelItem
import com.umutatakul.jsonplaceholder.Constants.Constants
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

open class GetDataBaseClass (){
    open fun getData(){
        var selectedUserId = SingletonClass.gonderilenUsersId.toString()
        var SelectedItemModel: AlbumsModelItem
        var albumsUserId = selectedUserId



        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.baseUrl)
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

                val stringBuilder = StringBuilder()

                for (myData in responseBody){
                    stringBuilder.append(myData.id)
                    stringBuilder.append("\n")
                }
            }

            override fun onFailure(call: Call<List<AlbumsModelItem>?>, t: Throwable) {

            }

        }



        )





    }


}