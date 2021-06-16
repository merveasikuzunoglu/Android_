package com.merve.bitirme_projesi.model

import okhttp3.Interceptor
import okhttp3.Response


class MyInterceptor : Interceptor{


    override fun intercept(chain: Interceptor.Chain): Response {

        val hrequest = chain.request()
            .newBuilder()
            .addHeader("Content-Type","application/json")
            .addHeader("Authorization", "Token 114c7446578d548a6b3cbf6c089fccf5d8a6d893")
            .build()


        return chain.proceed(hrequest)

    }

//  114c7446578d548a6b3cbf6c089fccf5d8a6d893

   // val token="d48dcc03df28de9184ac6c232abeeacd45de0593"


}

