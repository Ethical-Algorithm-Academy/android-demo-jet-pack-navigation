package eu.jobernas.jetpacknavigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import eu.jobernas.jetpacknavigation.databinding.ActivityMainBinding
import eu.jobernas.jetpacknavigation.ui.activity.SecondaryActivity
import eu.jobernas.jetpacknavigation.ui.activity.SecondaryViewModel.Companion.KEY_PARAM

class MainActivity : AppCompatActivity() {

    private lateinit var sharedMainViewModel: SharedMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar)
        sharedMainViewModel = ViewModelProvider(this)[SharedMainViewModel::class.java]
        sharedMainViewModel.load()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        // Setup Bottom Navigation
        binding.apply {
            bottomNavigation.setupWithNavController(navController)
            mainActionFloatingButton.setOnClickListener {
                val intent = Intent(this@MainActivity, SecondaryActivity::class.java)
                intent.putExtra(KEY_PARAM, "This is a String Value passed through a Bundle in an Intent!")
                startActivity(intent)
            }
        }

        // Setup Action Bar Navigation
        val appBarConfiguration =
            AppBarConfiguration(topLevelDestinationIds = setOf(R.id.id_nav_screen,
                                                               R.id.dialog_nav_screen,
                                                               R.id.deeplink_nav_screen,
                                                               R.id.action_nav_screen))
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