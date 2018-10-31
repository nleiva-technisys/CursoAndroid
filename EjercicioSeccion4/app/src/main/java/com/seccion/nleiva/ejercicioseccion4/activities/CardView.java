package com.seccion.nleiva.ejercicioseccion4.activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.seccion.nleiva.ejercicioseccion4.R;

public class CardView extends AppCompatActivity {

    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        tv = findViewById(R.id.textViewInCardView);
        tv.setText("BIENVENIDOS");
    }
}
