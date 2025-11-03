package dsi.ppai.repository.context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbContext {
    private final EntityManager manager; // el EntityManager es el que maneja las operaciones con la base de datos

    public static DbContext instance = null; // para el patrón singleton (una sola instancia de DbContext)

    private DbContext() {
        // esto es lo que conecta con la base de datos y se debe de modificar el "empleados" por el nombre de la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("empleados"); // 
        manager = emf.createEntityManager(); // creamos el EntityManager para que maneje las operaciones
    }

    // método para obtener la instancia de DbContext (patrón singleton)
    public static DbContext getInstance() {
        if (instance == null) { // si no existe una instancia, la creamos
            instance = new DbContext();
        }
        return instance;
    }

    // método para obtener el EntityManager y poder usarlo en los repositorios
    public EntityManager getManager() {
        return this.manager;
    }
}
