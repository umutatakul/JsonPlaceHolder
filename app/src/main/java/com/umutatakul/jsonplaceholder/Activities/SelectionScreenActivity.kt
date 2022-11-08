package com.umutatakul.jsonplaceholder.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.umutatakul.jsonplaceholder.R

class SelectionScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_screen)


    }

    fun menuToPostsButton(view:View){
        val intent = Intent(applicationContext, PostsActivity::class.java)
        startActivity(intent)

    }

    fun menuToToDosButton(view:View) {
        val intent = Intent(applicationContext, TodosActivity::class.java)
        startActivity(intent)

    }

    fun menuToAlbumsButton(view: View){
        val intent = Intent(applicationContext, AlbumActivity::class.java)
        startActivity(intent)
    }
}