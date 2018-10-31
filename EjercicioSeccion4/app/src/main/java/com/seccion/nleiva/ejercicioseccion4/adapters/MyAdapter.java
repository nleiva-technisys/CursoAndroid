package com.seccion.nleiva.ejercicioseccion4.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seccion.nleiva.ejercicioseccion4.R;
import com.seccion.nleiva.ejercicioseccion4.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Movie> names;
    private int count =0;
    private ViewHolder.onItemClickListener itemClickListener;
    private Context context;


    public MyAdapter(List<Movie> names , int count, ViewHolder.onItemClickListener itemClickListener){
        this.names=names;
        this.count=count;
        this.itemClickListener=itemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(count,viewGroup,false);
       ViewHolder vh = new ViewHolder(v);
       context = viewGroup.getContext();
       return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(names.get(position) ,itemClickListener);

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

        public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViemName;
        public ImageView imageView;

            public ViewHolder(View itemView){
                super(itemView);
                this.textViemName = itemView.findViewById(R.id.textViewTitle);
                this.imageView= itemView.findViewById(R.id.imageViewMovie);
            }

            public interface onItemClickListener{
                void onItemClick(Movie name, int position);
            }


            public void bind (final Movie name, final onItemClickListener itemClickListener){
                textViemName.setText(name.getName());
                Picasso.get().load(name.getImage()).fit().into(imageView);
                //imageView.setImageResource(name.getImage());
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    itemClickListener.onItemClick(name,getAdapterPosition());
                    }
                });
            }

        }
}
