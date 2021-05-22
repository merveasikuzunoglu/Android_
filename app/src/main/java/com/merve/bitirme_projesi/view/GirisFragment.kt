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

        val responsefailsifre=GirisFailResponse(listOf("Verilen bilgiler ile giriş sağlanamadı."))
        val responsefailemail=GirisFailEmailResponse(listOf("Geçerli bir e-posta adresi girin."))

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

                if(responsefailsifre.non_field_errors.equals(responsefailsifre)){
                    failsifre()
                }
                if(responsefailemail.email.equals(responsefailemail)){
                    failemail()
                }
                else{
                    login()
                }

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
            }
            override fun onFailure(call: Call<GirisResponse>, t: Throwable) {
                Log.e("error","Siteye istek gönderilemedi",t)
            } } )
    }

    fun failsifre(){
        request.email=editTxtEmail.text.toString().trim()
        request.password=editTxtPasswordGiris.text.toString().trim()
        retro.loginfailsifre(request).enqueue(object : Callback<GirisFailResponse> {
            override fun onResponse(
                call: Call<GirisFailResponse>, response: Response<GirisFailResponse>
            ) {
                if (response.isSuccessful) {
                    val userfail = response.body()
                    val x = listOf(userfail?.non_field_errors)

                    Log.e("errorsifre", "sifre hatalı $x")
                }

            }

            override fun onFailure(call: Call<GirisFailResponse>, t: Throwable) {
                Log.e("error", "Siteye istek gönderilemedi", t)
            }

        })
    }

    fun failemail(){
        request.email=editTxtEmail.text.toString().trim()
        request.password=editTxtPasswordGiris.text.toString().trim()
        retro.loginfailemail(request).enqueue(object:Callback<GirisFailEmailResponse>{
            override fun onResponse(call: Call<GirisFailEmailResponse>, response: Response<GirisFailEmailResponse>
            ) {
                if(response.isSuccessful){
                    val useremailf=response.body()
                    val y= useremailf?.email
                    Log.e("erroremail","email hatalı $y" )

                }
            }

            override fun onFailure(call: Call<GirisFailEmailResponse>, t: Throwable) {
                Log.e("error","Siteye istek gönderilemedi",t)
            }

        }
        )

    }


}




/*
    else{
        //şifre veya email hatalı ise
if(request.email==editTxtEmail.text.toString()){
    if(request.password!=editTxtPasswordGiris.text.toString()){
        Log.e("error","şifre hatalı " )
    }
if(request.email!=editTxtEmail.text.toString())  {
    Log.e("error","email hatalı " )

}*/
                //Log.e("email","email hatalı " )
            /*context?.let{
                    Toast.makeText(it,"Girdiğiniz emaille oluşmuş hesap bulunmamakta", Toast.LENGTH_LONG).show()
                }*/
                /*  view?.let{
                        val actionb=GirisFragmentDirections.actionGirisFragmentToGirisBasarisizFragment()
                        Navigation.findNavController(it).navigate(actionb)
                    }
                    */





             /* context?.let{
                     Toast.makeText(it,"Girdiğiniz şifre hatalı", Toast.LENGTH_LONG).show()
                 }*/











