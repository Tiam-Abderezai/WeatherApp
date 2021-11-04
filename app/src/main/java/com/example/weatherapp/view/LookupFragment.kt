package com.example.weatherapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.databinding.FragmentListBinding
import com.example.weatherapp.databinding.FragmentLookupBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import androidx.fragment.app.FragmentActivity

import android.app.Activity




class LookupFragment : Fragment() {
    lateinit var binding : FragmentLookupBinding
    private lateinit var etCity: TextInputEditText
    private lateinit var btnLookup: MaterialButton
    val fragList: ListFragment by lazy { ListFragment() }
    val fragDetail: DetailFragment by lazy { DetailFragment() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLookupBinding.inflate(inflater, container, false)
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