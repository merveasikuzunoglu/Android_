package com.merve.bitirme_projesi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.model.TumKitaplar
import com.merve.bitirme_projesi.util.gorselIndir2
import com.merve.bitirme_projesi.util.placeholderYap
import com.merve.bitirme_projesi.view.TumKitaplarFragmentDirections
import kotlinx.android.synthetic.main.recycler_row_tumkitap.view.*

class TumKitaplarRecyclerAdapter(val tumkitapListesi:ArrayList<TumKitaplar>): RecyclerView.Adapter<TumKitaplarRecyclerAdapter.TumkitaplarViewHolder>() {
    class TumkitaplarViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TumkitaplarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =inflater.inflate(R.layout.recycler_row_tumkitap,parent,false)
        return TumkitaplarViewHolder(view)

    }

    override fun onBindViewHolder(holder: TumkitaplarViewHolder, position: Int) {
        holder.itemView.tumKitapAd.text=tumkitapListesi.get(position).tkitapad
        holder.itemView.tumKitapYazar.text=tumkitapListesi.get(position).tyazarad
        holder.itemView.tumKitapFiyat.text=tumkitapListesi.get(position).tfiyat

        //görsel ekleme kodu
        holder.itemView.tumKitapImageBtn.gorselIndir2(tumkitapListesi.get(position).tkitapgorsel, placeholderYap(holder.itemView.context))


        holder.itemView.tumKitapImageBtn.setOnClickListener {
          val act=TumKitaplarFragmentDirections.actionTumKitaplarFragmentToTumKitapDetayFragment()
           Navigation.findNavController(it).navigate(act)

       }
        holder.itemView.tumKitapSepeteEkle.setOnClickListener {
            Toast.makeText(it.context,"Sepete Eklendi ${tumkitapListesi.get(position).tkitapad}",Toast.LENGTH_LONG).show()

        }

    }

    override fun getItemCount(): Int {
        return tumkitapListesi.size
    }

    //yeni bir liste geldiği zaman sayfanın yenilenmesi için yazıyoruz
    fun tumkitaplarlistesiGuncelle(yeniTumkitapListesi:List<TumKitaplar>){
        tumkitapListesi.clear()
        tumkitapListesi.addAll(yeniTumkitapListesi)
        notifyDataSetChanged()

    }
}