package mob.nereek.hiltapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import mob.nereek.hiltapp.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the activity content view
        setContentView(R.layout.activity_main)

        // Find the NavHostFragment and retrieve its NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        // Navigate to the NewsListFragment
        navController.navigate(R.id.splashScreenFragment)

        // Hide the ActionBar
        supportActionBar?.hide()

    }
}