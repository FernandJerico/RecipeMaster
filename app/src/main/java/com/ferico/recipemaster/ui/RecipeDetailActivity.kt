package com.ferico.recipemaster.ui

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R
import com.ferico.recipemaster.adapter.RecipeIngredientAdapter
import com.ferico.recipemaster.data.RecipeIngredient

class RecipeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recipe_detail)

        val btnBack = findViewById<ImageButton>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }

        // Menerima data dari Intent
        val recipeTitle = intent.getStringExtra("RECIPE_TITLE")
        val recipeImageResId = intent.getIntExtra("RECIPE_IMAGE", 0)
        val recipeRating = intent.getStringExtra("RECIPE_RATING")
        val ingredients = intent.getParcelableArrayListExtra<RecipeIngredient>("RECIPE_INGREDIENTS")

        val ingredientsAdapter = RecipeIngredientAdapter(ingredients ?: listOf())
        findViewById<RecyclerView>(R.id.rv_ingredients_detail).apply {
            layoutManager = LinearLayoutManager(this@RecipeDetailActivity)
            adapter = ingredientsAdapter
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
        }
        // Update UI dengan data yang diterima
        findViewById<TextView>(R.id.tv_recipe_detail_title).text = recipeTitle
        findViewById<ImageView>(R.id.iv_recipe_detail_img).setImageResource(recipeImageResId)
        findViewById<TextView>(R.id.tv_recipe_detail_rating).text = recipeRating.toString()
    }
}