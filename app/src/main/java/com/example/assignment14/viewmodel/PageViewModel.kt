package com.example.assignment14.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment14.model.HitsItem
import com.example.assignment14.model.Page
import com.example.assignment14.network.RetroInstance
import com.example.assignment14.utils.Constants
import com.example.assignment14.utils.checkPermission
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PageViewModel : ViewModel() {

    var pageNumber = MutableLiveData<String>()
    val livePageNumber : LiveData<String>
    get() = pageNumber

    var pageData = MutableLiveData<ArrayList<HitsItem>>()
    var apiFailure = MutableLiveData<String>()

    fun getNetworkData(context: Context){

        if (!checkPermission().checkInternetConn(context)){
            apiFailure.value = Constants.NETWORK_ERROR
            return
        }
        RetroInstance().getPageService()
            .getPage(pageNumber.value.toString())
            .enqueue(object : Callback<Page?> {
                override fun onResponse(call: Call<Page?>, response: Response<Page?>) {
                    if (response.isSuccessful && response.body() != null){
                        if (response.body()!!.hits?.isEmpty() == true){
                            apiFailure.value = Constants.EMPTY_LIST_ERROR
                            return
                        }
                        pageData.value = (response.body()!!.hits as ArrayList<HitsItem>)
                    }
                }
                override fun onFailure(call: Call<Page?>, t: Throwable) {
                    apiFailure.value = t.message.toString()
                }
            })
    }

}

