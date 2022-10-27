package com.umutatakul.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_todos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class TodosActivity : AppCompatActivity() {

    lateinit var recyclerAdapterTodos: RecyclerAdapterTodos
    lateinit var linearlayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos)

        recyclerView_todos.setHasFixedSize(true)
        linearlayoutManager = LinearLayoutManager(this)
        recyclerView_todos.layoutManager = linearlayoutManager


        val intent = intent
        val gelenUserId = intent.getStringExtra("userId")
        //todosIdText.text=gelenUserId
        getTodosData()
        //return gelenUserId

        val selectedTodosId = SingletonClass.SecilenIdBilgiler
        //todosIdText.text = selectedTodosId.gonderilenUsersId.toString()
    }
    fun getTodosData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(ApiInterface::class.java)


        //val denemeId = "5"
        val todosUserId = SingletonClass.gonderilenUsersId.toString()
        val retrofitData = retrofitBuilder.getTodosDataFromWS(todosUserId)

        retrofitData.enqueue(object : Callback<List<TodosModelItem>?> {
            override fun onResponse(call: Call<List<TodosModelItem>?>,
                response: Response<List<TodosModelItem>?>
            ) {
                val responseBody = response.body()!!
                recyclerAdapterTodos = RecyclerAdapterTodos(baseContext,responseBody)
                recyclerAdapterTodos.notifyDataSetChanged()
                recyclerView_todos.adapter = recyclerAdapterTodos


            }

            override fun onFailure(call: Call<List<TodosModelItem>?>, t: Throwable) {

            }
        })
    }
}