package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasimvvm.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasimvvm.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiKayitViewModel
import com.example.kisileruygulamasimvvm.util.gecisYap


class AnaSayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim : FragmentAnaSayfaBinding
    private lateinit var viewModel : AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa, container, false)
        tasarim.anasayfaFragment = this
        tasarim.anasayfaToolbarBaslik = "Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa) // Action bar kullanmak için...


        viewModel.kisilerListesi.observe(viewLifecycleOwner) {

            val adapter = KisilerAdapter(requireContext(),it,viewModel)
            tasarim.kisilerAdapter = adapter
        }


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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabTikla(it : View) {
        Navigation.gecisYap(it,R.id.kisiKayitGecis)

    }

    override fun onQueryTextSubmit(query: String): Boolean {

        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {

        viewModel.ara(newText)
        return true
    }



    // Sayfaya geri dönüldüğünde güncellenmiş halde ana sayfa olması için...
    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()

    }

}