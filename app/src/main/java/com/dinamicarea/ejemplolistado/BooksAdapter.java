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

public class BooksAdapter extends ArrayAdapter<Book> {

    Context context;
    ArrayList<Book> booksList;
    int resource;

    public BooksAdapter(Context context, int resource, ArrayList<Book> booksList) {
        super(context, resource, booksList);

        this.context = context;
        this.booksList = booksList;
        this.resource = resource;
    }


    /**
     * Genera la vista para la celda
     *
     * @param position    posición de la lista para la que vamos a generar la celda
     * @param convertView celda reciclada
     * @param parent      padre de la vista que hemos generado
     * @return una vista que representa a la celda
     */
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
            holder.tvAuthor = cell.findViewById(R.id.tvAuthor);
            holder.ivCover = cell.findViewById(R.id.ivCover);

            cell.setTag(holder);

        } else {
            //Obtenemos el holder de la celda (almacenado previamente)
            holder = (ViewHolder) cell.getTag();
        }

        //Obtenemos el libro que está en la posición "position" de la lista bookList
        Book book = booksList.get(position);

        //Rellenamos la celda con los valores del libro
        holder.tvTitle.setText(book.getTitle());
        holder.tvAuthor.setText(book.getAuthor());

        //Sacamos la url del objeto libro
        String url = book.getCoverUrl();

        //Usamos la librería glide para cargar una url en el imageView
        Glide.with(context).load(url).into(holder.ivCover);

        //Devolvemos la celda creada
        return cell;
    }


    class ViewHolder {
        TextView tvTitle;
        TextView tvAuthor;
        ImageView ivCover;
    }

}


