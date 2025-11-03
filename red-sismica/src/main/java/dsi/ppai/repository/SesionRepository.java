package dsi.ppai.repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dsi.ppai.entities.Sesion;

public class SesionRepository extends Repository<Sesion, Long> {

    public SesionRepository() {
        super();
    }

    @Override
    public Sesion getById(Long id) {
        var lista = this.manager.createQuery("SELECT s FROM Sesion s WHERE s.id = :id", Sesion.class)
                .setParameter("id", id)
                .getResultList();
        return lista.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe una Sesion con el Id " + id));
    }

    @Override
    public Set<Sesion> getAll() {
        return this.manager.createQuery("SELECT s FROM Sesion s", Sesion.class)
                .getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<Sesion> getAllStrem() {
        return this.manager.createQuery("SELECT s FROM Sesion s", Sesion.class).getResultStream();
    }

}
