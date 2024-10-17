package com.ferico.recipemaster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecentRecipeAdapter(private val recentRecipe: List<RecentRecipe>): RecyclerView.Adapter<RecentRecipeAdapter.RecentRecipeViewHolder>() {
    inner class RecentRecipeViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val imageView: ImageView = view.findViewById(R.id.iv_recent_recipe)
        private val nameTextView: TextView = view.findViewById(R.id.tv_recent_recipe_name)
        private val authorTextView: TextView = view.findViewById(R.id.tv_recent_recipe_author)

        fun bind(item: RecentRecipe){
            imageView.setImageResource(item.imageResId)
            nameTextView.text = item.name
            authorTextView.text = item.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentRecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_recipe, parent, false)
        return RecentRecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecentRecipeViewHolder, position: Int) {
        holder.bind(recentRecipe[position])
    }

    override fun getItemCount():Int = recentRecipe.size
}