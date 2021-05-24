package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.merve.bitirme_projesi.R


import kotlinx.android.synthetic.main.fragment_uygulama_baslangic.*

class UygulamaBaslangicFragment : Fragment(R.layout.fragment_uygulama_baslangic) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnUygulama.setOnClickListener{
            val action_uygulama= UygulamaBaslangicFragmentDirections.actionUygulamaBaslangicFragmentToAnasayfaFragment2()
            Navigation.findNavController(it).navigate(action_uygulama)
        }
    }



}