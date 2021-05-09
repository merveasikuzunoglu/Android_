package com.merve.bitirme_projesi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.merve.bitirme_projesi.Kitaplarim8FragmentDirections
import com.merve.bitirme_projesi.R
import com.merve.bitirme_projesi.model.KisiselKitap
import com.merve.bitirme_projesi.util.gorselIndir2
import com.merve.bitirme_projesi.util.placeholderYap

import kotlinx.android.synthetic.main.recycler_row_kitaplarim8.view.*

class Kitaplarim8RecyclerAdapter(val kisiselKitaplarListesi:ArrayList<KisiselKitap>): RecyclerView.Adapter<Kitaplarim8RecyclerAdapter.KisiselKitapViewHolder>() {

    class KisiselKitapViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {


    }

    //recycler_row_kitaplarim8 görünümü buraya bağlandı
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KisiselKitapViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =inflater.inflate(R.layout.recycler_row_kitaplarim8,parent,false)
        return KisiselKitapViewHolder(view)


    }
    //recycler_row_kitaplarim8 görünümü buraya bağlanma işleminden sonra içerisindeki verileri görüntülemek için
    override fun onBindViewHolder(holder: KisiselKitapViewHolder, position: Int) {
        //kisiselKitap data classındaki verilerle recyclerrow8 görünümü eşleştirilir

        holder.itemView.kitaplarim8Ad.text=kisiselKitaplarListesi.get(position).kkitapad

        holder.itemView.kitaplarim8ImageBtn.setOnClickListener {
        val action= Kitaplarim8FragmentDirections.actionKitaplarim8FragmentToKitaplarim9Fragment(0)
        Navigation.findNavController(it).navigate(action) }

        holder.itemView.kitaplarim8Duzenle.setOnClickListener {
            val action1=Kitaplarim8FragmentDirections.actionKitaplarim8FragmentToKitaplarim10Fragment()
            Navigation.findNavController(it).navigate(action1)

        }

        // görsel ekleme kodu
        holder.itemView.kitaplarim8ImageBtn.gorselIndir2(kisiselKitaplarListesi.get(position).kgorsel,
            placeholderYap(holder.itemView.context))
    }

    override fun getItemCount(): Int {
        return kisiselKitaplarListesi.size

    }

    //yeni bir liste geldiği zaman sayfanın yenilenmesi için yazıyoruz
    fun kisiselKitaplarListesiGuncelle(yeniKisiselKitapListesi:List<KisiselKitap>){
        kisiselKitaplarListesi.clear()
        kisiselKitaplarListesi.addAll(yeniKisiselKitapListesi)
        notifyDataSetChanged()

    }
}