
package yt.ejercicio1_jpa_libreria.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Erica
 */
public abstract class Repositorio<T> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ej1Libreria_JPAPU");
    protected EntityManager em = emf.createEntityManager();

    protected void conectar() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    ///encargado del crud
//    public void persistirEntidad(T object) {
//        try {
//            em.getTransaction().begin();
//            em.persist(object);
//            em.getTransaction().commit();
//            System.out.println("Cargado exitosamente");
//        } catch (Exception e) {
//            System.out.println("No se pudo cargar");
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//        }finally {
//            desconectar();
//        }
//    }

    protected void crear(T object) {
        try {
            conectar();
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            System.out.println("Creadp exitosamente");
        } catch (Exception e) {
            System.out.println("Error al crear la base de datos");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectar();
        }
    }

    protected void editar(T object) {
        try {
            conectar();
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al editar la base de datos");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectar();
        }
    }

    protected void borrar(T object) {
        try {
            conectar();
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al borrar la base de datos");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectar();
        }
    }

}

