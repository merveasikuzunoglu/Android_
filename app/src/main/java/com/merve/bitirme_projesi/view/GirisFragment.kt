package com.merve.bitirme_projesi.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation
import com.merve.bitirme_projesi.GirisFragmentDirections
import com.merve.bitirme_projesi.ProjectAPI.ProjeApi
import com.merve.bitirme_projesi.ProjectAPI.RetrofitProvider

import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.model.GirisRequest
import com.merve.bitirme_projesi.model.GirisResponse
import kotlinx.android.synthetic.main.fragment_giris.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GirisFragment : Fragment(R.layout.fragment_giris) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAction()

    }
    fun initAction(){
        btnGirisYap.setOnClickListener{

            context?.let{
                if(editTxtEmail.text.isEmpty()){
                    Toast.makeText(it,"Email alanı boş bırakılamaz", Toast.LENGTH_LONG).show()
                }
                if(editTxtPasswordGiris.text.isEmpty()){
                    Toast.makeText(it,"Şifre alanı boş bırakılamaz", Toast.LENGTH_LONG).show()
                }
                else{
                    login()
                }
            }


        }
    }

    fun login(){
        val request=GirisRequest()
        request.email=editTxtEmail.text.toString().trim()
        request.password=editTxtPasswordGiris.text.toString().trim()

        val retro=RetrofitProvider().downloadData().create(ProjeApi::class.java)
        retro.login(request).enqueue(object : Callback<GirisResponse>{
            override fun onResponse(call: Call<GirisResponse>, response: Response<GirisResponse>) {
                val user=response.body()
                val a=user!!.key
                Log.e("token","giris yapılabilir  $a")

                view?.let{
                    val actiong=GirisFragmentDirections.actionGirisFragmentToMenuyeGecisActivity()
                    Navigation.findNavController(it).navigate(actiong)
                }

            }

            override fun onFailure(call: Call<GirisResponse>, t: Throwable) {
                Log.e("error","giris hatalı böyle bir kayıt yok",t)

                view?.let{
                    val actionb=GirisFragmentDirections.actionGirisFragmentToGirisBasarisizFragment()
                    Navigation.findNavController(it).navigate(actionb)
                }


            }

        })



    }


}