package com.example.drawerbottomviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toogle:ActionBarDrawerToggle
    private lateinit var dlVista:DrawerLayout
    private lateinit var navVista: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        dlVista = findViewById(R.id.dl_Vista)
        navVista = findViewById(R.id.nav_Vista)
        toogle =    ActionBarDrawerToggle(this,dlVista,R.string.abrir_drawer,R.string.cerrar_drawer)

        toogle?.syncState()


            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navVista.setNavigationItemSelectedListener {
              when(it.itemId)  {
                  R.id.nav_inicio->{
                      supportFragmentManager.beginTransaction().apply {
                          replace(R.id.fcv_Vista,InicioFragment())
                          commit()
                      }
                  }
                  R.id.nav_camara->{
                      supportFragmentManager.beginTransaction().apply {
                          replace(R.id.fcv_Vista,CamaraFragment())
                          commit()
                      }
                  }
                  R.id.nav_galeria->{
                      supportFragmentManager.beginTransaction().apply {
                          replace(R.id.fcv_Vista,GaleriaFragment())
                          commit()
                      }
                  }
                  R.id.nav_mensaje->{
                      supportFragmentManager.beginTransaction().apply {
                          replace(R.id.fcv_Vista,MensajeFragment())
                          commit()
                      }
                  }
              }



                dlVista.closeDrawer(GravityCompat.START)
                true
            }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toogle.onOptionsItemSelected(item)){

            return true
        }
        return super.onOptionsItemSelected(item)
    }

}