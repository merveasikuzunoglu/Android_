package com.merve.bitirme_projesi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.model.Sepet
import com.merve.bitirme_projesi.util.gorselIndir
import com.merve.bitirme_projesi.util.placeholderYap
import kotlinx.android.synthetic.main.recycler_row_sepet.view.*

class SepetRecyclerAdapter(val sepetListe:ArrayList<Sepet>): RecyclerView.Adapter<SepetRecyclerAdapter.SepetViewHolder>() {
    class SepetViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view =inflater.inflate(R.layout.recycler_row_sepet,parent,false)
        return SepetViewHolder(view)

    }

    override fun onBindViewHolder(holder: SepetViewHolder, position: Int) {
        holder.itemView.txtSepetKitapAd.text=sepetListe.get(position).skitapAd
        holder.itemView.txtSepetKitapFiyat.text="Fiyat: ${sepetListe.get(position).skitapfiyat}"

        // görsel ekleme kodu
        holder.itemView.sepetImageView.gorselIndir(sepetListe.get(position).skitapImage, placeholderYap(holder.itemView.context))
    }

    override fun getItemCount(): Int {
        return sepetListe.size
    }

    //yeni bir liste geldiği zaman sayfanın yenilenmesi için yazıyoruz
    fun sepetListesiGuncelle(yeniSepetListe:List<Sepet>){
        sepetListe.clear()
        sepetListe.addAll(yeniSepetListe)
        notifyDataSetChanged()
    }


}