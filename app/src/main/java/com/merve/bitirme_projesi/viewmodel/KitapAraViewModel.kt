package com.merve.bitirme_projesi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merve.bitirme_projesi.model.KitapAra

class KitapAraViewModel : ViewModel() {
    // ilgili fragmentın layout kısmında ne nasıl tutuluyorsa burada gösterilir

    val search= MutableLiveData<String>()
    val kitapAra=MutableLiveData<List<KitapAra>>()

}