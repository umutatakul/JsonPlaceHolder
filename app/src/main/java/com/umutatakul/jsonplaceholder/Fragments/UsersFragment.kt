package com.umutatakul.jsonplaceholder.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umutatakul.jsonplaceholder.ModelItems.UsersModelItem
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.RecyclerAdapters.RecyclerAdapterUsers
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_users.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UsersFragment : Fragment() {
    lateinit var  recyclerAdapterUsers: RecyclerAdapterUsers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewUsers.setHasFixedSize(true)
        getUsersData()
    }
    fun getUsersData(){
        val retrofitBuilder = SingletonClass.retrofitBuilderTemplate
        val retrofitData = retrofitBuilder.getUserDataFromWS()

        //retrofitData.enqueue () yazdıktan sonra ctrl+shift+space ile çağırdım.


        retrofitData.enqueue(object : Callback<List<UsersModelItem>?> {
            override fun onResponse(
                call: Call<List<UsersModelItem>?>,
                response: Response<List<UsersModelItem>?>
            ) {
                val responseBody=response.body()!!

                recyclerAdapterUsers = RecyclerAdapterUsers(requireContext() ,responseBody)

                //NotifyDataSetChanged()'i Adaptöre verinin değiştiğini bildirmek için kullanıyoruz

                recyclerAdapterUsers.notifyDataSetChanged()

                recyclerViewUsers.adapter = recyclerAdapterUsers
            }

            override fun onFailure(call: Call<List<UsersModelItem>?>, t: Throwable) {

            }
        })

    }


}