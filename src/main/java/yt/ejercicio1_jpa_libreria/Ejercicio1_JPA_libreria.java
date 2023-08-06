
package yt.ejercicio1_jpa_libreria;

 
import yt.ejercicio1_jpa_libreria.servicios.AutorServicio;
import yt.ejercicio1_jpa_libreria.servicios.EditorialServicio;
import yt.ejercicio1_jpa_libreria.servicios.LibroServicio;

 
public class Ejercicio1_JPA_libreria {

    public static void main(String[] args) {
        AutorServicio a1 = new AutorServicio();
//        a1.crearAutor();
         
         EditorialServicio e1 = new EditorialServicio();
//        e1.crearEditorial();
        
        LibroServicio l1 = new LibroServicio();
//        System.out.println("Metodo crear libro \n\n");
//        l1.crearLibro();
        System.out.println("\nMetodo buscar por autor ");
//         a1.buscarAutorNombre();
         System.out.println(a1.buscarAutorNombre());
        System.out.println("\n Metodo buscar lirbo por nombre de autor ");
        l1.buscarLibroPorAutor();
        
    }
}
