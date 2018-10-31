package com.seccion.nleiva.ejercicioseccion4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.seccion.nleiva.ejercicioseccion4.models.Movie;
import com.seccion.nleiva.ejercicioseccion4.adapters.MyAdapter;
import com.seccion.nleiva.ejercicioseccion4.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAndViewActivity extends AppCompatActivity {

    private List<Movie> movies;
    private RecyclerView rv;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int cont = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_and_view);

            movies = getAllFilms();

            rv = findViewById(R.id.recycler_cardview);
            layoutManager = new LinearLayoutManager(this);
           // layoutManager = new GridLayoutManager(this, 2);
           // layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        myAdapter= new MyAdapter(movies, R.layout.recycler_and_cardview_item, new MyAdapter.ViewHolder.onItemClickListener() {
            @Override
            public void onItemClick(Movie name, int position) {
               // Toast.makeText(RecyclerViewActivity.this, name + " - "+  position,Toast.LENGTH_LONG).show();
                deleteName(position);
            }
        });

            rv.setLayoutManager(layoutManager);
            rv.setAdapter(myAdapter);

            //Si uso StaggeredGridLayoutManager esta opcion no va
            //rv.setHasFixedSize(true);

            //rv.setItemAnimator(new DefaultItemAnimator());

        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.add_name, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId()){
                case R.id.AddName:
                    this.addName(0);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }

        }

    private void addName(int position) {
        movies.add(position, new Movie("Peli ", R.drawable.fondohd));
        myAdapter.notifyItemInserted(position);
        layoutManager.scrollToPosition(position);
    }
    private void deleteName(int position){
        movies.remove(position);
        myAdapter.notifyItemRemoved(position);
    }



        public List<Movie> getAllFilms(){
            return new ArrayList<Movie>(){{
                add(new Movie("Pelicula 1", R.drawable.images));
                add(new Movie("Pelicula 2", R.drawable.poster));
                add(new Movie("Pelicula 3", R.drawable.poster1));
                add(new Movie("Pelicula 4", R.drawable.poster3));

            }};
        }

}

