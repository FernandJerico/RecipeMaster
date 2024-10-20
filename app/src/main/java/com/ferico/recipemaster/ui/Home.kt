package com.ferico.recipemaster.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.ferico.recipemaster.adapter.RecipeAdapter
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

class Home : Fragment(R.layout.fragment_home) {
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var popularItemAdapter: PopularItemAdapter
    private lateinit var recentRecipeAdapter: RecentRecipeAdapter
    private lateinit var popularCreatorsAdapter: PopularCreatorsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_item_recipe)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
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
            PopularItem(
                "Pepper sweetcorn ramen",
                "10 Min's",
                "4.5",
                R.drawable.onboarding,
                listOf(
                    RecipeIngredient("Ramen Noodles", "Noodle", "200g"),
                    RecipeIngredient("Sweetcorn", "Vegetable", "100g"),
                    RecipeIngredient("Red Pepper", "Vegetable", "1 piece"),
                    RecipeIngredient("Soy Sauce", "Condiment", "2 tbsp"),
                    RecipeIngredient("Green Onions", "Vegetable", "2 stalks")
                )
            ),
            PopularItem(
                "Spaghetti Bolognese",
                "20 Min's",
                "4.7",
                R.drawable.onboarding,
                listOf(
                    RecipeIngredient("Spaghetti", "Pasta", "250g"),
                    RecipeIngredient("Ground Beef", "Meat", "200g"),
                    RecipeIngredient("Tomato Sauce", "Sauce", "150ml"),
                    RecipeIngredient("Onion", "Vegetable", "1 piece"),
                    RecipeIngredient("Garlic", "Condiment", "2 cloves"),
                    RecipeIngredient("Olive Oil", "Oil", "2 tbsp")
                )
            ),
            PopularItem(
                "Chicken Tacos",
                "15 Min's",
                "4.9",
                R.drawable.onboarding,
                listOf(
                    RecipeIngredient("Chicken Breast", "Meat", "150g"),
                    RecipeIngredient("Taco Shells", "Shell", "3 pieces"),
                    RecipeIngredient("Lettuce", "Vegetable", "1 head"),
                    RecipeIngredient("Tomato", "Vegetable", "1 piece"),
                    RecipeIngredient("Cheddar Cheese", "Cheese", "50g"),
                    RecipeIngredient("Sour Cream", "Condiment", "2 tbsp")
                )
            )
        )


        val recipeList = listOf(
            Recipe(
                "Sushi",
                "4.5",
                "Fernand",
                R.drawable.onboarding,
                "20 Minute",
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
                "20 Minute",
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
                "20 Minute",
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
                "20 Minute",
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


        // Initialising Adapter dengan daftar recipe
        recipeAdapter = RecipeAdapter(recipeList){recipe ->
            val intent = Intent(requireContext(), RecipeDetailActivity::class.java).apply {
                putExtra("RECIPE_TITLE", recipe.title)
                putExtra("RECIPE_IMAGE", recipe.imageResId)
                putExtra("RECIPE_RATING", recipe.rating)
                putExtra("RECIPE_TIME_COOKING", recipe.time)
                putParcelableArrayListExtra("RECIPE_INGREDIENTS", ArrayList(recipe.ingredients))
            }
            startActivity(intent)
        }
        recyclerView.adapter = recipeAdapter

        val rvCategory = view.findViewById<RecyclerView>(R.id.rv_category)
        rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categoryAdapter = CategoryAdapter(categories) { selectedCategory ->
            categories.forEach { it.isSelected = false }
            selectedCategory.isSelected = true
            categoryAdapter.notifyDataSetChanged()
        }
        rvCategory.adapter = categoryAdapter

        val rvItemPopularCategory = view.findViewById<RecyclerView>(R.id.rv_item_popular_category)
        rvItemPopularCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        popularItemAdapter = PopularItemAdapter(popularItems){recipe ->
            val intent = Intent(requireContext(), RecipeDetailActivity::class.java).apply {
                putExtra("RECIPE_TITLE", recipe.name)
                putExtra("RECIPE_IMAGE", recipe.imageResId)
                putExtra("RECIPE_RATING", recipe.rating)
                putExtra("RECIPE_TIME_COOKING", recipe.time)
                putParcelableArrayListExtra("RECIPE_INGREDIENTS", ArrayList(recipe.ingredients))
            }
            startActivity(intent)
        }
        rvItemPopularCategory.adapter = popularItemAdapter

        val rvRecentRecipe = view.findViewById<RecyclerView>(R.id.rv_recent_recipe)
        rvRecentRecipe.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recentRecipeAdapter = RecentRecipeAdapter(recentRecipeList)
        rvRecentRecipe.adapter = recentRecipeAdapter

        val rvPopularCreators = view.findViewById<RecyclerView>(R.id.rv_popular_creators)
        rvPopularCreators.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        popularCreatorsAdapter = PopularCreatorsAdapter(popularCreatorsList)
        rvPopularCreators.adapter = popularCreatorsAdapter
    }
}
