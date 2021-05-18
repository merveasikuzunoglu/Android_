package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.viewmodel.TumDetayViewModel
import kotlinx.android.synthetic.main.fragment_giris.*
import kotlinx.android.synthetic.main.fragment_tum_kitap_detay.*


class TumKitapDetayFragment : Fragment() {
    private lateinit var viewmodel : TumDetayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tum_kitap_detay, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel=ViewModelProviders.of(this).get(TumDetayViewModel::class.java)

        TumDetaySepeteEkle.setOnClickListener{
         val action= TumKitaplarFragmentDirections.actionTumKitapDetayFragmentToSepetimFragment()
            Navigation.findNavController(it).navigate(action)
        }
        observeLiveData()

    }

    fun observeLiveData(){
        viewmodel.tumKitapDetayLiveData.observe(viewLifecycleOwner, Observer{ TumKitaplar ->
            TumKitaplar?.let {
                txtTumDetayad.text= it.tkitapad
                txtTumDetayyazar.text=it.tyazarad
                txtTumDetayyayinevi.text=it.tyayinevi
                txtTumDetaybaskiyili.text=it.tbaskiyili
                txtTumDetaysayfasayisi.text=it.tsayfasayisi
                txtTumDetayisbn.text=it.tisbn
                txtTumDetaythg.text=it.tthg
                txtTumDetayaciklama.text=it.taciklama
                txtTumDetayFiyat.text=it.tfiyat


            }

        })
    }

}