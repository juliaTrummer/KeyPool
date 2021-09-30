package com.mobappdev.keypool.passwordlist

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.mobappdev.keypool.R

class PasswordList (private val mKeyItems: List<KeyItem>, val context : Context) : RecyclerView.Adapter<PasswordList.ViewHolder>()
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
        val keyItem : KeyItem = mKeyItems.get(position)
        viewHolder.header.setText(keyItem.websiteName)
        viewHolder.pwBtn.setOnClickListener(){
            var clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            var clip = ClipData.newPlainText("RANDOMPW", keyItem.passwordItem.password)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(context, "copied password", Toast.LENGTH_SHORT).show()
        }
        viewHolder.userBtn.setOnClickListener(){
            var clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            var clip = ClipData.newPlainText("RANDOMUSER", keyItem.passwordItem.user)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(context, "copied username", Toast.LENGTH_SHORT).show()
        }
        viewHolder.info.setText(keyItem.description)
    }

    override fun getItemCount(): Int {
        return mKeyItems.size
    }
}