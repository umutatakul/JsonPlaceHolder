package com.umutatakul.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_comments.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommentsActivity : AppCompatActivity() {

    lateinit var recyclerAdapterComments: RecyclerAdapterComments
    lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        recyclerViewComments.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerViewComments.layoutManager = linearLayoutManager

        getCommentsData ()
    }

    fun getCommentsData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getCommentsDataFromWS(SingletonClass.gonderilenPostsId.toString())

        retrofitData.enqueue(object : Callback<List<CommentsModelItem>?> {
            override fun onResponse(
                call: Call<List<CommentsModelItem>?>,
                response: Response<List<CommentsModelItem>?>
            ) {
                val responseBody = response.body()

                recyclerAdapterComments = RecyclerAdapterComments(baseContext,responseBody!!)
                recyclerAdapterComments.notifyDataSetChanged()
                recyclerViewComments.adapter = recyclerAdapterComments






            }

            override fun onFailure(call: Call<List<CommentsModelItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}