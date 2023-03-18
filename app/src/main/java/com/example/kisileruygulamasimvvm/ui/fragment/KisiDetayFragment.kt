package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiDetayBinding


class KisiDetayFragment : Fragment() {
    private lateinit var tasarim : FragmentKisiDetayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentKisiDetayBinding.inflate(inflater,container, false)


        tasarim.toolbarKisiDetay.title = "Kişi Detay"

        val bundle : KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi



        tasarim.editTextAdGuncelleme.setText(gelenKisi.kisi_ad)
        tasarim.editTextTelGuncelleme.setText(gelenKisi.kisi_tel)

        tasarim.buttonGuncelle.setOnClickListener {

            val kisi_ad = tasarim.editTextAdGuncelleme.text.toString()
            val kisi_tel = tasarim.editTextTelGuncelleme.text.toString()

            guncelle(gelenKisi.kisi_id,gelenKisi.kisi_ad,gelenKisi.kisi_tel)
        }

        return tasarim.root
    }

    fun guncelle(kisi_id : Int,kisi_ad : String,kisi_tel : String) {

        Log.e("Kişi Güncelle"," ${kisi_id} - ${kisi_ad}-${kisi_tel}")

    }

}