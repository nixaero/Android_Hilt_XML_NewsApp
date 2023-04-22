package mob.nereek.hiltapp.ui.splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import mob.nereek.hiltapp.R

@AndroidEntryPoint
class SplashScreenFragment : Fragment(R.layout.news_splashscreen_fragment) {

    override fun onResume() {
        super.onResume()

        // Delay navigation to NewsListFragment by 2.5 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashScreenFragment_to_newsListFragment)
        }, 2500) // Delay in milliseconds

    }
}