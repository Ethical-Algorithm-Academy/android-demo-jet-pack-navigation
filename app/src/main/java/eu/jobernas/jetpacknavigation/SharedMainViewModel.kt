package eu.jobernas.jetpacknavigation

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eu.jobernas.jetpacknavigation.models.Moto

class SharedMainViewModel: ViewModel() {

    val onDataChanged: MutableLiveData<Moto?> = MutableLiveData()

    fun load() {
        onDataChanged.postValue(Moto("33", "CBR", Color.BLUE, "Honda", false))
    }
}