package com.merve.bitirme_projesi.ProjectAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {
    fun downloadData(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://safe-woodland-40596.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}