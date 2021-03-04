package com.beatstars.testingjetpacknavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(main_toolbar)
        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.main_nav_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        // Setup Bottom Navigation
        bottom_navigation.apply {
            setupWithNavController(navController)
        }

        // Setup Action Bar Navigation
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf (
                R.id.fragmentHome,
                R.id.fragmentNotifications,
                R.id.fragmentMenu
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    /**
     * Note:
     * We have overridden the onSupportNavigateUp() method, this will delegate the system up button call with the NavController.
     */
    override fun onSupportNavigateUp() = findNavController(R.id.main_nav_fragment).navigateUp()
}