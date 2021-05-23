package com.merve.bitirme_projesi.view

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment

import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.gson.Gson

import com.merve.bitirme_projesi.ProjectAPI.ProjeApi
import com.merve.bitirme_projesi.ProjectAPI.RetrofitProvider

import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.model.*
import kotlinx.android.synthetic.main.fragment_giris.*
import kotlinx.android.synthetic.main.fragment_kayit.*

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
            //email boşsa veya istenilen formatta değilse
            if(editTxtEmail.text.isEmpty()){
                editTxtEmail.error="Email alanı boş bırakılamaz"
                return@setOnClickListener
            }
            else if(editTxtPasswordGiris.text.isEmpty()){
                editTxtPasswordGiris.error="Şifre alanı boş bırakılamaz"
                return@setOnClickListener
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(editTxtEmail.text).matches()){
                editTxtEmail.error="Girilen email, email formatına uygun değil"
                return@setOnClickListener
            }
           else{
                    Log.e("error","program hatasız if çalıştı")
                    login()

            }
        }
    }
    val request=GirisRequest()
    val retro=RetrofitProvider().downloadData().create(ProjeApi::class.java)

    fun login(){
        request.email=editTxtEmail.text.toString().trim()
        request.password=editTxtPasswordGiris.text.toString().trim()
        retro.login(request).enqueue(object : Callback<GirisResponse>{
            override fun onResponse(call: Call<GirisResponse>, response: Response<GirisResponse>) {
     if(response.isSuccessful){
         val user=response.body()
         val a=user?.key
         Log.e("token","giris yapılabilir $a" )
         view?.let{
             val actiong=GirisFragmentDirections.actionGirisFragmentToMenuyeGecisActivity()
             Navigation.findNavController(it).navigate(actiong) }
     }
     else if(response.code()==400){
         Log.e("error","giris olamaz sifre hatalı" )
         context?.let{
             Toast.makeText(it,"Girdiğiniz şifre hatalı", Toast.LENGTH_LONG).show()
         }
     }
     else{
         Log.e("error","giris olamaz hesap kayıtlı değil" )
         view?.let{
             val actionb=GirisFragmentDirections.actionGirisFragmentToGirisBasarisizFragment()
             Navigation.findNavController(it).navigate(actionb)
         }
     }
            }
            override fun onFailure(call: Call<GirisResponse>, t: Throwable) {
                Log.e("error","Siteye istek gönderilemedi",t)
            } } ) }


}




