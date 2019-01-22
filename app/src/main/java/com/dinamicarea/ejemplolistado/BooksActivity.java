package com.dinamicarea.ejemplolistado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class BooksActivity extends AppCompatActivity {

    ListView lvLibros;
    ArrayList<Book> booksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLibros = findViewById(R.id.lvLibros);

        addBooks();

        //Creamos el adapter y se le pasa como parámetro el contexto, el xml de la celda y el listado de libros
        BooksAdapter adapter = new BooksAdapter(
                BooksActivity.this,
                R.layout.book_list_item,
                booksList);

        lvLibros.setAdapter(adapter);

    }

    /**
     * Esta función añade libros
     */
    private void addBooks() {
        booksList = new ArrayList<>();

        Book book1 = new Book();
        book1.setTitle("La comunidad del anillo");
        book1.setAuthor("Tolkien");
        book1.setCoverUrl("https://imagessl8.casadellibro.com/a/l/t0/28/9788445073728.jpg");

        Book book2 = new Book();
        book2.setTitle("Las dos torres");
        book2.setAuthor("Tolkien");
        book2.setCoverUrl("https://imagessl5.casadellibro.com/a/l/t0/35/9788445073735.jpg");

        Book book3 = new Book();
        book3.setTitle("El retorno del rey");
        book3.setAuthor("Tolkien");
        book3.setCoverUrl("https://imagessl1.casadellibro.com/a/l/t0/11/9788445077511.jpg");

        for (int i = 0; i < 10; i++) {
            booksList.add(book1);
            booksList.add(book2);
            booksList.add(book3);
        }
    }
}
