package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiKayitBinding
import com.example.kisileruygulamasimvvm.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiKayitViewModel


class KisiKayitFragment : Fragment() {
    private lateinit var tasarim : FragmentKisiKayitBinding
    private lateinit var viewModel : KisiKayitViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit,container,false)

        tasarim.kisiKayitFragment = this // Yetki verildi.
        tasarim.kisiKayitToolbarBaslik = "Kişi Kayıt"


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KisiKayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydet(kisi_ad : String, kisi_tel : String) {
        viewModel.kayit(kisi_ad, kisi_tel)
    }
}