package com.ferico.recipemaster

import RecipeAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recipeAdapter: RecipeAdapter

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var popularItemAdapter: PopularItemAdapter
    private lateinit var recentRecipeAdapter: RecentRecipeAdapter
    private lateinit var popularCreatorsAdapter: PopularCreatorsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_item_recipe)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val categories = listOf(
            Category("Salad", true),
            Category("Breakfast"),
            Category("Appetizer"),
            Category("Noodle"),
            Category("Lunch"),
            Category("Dinner"),
            Category("Snack")
        )

        val popularItems = listOf(
            PopularItem("Pepper sweetcorn ramen", "10 Min's", R.drawable.onboarding),
            PopularItem("Spaghetti Bolognese", "20 Min's", R.drawable.onboarding),
            PopularItem("Chicken Tacos", "15 Min's", R.drawable.onboarding)
        )

        val recipeList = listOf(
            Recipe("Sushi", "4.5", "Fernand", R.drawable.onboarding),
            Recipe("Pasta", "4.7", "Jericho", R.drawable.onboarding),
            Recipe("Salad", "4.9", "Federico", R.drawable.onboarding),
            Recipe("Breakfast", "4.6", "Struck", R.drawable.onboarding),
        )

        val recentRecipeList = listOf(
            RecentRecipe("Indonesian Chicken Burger", "Fernand Jerico", R.drawable.onboarding),
            RecentRecipe("Home made cute pancake", "Fajar Gema", R.drawable.onboarding),
            RecentRecipe("How to make seafood fried rice", "Hafidz Sr", R.drawable.onboarding)
        )
        val popularCreatorsList = listOf(
            PopularCreators("Fernand Jerico", R.drawable.onboarding),
            PopularCreators("Fajar Gema", R.drawable.onboarding),
            PopularCreators("Hafidz Surya", R.drawable.onboarding),
            PopularCreators("Ozan Sulap", R.drawable.onboarding)
        )

        recipeAdapter = RecipeAdapter(recipeList)
        recyclerView.adapter = recipeAdapter

        val rvCategory = findViewById<RecyclerView>(R.id.rv_category)
        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryAdapter = CategoryAdapter(categories) { selectedCategory ->
            categories.forEach { it.isSelected = false }
            selectedCategory.isSelected = true
            categoryAdapter.notifyDataSetChanged()
        }
        rvCategory.adapter = categoryAdapter

        val rvItemPopularCategory = findViewById<RecyclerView>(R.id.rv_item_popular_category)
        rvItemPopularCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        popularItemAdapter = PopularItemAdapter(popularItems)
        rvItemPopularCategory.adapter = popularItemAdapter

        val rvRecentRecipe = findViewById<RecyclerView>(R.id.rv_recent_recipe)
        rvRecentRecipe.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recentRecipeAdapter = RecentRecipeAdapter(recentRecipeList)
        rvRecentRecipe.adapter = recentRecipeAdapter

        val rvPopularCreators = findViewById<RecyclerView>(R.id.rv_popular_creators)
        rvPopularCreators.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        popularCreatorsAdapter = PopularCreatorsAdapter(popularCreatorsList)
        rvPopularCreators.adapter = popularCreatorsAdapter
    }
}