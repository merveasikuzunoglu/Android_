package com.merve.bitirme_projesi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GirisFailEmailResponse(
    @SerializedName("email")
    @Expose
    val email: List<String>
)