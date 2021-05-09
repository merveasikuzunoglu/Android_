package com.merve.bitirme_projesi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GirisViewModel: ViewModel() {

    val gEmail= MutableLiveData<String>()
    val gSifre=MutableLiveData<String>()

    //kullanıcı girişini doğru yapıp yapmadığını denetlemek için burada fonksiyon içinde kod yazılır ve
    //sonrasında bu kod girisFragment onViewvCreated Altında çağrılır
    //aynı zamanda internettten alınan veriler içinde fonksiyonlu kodlar oluşturulup o fonksiyonlarda girisFragment onViewvCreated Altında çağrılır
}