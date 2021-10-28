package com.example.todo.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.todo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import it.emperor.animatedcheckbox.AnimatedCheckBox


class TodoListFragment : Fragment() {

    private lateinit var  spineer : Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addFloatingActionButton : FloatingActionButton = view.findViewById(R.id.add_button)

        val categories = resources.getStringArray(R.array.categories)
        spineer = view.findViewById<Spinner>(R.id.spinner)

        if (spineer != null)
        {
            val adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_dropdown_item, categories)
            spineer.adapter = adapter
        }




        addFloatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_todoListFragment_to_detailsFragment)
        }
    }

}