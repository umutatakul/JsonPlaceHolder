package com.umutatakul.jsonplaceholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row_comments.view.*
import java.lang.StringBuilder

class RecyclerAdapterComments (val context : Context, val commentsList:List<CommentsModelItem>):RecyclerView.Adapter<RecyclerAdapterComments.CommentsVH>(){
    class CommentsVH(itemView:View):RecyclerView.ViewHolder(itemView) {
        var commentsNameVH:TextView
        var commentsEmailVH:TextView
        var commentsBody:TextView
        init {
            commentsNameVH = itemView.commentsNameText
            commentsEmailVH = itemView.commentsEmailText
            commentsBody = itemView.commentsBodyText
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsVH {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_comments,parent,false)
        return CommentsVH(itemView)
    }

    override fun onBindViewHolder(holder: CommentsVH, position: Int) {
        holder.commentsNameVH.text = commentsList[position].name
        holder.commentsEmailVH.text = commentsList[position].email
        holder.commentsBody.text = commentsList[position].body
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }


}