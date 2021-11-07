package com.example.weatherapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val actionBar: ActionBar? by lazy { supportActionBar }
    val fragLookup: MainFragment by lazy { MainFragment() }
    val fragDetail: DetailFragment by lazy { DetailFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    fun initUI() {
        actionBar?.hide()
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragLookup)
            addToBackStack(null)
            commit()
//                actionBar?.show()
        }
    }

    fun goBack(view: View?) {
        supportFragmentManager.beginTransaction().apply {
            supportFragmentManager.popBackStack()
            commit()
        }
    }
}