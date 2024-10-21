package com.ferico.recipemaster

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ferico.recipemaster.ui.CreateRecipeActivity
import com.ferico.recipemaster.ui.Home
import com.ferico.recipemaster.ui.Notification
import com.ferico.recipemaster.ui.Profile
import com.ferico.recipemaster.ui.Saved
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private  lateinit var navView: BottomNavigationView
    private lateinit var fab: FloatingActionButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        navView = findViewById(R.id.nav_view)
        fab = findViewById(R.id.floatingActionButton)

        // Set default fragment (HomeFragment)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.navhost, Home())
                .commit()
        }

        // Listener untuk FAB (Floating Action Button)
        fab.setOnClickListener {
            val moveIntent = Intent(this, CreateRecipeActivity::class.java)
            startActivity(moveIntent)
        }

        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replace(Home())
                    true
                }
                R.id.navigation_saved -> {
                    replace(Saved())
                    true
                }
                R.id.navigation_notification -> {
                    replace(Notification())
                    true
                }
                R.id.navigation_profile -> {
                    replace(Profile())
                    true
                }
                else -> false
            }
        }
    }

    private fun replace(fragment: Fragment){
        val activityManager = supportFragmentManager
        val fragmentTransaction = activityManager.beginTransaction()
        fragmentTransaction.replace(R.id.navhost, fragment)
        fragmentTransaction.commit()
    }
}