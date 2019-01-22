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


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Creamos el inflate
        LayoutInflater inflater = LayoutInflater.from(context);
        //"Inflamos" la vista a partir del XML
        View cell = inflater.inflate(resource, null);

        //Enlazamos las variables java con los componentes del xml
        TextView tvTitle = cell.findViewById(R.id.tvTitle);
        TextView tvAuthor = cell.findViewById(R.id.tvAuthor);
        ImageView ivCover = cell.findViewById(R.id.ivCover);

        //Obtenemos el libro que está en la posición "position" de la lista bookList
        Book book = booksList.get(position);

        //Rellenamos la celda con los valores del libro
        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());

        //Sacamos la url del objeto libro
        String url = book.getCoverUrl();

        //Usamos la librería glide para cargar una url en el imageView
        Glide.with(context).load(url).into(ivCover);

        //Devolvemos la celda creada
        return cell;
    }
}
