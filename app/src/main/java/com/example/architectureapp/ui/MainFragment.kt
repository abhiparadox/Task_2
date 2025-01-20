package com.example.architectureapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.architectureapp.R
import com.example.architectureapp.utils.UserAdapter
import com.example.architectureapp.view_model.UserViewModel

class MainFragment:Fragment() {
    private lateinit var viewModel: UserViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        progressBar = view.findViewById(R.id.progress_bar)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.users.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = UserAdapter(it)
            progressBar.visibility = View.GONE
        })

        progressBar.visibility = View.VISIBLE
    }
}