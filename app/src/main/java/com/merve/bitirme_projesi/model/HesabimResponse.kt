package com.merve.bitirme_projesi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HesabimResponse(
    @SerializedName("first_name")
    @Expose
    var first_name:String?=null,
    @SerializedName("last_name")
    @Expose
    var last_name:String?=null,
    @SerializedName("email")
    @Expose
    var email:String?=null,
    @SerializedName("il")
    @Expose
    var il:String?=null,
    @SerializedName("ilce")
    @Expose
    var ilce:String?=null,
    @SerializedName("adres")
    @Expose
    var adres:String?=null

){

}
