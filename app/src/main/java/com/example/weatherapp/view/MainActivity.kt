package com.example.weatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.ActionBar
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.databinding.FragmentListBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val actionBar: ActionBar? by lazy { supportActionBar }
    val fragLookup: LookupFragment by lazy { LookupFragment() }
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