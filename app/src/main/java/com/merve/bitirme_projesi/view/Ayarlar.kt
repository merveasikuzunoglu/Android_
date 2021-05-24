package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.merve.bitirme_projesi.R
import kotlinx.android.synthetic.main.fragment_ayarlar.*

class Ayarlar : Fragment(R.layout.fragment_ayarlar) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

   // override fun onCreateView(
   //     inflater: LayoutInflater, container: ViewGroup?,
   //     savedInstanceState: Bundle?
   // ): View? {
   //     // Inflate the layout for this fragment
   //     return inflater.inflate(R.layout.fragment_ayarlar, container, false)
   // }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnKullaniciBilgileri.setOnClickListener{

            val action_KullaniciBilgiGuncl = AyarlarDirections.actionAyarlarToUyeBilgGuncelle()
            Navigation.findNavController(it).navigate(action_KullaniciBilgiGuncl)
        }
        btnSifreDegis.setOnClickListener {
            val action_SifreDegisiklik = AyarlarDirections.actionAyarlarToSifreDegisklik()
            Navigation.findNavController(it).navigate(action_SifreDegisiklik)
        }
        btnKayitliKart.setOnClickListener {
            val action_KayitliKart = AyarlarDirections.actionAyarlarToOdemeKartBilgileri()
            Navigation.findNavController(it).navigate(action_KayitliKart)
        }

    }



}