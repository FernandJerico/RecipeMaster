package com.ferico.recipemaster.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R
import com.ferico.recipemaster.adapter.ProfileMyRecipeAdapter
import com.ferico.recipemaster.adapter.ProfileMyVideoAdapter
import com.ferico.recipemaster.data.Recipe
import com.ferico.recipemaster.data.RecipeIngredient

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileRecipe.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileRecipe : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var profileMyRecipeAdapter: ProfileMyRecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialising RecyclerView
        val rvSavedVideo = view.findViewById<RecyclerView>(R.id.rv_my_recipe)
        val rvSavedVideoLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvSavedVideo.layoutManager = rvSavedVideoLayoutManager

        val recipeList = listOf(
            Recipe(
                "Sushi with Iwak Lele Saos Padang",
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
        profileMyRecipeAdapter = ProfileMyRecipeAdapter(recipeList){recipe ->
            val intent = Intent(requireContext(), RecipeDetailActivity::class.java).apply {
                putExtra("RECIPE_TITLE", recipe.title)
                putExtra("RECIPE_IMAGE", recipe.imageResId)
                putExtra("RECIPE_RATING", recipe.rating)
                putExtra("RECIPE_TIME_COOKING", recipe.time)
                putParcelableArrayListExtra("RECIPE_INGREDIENTS", ArrayList(recipe.ingredients))
            }
            startActivity(intent)
        }
        rvSavedVideo.adapter = profileMyRecipeAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileRecipe.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileRecipe().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}