package com.upc.proyectobus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainRegistroPasajero extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner1, spinner2, spinner3;

    /*dd*/ private static final String TAG = "MainRegistroPasajero";

    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_register_passenger);
        /*dd*/ mDisplayDate = (EditText) findViewById(R.id.editDateNac);
        /*dd*/ mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainRegistroPasajero.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener,
                        year, month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d(TAG, "onDateSet: mm/bb/yyy: " + month + "/" + dayOfMonth + "/" + year);
                String date = month + "/" + dayOfMonth + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        spinner1 = findViewById(R.id.spinnerViewDoc);
        spinner2 = findViewById(R.id.spinnerViewCountry);
        spinner3 = findViewById(R.id.spinnerViewGenero);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.documento,
                android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.pais,
                android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.genero,
                android.R.layout.simple_spinner_item);


        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
   }