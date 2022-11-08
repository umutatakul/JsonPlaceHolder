package com.umutatakul.jsonplaceholder.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.umutatakul.jsonplaceholder.API.ApiInterface
import com.umutatakul.jsonplaceholder.Constants.Constants
import com.umutatakul.jsonplaceholder.ModelItems.PostsModelItem
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.RecyclerAdapters.RecyclerAdapterPosts
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import kotlinx.android.synthetic.main.activity_posts.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsActivity : AppCompatActivity() {

    lateinit var recyclerAdapterPosts: RecyclerAdapterPosts
    //lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        recyclerViewPosts.setHasFixedSize(true)
        //linearLayoutManager = LinearLayoutManager(this)
        //recyclerViewPosts.layoutManager = linearLayoutManager

        getPostsData ()
    }
    fun getPostsData(){
        val retrofitBuilder = SingletonClass.retrofitBuilderTemplate

        val retrofitData = retrofitBuilder.getPostDataFromWS(SingletonClass.gonderilenUsersId.toString())

        retrofitData.enqueue(object : Callback<List<PostsModelItem>?> {
            override fun onResponse(
                call: Call<List<PostsModelItem>?>,
                response: Response<List<PostsModelItem>?>
            ) {
                val responseBody = response.body()!!

                recyclerAdapterPosts = RecyclerAdapterPosts(baseContext,responseBody)
                recyclerAdapterPosts.notifyDataSetChanged()
                recyclerViewPosts.adapter = recyclerAdapterPosts
            }


            override fun onFailure(call: Call<List<PostsModelItem>?>, t: Throwable) {

            }
        })


    }
}