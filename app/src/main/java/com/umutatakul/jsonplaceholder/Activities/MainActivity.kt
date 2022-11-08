package com.umutatakul.jsonplaceholder.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.umutatakul.jsonplaceholder.API.ApiInterface
import com.umutatakul.jsonplaceholder.Constants.Constants
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.RecyclerAdapters.RecyclerAdapterUsers
import com.umutatakul.jsonplaceholder.ModelItems.UsersModelItem
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// https://jsonplaceholder.typicode.com
// /users

//val baseUrl = "https://jsonplaceholder.typicode.com"



class MainActivity : AppCompatActivity() {

    //lateinit var  recyclerAdapterUsers: RecyclerAdapterUsers
    //lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //https://stackoverflow.com/questions/28709220/understanding-recyclerview-sethasfixedsize

        //recyclerViewUsers.setHasFixedSize(true)

        //Bunları direkt layout dosyası içinde tanımladık
        /*

        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        android:orientation="vertical"

         */

        //linearLayoutManager = LinearLayoutManager(this)
        //recyclerViewUsers.layoutManager= linearLayoutManager

        //getUsersData()


    }
    /*fun getUsersData(){
        val retrofitBuilder = SingletonClass.retrofitBuilderTemplate
        val retrofitData = retrofitBuilder.getUserDataFromWS()

        //retrofitData.enqueue () yazdıktan sonra ctrl+shift+space ile çağırdım.


        retrofitData.enqueue(object : Callback<List<UsersModelItem>?> {
            override fun onResponse(
                call: Call<List<UsersModelItem>?>,
                response: Response<List<UsersModelItem>?>
            ) {
                val responseBody=response.body()!!

                recyclerAdapterUsers = RecyclerAdapterUsers(baseContext ,responseBody)

                //NotifyDataSetChanged()'i Adaptöre verinin değiştiğini bildirmek için kullanıyoruz

                recyclerAdapterUsers.notifyDataSetChanged()

                recyclerViewUsers.adapter = recyclerAdapterUsers
            }

            override fun onFailure(call: Call<List<UsersModelItem>?>, t: Throwable) {

            }
        })

    }*/


}