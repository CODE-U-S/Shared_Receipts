package com.example.shared_receipts_application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactFavoriteList(val data: List<Favorite>) :
    RecyclerView.Adapter<ContactFavoriteList.ItemViewHolder>() {
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(viewType, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]

        val image = holder.view.findViewById<ImageView>(R.id.favorite_image)
        val user = holder.view.findViewById<TextView>(R.id.favorite_user)
        val title = holder.view.findViewById<TextView>(R.id.favorite_title)
        val price = holder.view.findViewById<TextView>(R.id.favorite_price)
        val number = holder.view.findViewById<TextView>(R.id.favorite_number)

        image.setImageResource(item.image)
        user.text = item.user
        title.text = item.title
        price.text = item.price
        number.text = item.number
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.activity_favorite_list
    }
}