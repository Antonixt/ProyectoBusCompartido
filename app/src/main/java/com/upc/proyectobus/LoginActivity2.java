package com.upc.proyectobus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import com.upc.proyectobus.MenuApp.MenuActivity;

public class LoginActivity2 extends AppCompatActivity {
    Button btnCrearUsuario, btnIniciarSesion;
    EditText txtIncioUsuario, txtInicioContrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        asignarReferenciasl();
    }

    private void asignarReferenciasl() {
        btnCrearUsuario = findViewById(R.id.btnCrearUsuario);
        txtIncioUsuario = findViewById(R.id.txtInicioCorreo);
        txtInicioContrasenia = findViewById(R.id.txtInicioContrasenia);
        btnCrearUsuario.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegistroUsuarioActivity.class);
            startActivity(intent);
        });
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnIniciarSesion.setOnClickListener(view -> {
            if(capturarDatos() == true){
                String mensaje = "Inicio correctamente";
                mostrarMensaje(mensaje);
            }
        });
    }

    private void mostrarMensaje(String mensaje) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setTitle("Mensaje Informativo");
        ventana.setMessage(mensaje);
        ventana.setPositiveButton("Aceptar",(dialogInterface, i) -> {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        });
        ventana.create().show();
    }

    private boolean capturarDatos() {
        boolean valida = true;
        String correo = txtIncioUsuario.getText().toString();
        String contrasenia = txtInicioContrasenia.getText().toString();
        if(correo.equals("")){
            txtIncioUsuario.setError("Correo es obligatorio");
            valida = false;
        }
        if(contrasenia.equals("")){
            txtInicioContrasenia.setError("Contraseña es obligatorio");
            valida = false;
        }

        return valida;
    }
}