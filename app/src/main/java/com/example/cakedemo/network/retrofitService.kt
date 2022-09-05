package com.example.cakedemo.network

import com.example.cakedemo.model.Cake_ItemsItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface retrofitService {
    // perform network requests - separate threads- coroutines
    @GET(APIEndPoints.API_CAKE_LIST)
    suspend fun getCakeListService(): Response<List<Cake_ItemsItem>>

    companion object {

        var RetrofitService: retrofitService? = null

        fun getRetrofitInstance() : retrofitService{

            if(retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(APIEndPoints.Base_Url) // link to communicate to get data
                    .addConverterFactory(GsonConverterFactory.create()) // converting the JSON to relevant format(kotlin)
                    .build()
                RetrofitService = retrofit.create(retrofitService::class.java)

            }

            return RetrofitService!!

        }
    }
}