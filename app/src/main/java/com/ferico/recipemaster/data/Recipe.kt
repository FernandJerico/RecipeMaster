package com.ferico.recipemaster.data

data class Recipe(val title: String, val rating: String, val username: String, val imageResId: Int, val time: String, val ingredients: List<RecipeIngredient> )
