package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.adapter.TumKitaplarRecyclerAdapter
import com.merve.bitirme_projesi.viewmodel.TumKitaplarViewModel
import kotlinx.android.synthetic.main.fragment_tum_kitaplar.*

class TumKitaplarFragment : Fragment() {
    private lateinit var viewmodel:TumKitaplarViewModel
    private val tumkitapAdapter:TumKitaplarRecyclerAdapter?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tum_kitaplar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //fragmentta bulunan listede bir satırda kaç tane ürün gösterileceğini yazdık
        recyclerViewTumKitaplar.layoutManager= GridLayoutManager(context,2)
        recyclerViewTumKitaplar.adapter= tumkitapAdapter

        //view model ile fragmenti birbirine bağladık
        viewmodel = ViewModelProviders.of(this).get(TumKitaplarViewModel::class.java)

        //sonrasında TumKitaplarviewmodel içerisinde yazdığımız intetnetten çekme fonksiyonunu burda çağırabiliri

        observeLiveDataTum()


    }

    fun observeLiveDataTum(){


        viewmodel.kitaplar.observe(viewLifecycleOwner, Observer { TumKitaplar ->
            TumKitaplar?.let{
                recyclerViewTumKitaplar.visibility=View.VISIBLE
                tumkitapAdapter?.tumkitaplarlistesiGuncelle(TumKitaplar)
            }

        })
    }


}