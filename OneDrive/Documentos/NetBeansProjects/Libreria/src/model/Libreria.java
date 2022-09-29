/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

/**
 *
 * @author fatim
 */
public class Libreria {
     private List<Libro> libros;
    private String nombre;

    public Libreria(String nom) {
        libros = new ArrayList<>();
        this.nombre = nom;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean agregarLibro(Libro l) {
        libros.add(l);
        return true;
    }

    public List<String> obtenerLibros() {
        List<String> nomLibros = libros.stream()
                .map(libro -> libro.getTitulo())
                .collect(Collectors.toList());
        return nomLibros;
    }

    //obtener los autores con más
    public List<String> obtenerAutores() {
        List<String> nomAutores = libros.stream()
                .map(book -> book.getAutores())
                .flatMap(autores -> autores.stream())
                .filter(autor -> autor.getEdad() >= 50)
                .map(Autor::getNombre)
                .map(String::toUpperCase)
                .distinct()
                .limit(15)
                .collect(Collectors.toList());
        return nomAutores;
    }

    public int obtenerSumadeEdadesAutores() {
        return libros.stream()
                .map(libro -> libro.getAutores()) // solo se hace referencia a los que son de la clase
                // .map(Libro::getAutores)
                .flatMap(autores -> autores.stream())
                // .flatMap(List<Autor>::stream())
                // .peek(autor -> sout("Salida flatMap: "+ autor))
                .distinct()
                .map(autor -> autor.getEdad())
                //.map(Autor::getEdad)
                .reduce(0, (base, edad) -> base + edad); // se hace suma en arbolito
        //otra forma en vez de reduce()
        //mapToInt(Autor::getEdad)
        //sum()
        //peek para ver qué se está viendo, solo es como un tuvoo transparente
    }
    
    //Paralelismo, para hacer más operaciones a la vez
    public Map<Genero, List<Autor>> agruparPorGenero(){
              return   libros.parallelStream()
                .map(book -> book.getAutores())
                .flatMap(autores -> autores.parallelStream())
                .collect(groupingBy(Autor::getGenero));
     }
}
