package com.example.cakedemo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cakedemo.repository.MainRepository
import com.example.cakedemo.viewModel.MainViewModel


class MyViewModelFactory(private val respository: MainRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(respository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}