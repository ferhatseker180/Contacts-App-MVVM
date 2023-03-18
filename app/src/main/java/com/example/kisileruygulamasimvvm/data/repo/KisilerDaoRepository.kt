package com.example.kisileruygulamasimvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasimvvm.data.entity.Kisiler

class KisilerDaoRepository {
    var kisilerListesi : MutableLiveData<List<Kisiler>>

    init {
        kisilerListesi = MutableLiveData()
    }

    fun kisileriGetir() : MutableLiveData<List<Kisiler>> {
        return kisilerListesi
    }

    fun kisiKayit(kisi_ad : String, kisi_tel : String) {

        Log.e("Kişi Kayıt","${kisi_ad}-${kisi_tel}")
    }

    fun kisiGuncelle(kisi_id : Int,kisi_ad : String,kisi_tel : String) {

        Log.e("Kişi Güncelle"," ${kisi_id} - ${kisi_ad}-${kisi_tel}")
    }

    fun kisiAra(aramaKelimesi : String) {
        Log.e("Kişi Ara",aramaKelimesi)
    }

    fun kisiSil(kisi_id: Int) {
        Log.e("Kişi Sil",kisi_id.toString())
    }

    fun tumKisileriAl() {

        val liste = ArrayList<Kisiler>()
        val kisi1 = Kisiler(1,"Ferhat","123456789")
        val kisi2 = Kisiler(2,"Ali","123456")
        val kisi3 = Kisiler(3,"Mehmet","12489")
        liste.add(kisi1)
        liste.add(kisi2)
        liste.add(kisi3)

        kisilerListesi.value = liste
    }
}