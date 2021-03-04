package com.beatstars.testingjetpacknavigation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.beatstars.testingjetpacknavigation.R
import com.beatstars.testingjetpacknavigation.helpers.NavigationConfig
import com.beatstars.testingjetpacknavigation.models.Car
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = FragmentHome()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        actionB.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.actionB -> {
                // New Way
                val selectedCar = Car("This is a car from Home Screen", 1000)
                // With Segues
//                val action = FragmentADirections.actionFragmentAToFragmentB(selectedCar)
//                v.findNavController().navigate(action)

                // Compatible with Old Way
                v.findNavController().navigate(R.id.fragmentB,
                        FragmentBArgs(selectedCar).toBundle(),
                        NavigationConfig.defaultNavigationBuilder.build())

            }
        }
    }

}