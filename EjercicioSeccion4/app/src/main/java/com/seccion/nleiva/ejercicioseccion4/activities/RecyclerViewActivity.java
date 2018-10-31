package com.seccion.nleiva.ejercicioseccion4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.seccion.nleiva.ejercicioseccion4.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<String> name;
    private RecyclerView rv;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int cont = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        name =getAllNames();

        rv= findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this);
        layoutManager=new GridLayoutManager(this, 2);
        layoutManager= new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

//        myAdapter= new MyAdapter(name, R.layout.recycler_view_item, new MyAdapter.ViewHolder.onItemClickListener() {
//            @Override
//            public void onItemClick(Movie name, int position) {
//               // Toast.makeText(RecyclerViewActivity.this, name + " - "+  position,Toast.LENGTH_LONG).show();
//                deleteName(position);
//            }
//        });

        rv.setLayoutManager(layoutManager);
        rv.setAdapter(myAdapter);

        //Si uso StaggeredGridLayoutManager esta opcion no va
        rv.setHasFixedSize(true);

        rv.setItemAnimator(new DefaultItemAnimator());

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
        name.add(position, "New Name" + (++cont));
        myAdapter.notifyItemInserted(position);
        layoutManager.scrollToPosition(position);
    }
    private void deleteName(int position){
        name.remove(position);
        myAdapter.notifyItemRemoved(position);
    }


    public List<String> getAllNames(){
        return new ArrayList<String>(){{
            add("Nicolas");
            add("Nic");
            add("Niolas");
            add("Kicolas");

        }};
    }
}
