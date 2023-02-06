package com.upc.proyectobus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegistroUsuarioActivity extends AppCompatActivity {

    Button btnConfirmarRegistro;
    EditText txtNombres, txtApellidoPat, txtApellidoMat, txtPais, txtCorreo, txtTelefono, txtContraseniaA, txtContraseniaB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        asignarReferencias();
    }

    private void asignarReferencias() {
        btnConfirmarRegistro = findViewById(R.id.btnConfirmarRegistro);
        txtNombres = findViewById(R.id.txtNombres);
        txtApellidoPat = findViewById(R.id.txtApellidoPat);
        txtApellidoMat = findViewById(R.id.txtApellidoMat);
        txtPais = findViewById(R.id.txtPais);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtContraseniaA = findViewById(R.id.txtPasswordA);
        txtContraseniaB = findViewById(R.id.txtPasswordB);
        btnConfirmarRegistro.setOnClickListener(view -> {
            if(capturarDatos() == true){
                String mensaje = "Registrado correctamente";
                mostrarMensaje(mensaje);
            }
        });
    }

    private boolean capturarDatos() {
        boolean valida = true;
        String nombres = txtNombres.getText().toString();
        String apepat = txtApellidoPat.getText().toString();
        String apemat = txtApellidoMat.getText().toString();
        String pais = txtPais.getText().toString();
        String correo = txtCorreo.getText().toString();
        String telefono = txtTelefono.getText().toString();
        String passA = txtContraseniaA.getText().toString();
        String passB = txtContraseniaB.getText().toString();
        if(nombres.equals("")){
            txtNombres.setError("Nombres es obligatorio");
            valida = false;
        }
        if(apepat.equals("")){
            txtApellidoPat.setError("Apellido Paterno es obligatorio");
            valida = false;
        }
        if(apemat.equals("")){
            txtApellidoMat.setError("Apellido Materno es obligatorio");
            valida = false;
        }
        if(pais.equals("")){
            txtPais.setError("Pais es obligatorio");
            valida = false;
        }
        if(correo.equals("")){
            txtCorreo.setError("Correo es obligatorio");
            valida = false;
        }
        if(telefono.equals("")){
            txtTelefono.setError("Telefono es obligatorio");
            valida = false;
        }
        if(passA.equals("")){
            txtContraseniaA.setError("Contraseña es obligatorio");
            valida = false;
        }
        if(passB.equals("")){
            txtContraseniaB.setError("Contraseña es obligatorio");
            valida = false;
        }
        if(!passA.equals("") && !passB.equals(passA)){
            txtContraseniaB.setError("Contraseña no coincide con anterior");
            valida = false;
        }

        return valida;
    }

    private void mostrarMensaje(String mensaje) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setTitle("Mensaje Informativo");
        ventana.setMessage(mensaje);
        ventana.setPositiveButton("Aceptar",(dialogInterface, i) -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        ventana.create().show();
    }
}