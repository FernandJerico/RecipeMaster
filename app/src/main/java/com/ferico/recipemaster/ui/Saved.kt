package com.ferico.recipemaster.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ferico.recipemaster.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Saved.newInstance] factory method to
 * create an instance of this fragment.
 */
class Saved : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view = inflater.inflate(R.layout.fragment_saved, container, false)

        val btnSavedVideo = view.findViewById<Button>(R.id.btn_saved_video)
        val btnSavedRecipe = view.findViewById<Button>(R.id.btn_saved_recipe)

        // Set initial selection for buttons
        btnSavedVideo.isSelected = true
        btnSavedRecipe.isSelected = false

        // Show VideoFragment initially
        loadFragment(SavedVideo())

        // Set click listeners for the buttons
        btnSavedVideo.setOnClickListener {
            btnSavedVideo.isSelected = true
            btnSavedRecipe.isSelected = false
            loadFragment(SavedVideo())
        }

        btnSavedRecipe.setOnClickListener {
            btnSavedVideo.isSelected = false
            btnSavedRecipe.isSelected = true
            loadFragment(SavedRecipe())
        }

        return view
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Saved.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Saved().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}