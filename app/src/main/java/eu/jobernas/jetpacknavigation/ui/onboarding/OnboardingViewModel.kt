package eu.jobernas.jetpacknavigation.ui.onboarding

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnboardingViewModel: ViewModel() {

    companion object {
        const val KEY_PARAM = "PARAM_KEY"
    }

    val onDataLoaded: MutableLiveData<String> = MutableLiveData("")

    fun load(arguments: Bundle?) {
        onDataLoaded.postValue(arguments?.getString(KEY_PARAM).orEmpty())
    }
}