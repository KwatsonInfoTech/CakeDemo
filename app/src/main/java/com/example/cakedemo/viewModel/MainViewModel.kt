package com.example.cakedemo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cakedemo.model.Cake_ItemsItem
import com.example.cakedemo.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel

class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel() {

    val errorMsg = MutableLiveData<String>()
    val respData = MutableLiveData<List<Cake_ItemsItem>>()
    var job: Job? = null

    fun getCakeDataFromVM() {
        job = CoroutineScope(Dispatchers.IO).launch {

            val response = repository.getAllCakeFromAPI()
            withContext(Dispatchers.Main) {
                respData.postValue(response.body())

            }


        }
    }
}