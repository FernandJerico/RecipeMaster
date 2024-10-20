package com.ferico.recipemaster.ui

import com.ferico.recipemaster.adapter.RecipeAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.data.Category
import com.ferico.recipemaster.adapter.CategoryAdapter
import com.ferico.recipemaster.data.PopularCreators
import com.ferico.recipemaster.adapter.PopularCreatorsAdapter
import com.ferico.recipemaster.data.PopularItem
import com.ferico.recipemaster.adapter.PopularItemAdapter
import com.ferico.recipemaster.R
import com.ferico.recipemaster.data.RecentRecipe
import com.ferico.recipemaster.adapter.RecentRecipeAdapter
import com.ferico.recipemaster.data.Recipe
import com.ferico.recipemaster.data.RecipeIngredient

class HomeActivity : AppCompatActivity() {
    private lateinit var recipeAdapter: RecipeAdapter

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var popularItemAdapter: PopularItemAdapter
    private lateinit var recentRecipeAdapter: RecentRecipeAdapter
    private lateinit var popularCreatorsAdapter: PopularCreatorsAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
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
            Recipe(
                "Sushi",
                "4.5",
                "Fernand",
                R.drawable.onboarding,
                listOf(
                    RecipeIngredient("Rice", "Grain", "200g"),
                    RecipeIngredient("Nori", "Seaweed", "5 sheets"),
                    RecipeIngredient("Salmon", "Fish", "150g"),
                    RecipeIngredient("Soy Sauce", "Condiment", "50ml")
                )
            ),
            Recipe(
                "Pasta",
                "4.7",
                "Jericho",
                R.drawable.onboarding,
                listOf(
                    RecipeIngredient("Pasta", "Grain", "300g"),
                    RecipeIngredient("Tomato Sauce", "Sauce", "200ml"),
                    RecipeIngredient("Parmesan", "Cheese", "50g"),
                    RecipeIngredient("Olive Oil", "Oil", "2 tbsp")
                )
            ),
            Recipe(
                "Salad",
                "4.9",
                "Federico",
                R.drawable.onboarding,
                listOf(
                    RecipeIngredient("Lettuce", "Vegetable", "1 head"),
                    RecipeIngredient("Cucumber", "Vegetable", "1 piece"),
                    RecipeIngredient("Carrot", "Vegetable", "1 piece"),
                    RecipeIngredient("Olive Oil", "Oil", "2 tbsp"),
                    RecipeIngredient("Vinegar", "Condiment", "1 tbsp")
                )
            ),
            Recipe(
                "Breakfast",
                "4.6",
                "Struck",
                R.drawable.onboarding,
                listOf(
                    RecipeIngredient("Eggs", "Protein", "2 pcs"),
                    RecipeIngredient("Bread", "Grain", "2 slices"),
                    RecipeIngredient("Butter", "Dairy", "1 tbsp"),
                    RecipeIngredient("Bacon", "Meat", "3 strips")
                )
            )
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