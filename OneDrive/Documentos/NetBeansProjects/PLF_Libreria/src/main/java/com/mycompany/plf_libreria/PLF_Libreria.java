/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.plf_libreria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import model.Autor;
import model.Genero;
import model.Libreria;
import model.Libro;

/**
 *
 * @author monse
 */
public class PLF_Libreria {

    public static void main(String[] args) {
        Libreria  libreria = new Libreria("Ocho Libros");
        
        ArrayList<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Craig Larman",70, Genero.HOMBRE));
        Libro libro = new Libro("UML y Patrones", autor, "7ma","1234567890");
        libreria.agregarLibro(libro);
        
        autor = new ArrayList<>();
        autor.add(new Autor("Jane Austen",100, Genero.MUJER));
        libro = new Libro("Orgullo y Prejuicio", autor, "7ma","1234567890");
        libreria.agregarLibro(libro);
        
         autor.add(new Autor("Fatima Perez",21, Genero.MUJER));
         autor.add(new Autor("Gabi",54, Genero.MUJER));
        
        //Obtener todos los nombres de todos los libros
        List<String> libros = libreria.obtenerLibros();
        System.out.println("Titulos disponibles: " + libros);
        
        System.out.println("Autores"+ libreria.obtenerAutores());
        
        System.out.println("Agrupados: "+ libreria.agruparPorGenero());
        
        
        int suma = IntStream.range(0, 100).sum();
        System.out.println(suma);
        
//        IntStream.iterate(0, valor -> +1)
//                .forEach(valor -> System.out.println(valor))
//                ;


    }
}
