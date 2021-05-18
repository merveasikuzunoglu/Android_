package com.merve.bitirme_projesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.SepetimFragmentDirections
import com.merve.bitirme_projesi.adapter.SepetRecyclerAdapter
import com.merve.bitirme_projesi.viewmodel.SepetimViewModel

import kotlinx.android.synthetic.main.fragment_sepetim.*

class SepetimFragment : Fragment() {

    private lateinit var viewModel: SepetimViewModel
   private val sepetAdapter : SepetRecyclerAdapter?=null


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

        //view model ile fragmenti birbirine bağladık
        viewModel=ViewModelProviders.of(this).get(SepetimViewModel::class.java)

        //sonrasında Sepetimviewmodel içerisinde yazdığımız intetnetten çekme fonksiyonunu burda çağırabiliriz




        btnSepetOnayla.setOnClickListener{
            val action_sepetonay=
                SepetimFragmentDirections.actionSepetimFragmentToOdemeAdresFragment()
            Navigation.findNavController(it).navigate(action_sepetonay)
        }



    }

}