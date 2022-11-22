package com.example.drawerbottomviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ButtomActivity : AppCompatActivity() {

    private  lateinit var btnvMenu:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttom)


        var inicioFragment = InicioFragment()
        var MensajeFragment= MensajeFragment()
        var perfilFragment = PerfilFragment()


        setFragmentActual(inicioFragment)
        btnvMenu = findViewById(R.id.bnv_Menu)
        btnvMenu.setOnNavigationItemReselectedListener{
            when(it.itemId){
                R.id.myinicio->{
                    setFragmentActual(inicioFragment)
                }
                R.id.mymensaje->{
                    setFragmentActual(MensajeFragment)
                }
                R.id.myperfil->{
                    setFragmentActual(perfilFragment)
                }

            }


        }
    }


    private  fun setFragmentActual(fragment: Fragment) = supportFragmentManager.beginTransaction().apply{
        replace(R.id.fl_vista,fragment)
        commit()

    }
}