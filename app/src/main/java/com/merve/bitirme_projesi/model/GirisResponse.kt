package com.merve.bitirme_projesi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.json.JSONArray

data class GirisResponse(
    @SerializedName("key")
    @Expose
    var key:String?=null,


)

