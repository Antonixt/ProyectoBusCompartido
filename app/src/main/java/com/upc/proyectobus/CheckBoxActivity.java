package com.upc.proyectobus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class CheckBoxActivity extends AppCompatActivity {

    private TextView textView;
    private CheckBox checkBox;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viaje);


        checkBox = findViewById(R.id.checkSoloIda);
        textView = findViewById(R.id.txtDateEnd);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    textView.setVisibility(View.INVISIBLE);
            }else{
                    textView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}




















