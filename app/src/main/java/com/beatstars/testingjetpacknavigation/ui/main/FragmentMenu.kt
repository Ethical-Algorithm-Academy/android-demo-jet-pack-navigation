package com.beatstars.testingjetpacknavigation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.beatstars.testingjetpacknavigation.R

class FragmentMenu : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = FragmentMenu()
    }

    private lateinit var viewModelA: ViewModelA

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.actionB -> {
//                // New Way
//                val selectedCar = Car("this is a test car", 1000)
//                val action = FragmentADirections.actionFragmentAToFragmentB(selectedCar)
//                v.findNavController().navigate(action)
//
//                // Old Way
////                v.findNavController().navigate(R.id.action_fragmentA_to_fragmentB, FragmentB.getBundle(selectedCar))
//
//            }
//        }
    }

}