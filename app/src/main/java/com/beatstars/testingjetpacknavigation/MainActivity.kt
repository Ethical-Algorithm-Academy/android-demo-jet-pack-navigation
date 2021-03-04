package com.beatstars.testingjetpacknavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.main_nav_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Setup Bottom Navigation
//        bottom_navigation.setupWithNavController(navController)

        // Setup Top Navigation
//        val appBarConfiguration = AppBarConfiguration(
//                topLevelDestinationIds = setOf (
//                        R.id.fragmentHome,
//                        R.id.fragmentNotifications,
//                        R.id.fragmentMenu
//                )
//        )
//        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        bottomNavigationView.apply {
            setupWithNavController(navController)
//            // Note: This adds navigation like youtube and instagram.
//            setOnNavigationItemSelectedListener {
//                item -> onNavDestinationSelected(item, navController)
//            }
        }
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    /**
     * Note:
     * We have overridden the onSupportNavigateUp() method, this will delegate the system up button call with the NavController.
     */
//    override fun onSupportNavigateUp() = findNavController(R.id.main_nav_fragment).navigateUp()
}