 
package yt.ejercicio1_jpa_libreria.servicios;

import java.util.List;
import java.util.Scanner;
import yt.ejercicio1_jpa_libreria.entidades.Autor;
import yt.ejercicio1_jpa_libreria.persistence.AutorRepositorio;
 


public class AutorServicio {
    Scanner sc = new Scanner (System.in).useDelimiter("\n");

    AutorRepositorio autorDAO = new AutorRepositorio();
    
    
    /////////////no ES void porque se necesita que se devuelva el OBJETO que va a ser usado en LIBRO, el atributo autor
    public Autor crearAutor() {
        Autor autor = new Autor();
        System.out.println("Nombre del autor: ");
        String nombre =sc.next().toLowerCase();
        autor.setAlta(true);
        autor.setNombre(nombre);
        autorDAO.crear(autor);
       return autor;
    }
    
    public void editarAutor ( ) {
        System.out.println("Ingrese el nombre del autor que desea editar ");
        String autorEditar = sc.next();
//        Autor autor = autorDAO.buscarPorNombre(autorEditar);
//        if 
    }
   
        
   public void darBaja () {
       System.out.println("Ingrese el Id del autor que se desea dar de baja");
       Integer id = sc.nextInt();
       Autor autor = autorDAO.buscarAutorPorId(id);
       autor.setAlta(Boolean.FALSE);
       autorDAO.borrar(autor);
       System.out.println("Autor borrado");
   } 
    
   
   public List <Autor> buscarAutorNombre () {
       
       System.out.println("Ingrese el nombre del autor");
       String nombre = sc.next();
        return autorDAO.buscarPorNombre(nombre);
   }
   
   
   
}
