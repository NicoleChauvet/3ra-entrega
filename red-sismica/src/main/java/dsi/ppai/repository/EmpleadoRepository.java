package dsi.ppai.repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dsi.ppai.entities.Empleado;

public class EmpleadoRepository extends Repository<Empleado, Long> {

    public EmpleadoRepository() {
        super();
    }

    @Override
    public Empleado getById(Long id) {
        var lista = this.manager.createQuery("SELECT e FROM Empleado e WHERE e.id = :id", Empleado.class)
                .setParameter("id", id)
                .getResultList();
        return lista.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe un Empleado con el Id " + id));
    }

    @Override
    public Set<Empleado> getAll() {
        return this.manager.createQuery("SELECT e FROM Empleado e", Empleado.class)
                .getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<Empleado> getAllStrem() {
        return this.manager.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultStream();
    }

}
