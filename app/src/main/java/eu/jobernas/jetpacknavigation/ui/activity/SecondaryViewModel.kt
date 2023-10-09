package eu.jobernas.jetpacknavigation.ui.activity

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondaryViewModel: ViewModel() {

    companion object {
        const val KEY_PARAM = "PARAM_KEY"
    }

    val onDataLoaded: MutableLiveData<String> = MutableLiveData("")

    fun load(arguments: Bundle?) {
        onDataLoaded.postValue(arguments?.getString(KEY_PARAM).orEmpty())
    }
}