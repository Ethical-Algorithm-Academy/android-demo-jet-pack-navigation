package eu.jobernas.jetpacknavigation.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    companion object {
        private val TAG = OnboardingActivity::class.java.simpleName
    }

    private lateinit var onboardingViewModel: OnboardingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onboardingViewModel = ViewModelProvider(this)[OnboardingViewModel::class.java]
        onboardingViewModel.apply {
            load(intent.extras)
            binding.apply {
                onDataLoaded
                    .observe(this@OnboardingActivity) {
                    Log.d(TAG, it)
                }
            }
        }
    }
}