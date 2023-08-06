

package yt.ejercicio1_jpa_libreria.servicios;

import java.util.Scanner;
import yt.ejercicio1_jpa_libreria.entidades.Editorial;
import yt.ejercicio1_jpa_libreria.persistence.EditorialRepositorio;
 
public class EditorialServicio {
     Scanner sc = new Scanner (System.in).useDelimiter("\n");

     EditorialRepositorio editorialDAO = new EditorialRepositorio();
    
    public void crearEditorial() {
        Editorial editorialInstancia = new Editorial();
        System.out.println("Nombre de la editorial: ");
        String nombre =sc.next().toLowerCase();
        editorialInstancia.setAlta(true);
        editorialInstancia.setNombre(nombre);
        editorialDAO.crear(editorialInstancia);
    }
    
       public void darBaja () {
       System.out.println("Ingrese el Id de la editorial que se desea dar de baja");
       Integer id = sc.nextInt();
       Editorial editorial = editorialDAO.buscarEditorialPorId(id);
       editorial.setAlta(Boolean.FALSE);
       editorialDAO.editar(editorial);
       System.out.println("Editorial borrado");
   } 
    
    
}
