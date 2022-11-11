package com.umutatakul.jsonplaceholder.RecyclerAdapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

import com.umutatakul.jsonplaceholder.Fragments.PostsFragment
import com.umutatakul.jsonplaceholder.Fragments.PostsFragmentDirections
import com.umutatakul.jsonplaceholder.ModelItems.PostsModelItem
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import kotlinx.android.synthetic.main.recycler_row_posts.view.*

class RecyclerAdapterPosts (val context : Context, val postsList:List<PostsModelItem>):RecyclerView.Adapter<RecyclerAdapterPosts.PostsVH>(){
    class PostsVH (itemView: View):RecyclerView.ViewHolder(itemView){
        var postIdVH : TextView
        var postTitleVH : TextView
        var postBodyVH : TextView

        init {
            postIdVH = itemView.postIdText
            postTitleVH = itemView.postTitleText
            postBodyVH = itemView.postBodyText
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsVH {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_posts,parent,false)
        return PostsVH(itemView)
    }

    override fun onBindViewHolder(holder: PostsVH, position: Int) {
        holder.postIdVH.text=postsList[position].id.toString()
        holder.postTitleVH.text = postsList[position].title
        holder.postBodyVH.text = postsList[position].body

        holder.itemView.setOnClickListener {
            //val intent = Intent(holder.itemView.context, CommentsActivity::class.java)
            val action = PostsFragmentDirections.actionPostsFragmentToCommentsFragment()
            Navigation.findNavController(it).navigate(action)
            var singletonId = SingletonClass.SecilenIdBilgiler

            singletonId.gonderilenPostsId = postsList[position].id.toString()

            //holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return postsList.size
    }
}