 
package yt.ejercicio1_jpa_libreria.servicios;

import java.util.List;
import java.util.Scanner; 
import yt.ejercicio1_jpa_libreria.entidades.Autor;
import yt.ejercicio1_jpa_libreria.entidades.Libro;
import yt.ejercicio1_jpa_libreria.persistence.AutorRepositorio;
import yt.ejercicio1_jpa_libreria.persistence.EditorialRepositorio;
import yt.ejercicio1_jpa_libreria.persistence.LibroRepositorio;

public class LibroServicio {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    LibroRepositorio libroDAO = new LibroRepositorio();

    public void crearLibro() {
        AutorRepositorio autorDao = new AutorRepositorio();
        EditorialRepositorio editorialDaoInstancia = new EditorialRepositorio();
        EditorialServicio editorialServicioInstancia = new EditorialServicio();
        AutorServicio autorServicio = new AutorServicio();
        Libro libroInstancia = new Libro();
        System.out.println("Ingrese el isbn del libro");
        do {
            try {
                long isbn = sc.nextLong();
                libroInstancia.setIsbn(isbn);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al ingresar el ISBN");
            }
        } while (true);

        do {
            System.out.println("Ingrese el Nombre del libro: ");
            String tituloLibro = sc.next();
            if (!buscarLibroTitulo(tituloLibro)) {
                System.out.println("El libro ya esta cargado" + libroInstancia.getTitulo());
            } else {
                libroInstancia.setTitulo(tituloLibro);
                break;
            }
        } while (true);

        do {
            System.out.println("Ingrese el año de edición del libro: ");
            try {
                libroInstancia.setAnio(sc.nextInt());

                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al ingresar el año");
            }
        } while (true);

        do {
            System.out.println("Ingrese la cantidad de ejemplares ");
            try {
                libroInstancia.setEjemplares(sc.nextInt());
                libroInstancia.setEjemplaresRestantes(libroInstancia.getEjemplares());
                libroInstancia.setEjemplaresPrestados(0);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al ingresar la cantidad de ejemplares");
            }
        } while (true);

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
        Libro libroObj = libroDAO.buscarLibroPorIsbn(isbn);
        libroObj.setAlta(Boolean.FALSE);
        libroDAO.borrar(libroObj);
        System.out.println("Editorial borrado");
    }

    public void buscarLibroPorAutor() {
        System.out.println("Ingrese el nombre del autor a buscar ");
        String nombreAutor = sc.next();
        System.out.println("Resultado búsqueda: " + libroDAO.buscarLibroPorAutor(nombreAutor));
    }

    public void buscarLibroTitulo() {
        System.out.println("Ingrese el titulo del libro a buscar ");
        String aux = sc.next();
        System.out.println(libroDAO.buscarLibroPorTitulo(aux).toString());
        System.out.println("metodo libroTitulo exitoso");
    }

    //SOBRECARGA DE METODO
    public boolean buscarLibroTitulo(String titulo) {
        System.out.println("Ingrese el titulo del libro a buscar ");
        List<Libro> aux = libroDAO.buscarLibroPorTitulo(titulo);
        return aux.isEmpty(); // devuelve true
    }

    public void buscarLibroEditorial() {
        System.out.println("Ingrese el nombre de la editorial del libro a buscar ");
        String aux = sc.next();
        System.out.println(libroDAO.buscarLibroPorEditorial(aux).toString());
        System.out.println("metodo libroEditorial exitoso");
    }

}
