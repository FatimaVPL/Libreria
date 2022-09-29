/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author fatim
 */
public class Libro {
     private String titulo;
    private List<Autor> autores;
    private String edicion;
    private String isbn;

    public Libro(String titulo, List<Autor> autores, String edicion, String isbn) {
        this.titulo = titulo;
        this.autores = autores;
        this.edicion = edicion;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public String getEdicion() {
        return edicion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
