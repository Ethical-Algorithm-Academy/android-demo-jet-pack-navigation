package com.beatstars.testingjetpacknavigation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.beatstars.testingjetpacknavigation.R
import com.beatstars.testingjetpacknavigation.helpers.NavigationConfig
import com.beatstars.testingjetpacknavigation.models.Car
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentA : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = FragmentA()
    }

    // TODO: Check Passing data with View Model
//    private lateinit var viewModelA: ViewModelA

    val args: FragmentAArgs by navArgs()
    var selectedCar: Car? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModelA = ViewModelProvider(this).get(ViewModelA::class.java)
        selectedCar = args.selectedCar
        messageA.text = "${selectedCar?.title} + Number:${selectedCar?.number}"
        actionB.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.actionB -> {
                // New Way
                val selectedCar = Car("this is a car from A Screen", 1000)

//                val action = FragmentADirections.actionFragmentAToFragmentB(selectedCar)
//                v.findNavController().navigate(action, navOptions)

                // Old Way
//                v.findNavController().navigate(R.id.action_fragmentA_to_fragmentB, FragmentB.getBundle(selectedCar))
                // OR
//                v.findNavController().navigate(R.id.fragmentB, FragmentB.getBundle(selectedCar), navOptions)
                // OR
                v.findNavController().navigate(R.id.fragmentB,
                        FragmentBArgs(selectedCar).toBundle(),
                        NavigationConfig.defaultNavigationBuilder.build())
            }
        }
    }

}