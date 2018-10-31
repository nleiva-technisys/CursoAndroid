package com.seccion.nleiva.ejercicioseccion4.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.seccion.nleiva.ejercicioseccion4.R;

public class MainActivity extends AppCompatActivity {

        private Button next,goList,goGrid, goRecyclerView,goCardView, goRecyclerAndCardView;
        private EditText nombre;
        private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.mipmap.ic_face);

       next = (Button) findViewById(R.id.buttonNext);
       nombre = findViewById(R.id.editTextIngresarNombre);
       goList=findViewById(R.id.buttonListView);
       goGrid=findViewById(R.id.buttonGoGrid);
       goRecyclerView=findViewById(R.id.buttonRecyclerView);
       goCardView=findViewById(R.id.buttonCardView);
       goRecyclerAndCardView=findViewById(R.id.buttonRecyclerAndCardView);



    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            name = nombre.getText().toString();
            Intent nextPage = new Intent(MainActivity.this, SecondActivity.class);
            nextPage.putExtra("nombre", name);
            startActivity(nextPage);
        }
    });
        goList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // name = nombre.getText().toString();
                Intent nextPage = new Intent(MainActivity.this, ListViewActivity.class);
                //nextPage.putExtra("nombre", name);
                startActivity(nextPage);
            }
        });
        goGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // name = nombre.getText().toString();
                Intent nextPage = new Intent(MainActivity.this, GridViewActivity.class);
                //nextPage.putExtra("nombre", name);
                startActivity(nextPage);
            }
        });

        goRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // name = nombre.getText().toString();
                Intent nextPage = new Intent(MainActivity.this, RecyclerViewActivity.class);
                //nextPage.putExtra("nombre", name);
                startActivity(nextPage);
            }
        });
        goCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // name = nombre.getText().toString();
                Intent nextPage = new Intent(MainActivity.this, CardView.class);
                //nextPage.putExtra("nombre", name);
                startActivity(nextPage);
            }
        });
        goRecyclerAndCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // name = nombre.getText().toString();

                Intent nextPage = new Intent(MainActivity.this, RecyclerAndViewActivity.class);

                //nextPage.putExtra("nombre", name);
                startActivity(nextPage);
            }
        });






    }
}
