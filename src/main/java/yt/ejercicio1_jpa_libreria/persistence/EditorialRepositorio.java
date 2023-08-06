 
package yt.ejercicio1_jpa_libreria.persistence;

import java.util.List;
import yt.ejercicio1_jpa_libreria.entidades.Editorial;

 
public class EditorialRepositorio extends Repositorio<Editorial>{
    


 
    public void borrar(Editorial object) {
        super.borrar(object); 
    }

 
    public void crear(Editorial object) {
        super.crear(object); 
    }

   
    public void editar(Editorial object) {
        super.editar(object);  
    }
    
    
 
//    public List<Editorial> buscarPorNombre (String nombre) {
//        String solicitud ="SELECT e FROM Editorial WHERE e.nombre=:nombre";
//        return em.createQuery(solicitud, Editorial.class).
//                setParameter("nombre", nombre).getResultList();
//    }

    public Editorial buscarEditorialPorId(Integer id) {
            Editorial editorial = em.find(Editorial.class, id);
        return editorial; 
    }
    

    
    
}
