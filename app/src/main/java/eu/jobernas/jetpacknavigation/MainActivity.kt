package eu.jobernas.jetpacknavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import eu.jobernas.jetpacknavigation.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar)
        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.main_nav_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        // Setup Bottom Navigation
        binding.apply {
            bottomNavigation.setupWithNavController(navController)
        }

        // Setup Action Bar Navigation
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf (
                R.id.fragmentHome,
                R.id.fragmentNotifications,
                R.id.fragmentMenu,
                R.id.fragmentSettings
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    /**
     * Note:
     * We have overridden the onSupportNavigateUp() method, this will delegate the system up button call with the NavController.
     */
    override fun onSupportNavigateUp() = findNavController(R.id.main_nav_fragment).navigateUp()

//    override fun onBackPressed() {
//        findNavController(R.id.main_nav_fragment).popBackStack()
//    }
}