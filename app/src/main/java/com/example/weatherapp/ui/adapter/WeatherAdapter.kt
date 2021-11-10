package com.example.weatherapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.databinding.ItemWeatherBinding
import com.example.weatherapp.ui.view.ListFragmentDirections
import kotlinx.android.synthetic.main.item_weather.view.*
import retrofit2.Response
import javax.inject.Inject
import kotlin.math.log

class WeatherAdapter @Inject constructor(
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private val items = mutableListOf<Response<WeatherResponse>>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = items[position]
        Log.d("WeatherAdapter", "onBindViewHolder: $item")
        holder.bind(item)
        val action =
            item.body()?.let {
                ListFragmentDirections.actionListFragmentToDetailFragment(
                    it
                )
            }
        holder.itemView.setOnClickListener {
            action?.let { weatherResponse -> it.findNavController().navigate(weatherResponse) }
//            Toast.makeText(holder.itemView.context, items[position], Toast.LENGTH_SHORT).show()
        }
    }

    class WeatherViewHolder(itemView: ItemWeatherBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(item: Response<WeatherResponse>) {
            val weather = item.body()?.weather?.get(0)?.description.toString()
            val temp = item.body()?.main?.temp.toString()
            Log.d("WeatherAdapter", "WeatherViewHolder: $weather $temp")

            itemView.tv_weather.text = weather
            itemView.tv_temp.text = "Temp $temp"
        }
    }

    fun addData(items: Response<WeatherResponse>) {
        this.items.apply {
            clear()
            addAll(mutableListOf(items))
            notifyDataSetChanged()
        }
    }
}