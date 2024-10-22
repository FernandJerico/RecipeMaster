package com.ferico.recipemaster.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R
import com.ferico.recipemaster.adapter.ProfileMyVideoAdapter.ProfileMyVideoViewHolder
import com.ferico.recipemaster.data.Recipe

class ProfileMyRecipeAdapter(private val recipeList: List<Recipe>, private val onItemClicked: (Recipe) -> Unit) : RecyclerView.Adapter<ProfileMyRecipeAdapter.ProfileMyRecipeViewHolder>() {
    class ProfileMyRecipeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imageRecipe: ImageView = v.findViewById(R.id.iv_img_my_content)
        val titleRecipe: TextView = v.findViewById(R.id.tv_my_content_title)
        val ratingRecipe: TextView = v.findViewById(R.id.tv_rating_my_content)
        val ingredient: TextView = v.findViewById(R.id.tv_my_content_body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileMyRecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_my_content, parent, false)
        return ProfileMyRecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileMyRecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.titleRecipe.text = recipe.title
        holder.ratingRecipe.text = recipe.rating
        holder.imageRecipe.setImageResource(recipe.imageResId)

        holder.itemView.setOnClickListener {
            onItemClicked(recipe)
        }
    }

    override fun getItemCount(): Int = recipeList.size
}