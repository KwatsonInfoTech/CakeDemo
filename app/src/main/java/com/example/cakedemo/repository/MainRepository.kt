package com.example.cakedemo.repository

import com.example.cakedemo.network.retrofitService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class MainRepository @Inject constructor(private val retrofitService: retrofitService) {

     suspend fun getAllCakeFromAPI() = retrofitService.getCakeListService()
}