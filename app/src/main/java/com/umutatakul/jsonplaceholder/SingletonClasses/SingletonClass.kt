package com.umutatakul.jsonplaceholder.SingletonClasses

import com.umutatakul.jsonplaceholder.API.ApiInterface
import com.umutatakul.jsonplaceholder.Constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SingletonClass {
    companion object SecilenIdBilgiler{
        var gonderilenUsersId: Int? = null
        var gonderilenUserName : String? = null
        var gonderilenAlbumId: Int? = null
        var gonderilenPhotoUrl : String? =null
        var gonderilenPostsId : String? = null

        var retrofitBuilderTemplate = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.baseUrl)
            .build()
            .create(ApiInterface::class.java)
    }
}