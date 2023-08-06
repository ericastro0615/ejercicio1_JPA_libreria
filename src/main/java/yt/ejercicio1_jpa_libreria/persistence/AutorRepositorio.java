 
package yt.ejercicio1_jpa_libreria.persistence;

import java.util.List;
import yt.ejercicio1_jpa_libreria.entidades.Autor;

 
public class AutorRepositorio extends Repositorio<Autor>{
 


 
    public void borrar(Autor object) {
        super.borrar(object); 
    }

 
    public void crear(Autor object) {
        super.crear(object); 
    }

   
    public void editar(Autor object) {
        super.editar(object);  
    }
     
 
    public List<Autor> buscarPorNombre (String nombre) {
        conectar();
        List solicitud= em.createQuery("SELECT a FROM Autor a WHERE a.nombre=:nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return solicitud;
    }
    
    public Autor buscarAutorPorId(Integer id) {
        Autor autor = em.find(Autor.class, id);
        return autor;
    }


    

}
