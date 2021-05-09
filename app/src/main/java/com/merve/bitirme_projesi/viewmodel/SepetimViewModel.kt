package com.merve.bitirme_projesi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merve.bitirme_projesi.model.Sepet

class SepetimViewModel: ViewModel() {
    val alinanKitaplar= MutableLiveData<List<Sepet>>()
    val totalSepet=MutableLiveData<Int>()
}

//internetten veri çekme işlemlerini buralarda yapıcaz