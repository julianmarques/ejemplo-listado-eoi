package com.dinamicarea.ejemplolistado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FilmAdapter extends ArrayAdapter {

    Context context;
    ArrayList<Film> films;
    int resource;

    public FilmAdapter(Context context, int resource, ArrayList<Film> films) {
        super(context, resource, films);

        this.context = context;
        this.films = films;
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//Guardamos la celda reciclada en cell.
        View cell = convertView;
        ViewHolder holder;

        if (cell == null) {
            //Entra sólo cuando hay que crear la celda
            //Creamos el inflate
            LayoutInflater inflater = LayoutInflater.from(context);
            //"Inflamos" la vista a partir del XML
            cell = inflater.inflate(resource, null);


            holder = new ViewHolder();
            holder.tvTitle = cell.findViewById(R.id.tvTitle);
            holder.ivCover = cell.findViewById(R.id.ivPoster);

            cell.setTag(holder);

        } else {
            //Obtenemos el holder de la celda (almacenado previamente)
            holder = (ViewHolder) cell.getTag();
        }

        //Obtenemos el libro que está en la posición "position" de la lista bookList
        Film film = films.get(position);

        //Rellenamos la celda con los valores del libro
        holder.tvTitle.setText(film.getTitle());

        //Sacamos la url del objeto libro
        String url = film.getPosterUrl();

        //Usamos la librería glide para cargar una url en el imageView
        Glide.with(context).load(url).into(holder.ivCover);

        //Devolvemos la celda creada
        return cell;
    }

    class ViewHolder {
        TextView tvTitle;
        ImageView ivCover;
    }
}
