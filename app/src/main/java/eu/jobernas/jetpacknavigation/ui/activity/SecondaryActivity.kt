package eu.jobernas.jetpacknavigation.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import eu.jobernas.jetpacknavigation.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity() {

    companion object {
        private val TAG = SecondaryActivity::class.java.simpleName
    }

    private lateinit var secondaryViewModel: SecondaryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        secondaryViewModel = ViewModelProvider(this)[SecondaryViewModel::class.java]
        binding.apply {
            secondaryViewModel.apply {
                load(intent.extras)
                binding.apply {
                    onDataLoaded.observe(this@SecondaryActivity) {
                            Log.d(TAG, it)
                            secondaryTextView.text = it
                        }
                }
            }
        }
    }
}