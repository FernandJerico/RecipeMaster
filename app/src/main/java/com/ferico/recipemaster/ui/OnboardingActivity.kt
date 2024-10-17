package com.ferico.recipemaster.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ferico.recipemaster.MainActivity
import com.ferico.recipemaster.R

class OnboardingActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnStartCooking : Button = this.findViewById(R.id.btn_start_cooking)
        btnStartCooking.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when(v?.id){
            R.id.btn_start_cooking -> {
                val moveIntent = Intent(this@OnboardingActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}