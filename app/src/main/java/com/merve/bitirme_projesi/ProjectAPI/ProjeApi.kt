package com.merve.bitirme_projesi.ProjectAPI

import com.merve.bitirme_projesi.model.*
import retrofit2.Call
import retrofit2.http.*

interface ProjeApi {
    @POST("kullanici/api/api/rest-auth/login/")
    fun login( @Body loginrequest: GirisRequest ): Call<GirisResponse>

    @POST("kullanici/api/users/")
    fun register( @Body registerrequest: KayitRequest ): Call<KayitResponse>

    //@Headers(value=["Content-Type:application/json" , "Authorization:Token xxx"] )
    @GET("kullanici/api/guncelle")
    fun hesabim(@Header("Auth") authToken:String):Call<HesabimResponse>

    @PUT("kullanici/api/guncelle")
    fun updatehesap(@Body kayitRequest: KayitRequest):Call<KayitResponse>




}