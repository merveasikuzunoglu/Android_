package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.merve.bitirme_projesi.GirisFragmentDirections

import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.viewmodel.GirisViewModel
import kotlinx.android.synthetic.main.fragment_giris.*

class GirisFragment : Fragment() {
    private lateinit var viewModel: GirisViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_giris, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProviders.of(this).get(GirisViewModel::class.java)

        btnGirisYap.setOnClickListener{
           val action_girissayfa= GirisFragmentDirections.actionGirisFragmentToMenuyeGecisActivity()
            Navigation.findNavController(it).navigate(action_girissayfa)
        }

    }

}