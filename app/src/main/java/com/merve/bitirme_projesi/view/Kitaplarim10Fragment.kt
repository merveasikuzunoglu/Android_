package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation


import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.viewmodel.Kitaplarim10ViewModel
import kotlinx.android.synthetic.main.fragment_kitaplarim10.*


class Kitaplarim10Fragment : Fragment(R.layout.fragment_kitaplarim10) {
    private lateinit var viewmodel :Kitaplarim10ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // viewmodel=ViewModelProviders.of(this).get(Kitaplarim10ViewModel::class.java)
        //viewmodel = ViewModel
        //viewmodel = ViewModelProviders.of(this).get(Kitaplarim10ViewModel::class.java)

        //kitap bilgisi düzenledikten sonra menuye geç
        btnK10kaydet.setOnClickListener{
                val kitap10=Kitaplarim10FragmentDirections.actionKitaplarim10FragmentToKitaplarim8Fragment()
            Navigation.findNavController(it).navigate(kitap10)

        }



    }

    }


