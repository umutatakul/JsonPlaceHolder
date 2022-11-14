package com.umutatakul.jsonplaceholder.RecyclerAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.ModelItems.TodosModelItem
import kotlinx.android.synthetic.main.recycler_row_todos.view.*

class RecyclerAdapterTodos (val context: Context,val todosList : List<TodosModelItem>):RecyclerView.Adapter<RecyclerAdapterTodos.TodosVH>(){
    class TodosVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        //var userIdVH :TextView
        var titleVH : TextView
        //var complatedVH : TextView
        var complatedImageVH : ImageView

        init {
            //userIdVH = itemView.todosUserIdText
            titleVH = itemView.photosTitleText
            //complatedVH = itemView.todosCompletedText
            complatedImageVH = itemView.photosThumbnailImage
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodosVH {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_todos,parent,false)
        return TodosVH(itemView)
    }

    override fun onBindViewHolder(holder: TodosVH, position: Int) {
        //holder.userIdVH.text = todosList[position].userId.toString()
        holder.titleVH.text = todosList[position].title
        //holder.complatedVH.text = todosList[position].completed.toString()
        if(todosList[position].completed){
            holder.complatedImageVH.setImageResource(R.drawable.check)
        }else if (!todosList[position].completed)
            holder.complatedImageVH.setImageResource(R.drawable.cross)


    }

    override fun getItemCount(): Int {
        return todosList.size
    }
}