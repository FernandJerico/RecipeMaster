package com.ferico.recipemaster.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R
import com.ferico.recipemaster.data.Recipe

class SavedVideoAdapter(private val recipeList: List<Recipe>, private val onItemClicked: (Recipe) -> Unit) : RecyclerView.Adapter<SavedVideoAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imageRecipe: ImageView = v.findViewById(R.id.iv_img_content_saved_video)
        val textRecipe: TextView = v.findViewById(R.id.tv_title_saved_video)
        val ratingRecipe: TextView = v.findViewById(R.id.tv_rating_saved_video)
        val username: TextView = v.findViewById(R.id.tv_username_saved_video)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_saved_video, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.textRecipe.text = recipe.title
        holder.ratingRecipe.text = recipe.rating
        holder.username.text = recipe.username
        holder.imageRecipe.setImageResource(recipe.imageResId)

        holder.itemView.setOnClickListener {
            onItemClicked(recipe)
        }
    }

    override fun getItemCount() = recipeList.size
}