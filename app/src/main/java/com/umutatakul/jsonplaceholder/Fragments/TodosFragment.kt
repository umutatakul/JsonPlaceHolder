package com.umutatakul.jsonplaceholder.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umutatakul.jsonplaceholder.ModelItems.TodosModelItem
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.RecyclerAdapters.RecyclerAdapterTodos
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import kotlinx.android.synthetic.main.activity_todos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TodosFragment : Fragment() {
    lateinit var recyclerAdapterTodos: RecyclerAdapterTodos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_todos.setHasFixedSize(true)
        getTodosData()
    }
    fun getTodosData(){
        val retrofitBuilder = SingletonClass.retrofitBuilderTemplate


        //val denemeId = "5"
        val todosUserId = SingletonClass.gonderilenUsersId.toString()
        val retrofitData = retrofitBuilder.getTodosDataFromWS(todosUserId)

        retrofitData.enqueue(object : Callback<List<TodosModelItem>?> {
            override fun onResponse(call: Call<List<TodosModelItem>?>,
                                    response: Response<List<TodosModelItem>?>
            ) {
                val responseBody = response.body()!!
                recyclerAdapterTodos = RecyclerAdapterTodos(context!!,responseBody)
                recyclerAdapterTodos.notifyDataSetChanged()
                recyclerView_todos.adapter = recyclerAdapterTodos


            }

            override fun onFailure(call: Call<List<TodosModelItem>?>, t: Throwable) {

            }
        })
    }


}