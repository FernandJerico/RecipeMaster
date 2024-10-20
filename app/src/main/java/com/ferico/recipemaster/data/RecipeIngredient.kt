package com.ferico.recipemaster.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeIngredient(
    val ingredientName: String,
    val ingredientType: String,
    val ingredientWeight: String
): Parcelable
