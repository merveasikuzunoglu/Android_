package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.merve.bitirme_projesi.R
import kotlinx.android.synthetic.main.fragment_sifre_degisklik.*


class SifreDegisklik : Fragment(R.layout.fragment_sifre_degisklik) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSifreDegis.setOnClickListener{
           val actionsifredegis=SifreDegisklikDirections.actionSifreDegisklikToAnasayfaFragment2()
            Navigation.findNavController(it).navigate(actionsifredegis)
        }
    }

}