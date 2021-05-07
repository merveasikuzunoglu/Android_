package com.merve.bitirme_projesi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_adres_ekle.*
import kotlinx.android.synthetic.main.fragment_kayit.*


class AdresEkle : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adres_ekle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnKayitOl.setOnClickListener{
            val action_Kayit=AdresEkleDirections.actionAdresEkleToMenuyeGecisActivity()
            Navigation.findNavController(it).navigate(action_Kayit)
        }
    }
}