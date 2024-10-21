package com.ferico.recipemaster.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ferico.recipemaster.R

class CreateRecipeActivity : AppCompatActivity() {
    private lateinit var ingredientListContainer: LinearLayout
    private lateinit var addIngredientButton: ImageButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_recipe)

        val btnBack = findViewById<ImageButton>(R.id.btn_create_back)
        btnBack.setOnClickListener {
            finish()
        }

        ingredientListContainer = findViewById(R.id.ingredient_list_container)
        addIngredientButton = findViewById(R.id.btn_add_new_ingredient)

        // Add initial layout for ingredients
        addNewIngredientView()

        // Set the click listener for the add ingredient button
        addIngredientButton.setOnClickListener {
            addNewIngredientView()
        }

    }

    private fun addNewIngredientView() {
        // Inflate the new ingredient row from the existing XML
        val ingredientView = layoutInflater.inflate(R.layout.item_add_recipe_ingredient, null)

        // Optionally, set up logic for the views (e.g., delete button)
        val deleteButton: ImageButton = ingredientView.findViewById(R.id.btn_add_delete_ingredient)
        deleteButton.setImageResource(R.drawable.ic_minus_border)
        deleteButton.setOnClickListener {
            ingredientListContainer.removeView(ingredientView) // Remove ingredient row
        }

        // Add the new row to the parent container
        ingredientListContainer.addView(ingredientView)
    }
}