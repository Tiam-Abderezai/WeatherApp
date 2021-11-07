package com.example.weatherapp.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.databinding.FragmentListBinding
import com.example.weatherapp.ui.adapter.WeatherAdapter
import com.example.weatherapp.ui.viewmodel.WeatherViewModel
import com.example.weatherapp.utils.Status
import javax.inject.Inject


class ListFragment : Fragment(R.layout.fragment_list) {
    lateinit var binding: FragmentListBinding
    val fragDetail: DetailFragment by lazy { DetailFragment() }
    val fragLookup: LookupFragment by lazy { LookupFragment() }
    private val weatherViewModel: WeatherViewModel by activityViewModels()
    @Inject
    lateinit var adapter: WeatherAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        initUI()
        initAPI()
        return binding.root
    }

    fun initUI() {
        binding.vBackArrow.setOnClickListener {
            binding.recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.addItemDecoration(
                DividerItemDecoration(
                    binding.recyclerView.context,
                    (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )

            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_layout, fragLookup,"toLookupFrag")
                disallowAddToBackStack()
                commit()
            }
        }
    }

    private fun initAPI() {
        weatherViewModel.fetchWeatherData().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.i("MainActivity", "Success: ${it.message}")
                    binding.progressBar.visibility = View.INVISIBLE
                    it.data?.let { usersData -> renderList(usersData) }
                    binding.recyclerView.visibility = View.INVISIBLE
                }
                Status.LOADING -> {
                    Log.i("MainActivity", "Loading: ${it.message}")
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.recyclerView.visibility = View.INVISIBLE
                }
                Status.ERROR -> {
                    //Handle Error
                    Log.d("MainActivity", "Error: ${it.message}")
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun renderList(items: List<Weather>) {
        adapter.apply {
            addData(items)
            notifyDataSetChanged()
        }
    }
}