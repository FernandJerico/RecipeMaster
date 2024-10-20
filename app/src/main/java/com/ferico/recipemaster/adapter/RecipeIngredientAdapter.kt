package com.ferico.recipemaster.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R
import com.ferico.recipemaster.data.RecipeIngredient

class RecipeIngredientAdapter (private val recipeIngredient: List<RecipeIngredient>): RecyclerView.Adapter<RecipeIngredientAdapter.RecipeIngredientViewHolder>(){
    inner class RecipeIngredientViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val ingredientName: TextView = view.findViewById(R.id.tv_ingredients_name)
        private val ingredientWeight: TextView = view.findViewById(R.id.tv_ingredients_weight)

        fun bind(item: RecipeIngredient){
            ingredientName.text = item.ingredientName
            ingredientWeight.text = item.ingredientWeight
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeIngredientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ingredients, parent, false)
        return RecipeIngredientViewHolder(view)
    }

    override fun getItemCount(): Int = recipeIngredient.size

    override fun onBindViewHolder(holder: RecipeIngredientViewHolder, position: Int) {
        holder.bind(recipeIngredient[position])
    }
}