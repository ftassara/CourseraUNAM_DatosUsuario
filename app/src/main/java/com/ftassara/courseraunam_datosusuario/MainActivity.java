package com.ftassara.courseraunam_datosusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Contacto contactos;
    Button btnSiguiente;
    EditText Contacto;
    EditText Telefono;
    EditText Mail;
    EditText FechaNac;
    EditText Descripcion;
    DatePickerDialog picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //inicializo mis variables relacionadolas con el objeto del layout correspondiente
        btnSiguiente = (Button) findViewById(R.id.button);
        Contacto = (EditText) findViewById(R.id.editNombre);
        Telefono = (EditText) findViewById(R.id.editTelefono);
        Mail = (EditText) findViewById(R.id.editMail);
        FechaNac = (EditText) findViewById(R.id.editDate);
        Descripcion = (EditText) findViewById(R.id.editDesc);
        FechaNac.setInputType(InputType.TYPE_NULL);
        FechaNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                FechaNac.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactos = new Contacto(Contacto.getText().toString(),Telefono.getText().toString(),
                        Mail.getText().toString(),FechaNac.getText().toString(),Descripcion.getText().toString());

                cambiarActividad();
            }
        });



    }

    public void cambiarActividad(){
        Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
        intent.putExtra(getResources().getString(R.string.pcontacto),contactos.getContacto());
        intent.putExtra(getResources().getString(R.string.ptelefono),contactos.getTelefono());
        intent.putExtra(getResources().getString(R.string.pmail),contactos.getMail());
        intent.putExtra(getResources().getString(R.string.fechanac),contactos.getFechaNac());
        intent.putExtra(getResources().getString(R.string.pdesc),contactos.getDescripcion());
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 1  && resultCode  == RESULT_OK) {

                Contacto.setText(contactos.getContacto());
                Telefono.setText(contactos.getTelefono());
                Mail.setText(contactos.getMail());
                FechaNac.setText(contactos.getFechaNac());
                Descripcion.setText(contactos.getDescripcion());
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.toString(),
                    Toast.LENGTH_SHORT).show();
        }

    }



}