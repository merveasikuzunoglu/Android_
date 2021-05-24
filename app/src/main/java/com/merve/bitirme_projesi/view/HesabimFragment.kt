package com.merve.bitirme_projesi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_hesabim.*

class HesabimFragment : Fragment(R.layout.fragment_hesabim) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnHesabimDuzenle.setOnClickListener{
            val action_hesabimduzenle=HesabimFragmentDirections.actionHesabimFragmentToUyeBilgGuncelle()
            Navigation.findNavController(it).navigate(action_hesabimduzenle)
        }

    }

}