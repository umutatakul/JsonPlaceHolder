package com.umutatakul.jsonplaceholder.API

import com.umutatakul.jsonplaceholder.ModelItems.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/users")
    fun getUserDataFromWS():Call<List<UsersModelItem>>


    /*@GET("/todos?userId={userId}")
    fun getData2 (@Path("userId")userId:String)
    :Call<List<TodosModelItem>>*/

    @GET("/users/{userId}/todos")
    fun getTodosDataFromWS(@Path("userId")userId:String):Call<List<TodosModelItem>>

    @GET("users/{userId}/albums")
    fun getAlbumsDataFromWS(@Path("userId")userId:String):Call<List<AlbumsModelItem>>

    @GET("albums/{albumId}/photos")
    fun getPhotosDataFromWS(@Path("albumId")albumId:String):Call<List<PhotosModelItem>>

    @GET("/user/{userId}/posts")
    fun getPostDataFromWS(@Path("userId")userId:String):Call<List<PostsModelItem>>

    @GET("/posts/{postId}/comments")
    fun getCommentsDataFromWS(@Path("postId")postId:String):Call<List<CommentsModelItem>>
}