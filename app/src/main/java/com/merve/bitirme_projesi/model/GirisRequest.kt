package com.merve.bitirme_projesi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GirisRequest(
    @SerializedName("email")
    @Expose
    var email:String?=null,
    @SerializedName("password")
    @Expose
    var password:String?=null){

}
