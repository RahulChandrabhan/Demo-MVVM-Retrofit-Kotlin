package com.rsc.assignment247.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.rsc.assignment247.R
import com.rsc.assignment247.model.UserResult

class UserAdapter(var userDetailsList: List<UserResult>, var context: Context) :
    RecyclerView.Adapter<UserAdapter.RecyclerDemoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerDemoViewHolder {
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.rv_items_user_details, parent, false)
        return RecyclerDemoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userDetailsList.size
    }

    override fun onBindViewHolder(holder: RecyclerDemoViewHolder, position: Int) {
        val userResult: UserResult = userDetailsList[position]
        holder.nameTv.text = userResult.name
        holder.emailTv.text = userResult.email
        holder.genderTv.text = userResult.gender
        holder.statusTv.text = userResult.status
    }


    class RecyclerDemoViewHolder(itemView: View) : ViewHolder(itemView) {
        var nameTv: TextView = itemView.findViewById(R.id.rv_items_user_details_name_tv)
        var emailTv: TextView = itemView.findViewById(R.id.rv_items_user_details_email_tv)
        var genderTv: TextView = itemView.findViewById(R.id.rv_items_user_details_gender_tv)
        var statusTv: TextView = itemView.findViewById(R.id.rv_items_user_details_status_tv)
    }

}