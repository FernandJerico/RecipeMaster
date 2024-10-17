package com.ferico.recipemaster.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R
import com.ferico.recipemaster.data.Recipe

class RecipeAdapter(private val recipeList: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imageRecipe: ImageView = v.findViewById(R.id.iv_img_content)
        val textRecipe: TextView = v.findViewById(R.id.tv_title)
        val ratingRecipe: TextView = v.findViewById(R.id.tv_rating)
        val username: TextView = v.findViewById(R.id.tv_username)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.textRecipe.text = recipe.title
        holder.ratingRecipe.text = recipe.rating
        holder.username.text = recipe.username
        holder.imageRecipe.setImageResource(recipe.imageResId)
    }

    override fun getItemCount() = recipeList.size
}
