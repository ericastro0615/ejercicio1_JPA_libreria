 
package yt.ejercicio1_jpa_libreria.servicios;

import java.util.Scanner;
import yt.ejercicio1_jpa_libreria.entidades.Autor;
import yt.ejercicio1_jpa_libreria.persistence.AutorRepositorio;
 


public class AutorServicio {
    Scanner sc = new Scanner (System.in).useDelimiter("\n");

    AutorRepositorio autorDAO = new AutorRepositorio();
    
    
    /////////////arreglar met crear
    public void crearAutor() {
        Autor autor = new Autor();
        System.out.println("Nombre del autor: ");
        String nombre =sc.next().toLowerCase();
        autor.setAlta(true);
        autor.setNombre(nombre);
        autorDAO.crear(autor);
       
    }
    
//    public void editarAutor ( Autor autor) {
//        
//    }
   
        
    
    
}
