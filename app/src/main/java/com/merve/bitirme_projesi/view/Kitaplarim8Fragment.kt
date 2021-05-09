package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager

import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.adapter.Kitaplarim8RecyclerAdapter
import com.merve.bitirme_projesi.model.KisiselKitap
import com.merve.bitirme_projesi.viewmodel.Kitaplarim8ViewModel
import kotlinx.android.synthetic.main.fragment_kitaplarim8.*
import kotlinx.android.synthetic.main.recycler_row_kitaplarim8.*

class Kitaplarim8Fragment : Fragment() {

    private lateinit var viewModel : Kitaplarim8ViewModel
    private var Kitaplarim8Adapter : Kitaplarim8RecyclerAdapter? = null


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

        //fragmentta bulunan listede bir satırda kaç tane ürün gösterileceğini yazdık
        recyclerViewKitaplarim.layoutManager = GridLayoutManager(context,2)
        recyclerViewKitaplarim.adapter=Kitaplarim8Adapter

        viewModel=ViewModelProviders.of(this).get(Kitaplarim8ViewModel::class.java)

        observeLiveData()


    }

    fun observeLiveData(){
        viewModel.kisiselkitaplar.observe(viewLifecycleOwner, Observer { kisiselKitap ->
            kisiselKitap?.let{
                // eğer kitaplar liste olarak gelebiliyorsa

                recyclerViewKitaplarim.visibility=View.VISIBLE //recyclerview görünür yapıldı
                Kitaplarim8Adapter?.kisiselKitaplarListesiGuncelle(kisiselKitap)
            }

        })
    }

}