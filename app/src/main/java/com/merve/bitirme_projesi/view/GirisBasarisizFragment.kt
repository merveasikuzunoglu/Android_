package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.merve.bitirme_projesi.R
import kotlinx.android.synthetic.main.fragment_giris_basarisiz.*


class GirisBasarisizFragment : Fragment(R.layout.fragment_giris_basarisiz) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBasarisizKayit.setOnClickListener {
            val actionbkayit=GirisBasarisizFragmentDirections.actionGirisBasarisizFragmentToKayitFragment()
            Navigation.findNavController(it).navigate(actionbkayit)

        }
        btnBasarisizGiris.setOnClickListener {
            val actionbgiris=GirisBasarisizFragmentDirections.actionGirisBasarisizFragmentToGirisFragment()
            Navigation.findNavController(it).navigate(actionbgiris)

        }

    }
}