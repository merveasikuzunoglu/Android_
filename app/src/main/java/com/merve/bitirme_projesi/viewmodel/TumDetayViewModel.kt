package com.merve.bitirme_projesi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merve.bitirme_projesi.model.TumKitaplar

class TumDetayViewModel: ViewModel() {

    val tumKitapDetayLiveData= MutableLiveData<TumKitaplar>()
}