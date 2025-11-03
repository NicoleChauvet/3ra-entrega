package dsi.ppai.repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dsi.ppai.entities.Rol;

public class RolRepository extends Repository<Rol, Long> {

    public RolRepository() {
        super();
    }

    @Override
    public Rol getById(Long id) {
        var lista = this.manager.createQuery("SELECT r FROM Rol r WHERE r.id = :id", Rol.class)
                .setParameter("id", id)
                .getResultList();
        return lista.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe un Rol con el Id " + id));
    }

    @Override
    public Set<Rol> getAll() {
        return this.manager.createQuery("SELECT r FROM Rol r", Rol.class)
                .getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<Rol> getAllStrem() {
        return this.manager.createQuery("SELECT r FROM Rol r", Rol.class).getResultStream();
    }

}
