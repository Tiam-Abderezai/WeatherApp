package com.example.weatherapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment(){
    private lateinit var binding : FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    fun initUI() {
        binding.apply {
//            btnLookup.setOnClickListener {
//                if (etCityName.text.toString().isNotEmpty()) {
//                    val action =
//                        MainFragmentDirections.actionMainFragmentToListFragment(etCityName.text.toString())
//                    findNavController().navigate(action)
//                } else {
//                    Toast.makeText(context, "City cannot be empty", Toast.LENGTH_SHORT).show()
//                }
//            }
        }

    }

}