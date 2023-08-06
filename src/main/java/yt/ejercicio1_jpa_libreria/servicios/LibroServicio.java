 
package yt.ejercicio1_jpa_libreria.servicios;

import java.util.Scanner; 
import yt.ejercicio1_jpa_libreria.entidades.Autor;
import yt.ejercicio1_jpa_libreria.entidades.Editorial;
import yt.ejercicio1_jpa_libreria.entidades.Libro;
import yt.ejercicio1_jpa_libreria.persistence.AutorRepositorio;
import yt.ejercicio1_jpa_libreria.persistence.EditorialRepositorio;
import yt.ejercicio1_jpa_libreria.persistence.LibroRepositorio;

 
public class LibroServicio {
     Scanner sc = new Scanner (System.in).useDelimiter("\n");

     LibroRepositorio libroDAO = new LibroRepositorio();
    
    public void crearLibro() {
        AutorRepositorio autorDao = new AutorRepositorio();
        EditorialRepositorio editorialDaoInstancia = new EditorialRepositorio();
        EditorialServicio editorialServicioInstancia = new EditorialServicio();
        AutorServicio autorServicio = new AutorServicio();
        Libro libroInstancia = new Libro();
        
        System.out.println("Ingrese el isbn del libro");
        long isbn = sc.nextLong();
        libroInstancia.setIsbn(isbn);
        System.out.println("Nombre del libro: ");
        libroInstancia.setTitulo(sc.next());
        System.out.printf("Ingrese la cantidad de ejemplares del libro ", libroInstancia.getTitulo() );
        libroInstancia.setEjemplares(sc.nextInt());
        
        libroInstancia.setEjemplaresRestantes(libroInstancia.getEjemplares());
        libroInstancia.setEjemplaresPrestados(0);
        
        libroInstancia.setAlta(true);
        libroDAO.crear(libroInstancia);
        Autor autorS = autorServicio.crearAutor();
        libroInstancia.setAutor(autorS);
        editorialServicioInstancia.crearEditorial();
        libroDAO.editar(libroInstancia);
        
    }    
    
      public void darBaja() {
        System.out.println("Ingrese el isbn del libro  que se desea dar de baja");
        Integer isbn = sc.nextInt();
        Libro libroObj= libroDAO.buscarLibroPorIsbn(isbn);
        libroObj.setAlta(Boolean.FALSE);
        libroDAO.borrar(libroObj);
        System.out.println("Editorial borrado");
    }
      
      
      
       public void buscarLibroPorAutor () {
           System.out.println("Ingrese el nombre del autor a buscar ");
           String nombreAutor = sc.next();
           System.out.println("Resultado búsqueda: " + libroDAO.buscarLibroPorAutor(nombreAutor));
           
       }
 
}
