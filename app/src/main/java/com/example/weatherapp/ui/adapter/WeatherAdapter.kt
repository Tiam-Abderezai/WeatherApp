package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.model.Weather

class WeatherAdapter  constructor(
) : RecyclerView.Adapter<WeatherAdapter.DataViewHolder>() {

    private var items: ArrayList<Weather> = ArrayList()

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Weather) {
//            itemView.weaweatvwwetvtv_weather
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_weather, parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, items[position].main, Toast.LENGTH_SHORT).show()
        }
    }
        fun addData(items: List<Weather>) {
            this.items.apply {
                clear()
                addAll(items)
            }
        }


}