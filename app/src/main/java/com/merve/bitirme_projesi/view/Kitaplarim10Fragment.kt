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


class Kitaplarim10Fragment : Fragment() {
    private lateinit var viewmodel :Kitaplarim10ViewModel

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

       // viewmodel=ViewModelProviders.of(this).get(Kitaplarim10ViewModel::class.java)
        //viewmodel = ViewModel
        //viewmodel = ViewModelProviders.of(this).get(Kitaplarim10ViewModel::class.java)

        //kitap bilgisi düzenledikten sonra menuye geç
        btnK10kaydet.setOnClickListener{
            val action_kitapduzenleyipkaydet=
                 Kitaplarim10FragmentDirections.actionKitaplarim10FragmentToMenuyeGecisActivity()
            Navigation.findNavController(it).navigate(action_kitapduzenleyipkaydet)
        }



    }

    }


