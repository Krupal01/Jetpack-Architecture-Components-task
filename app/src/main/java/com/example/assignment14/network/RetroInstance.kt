package com.example.assignment14.network

import com.example.assignment14.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    private var retroInstance : Retrofit?= null

    fun getRetroInstance():Retrofit{
        if (retroInstance == null){
            retroInstance = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retroInstance as Retrofit
    }

    fun getPageService(): PageService {
        return RetroInstance().getRetroInstance().create(PageService::class.java)
    }
}