package com.merve.bitirme_projesi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KayitwAdresViewModel: ViewModel() {
    val kayAd= MutableLiveData<String>()
    val kaySoyad= MutableLiveData<String>()
    val kayEmail= MutableLiveData<String>()
    val kayTelefon= MutableLiveData<Int>()
    val kaySifre= MutableLiveData<String>()
    val kaySifreTekrar= MutableLiveData<String>()
    val kaySehir= MutableLiveData<String>()
    val kayIlce= MutableLiveData<String>()
    val kayAdres= MutableLiveData<String>()


    // kayıt için fonksiyonlar burada yazılır
}