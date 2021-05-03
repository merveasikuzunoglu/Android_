package com.merve.bitirme_projesi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_giris.*
import kotlinx.android.synthetic.main.fragment_giris.btnGiris
import kotlinx.android.synthetic.main.fragment_uygulama_baslangic.*

class UygulamaBaslangicFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_uygulama_baslangic, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnUygulama.setOnClickListener{
            val action_uygulama= UygulamaBaslangicFragmentDirections.actionUygulamaBaslangicFragmentToAnasayfaFragment2()
            Navigation.findNavController(it).navigate(action_uygulama)
        }
    }



}