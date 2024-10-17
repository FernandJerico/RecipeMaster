package com.ferico.recipemaster

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class CategoryAdapter(
    private val categories: List<Category>,
    private val onItemClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val cardView: MaterialCardView = view.findViewById(R.id.mcv_popular_category) // Ganti id
        private val textView: TextView = view.findViewById(R.id.tv_category_name) // Ganti id

        fun bind(category: Category) {
            textView.text = category.name
            cardView.isChecked = category.isSelected

            // Update tampilan berdasarkan isSelected
            if (category.isSelected) {
                cardView.setCardBackgroundColor(Color.parseColor("#E23E3E"))
                textView.setTextColor(Color.WHITE)
            } else {
                cardView.setCardBackgroundColor(Color.TRANSPARENT)
                textView.setTextColor(Color.parseColor("#EE8B8B"))
            }

            // Listener untuk item kategori
            cardView.setOnClickListener {
                onItemClick(category)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_category, parent, false) // layout item kategori yang benar
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size
}





