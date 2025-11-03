package dsi.ppai.repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dsi.ppai.entities.OrdenInspeccion;

public class OrdenInspeccionRepository extends Repository<OrdenInspeccion, Long> {

    public OrdenInspeccionRepository() {
        super();
    }

    @Override
    public OrdenInspeccion getById(Long id) {
        var lista = this.manager.createQuery("SELECT o FROM OrdenInspeccion o WHERE o.id = :id", OrdenInspeccion.class)
                .setParameter("id", id)
                .getResultList();
        return lista.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe una OrdenInspeccion con el Id " + id));
    }

    @Override
    public Set<OrdenInspeccion> getAll() {
        return this.manager.createQuery("SELECT o FROM OrdenInspeccion o", OrdenInspeccion.class)
                .getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<OrdenInspeccion> getAllStrem() {
        return this.manager.createQuery("SELECT o FROM OrdenInspeccion o", OrdenInspeccion.class).getResultStream();
    }

}
