package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.merve.bitirme_projesi.Kitaplarim9FragmentArgs

import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.viewmodel.Kitaplarim9ViewModel
import kotlinx.android.synthetic.main.fragment_kitaplarim9.*

class Kitaplarim9Fragment : Fragment() {
    private var kitapId=0
    private lateinit var viewmodel : Kitaplarim9ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kitaplarim9, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel=ViewModelProviders.of(this).get(Kitaplarim9ViewModel::class.java)


        arguments?.let{
            kitapId= Kitaplarim9FragmentArgs.fromBundle(it).kitapId
        }

        observeLiveData()
    }


    fun observeLiveData(){
        viewmodel.tumKitaplarim9LiveData.observe(viewLifecycleOwner, Observer{ kisiselKitap ->
            kisiselKitap?.let {
                txtK9ad.text=it.kkitapad
                txtK9yazar.text=it.kyazar
                txtK9yayinevi.text=it.kyayinevi
                txtK9baskiyili.text=it.kbaskiyil
                txtK9sayfasayisi.text=it.ksayfasayi
                txtK9isbn.text=it.kisbn
                txtK9thg.text=it.kthg
                txtK9kargo.text=it.kkargo
                txtK9aciklama.text=it.kaciklama
                txtK9Fiyat.text = it.kfiyat
            }

        })

    }


}