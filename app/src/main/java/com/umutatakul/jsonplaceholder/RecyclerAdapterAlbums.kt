package com.umutatakul.jsonplaceholder

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row_albums.view.*

class RecyclerAdapterAlbums(val context:Context ,val albumList:List<AlbumsModelItem>):RecyclerView.Adapter<RecyclerAdapterAlbums.AlbumsVH>(){
    class AlbumsVH(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var PostIdVH : TextView
        var titleVH : TextView

        init {
            PostIdVH = itemView.albumPostIdText
            titleVH = itemView.albumTitleText
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsVH {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_albums,parent,false)
        return AlbumsVH(itemView)
    }

    override fun onBindViewHolder(holder: AlbumsVH, position: Int) {
        holder.PostIdVH.text = albumList[position].id.toString()
        holder.titleVH.text = albumList[position].title


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,PhotosActivity::class.java)

            var singletonId = SingletonClass.SecilenIdBilgiler

            singletonId.gonderilenAlbumId =albumList[position].id

            holder.itemView.context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {
        return albumList.size
    }
}