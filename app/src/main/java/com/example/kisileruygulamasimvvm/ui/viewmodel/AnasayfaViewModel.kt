package com.example.kisileruygulamasimvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.data.repo.KisilerDaoRepository

class AnasayfaViewModel : ViewModel() {

    val krepo = KisilerDaoRepository()
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
        kisilerListesi = krepo.kisileriGetir()
    }

    fun ara(aramaKelimesi : String) {
        krepo.kisiAra(aramaKelimesi)
    }

    fun sil(kisi_id: Int) {
        krepo.kisiSil(kisi_id)
    }

    fun kisileriYukle() {
        krepo.tumKisileriAl()
    }

}