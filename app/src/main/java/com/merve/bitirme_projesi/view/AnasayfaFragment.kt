package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.merve.bitirme_projesi.AnasayfaFragmentDirections

import com.merve.bitirme_projesi.R
import kotlinx.android.synthetic.main.fragment_anasayfa.*

class AnasayfaFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anasayfa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //giris yap buton yönlendirme
        btnAGirisYap.setOnClickListener{
       val action_giris=AnasayfaFragmentDirections.actionAnasayfaFragment2ToGirisFragment()
          Navigation.findNavController(it).navigate(action_giris)

        }
        //kayıt ol buton yönlendirme
        btnAKayitOl.setOnClickListener{
            val action_kayit= AnasayfaFragmentDirections.actionAnasayfaFragment2ToKayitFragment()
            Navigation.findNavController(it).navigate(action_kayit)
        }


    }

}