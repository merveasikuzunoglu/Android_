package com.merve.bitirme_projesi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.merve.bitirme_projesi.KitapAraFragmentDirections
import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.model.KitapAra
import com.merve.bitirme_projesi.util.gorselIndir2
import com.merve.bitirme_projesi.util.placeholderYap
import kotlinx.android.synthetic.main.recycler_row_kitapara.view.*

class KitapAraRecyclerAdapter(val kitaparaListesi:ArrayList<KitapAra>): RecyclerView.Adapter<KitapAraRecyclerAdapter.AraViewHolder>() {
    class AraViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AraViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =inflater.inflate(R.layout.recycler_row_kitapara,parent,false)
        return AraViewHolder(view)
    }

    override fun onBindViewHolder(holder: AraViewHolder, position: Int) {

        holder.itemView.txtKitapAraAd.text=kitaparaListesi.get(position).kitapAraAd
        holder.itemView.kitapAraImagebtn.gorselIndir2(kitaparaListesi.get(position).kitapAraGorsel,
            placeholderYap(holder.itemView.context))


        holder.itemView.kitapAraImagebtn.setOnClickListener{
           val actio=KitapAraFragmentDirections.actionKitapAraFragmentToTumKitapDetayFragment()
           Navigation.findNavController(it).navigate(actio)
       }
        holder.itemView.txtKitapAraAd.setOnClickListener{
            val actio=KitapAraFragmentDirections.actionKitapAraFragmentToTumKitapDetayFragment()
            Navigation.findNavController(it).navigate(actio)
        }
          }

    override fun getItemCount(): Int {
        return kitaparaListesi.size
    }

    fun kitaparaListesiGuncelle(yenikitaparaListesi:List<KitapAra>){
        kitaparaListesi.clear()
        kitaparaListesi.addAll(yenikitaparaListesi)
        notifyDataSetChanged()

    }


}