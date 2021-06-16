package com.merve.bitirme_projesi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.merve.bitirme_projesi.ProjectAPI.ProjeApi
import com.merve.bitirme_projesi.ProjectAPI.RetrofitProvider
import com.merve.bitirme_projesi.model.GirisResponse
import com.merve.bitirme_projesi.model.HesabimRequest
import com.merve.bitirme_projesi.model.HesabimResponse
import kotlinx.android.synthetic.main.fragment_hesabim.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HesabimFragment : Fragment(R.layout.fragment_hesabim) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showHesap()

    }



    fun showHesap(){

        val requesth=GirisResponse()
        var t=requesth.key
        val retrog=RetrofitProvider().downloadData().create(ProjeApi::class.java)
      //114c7446578d548a6b3cbf6c089fccf5d8a6d893

        retrog.hesabim("114c7446578d548a6b3cbf6c089fccf5d8a6d893").enqueue(object: Callback<HesabimResponse>{

            override fun onResponse(call: Call<HesabimResponse>, response: Response<HesabimResponse>) {
                if(response.isSuccessful){
                    val userhesab=response.body()

                    val tok=response.headers().toString()
                    t=tok.replace("Token ",tok)


                    txtad.text=userhesab?.first_name.toString()
                    txtsoyad.text=userhesab?.last_name.toString()
                    txtemail.text=userhesab?.email.toString()
                    txtil.text=userhesab?.il.toString()
                    txtilce.text=userhesab?.ilce.toString()
                    txtadres.text=userhesab?.adres.toString()

                    Log.d("Hesabim",response.headers().toString())




                }
                else if(response.code()==401){
                    Log.e("error", "oturumu olmayan hesap")
                }
                else{
                    Log.e("error", "yukarı islem yok")
                }

            }

            override fun onFailure(call: Call<HesabimResponse>, t: Throwable) {
                Log.e("error", "Siteye istek gönderilemedi", t)
            }

        })

    }

}