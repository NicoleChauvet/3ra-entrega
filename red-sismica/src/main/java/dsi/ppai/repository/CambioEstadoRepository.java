package dsi.ppai.repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dsi.ppai.entities.CambioEstado;

public class CambioEstadoRepository extends Repository<CambioEstado, Long> {

    public CambioEstadoRepository() {
        super();
    }

    @Override
    public CambioEstado getById(Long id) {
        var lista = this.manager.createQuery("SELECT c FROM CambioEstado c WHERE c.id = :id", CambioEstado.class)
                .setParameter("id", id)
                .getResultList();
        return lista.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe un CambioEstado con el Id " + id));
    }

    @Override
    public Set<CambioEstado> getAll() {
        return this.manager.createQuery("SELECT c FROM CambioEstado c", CambioEstado.class)
                .getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<CambioEstado> getAllStrem() {
        return this.manager.createQuery("SELECT c FROM CambioEstado c", CambioEstado.class).getResultStream();
    }

}
