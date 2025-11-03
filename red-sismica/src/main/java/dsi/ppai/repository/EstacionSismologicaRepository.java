package dsi.ppai.repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dsi.ppai.entities.EstacionSismologica;

public class EstacionSismologicaRepository extends Repository<EstacionSismologica, Long> {

    public EstacionSismologicaRepository() {
        super();
    }

    @Override
    public EstacionSismologica getById(Long id) {
        var lista = this.manager
                .createQuery("SELECT e FROM EstacionSismologica e WHERE e.id = :id", EstacionSismologica.class)
                .setParameter("id", id)
                .getResultList();
        return lista.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe una EstacionSismologica con el Id " + id));
    }

    @Override
    public Set<EstacionSismologica> getAll() {
        return this.manager.createQuery("SELECT e FROM EstacionSismologica e", EstacionSismologica.class)
                .getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<EstacionSismologica> getAllStrem() {
        return this.manager.createQuery("SELECT e FROM EstacionSismologica e", EstacionSismologica.class)
                .getResultStream();
    }

}
