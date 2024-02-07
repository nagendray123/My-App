package com.example.myapp.interfaceapi
import com.example.myapp.model.DataModel

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("photos")
    fun  getData(): Call<DataModel>
}