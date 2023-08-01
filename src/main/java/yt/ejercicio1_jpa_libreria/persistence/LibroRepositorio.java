/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    
 
//    public List<Libro> buscarPorNombre (String nombre) {
//        String solicitud ="SELECT l FROM Libro l WHERE e.nombre=:nombre";
//        return em.createQuery(solicitud, Libro.class).
//                setParameter("nombre", nombre).getResultList();
//    }
}
