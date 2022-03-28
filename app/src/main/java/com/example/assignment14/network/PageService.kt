package com.example.assignment14.network

import com.example.assignment14.model.Page
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PageService {

    @GET("search_by_date")
    fun getPage(@Query("page")pageNumber : String) : Call<Page>
}