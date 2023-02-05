package com.upc.proyectobus;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MenuActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viajes);
        asignarReferencias();
    }
    private void asignarReferencias(){
        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                if (item.getItemId()== R.id.menu_1){
                    mostrarFragmento( new Fragment_bus_menu());
                }
                if (item.getItemId()== R.id.menu_2){
                    mostrarFragmento( new Fragment_micuenta_menu());
                }
                if (item.getItemId()== R.id.menu_3){
                    mostrarFragmento( new Fragment_contacto_menu());
                }
                return;
            }
        });
    }
    private void mostrarFragmento(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }

}
