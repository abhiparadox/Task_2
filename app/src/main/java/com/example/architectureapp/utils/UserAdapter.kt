package com.example.architectureapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.architectureapp.R
import com.example.architectureapp.model.data.User

class UserAdapter(private val users:List<User>):RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val username: TextView = itemView.findViewById(R.id.username)
        private val email: TextView = itemView.findViewById(R.id.email)

        fun bind(user: User) {
            username.text = user.username
            email.text = user.email
        }
    }
}