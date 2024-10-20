package com.ferico.recipemaster.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R
import com.ferico.recipemaster.adapter.SavedRecipeAdapter
import com.ferico.recipemaster.data.PopularItem
import com.ferico.recipemaster.data.Recipe
import com.ferico.recipemaster.data.RecipeIngredient

class SavedRecipe : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SavedRecipeAdapter
    private lateinit var recipeList: List<PopularItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_saved_recipe, container, false)

        recyclerView = view.findViewById(R.id.rv_saved_recipe)

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

        // Set adapter
        adapter = SavedRecipeAdapter(recipeList)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        return view
    }

    companion object {

    }
}