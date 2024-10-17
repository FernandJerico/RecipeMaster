package com.ferico.recipemaster.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.data.PopularCreators
import com.ferico.recipemaster.R

class PopularCreatorsAdapter(
    private val popularCreators: List<PopularCreators>
) : RecyclerView.Adapter<PopularCreatorsAdapter.PopularCreatorsViewHolder>() {
    inner class PopularCreatorsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView = view.findViewById(R.id.civ_creator_img)
        private val creatorNameTextView: TextView = view.findViewById(R.id.tv_creator_name)

        fun bind(item: PopularCreators) {
            imageView.setImageResource(item.imageResId)
            creatorNameTextView.text = item.creatorName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularCreatorsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_popular_creators, parent, false)
        return PopularCreatorsViewHolder(view)
    }

    override fun getItemCount(): Int = popularCreators.size

    override fun onBindViewHolder(holder: PopularCreatorsViewHolder, position: Int) {
        holder.bind(popularCreators[position])
    }
}