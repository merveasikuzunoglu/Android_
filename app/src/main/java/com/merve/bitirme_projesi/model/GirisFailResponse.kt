package com.merve.bitirme_projesi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GirisFailResponse(
    @SerializedName("non_field_errors")
    @Expose
    val non_field_errors: List<String>
)