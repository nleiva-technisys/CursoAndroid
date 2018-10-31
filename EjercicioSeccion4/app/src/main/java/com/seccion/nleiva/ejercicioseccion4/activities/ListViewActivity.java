package com.seccion.nleiva.ejercicioseccion4.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.seccion.nleiva.ejercicioseccion4.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private List<String> names;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        list = findViewById(R.id.listViewMuestra);

        names=new ArrayList<String>();
        names.add("Nico");
        names.add("Tomi");
        names.add("Delfi");
        names.add("Marti");


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
//        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Seleccionado: "+ names.get(position), Toast.LENGTH_LONG).show();
            }
        });

        MyAdapter myAdapter = new MyAdapter(this, R.layout.listitem,names);
        list.setAdapter(myAdapter);
    }

    public static class MyAdapter extends BaseAdapter {

        private Context context;
        private int layout;
        private List <String> names;

        public MyAdapter(Context context, int layout, List <String> names){
            this.context=context;
            this.layout=layout;
            this.names=names;
        }

        @Override
        public int getCount() {
            //NUMERO DE ITEMS A DIBUJAR
            return names.size();
        }

        @Override
        public Object getItem(int position) {
            return names.get(position);
        }

        @Override
        public long getItemId(int id) {
            return id;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //AGARRA CADA ITEM Y SE DIBUJA

            ViewHolder holder;
            if(convertView==null){
                LayoutInflater lflater= LayoutInflater.from(context);
                convertView = lflater.inflate(this.layout,null);
                holder = new ViewHolder();
                holder.tv = (TextView) convertView.findViewById(R.id.textView);
                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
           }
            //LEVANTO VISTA Y LUEGO LA INFLO CON NUESTRA INFO
            //View v = convertView;

            String curretName = names.get(position);
            //TextView tv = (TextView) v.findViewById(R.id.textView);
            holder.tv.setText(curretName);

            return convertView;
        }
    }
    static class ViewHolder {
        private TextView tv;
    }
}
