package com.ferico.recipemaster.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R

class RecipeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recipe_detail)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_ingredients_detail)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        // Menerima data dari Intent
        val recipeTitle = intent.getStringExtra("RECIPE_TITLE")
        val recipeImageResId = intent.getIntExtra("RECIPE_IMAGE", 0)
        val recipeRating = intent.getStringExtra("RECIPE_RATING")

        // Update UI dengan data yang diterima
        findViewById<TextView>(R.id.tv_recipe_detail_title).text = recipeTitle
        findViewById<ImageView>(R.id.iv_recipe_detail_img).setImageResource(recipeImageResId)
        findViewById<TextView>(R.id.tv_recipe_detail_rating).text = recipeRating.toString()
    }
}