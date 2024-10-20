package com.ferico.recipemaster.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R
import com.ferico.recipemaster.adapter.SavedRecipeAdapter
import com.ferico.recipemaster.data.Recipe
import com.ferico.recipemaster.data.RecipeIngredient

class SavedRecipe : Fragment() {
    private lateinit var savedRecipeAdapter: SavedRecipeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_saved_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialising RecyclerView
        val rvSavedRecipe = view.findViewById<RecyclerView>(R.id.rv_saved_recipe)
        val rvSavedRecipeLayoutManager = GridLayoutManager(requireContext(), 2)
        rvSavedRecipe.layoutManager = rvSavedRecipeLayoutManager

        val recipeList = listOf(
            Recipe(
                "Sushi",
                "4.5",
                "Fernand",
                R.drawable.onboarding,
                "10 Minute",
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

        // Initialising Adapter dengan daftar recipe
        savedRecipeAdapter = SavedRecipeAdapter(recipeList){recipe ->
            val intent = Intent(requireContext(), RecipeDetailActivity::class.java).apply {
                putExtra("RECIPE_TITLE", recipe.title)
                putExtra("RECIPE_IMAGE", recipe.imageResId)
                putExtra("RECIPE_RATING", recipe.rating)
                putExtra("RECIPE_TIME_COOKING", recipe.time)
                putParcelableArrayListExtra("RECIPE_INGREDIENTS", ArrayList(recipe.ingredients))
            }
            startActivity(intent)
        }
        rvSavedRecipe.adapter = savedRecipeAdapter
    }

    companion object {

    }
}