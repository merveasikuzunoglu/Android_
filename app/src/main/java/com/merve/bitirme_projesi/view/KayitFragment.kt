package com.merve.bitirme_projesi

import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.fragment.app.Fragment
import com.merve.bitirme_projesi.ProjectAPI.ProjeApi
import com.merve.bitirme_projesi.ProjectAPI.RetrofitProvider
import com.merve.bitirme_projesi.model.KayitRequest
import com.merve.bitirme_projesi.model.KayitResponse
import kotlinx.android.synthetic.main.fragment_giris.*
import kotlinx.android.synthetic.main.fragment_kayit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern


class KayitFragment : Fragment(R.layout.fragment_kayit) {
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            initAction()

    }

    fun initAction(){

        //val speciCharRegex= ("^"+"(?=.*[0-9])"+"(?=.*[A-Z])"+"(?=.*[a-z])"+"(?=.*[a-zA-Z])"+"(?=S+$)"+".{8,}"+"$")
        val speciCharRegex= "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[a-zA-Z])(?=S+\\$).{8,}$"
        btnKayit.setOnClickListener{
            if(edtAd.text.isEmpty()){
                edtAd.error="İsim gerekli"
                return@setOnClickListener
            }
            else if(edtSoyad.text.isEmpty()){
                edtSoyad.error="Soyad gerekli"
                return@setOnClickListener
            }
            else if(edtEmail.text.isEmpty()){
                edtEmail.error="Email gerekli"
                return@setOnClickListener
            }
            else if(edtTel.text.isEmpty()){
                edtTel.error="Telefon numarası gerekli"
                return@setOnClickListener
            }
            else if(edtSifreKayit1.text.isEmpty()){
                edtSifreKayit1.error="Şifre gerekli"
                return@setOnClickListener
            }
            else if(edtil.text.isEmpty()){
                edtil.error="İl bilgisi gerekli"
                return@setOnClickListener
            }
            else if(edtilce.text.isEmpty()){
                edtilce.error="İlçe bilgisi gerekli"
                return@setOnClickListener
            }
            else if(edtAdres.text.isEmpty()){
                edtAdres.error="Adres bilgisi gerekli"
                return@setOnClickListener
            }

            else if(!Patterns.EMAIL_ADDRESS.matcher(edtEmail.text).matches()){
                edtEmail.error="Girilen email, email formatına uygun değil"
                return@setOnClickListener
            }

            else if(!Patterns.PHONE.matcher(edtTel.text).matches()){
                edtTel.error="Telefon numarası formatı doğru değil "
                return@setOnClickListener
            }

                else if(!Pattern.matches(edtSifreKayit1.text.toString(),speciCharRegex)){
                    edtSifreKayit1.error="Şifre büyük,küçük harf ve rakam içermeli"
                return@setOnClickListener
            }
            /*


            //"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"
                //^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{4,}$
                //^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[a-zA-Z]){8,}$
            }*/

            else if(edtSifreKayit1.length()<8){
                edtSifreKayit1.error="Şifre 8 karakterden az olamaz"
                return@setOnClickListener
            }







            else{
                register()
            }
        }
    }


    fun register(){

        val requestk=KayitRequest()
        requestk.first_name=edtAd.text.toString().trim()
        requestk.last_name=edtSoyad.text.toString().trim()
        requestk.email=edtEmail.text.toString().trim()
        requestk.password=edtSifreKayit1.text.toString().trim()
        requestk.phone=edtTel.text.toString().trim()
            //Regex(pattern="""\\d{3}-\\d{3}-\\d{4}""").find(input=edtTel.text.toString())?.value

        requestk.il= (edtil.text.filters + InputFilter.AllCaps()).toString().trim()
        requestk.ilce=(edtilce.text.filters+InputFilter.AllCaps()).toString().trim()
        requestk.adres=edtAdres.text.toString().trim()

        val retrok=RetrofitProvider().downloadData().create(ProjeApi::class.java)
        retrok.register(requestk).enqueue(object : Callback<KayitResponse> {
            override fun onResponse(call: Call<KayitResponse>, response: Response<KayitResponse>) {
                if (response.isSuccessful) {
                    val userk = response.body()
                    val e = userk!!.email
                    Log.e("token", " $e email adresi ile kayit sağlandı")
                    /*   view?.let{
                     val actionk=KayitFragmentDirections.actionKayitFragmentToGirisFragment()
                     Navigation.findNavController(it).navigate(actionk)

                 }*/
                } else if (response.code() == 400) {
                    Log.e("error", "böyle bir kullanıcı zaten var")
                }

            }

            override fun onFailure(call: Call<KayitResponse>, t: Throwable) {
                Log.e("error", "Siteye istek gönderilemedi", t)
            }

        }
        )
    }


}