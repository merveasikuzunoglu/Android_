package com.merve.bitirme_projesi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_hesabim.*
import kotlinx.android.synthetic.main.fragment_hesabim.btnHesabimDüzenle
import kotlinx.android.synthetic.main.fragment_kitaplarim10.*


class Kitaplarim10Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kitaplarim10, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //kitap bilgisi düzenledikten sonra menuye geç
        btnK10kaydet.setOnClickListener{
            val action_kitapduzenleyipkaydet=Kitaplarim10FragmentDirections.actionKitaplarim10FragmentToMenuyeGecisActivity()
            Navigation.findNavController(it).navigate(action_kitapduzenleyipkaydet)
        }

    }


}