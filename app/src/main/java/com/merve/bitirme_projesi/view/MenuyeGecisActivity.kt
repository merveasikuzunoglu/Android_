package com.merve.bitirme_projesi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.merve.bitirme_projesi.HesabimFragment
import com.merve.bitirme_projesi.R

class MenuyeGecisActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menuye_gecis)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toogle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0

        )

        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        navView.setNavigationItemSelectedListener(this)


        setToolBarTitle("")
        changeFragment(TumKitaplarFragment())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        drawerLayout.closeDrawer(GravityCompat.START)//sol sekmedeki menüden bir yere tıklayınca sol sekmenin kapanması için yazıldı
        when (item.itemId) {
            R.id.KitapAraFragment -> {

                setToolBarTitle("Kitap Ara")
                changeFragment(KitapAraFragment())

            }


            R.id.Kitaplarim8Fragment -> {

                setToolBarTitle("Kitaplarım")
                changeFragment(Kitaplarim8Fragment())

            }

            R.id.KitapEkleFragment -> {
                setToolBarTitle("Kitap Ekle")
                changeFragment(KitapEkleFragment())
            }

            R.id.SepetimFragment -> {
                setToolBarTitle("Sepetim")
                changeFragment(SepetimFragment())

            }


            R.id.SiparislerimFragment -> {
                setToolBarTitle("Siparislerim")
               changeFragment(SiparislerimGoruntuleme())

            }


            R.id.SatislarimFragment -> {
                setToolBarTitle("Satışlarım")
                // changeFragment(SatislarimFragment())

            }


            R.id.HesabimFragment -> {
                setToolBarTitle("Hesabım")
                changeFragment(HesabimFragment())


            }


            R.id.AyarlarFragment -> {
                setToolBarTitle("Ayarlar")
                changeFragment(Ayarlar())


            }
            R.id.CikisFragment -> {
                setToolBarTitle("Çıkış Yap")
                //changeFragment(CikisFragment())

            }


        }


        return true
    }

    fun setToolBarTitle(title:String){
        supportActionBar?.title=title
    }

    fun changeFragment(frag: Fragment){
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container,frag).commit()

    }

}