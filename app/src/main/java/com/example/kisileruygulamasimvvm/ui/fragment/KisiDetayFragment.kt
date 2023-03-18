package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasimvvm.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiDetayViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiKayitViewModel


class KisiDetayFragment : Fragment() {
    private lateinit var tasarim : FragmentKisiDetayBinding
    private lateinit var viewModel : KisiDetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay,container, false)
        tasarim.kisiDetayFragment = this
        tasarim.kisiDetayToolbarBaslik= "Kişi Detay"

        val bundle : KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        tasarim.kisiNesnesi = gelenKisi


        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KisiDetayViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun buttonGuncelle(kisi_id : Int,kisi_ad : String,kisi_tel : String) {

        viewModel.guncelle(kisi_id, kisi_ad, kisi_tel)

    }

}