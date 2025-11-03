package dsi.ppai.repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dsi.ppai.entities.MotivoFueraServicio;

public class MotivoFueraServicioRepository extends Repository<MotivoFueraServicio, Long> {

    public MotivoFueraServicioRepository() {
        super();
    }

    @Override
    public MotivoFueraServicio getById(Long id) {
        var lista = this.manager
                .createQuery("SELECT m FROM MotivoFueraServicio m WHERE m.id = :id", MotivoFueraServicio.class)
                .setParameter("id", id)
                .getResultList();
        return lista.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe un MotivoFueraServicio con el Id " + id));
    }

    @Override
    public Set<MotivoFueraServicio> getAll() {
        return this.manager.createQuery("SELECT m FROM MotivoFueraServicio m", MotivoFueraServicio.class)
                .getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<MotivoFueraServicio> getAllStrem() {
        return this.manager.createQuery("SELECT m FROM MotivoFueraServicio m", MotivoFueraServicio.class)
                .getResultStream();
    }

}
