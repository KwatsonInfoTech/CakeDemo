package com.example.cakedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cakedemo.adapter.CakeAdapter
import com.example.cakedemo.databinding.ActivityMainBinding
import com.example.cakedemo.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var activityBinding: ActivityMainBinding
    private val cakeAdapter = CakeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        //adapter and layout
        activityBinding.recyclerView.adapter = cakeAdapter
        activityBinding.recyclerView.layoutManager = LinearLayoutManager(this)

        callService()
        getDataToDisplay()

    }


    fun callService() {

        viewModel.getCakeDataFromVM()

    }

    fun getDataToDisplay() {
        // the UI will request live data and not VM
        // VM observes changes in live data

        viewModel.respData.observe(this) {
            Log.i("cake", it.get(0).title)
            cakeAdapter.submitList(it)


        }
    }

}