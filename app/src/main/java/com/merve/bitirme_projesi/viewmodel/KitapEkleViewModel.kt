package com.merve.bitirme_projesi.viewmodel

import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merve.bitirme_projesi.model.KisiselKitap
import com.merve.bitirme_projesi.model.TumKitaplar

class KitapEkleViewModel:ViewModel() {
    val eKitapad =MutableLiveData<String>()
    val eYazarad=MutableLiveData<String>()
    val eYayinevi=MutableLiveData<String>()
    val eBaskiyili=MutableLiveData<String>()
    val eSayfasayisi=MutableLiveData<String>()
    val eIsbn=MutableLiveData<String>()
    val eThg=MutableLiveData<String>()
    val eAciklama=MutableLiveData<String>()
    val eKargo=MutableLiveData<String>()









}