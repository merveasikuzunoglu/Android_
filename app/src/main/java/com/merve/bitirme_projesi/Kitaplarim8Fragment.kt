package com.merve.bitirme_projesi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_hesabim.*
import kotlinx.android.synthetic.main.fragment_hesabim.btnHesabimDüzenle
import kotlinx.android.synthetic.main.fragment_kitaplarim8.*

class Kitaplarim8Fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kitaplarim8, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //butona basınca kitap bilgi düzenleme ekranı
        btnDegisiklik8_1.setOnClickListener{
            val action_kitapdegisiklik=Kitaplarim8FragmentDirections.actionKitaplarim8FragmentToKitaplarim10Fragment()
            Navigation.findNavController(it).navigate(action_kitapdegisiklik)
        }

        //image a tıklayınca kitap görüntüle ekranı
        imageButtonKitapGoruntule.setOnClickListener{
            val action_kitapgoruntule=Kitaplarim8FragmentDirections.actionKitaplarim8FragmentToKitaplarim9Fragment()
            Navigation.findNavController(it).navigate(action_kitapgoruntule)
        }

    }

}