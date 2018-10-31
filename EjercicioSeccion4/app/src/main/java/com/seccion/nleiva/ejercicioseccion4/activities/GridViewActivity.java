package com.seccion.nleiva.ejercicioseccion4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.seccion.nleiva.ejercicioseccion4.R;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {
    private List<String> names;
    private GridView Gridlist;
    private int count =0;
    private ListViewActivity.MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        Gridlist = findViewById(R.id.gridText);

        names=new ArrayList<String>();
        names.add("Nico");
        names.add("Tomi");
        names.add("Delfi");
        names.add("Marti");


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
//        list.setAdapter(adapter);

        Gridlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "Seleccionado: "+ names.get(position), Toast.LENGTH_LONG).show();
            }
        });

       myAdapter = new ListViewActivity.MyAdapter(this, R.layout.grid_layout,names);
        Gridlist.setAdapter(myAdapter);
        registerForContextMenu(Gridlist);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInfl = getMenuInflater();
        menuInfl.inflate(R.menu.action_bar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.Add:
            this.names.add("add N°" + (++count));
            this.myAdapter.notifyDataSetChanged();
            return true;

          default:
              return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(names.get(info.position));
        MenuInflater menuInfl = getMenuInflater();
        menuInfl.inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.item_Delete:
                this.names.remove(info.position);
                this.myAdapter.notifyDataSetChanged();
                return true;

            default:
                return super.onContextItemSelected(item);
        }


    }
}
