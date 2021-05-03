package com.merve.bitirme_projesi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_hesabim.*
import kotlinx.android.synthetic.main.fragment_hesabim.btnHesabimDüzenle
import kotlinx.android.synthetic.main.fragment_sepetim.*

class SepetimFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sepetim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSepetOnayla.setOnClickListener{
            val action_sepetonay=SepetimFragmentDirections.actionSepetimFragmentToOdemeAdresFragment()
            Navigation.findNavController(it).navigate(action_sepetonay)
        }

        //sil butonuna ne yazılacak?

    }

}