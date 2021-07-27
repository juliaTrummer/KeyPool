package com.mobappdev.keypool.PwList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.mobappdev.keypool.R

class PasswordList (private val mShopItems: List<Password>, val context : Context) : RecyclerView.Adapter<PasswordList.ViewHolder>()
{

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val header = itemView.findViewById<TextView>(R.id.header)
        val info = itemView.findViewById<TextView>(R.id.info)
        val pwBtn = itemView.findViewById<Button>(R.id.pwBtn)
        val userBtn = itemView.findViewById<Button>(R.id.usernameBtn)
        val searchInput = itemView.findViewById<TextInputEditText>(R.id.searchInput)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasswordList.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val pwView = inflater.inflate(R.layout.password_item, parent, false)
        return ViewHolder(pwView)
    }

    override fun onBindViewHolder(viewHolder: PasswordList.ViewHolder, position: Int) {


    }

    override fun getItemCount(): Int {
        return mShopItems.size
    }
}