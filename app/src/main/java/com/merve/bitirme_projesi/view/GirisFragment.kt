package com.merve.bitirme_projesi.view

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment

import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation

import com.merve.bitirme_projesi.ProjectAPI.ProjeApi
import com.merve.bitirme_projesi.ProjectAPI.RetrofitProvider

import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.model.GirisRequest
import com.merve.bitirme_projesi.model.GirisResponse
import com.merve.bitirme_projesi.model.KayitRequest
import kotlinx.android.synthetic.main.fragment_giris.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class GirisFragment : Fragment(R.layout.fragment_giris) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAction()

    }
    fun initAction(){
        btnGirisYap.setOnClickListener{

            context?.let{
               //email boşsa veya istenilen formatta değilse
                if(editTxtEmail.text.isEmpty()){
                    editTxtEmail.error="Email alanı boş bırakılamaz"
                    return@setOnClickListener
                }
                else if(editTxtPasswordGiris.text.isEmpty()){
                    Toast.makeText(it,"Şifre alanı boş bırakılamaz", Toast.LENGTH_LONG).show()
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(editTxtEmail.text).matches()){
                    editTxtEmail.error="Girilen email, email formatına uygun değil"
                    return@setOnClickListener
                }

                else{
                    login()
                }
            }


        }
    }

    fun login(){
        val request=GirisRequest()
        val requestka=KayitRequest()
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
               //kayit ve giriş emaili aynı fakat giriş yapılamıyor ise
                if(request.email==requestka.email){
                    context?.let{
                        Toast.makeText(it,"Şifre hatalı", Toast.LENGTH_LONG).show()
                    }
                }

                view?.let{
                    val actionb=GirisFragmentDirections.actionGirisFragmentToGirisBasarisizFragment()
                    Navigation.findNavController(it).navigate(actionb)
                }


            }

        })



    }


}