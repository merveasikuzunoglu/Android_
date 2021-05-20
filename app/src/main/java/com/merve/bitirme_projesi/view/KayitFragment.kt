package com.merve.bitirme_projesi

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.merve.bitirme_projesi.ProjectAPI.ProjeApi
import com.merve.bitirme_projesi.ProjectAPI.RetrofitProvider
import com.merve.bitirme_projesi.model.GirisRequest
import com.merve.bitirme_projesi.model.KayitRequest
import com.merve.bitirme_projesi.model.KayitResponse

import kotlinx.android.synthetic.main.fragment_kayit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class KayitFragment : Fragment(R.layout.fragment_kayit) {
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            initAction()

    }

    fun initAction(){
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
                edtEmail.error="Mail gerekli"
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
            else if(edtSifreKayit2.text.isEmpty()){
                edtSifreKayit2.error="Şifre yeniden gerekli"
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
            else if(edtSifreKayit1.text!=edtSifreKayit2.text){
                edtSifreKayit2.error="Şifreler Aynı Değil"
                return@setOnClickListener
            }

            else{
                register()
            }
        }
    }

    fun register(){
        val requestk=KayitRequest()
        val requestg=GirisRequest()
        requestk.first_name=edtAd.text.toString().trim()
        requestk.last_name=edtSoyad.text.toString().trim()
        requestk.email=edtEmail.text.toString().trim()
        requestk.phone=edtTel.text.toString().trim()
        requestk.password=edtSifreKayit1.text.toString().trim()
        requestk.password=edtSifreKayit2.text.toString().trim()
        requestk.il=edtil.text.toString().trim()
        requestk.ilce=edtilce.text.toString().trim()
        requestk.adres=edtAdres.text.toString().trim()

        val retrok=RetrofitProvider().downloadData().create(ProjeApi::class.java)
        retrok.register(requestk).enqueue(object: Callback<KayitResponse>{
            override fun onResponse(call: Call<KayitResponse>, response: Response<KayitResponse>) {
                val userk=response.body()
                val e=userk!!.email
                val p=userk!!.password
                Log.e("token","$e email adresi ve $p şifre ile kayit sağlandı")

                view?.let{
               val actionk=KayitFragmentDirections.actionKayitFragmentToGirisFragment()
                    Navigation.findNavController(it).navigate(actionk)

                }

            }

            override fun onFailure(call: Call<KayitResponse>, t: Throwable) {
                Log.e("error","Kayıt olma işlemi yapılamadı",t)

               //eğer aynı emaille kayıt yapılmak istenirse

                if(requestk.email==requestg.email){
                    context?.let{
                        Toast.makeText(it,"Bu email ile oluşturulmuş bir hesap bulunmakta", Toast.LENGTH_LONG).show()
                    }
                }


            }

        }
        )
    }


}