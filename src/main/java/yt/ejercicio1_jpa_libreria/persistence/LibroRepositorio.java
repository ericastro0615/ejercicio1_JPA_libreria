 
package yt.ejercicio1_jpa_libreria.persistence;

import java.util.List;
import yt.ejercicio1_jpa_libreria.entidades.Libro;


public class LibroRepositorio extends Repositorio<Libro >{
     
    
   
 
    public void borrar(Libro object) {
        super.borrar(object); 
    }

 
    public void crear(Libro object) {
        super.crear(object); 
    }
 
    public void editar(Libro object) {
        super.editar(object);  
    }
    
    
    public List<Libro> buscarLibroPorTitulo(String titulo) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo =:titulo").setParameter("titulo", titulo)
                .getResultList();
        desconectar();
        return libros;
    }
     
 

    public Libro buscarLibroPorIsbn(Integer isbn) {
         Libro libro = em.find(Libro.class, isbn);
        return libro; 
    }
    
    public List <Libro> buscarLibroPorAutor (String nombreAutor) {
        conectar();
//        return (List<Libro>) em.createQuery("SELECT l FROM Libro l WHERE l.isbn = (SELECT a.id FROM Autor a WHERE a.nombre=:nombre)") .setParameter ("nombre", nombreAutor).getResultList();
/// ES NEECSARIO CONECTAR Y DESCONECTAR LA BASE, POR ESO SE RETORNA CON VARIABLE
     List<Libro> libros=  em.createQuery("SELECT l FROM Libro l WHERE l.autor.id = (SELECT a.id FROM Autor a WHERE a.nombre=:nombre)")
                .setParameter ("nombre", nombreAutor)
                .getResultList();
        desconectar();
        return libros;
    }
    
    //////  no LOGRA MOSTRAR RESULTADOS IDENTICOS, SOLO SINGULARES Y NO REPETIDOs
    public List<Libro> buscarLibroPorEditorial(String nombre) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.id = (SELECT e.id FROM Editorial e WHERE e.nombre=:nombre)").setParameter("nombre", nombre).getResultList();
        desconectar();
        return libros;
    }
    
    
}
