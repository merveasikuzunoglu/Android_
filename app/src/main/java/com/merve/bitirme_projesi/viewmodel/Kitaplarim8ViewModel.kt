package com.merve.bitirme_projesi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merve.bitirme_projesi.model.KisiselKitap

class Kitaplarim8ViewModel : ViewModel() {
    val kisiselkitaplar= MutableLiveData<List<KisiselKitap>>()
}