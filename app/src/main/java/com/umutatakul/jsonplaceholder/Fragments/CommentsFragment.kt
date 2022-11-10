package com.umutatakul.jsonplaceholder.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umutatakul.jsonplaceholder.ModelItems.CommentsModelItem
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.RecyclerAdapters.RecyclerAdapterComments
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import kotlinx.android.synthetic.main.activity_comments.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CommentsFragment : Fragment() {
    lateinit var recyclerAdapterComments: RecyclerAdapterComments

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewComments.setHasFixedSize(true)
        getCommentsData ()
    }
    fun getCommentsData(){
        val retrofitBuilder = SingletonClass.retrofitBuilderTemplate

        val retrofitData = retrofitBuilder.getCommentsDataFromWS(SingletonClass.gonderilenPostsId.toString())

        retrofitData.enqueue(object : Callback<List<CommentsModelItem>?> {
            override fun onResponse(
                call: Call<List<CommentsModelItem>?>,
                response: Response<List<CommentsModelItem>?>
            ) {
                val responseBody = response.body()

                recyclerAdapterComments = RecyclerAdapterComments(requireContext(),responseBody!!)
                recyclerAdapterComments.notifyDataSetChanged()
                recyclerViewComments.adapter = recyclerAdapterComments

            }

            override fun onFailure(call: Call<List<CommentsModelItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


}