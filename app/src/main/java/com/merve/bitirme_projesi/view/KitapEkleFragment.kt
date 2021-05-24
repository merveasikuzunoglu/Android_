package com.merve.bitirme_projesi.view

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation


import com.merve.bitirme_projesi.R
import kotlinx.android.synthetic.main.fragment_kitap_ekle.*
import kotlinx.android.synthetic.main.recycler_row_kitaplarim8.*
import java.io.ByteArrayOutputStream


class KitapEkleFragment : Fragment() {

   // private lateinit var viewModel:KitapEkleViewModel
    lateinit var option : Spinner
    var secilenBitmap: Bitmap?=null
    var secilenGorsel: Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kitap_ekle, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewModel=ViewModelProviders.of(this).get(KitapEkleViewModel::class.java)

        //kitap ekleyip menuye geç
        btnKitapEkle.setOnClickListener{
            kaydedipmenuyegec(it)

            //satırlardaki tüm bilgiler sunucuya gönderilecek şekilde kayıtlı olmalı
            //sonrasında görselin seçilip seçilmediği denetlenmek isteniyor

            if(secilenBitmap!=null){
                //görsel kısmı kullanıcı tarafından seçildiyse
                val kucukBitmap=kucukBitmapOlustur(secilenBitmap!!,300)

            //bitmapi veritabanına kaydetmek için bir kod
                val outputStream= ByteArrayOutputStream()
                kucukBitmap.compress(Bitmap.CompressFormat.PNG,50,outputStream)
                val byteDizisi=outputStream.toByteArray()
                //sonrasında bytedizisi ve diğer burada tanımlayacağımız maddeler veritabanına kaydedilecek
            }
        }

        btnFotografYükle.setOnClickListener{
            gorselSec(it)
        }
/*        spinnerKEkargo.setOnClickListener{
            spinnerKargoicin(it)
        }*/

    }

    fun gorselSec(view:View){
        activity?.let {
           if(ContextCompat.checkSelfPermission(it,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                // galeri izni verilmediyse , izin istenmeli
               requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)

           }
           else{
               //izin verilmiş , tekrar istemeden galeriye git
               val galeriIntent= Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
               startActivityForResult(galeriIntent,2)

           }
        }
    }
    //izinlerin ne olacağını değerlendiren fonksiyon
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode==1){
            //Galeriden izin verilmediyse ne yapılacak ?
            if(grantResults.size>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                //izni aldık
                val galeriIntent= Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeriIntent,2)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==2 && resultCode==Activity.RESULT_OK && data!=null){
            //galeriye gittikten sonra çıkmadan resim seçmeye devam edilmek isteniyorsa
            secilenGorsel= data.data //secilen gorselin telefonda nerde durduğu bilgisi alındı
            //secilen yerden görseli alıp işlemek gerekiyor bitmape çevirip imageview içine koymak için
            try {
                context?.let {
                    if(secilenGorsel!=null){
                        if(Build.VERSION.SDK_INT >= 28){
                            //API 28 ve üstünde çalıştğı için bu kontrol yapıldı
                            val source=ImageDecoder.createSource(it.contentResolver,secilenGorsel!!)
                            secilenBitmap=ImageDecoder.decodeBitmap(source)
                            kitaplarim8ImageBtn.setImageBitmap(secilenBitmap) //bitmapi kişisel kitaplardaki imagebutton içine atadık
                        }
                        else{
                            secilenBitmap=MediaStore.Images.Media.getBitmap(it.contentResolver,secilenGorsel)
                        }
                    }
                }
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
       //alınan görseli küçülterek kaydetmek istiyoruz , uygulamamız çökmesin diye
    fun kucukBitmapOlustur(kullanicinSectigiBitmap:Bitmap,maximumboyut:Int):Bitmap{
           var width=kullanicinSectigiBitmap.width
           var height=kullanicinSectigiBitmap.height
           val BitmapOrani : Double=width.toDouble()/height.toDouble()
           if(BitmapOrani>1){
               //görsel yatay
               width=maximumboyut
               val kisaltilmisHeight=width/BitmapOrani
               height=kisaltilmisHeight.toInt()
           }
           else{
               //görsel dikey
               height=maximumboyut
               val kisaltilmisWidth=height*BitmapOrani
               width=kisaltilmisWidth.toInt()
           }
        return Bitmap.createScaledBitmap(kullanicinSectigiBitmap,width,height,true)

    }


    //bu kısım çalışırsa süper olur çalışmazsa butona normal action olarak yazılacak
    fun kaydedipmenuyegec(view:View){
        val KayitKitapad=editTxtKEad.text.toString()
        val KayitYazar=editTxtKEyazarad.text.toString()
        val KayitYayinevi=editTxtKEyayinevi.text.toString()
        val KayitBaskiyili=editTxtKEbaskiyili.text.toString()
        val KayitSayfasayisi=editTxtKEsayfasayisi.text.toString()
        val KayitIsbn=editTxtKEisbn.text.toString()
        val KayitThg=editTxtKEthg.text.toString()
        val KayitKargo=spinnerKEkargo.selectedItem.toString()
        val KayitAciklama=editTxtKEaciklama.text.toString()


        view.let {
            val action_menuyegec= KitapEkleFragmentDirections.actionKitapEkleFragmentToKitaplarim8Fragment()
            Navigation.findNavController(it).navigate(action_menuyegec)
        }
    }

    fun spinnerKargoicin(view:View){
        context?.let{
            spinnerKEkargo.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    //spinnerda bir bölüm seçildiyse
                    TODO("Not yet implemented")


                }
                //spinnerda seçim yapılmadıysa
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(it,"Kargo Seçimi Yapmadınız",Toast.LENGTH_LONG).show()

                }

        }




        }

    }





}