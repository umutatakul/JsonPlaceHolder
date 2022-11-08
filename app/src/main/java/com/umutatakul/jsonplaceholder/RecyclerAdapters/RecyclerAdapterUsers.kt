package com.umutatakul.jsonplaceholder.RecyclerAdapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.umutatakul.jsonplaceholder.Activities.SelectionScreenActivity
import com.umutatakul.jsonplaceholder.Fragments.UsersFragmentDirections
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import com.umutatakul.jsonplaceholder.ModelItems.UsersModelItem
import kotlinx.android.synthetic.main.recycler_row_users.view.*

class RecyclerAdapterUsers (val context : Context, val usersList:List<UsersModelItem>):RecyclerView.Adapter<RecyclerAdapterUsers.UsersVH>(){
    class UsersVH (itemView:View):RecyclerView.ViewHolder(itemView){
        var idVH:TextView
        var nameVH:TextView
        var emailVH:TextView

        init {
            idVH = itemView.idText
            nameVH=itemView.nameText
            emailVH=itemView.emailText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersVH {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_users,parent,false)
        return UsersVH(itemView)
    }

    override fun onBindViewHolder(holder: UsersVH, position: Int) {
        holder.idVH.text = usersList[position].id.toString()
        holder.nameVH.text=usersList[position].name
        holder.emailVH.text=usersList[position].email

        holder.itemView.setOnClickListener {
            //val intent = Intent(holder.itemView.context, SelectionScreenActivity::class.java)

            val action = UsersFragmentDirections.actionUsersFragmentToSelectionScreenFragment()
            Navigation.findNavController(it).navigate(action)
            //var gonderlienId = holder.idVH
            //intent.putExtra("userId",usersList[position].id.toString())

            var singletonId = SingletonClass.SecilenIdBilgiler
            //singletonId.gonderilenId = holder.idVH.text.toString().toInt()

            //singletonId.gonderilenId = userList.get(position).id

            singletonId.gonderilenUsersId = usersList[position].id
            singletonId.gonderilenUserName= usersList[position].name

            //holder.itemView.context.startActivity(intent)



        }

    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}