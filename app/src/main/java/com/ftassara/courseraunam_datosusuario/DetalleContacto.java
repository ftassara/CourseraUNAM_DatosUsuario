package com.ftassara.courseraunam_datosusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalleContacto extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvMail;
    private TextView tvFecha;
    private TextView tvDesc;
    private Button btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        Bundle extras = getIntent().getExtras();
        String contacto = extras.getString(getResources().getString(R.string.pcontacto));
        String telefono = extras.getString(getResources().getString(R.string.ptelefono));
        String mail = extras.getString(getResources().getString(R.string.pmail));
        String fecha = extras.getString(getResources().getString(R.string.fechanac));
        String desc = extras.getString(getResources().getString(R.string.pdesc));


        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvMail = (TextView) findViewById(R.id.tvMail);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvDesc = (TextView) findViewById(R.id.tvDesc);
        btnEdit = (Button) findViewById(R.id.button2);
//ASIGNO EL VALOR A CADA TEXT VIEW
        tvNombre.setText(contacto);
        tvTelefono.setText(telefono);
        tvMail.setText(mail);
        tvFecha.setText(fecha);
        tvDesc.setText(desc);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            setResult(RESULT_OK, intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}