package com.beatstars.testingjetpacknavigation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.beatstars.testingjetpacknavigation.R
import com.beatstars.testingjetpacknavigation.helpers.NavigationConfig
import com.beatstars.testingjetpacknavigation.models.Car
import kotlinx.android.synthetic.main.fragment_b.*

class FragmentB : Fragment(),
        View.OnClickListener {

    companion object {
        private const val KEY_SELECTED_CAR = "SELECTED_CAR_KEY"

        /**
         * Old Way
         */
        fun newInstance(selectedCar: Car) =
            FragmentB().apply {
                arguments = getBundle(selectedCar)
            }

        fun getBundle(selectedCar: Car): Bundle =
            Bundle().apply {
                putParcelable(KEY_SELECTED_CAR, selectedCar)
            }
    }

    val args: FragmentBArgs by navArgs()
    var selectedCar: Car? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Old Way compatibility
//        messageB.text = arguments?.getParcelable<Car>(KEY_SELECTED_CAR)?.title

        // New Way
        selectedCar = args.selectedCar
        messageB.text = "${selectedCar?.title} + Number:${selectedCar?.number}"
        actionC.setOnClickListener(this)
    }

    /**
     * View.OnClickListener
     */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.actionC -> {
                selectedCar?.title = "Changed Name"
                v.findNavController().navigate(R.id.fragmentC,
                        FragmentCArgs(selectedCar).toBundle(),
                        NavigationConfig.defaultNavigationBuilder.build())
            }
        }

    }

}