package com.ferico.recipemaster.data

data class PopularItem(val name: String, val time: String, val rating: String, val imageResId: Int, val ingredients: List<RecipeIngredient>)
