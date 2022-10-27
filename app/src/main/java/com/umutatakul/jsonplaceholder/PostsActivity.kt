package com.umutatakul.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_posts.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsActivity : AppCompatActivity() {

    lateinit var recyclerAdapterPosts: RecyclerAdapterPosts
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        recyclerViewPosts.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerViewPosts.layoutManager = linearLayoutManager

        getPostsData ()
    }
    fun getPostsData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(ApiInterface::class.java)

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