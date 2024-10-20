package com.ferico.recipemaster.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R
import com.ferico.recipemaster.data.Recipe
import de.hdodenhof.circleimageview.CircleImageView

class SavedRecipeAdapter(private val recipeList: List<Recipe>) : RecyclerView.Adapter<SavedRecipeAdapter.RecipeViewHolder>() {

    // ViewHolder class untuk memegang view setiap item
    class RecipeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imageRecipe: CircleImageView = v.findViewById(R.id.civ_saved_recipe_img)
        val nameRecipe: TextView = v.findViewById(R.id.tv_saved_recipe_name)
        val timeRecipe: TextView = v.findViewById(R.id.tv_saved_recipe_time)
        val savedIcon: ImageView = v.findViewById(R.id.iv_saved_recipe)
    }

    // Inflate layout untuk setiap item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_saved_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    // Bind data dari list ke ViewHolder
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]

        // Set data ke view
        holder.imageRecipe.setImageResource(recipe.imageResId)
        holder.nameRecipe.text = recipe.title
        holder.timeRecipe.text = recipe.time

        // Click listener untuk icon bookmark
        holder.savedIcon.setOnClickListener {

        }
    }

    override fun getItemCount() = recipeList.size
}

