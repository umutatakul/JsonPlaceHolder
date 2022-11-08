package com.umutatakul.jsonplaceholder.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.umutatakul.jsonplaceholder.R
import kotlinx.android.synthetic.main.fragment_selection_screen.*


class SelectionScreenFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postsButton.setOnClickListener {
            val action = SelectionScreenFragmentDirections.actionSelectionScreenFragmentToPostsFragment()
            Navigation.findNavController(it).navigate(action)

        }
        toDoButton.setOnClickListener {
            val action = SelectionScreenFragmentDirections.actionSelectionScreenFragmentToTodosFragment()
            Navigation.findNavController(it).navigate(action)
        }
        albumButton.setOnClickListener {
            val action = SelectionScreenFragmentDirections.actionSelectionScreenFragmentToAlbumsFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }


}