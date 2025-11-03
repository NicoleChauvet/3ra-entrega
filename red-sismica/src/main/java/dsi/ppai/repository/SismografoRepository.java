package dsi.ppai.repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dsi.ppai.entities.Sismografo;

public class SismografoRepository extends Repository<Sismografo, Long> {

    public SismografoRepository() {
        super();
    }

    @Override
    public Sismografo getById(Long id) {
        var lista = this.manager.createQuery("SELECT s FROM Sismografo s WHERE s.id = :id", Sismografo.class)
                .setParameter("id", id)
                .getResultList();
        return lista.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe un Sismografo con el Id " + id));
    }

    @Override
    public Set<Sismografo> getAll() {
        return this.manager.createQuery("SELECT s FROM Sismografo s", Sismografo.class)
                .getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<Sismografo> getAllStrem() {
        return this.manager.createQuery("SELECT s FROM Sismografo s", Sismografo.class).getResultStream();
    }

}
