package com.upc.proyectobus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RegistroUsuarioActivity extends AppCompatActivity {

    Button btnConfirmarRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        asignarReferencias();
    }

    private void asignarReferencias() {
        btnConfirmarRegistro = findViewById(R.id.btnConfirmarRegistro);
        btnConfirmarRegistro.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}