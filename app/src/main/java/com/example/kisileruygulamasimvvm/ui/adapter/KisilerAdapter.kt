package com.example.kisileruygulamasimvvm.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.databinding.CardTasarimBinding
import com.example.kisileruygulamasimvvm.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasimvvm.ui.fragment.AnaSayfaFragmentDirections
import com.example.kisileruygulamasimvvm.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(private val mContext : Context,
                     private val kisilerListe : List<Kisiler>, var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root) {

        var tasarim : CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {

        val layoutInflater = LayoutInflater.from(mContext)
       val tasarim : CardTasarimBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_tasarim ,parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {

        return kisilerListe.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val kisi = kisilerListe.get(position)
        val t = holder.tasarim
        t.kisiNesnesi = kisi

        t.satirCard.setOnClickListener {
            val gecis = AnaSayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} Silinsin Mi?",Snackbar.LENGTH_LONG).setAction("Evet"){
                viewModel.sil(kisi.kisi_id)
            }.show()
        }



    }

}