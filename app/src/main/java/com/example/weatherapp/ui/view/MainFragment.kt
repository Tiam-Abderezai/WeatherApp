package com.example.weatherapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class MainFragment : Fragment() {
    lateinit var binding : FragmentMainBinding
    private lateinit var etCity: TextInputEditText
    private lateinit var btnLookup: MaterialButton
    val fragList: ListFragment by lazy { ListFragment() }
    val fragDetail: DetailFragment by lazy { DetailFragment() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    fun initUI(){
        etCity = binding.etCityName
        btnLookup = binding.btnLookup
        btnLookup.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_layout, fragList,"toListFrag")
                disallowAddToBackStack()
                commit()
        //                actionBar?.show()
            }
        }


    }



}