package com.ferico.recipemaster.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.data.PopularItem
import com.ferico.recipemaster.R

class PopularItemAdapter(
    private val popularItems: List<PopularItem>,
    private val onItemClick: (PopularItem) -> Unit
) : RecyclerView.Adapter<PopularItemAdapter.PopularItemViewHolder>() {

    inner class PopularItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView = view.findViewById(R.id.civ_recipe_popular_img)
        private val nameTextView: TextView = view.findViewById(R.id.tv_popular_item_name)
        private val timeTextView: TextView = view.findViewById(R.id.tv_popular_item_time)

        fun bind(item: PopularItem) {
            imageView.setImageResource(item.imageResId)
            nameTextView.text = item.name
            timeTextView.text = item.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_popular_category, parent, false)
        return PopularItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularItemViewHolder, position: Int) {
        val recipe = popularItems[position]
        holder.bind(popularItems[position])

        // Set click listener untuk item
        holder.itemView.setOnClickListener {
            onItemClick(recipe)
        }
    }

    override fun getItemCount(): Int = popularItems.size
}
