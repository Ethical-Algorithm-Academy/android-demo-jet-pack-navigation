package eu.jobernas.jetpacknavigation.ui.main.c

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import eu.jobernas.jetpacknavigation.databinding.FragmentCBinding
import eu.jobernas.jetpacknavigation.models.Car

class FragmentC : Fragment() {

    companion object {
        private const val KEY_SELECT_CAR = "KEY_SELECT_CAR"
        fun getBundle(selectCar: Car): Bundle =
            Bundle().apply {
                putParcelable(KEY_SELECT_CAR, selectCar)
            }
    }

    private var binding: FragmentCBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val selectCar = arguments?.getParcelable<Car>(KEY_SELECT_CAR)
        binding = FragmentCBinding.inflate(inflater, container, false)
        binding?.apply {
            if (selectCar != null){
                messageC.text = selectCar.title
            }
        }
        return binding?.root
    }
}