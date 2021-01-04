package com.rikihikmianto.rikicovid.api

import com.rikihikmianto.rikicovid.model.IndonesiaResponse
import com.rikihikmianto.rikicovid.model.ProvinsiResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("indonesia/provinsi")
    fun getProvinsi(): Call<ArrayList<ProvinsiResponse>>
}