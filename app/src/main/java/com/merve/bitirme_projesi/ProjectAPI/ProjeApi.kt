package com.merve.bitirme_projesi.ProjectAPI

import com.merve.bitirme_projesi.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ProjeApi {
    @POST("kullanici/api/api/rest-auth/login/")
    fun login( @Body loginrequest: GirisRequest ): Call<GirisResponse>

    @POST("kullanici/api/users/")
    fun register( @Body registerrequest: KayitRequest ): Call<KayitResponse>

}