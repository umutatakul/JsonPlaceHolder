package com.umutatakul.jsonplaceholder.RecyclerAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

import com.umutatakul.jsonplaceholder.Fragments.PhotosFragmentDirections
import com.umutatakul.jsonplaceholder.ImageLoaderClass
import com.umutatakul.jsonplaceholder.ImageLoaderHiltClass
import com.umutatakul.jsonplaceholder.ModelItems.PhotosModelItem
import com.umutatakul.jsonplaceholder.R
import com.umutatakul.jsonplaceholder.SingletonClasses.SingletonClass
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import kotlinx.android.synthetic.main.recycler_row_photos.view.*
import javax.inject.Inject


class RecyclerAdapterPhotos(var context:Context, private val photoList:List<PhotosModelItem>):RecyclerView.Adapter<RecyclerAdapterPhotos.PhotosVH>() {

    var imageLoaderGetter:ImageLoaderHiltClass

    init {
        imageLoaderGetter = ImageLoaderHiltClass(Picasso.get())
    }


    class PhotosVH (itemView: View):RecyclerView.ViewHolder(itemView){
        var photosIdVH : TextView
        var photosTitleVH : TextView
        var photosThumbnailVH : ImageView



        init {
            photosIdVH = itemView.photosIdText
            photosTitleVH = itemView.photosTitleText
            photosThumbnailVH = itemView.photosThumbnailImage
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_photos,parent,false)

        return PhotosVH(itemView)
    }

    override fun onBindViewHolder(holder: PhotosVH, position: Int) {
        holder.photosIdVH.text = photoList[position].id.toString()
        holder.photosTitleVH.text = photoList[position].title
        //Picasso.get().load(photoList[position].thumbnailUrl).into(holder.photosThumbnailVH)

        //var imageLoaderInstance = ImageLoaderClass()
        //imageLoaderInstance.imageLoader(photoList[position].thumbnailUrl,holder.photosThumbnailVH)

        ImageLoaderHiltClass(Picasso.get())
        imageLoaderGetter.imageLoader(photoList[position].thumbnailUrl,holder.photosThumbnailVH)




        holder.itemView.photosThumbnailImage.setOnClickListener {
            //val intent = Intent (holder.itemView.context, PhotosDetailActivity::class.java)
            val action = PhotosFragmentDirections.actionPhotosFragmentToPhotosDetailFragment()
            Navigation.findNavController(it).navigate(action)
            val singletonId = SingletonClass

            singletonId.gonderilenPhotoUrl = photoList.get(position).url

            //holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return photoList.size
    }
}