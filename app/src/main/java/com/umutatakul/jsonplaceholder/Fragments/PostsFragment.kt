package com.umutatakul.jsonplaceholder.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umutatakul.jsonplaceholder.API.ApiInterface
import com.umutatakul.jsonplaceholder.ModelItems.PostsModelItem
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.RecyclerAdapters.RecyclerAdapterPosts
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_posts.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class PostsFragment : Fragment() {
    lateinit var recyclerAdapterPosts: RecyclerAdapterPosts
    @Inject
    lateinit var retrofitBuilder:ApiInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewPosts.setHasFixedSize(true)
        getPostsData ()
    }

    fun getPostsData(){
        //val retrofitBuilder = SingletonClass.retrofitBuilderTemplate

        val retrofitData = retrofitBuilder.getPostDataFromWS(SingletonClass.gonderilenUsersId.toString())

        retrofitData.enqueue(object : Callback<List<PostsModelItem>?> {
            override fun onResponse(
                call: Call<List<PostsModelItem>?>,
                response: Response<List<PostsModelItem>?>
            ) {
                val responseBody = response.body()

                responseBody?.let {
                    recyclerAdapterPosts = RecyclerAdapterPosts(requireContext(),responseBody)
                }


                recyclerAdapterPosts.notifyDataSetChanged()
                recyclerViewPosts.adapter = recyclerAdapterPosts
            }


            override fun onFailure(call: Call<List<PostsModelItem>?>, t: Throwable) {

            }
        })


    }


}