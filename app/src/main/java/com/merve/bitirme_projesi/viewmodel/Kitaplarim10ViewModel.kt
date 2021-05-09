package com.merve.bitirme_projesi.viewmodel

import android.media.Image
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merve.bitirme_projesi.model.Kargo
import com.merve.bitirme_projesi.model.KisiselKitap

class Kitaplarim10ViewModel: ViewModel() {
    val k10image=MutableLiveData<Image>()
    val k10edtad=MutableLiveData<String>()
    val k10edtyayinevi=MutableLiveData<String>()
    val k10edtbaskiyil=MutableLiveData<String>()
    val k10edtsayfasay=MutableLiveData<Int>()
    val k10edtisbn=MutableLiveData<String>()
    val k10edtthg=MutableLiveData<String>()
    val k10edtkargo=MutableLiveData<List<Kargo>>()
    val k10edtaciklama=MutableLiveData<String>()
    val k10edtfiyat=MutableLiveData<Int>()

    //bunlar eğer jsonda liste şeklinde ve tüm listelerdeda aynı özellikler varsa örneğin tüm kitap için
    //yazılan isimlerle kisisel kitap için yazılan isimler aynı ise liste şeklinde ttuluyor deriz



}