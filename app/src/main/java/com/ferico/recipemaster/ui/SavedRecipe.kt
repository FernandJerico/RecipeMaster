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
            PopularItem("Pepper sweetcorn ramen", "10 Mins", R.drawable.onboarding),
            PopularItem("Avocado toast", "15 Mins", R.drawable.onboarding),
            PopularItem("Pasta with Pesto", "20 Mins", R.drawable.onboarding),
            PopularItem("Sate Ayam Madura", "30 Mins", R.drawable.onboarding),
            PopularItem("Sate Ayam Madura", "30 Mins", R.drawable.onboarding),
            PopularItem("Sate Ayam Madura", "30 Mins", R.drawable.onboarding),
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