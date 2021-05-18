package com.merve.bitirme_projesi.ProjectAPI

import com.merve.bitirme_projesi.model.GirisRequest
import com.merve.bitirme_projesi.model.GirisResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ProjeApi {
    @POST("kullanici/api/api/rest-auth/login/")
    fun login(
        @Body loginrequest: GirisRequest
    ): Call<GirisResponse>
}