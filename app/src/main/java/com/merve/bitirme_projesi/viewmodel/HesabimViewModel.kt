package com.merve.bitirme_projesi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HesabimViewModel : ViewModel() {
    val hesapAd= MutableLiveData<String>()
    val hesapSoyad= MutableLiveData<String>()
    val hesapEmail= MutableLiveData<String>()
    val hesapTelefon= MutableLiveData<Int>()
    val hesapAdres= MutableLiveData<String>()


}