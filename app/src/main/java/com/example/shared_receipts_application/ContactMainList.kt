package com.example.shared_receipts_application

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ContactMainList(val data: List<Main>) : RecyclerView.Adapter<ContactMainList.ItemViewHolder>() {
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(viewType, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]

        val image = holder.view.findViewById<ImageView>(R.id.main_image)
        val user = holder.view.findViewById<TextView>(R.id.main_user)
        val title = holder.view.findViewById<TextView>(R.id.main_title)
        val category = holder.view.findViewById<TextView>(R.id.main_category)
        val number = holder.view.findViewById<TextView>(R.id.main_number)

        image.setImageResource(item.image)
        user.text = item.user
        title.text = item.title
        category.text = item.category
        number.text = item.number
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.activity_main_list
    }
}