package com.merve.bitirme_projesi.ProjectAPI

import com.merve.bitirme_projesi.model.MyInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {

    private val client= OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()


    fun downloadData(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://safe-woodland-40596.herokuapp.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}