package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasimvvm.ui.adapter.KisilerAdapter


class AnaSayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim : FragmentAnaSayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa, container, false)
        tasarim.anasayfaFragment = this
        tasarim.anasayfaToolbarBaslik = "Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa) // Action bar kullanmak için...


        val kisilerListesi = ArrayList<Kisiler>()
        val kisi1 = Kisiler(1,"Ferhat","123456789")
        val kisi2 = Kisiler(2,"Ali","123456")
        val kisi3 = Kisiler(3,"Mehmet","12489")
        kisilerListesi.add(kisi1)
        kisilerListesi.add(kisi2)
        kisilerListesi.add(kisi3)

        val adapter = KisilerAdapter(requireContext(),kisilerListesi)
        tasarim.kisilerAdapter = adapter


        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView // Search View özelliği kazandırıldı.
                searchView.setOnQueryTextListener(this@AnaSayfaFragment)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED) // Yaşam döngüsüyle doğru çalışması için...


        return tasarim.root
    }

    fun fabTikla(it : View) {
        Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)

    }

    override fun onQueryTextSubmit(query: String): Boolean {

        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {

        ara(newText)
        return true
    }

    fun ara(aramaKelimesi : String) {
        Log.e("Kişi Ara",aramaKelimesi)

    }

    // Sayfaya geri dönüldüğünde güncellenmiş halde ana sayfa olması için...
    override fun onResume() {
        super.onResume()
        Log.e("Kişi Ana Sayfa","Dönüldü")

    }

}