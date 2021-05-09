package com.merve.bitirme_projesi.util

import android.content.Context
import android.widget.ImageButton
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.merve.bitirme_projesi.R

//ımageviewleri gösterebilmek için eklendtiler kullanıcaz

fun ImageView.gorselIndir(url:String?,placeholder:CircularProgressDrawable){
//RequestOptions() , Glide içerisinde seçenekleri koymak için yapı
    val option = RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher) //error içerisine hata olduğunda boş bir android sayfasıgetirmesi söylendi
    Glide.with(context).setDefaultRequestOptions(option).load(url).into(this)
}

fun ImageButton.gorselIndir2(url : String?,placeholder:CircularProgressDrawable){
    val option2 = RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher) //error içerisine hata olduğunda boş bir android sayfasıgetirmesi söylendi
    Glide.with(context).setDefaultRequestOptions(option2).load(url).into(this)

}

//görsel inerken indiğini gösteren bir işaret
fun placeholderYap(context: Context):CircularProgressDrawable{
return CircularProgressDrawable(context).apply{

    strokeWidth=8f //yuvarlak dönen işaretin kalınlığı
    centerRadius=40f //yuvarlak dönen işaretin yarıçapı
    start()
}

}


