package dsi.ppai.repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dsi.ppai.entities.MotivoTipo;

public class MotivoTipoRepository extends Repository<MotivoTipo, Long> {

    public MotivoTipoRepository() {
        super();
    }

    @Override
    public MotivoTipo getById(Long id) {
        var lista = this.manager.createQuery("SELECT m FROM MotivoTipo m WHERE m.id = :id", MotivoTipo.class)
                .setParameter("id", id)
                .getResultList();
        return lista.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe un MotivoTipo con el Id " + id));
    }

    @Override
    public Set<MotivoTipo> getAll() {
        return this.manager.createQuery("SELECT m FROM MotivoTipo m", MotivoTipo.class)
                .getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<MotivoTipo> getAllStrem() {
        return this.manager.createQuery("SELECT m FROM MotivoTipo m", MotivoTipo.class).getResultStream();
    }

}
