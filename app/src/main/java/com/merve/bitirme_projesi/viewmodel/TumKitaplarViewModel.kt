package com.merve.bitirme_projesi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merve.bitirme_projesi.model.TumKitaplar

class TumKitaplarViewModel : ViewModel() {
    val kitaplar= MutableLiveData<List<TumKitaplar>>()

}