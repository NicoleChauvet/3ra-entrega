package dsi.ppai.repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dsi.ppai.entities.Usuario;

public class UsuarioRepository extends Repository<Usuario, Long> {

    public UsuarioRepository() {
        super();
    }

    @Override
    public Usuario getById(Long id) {
        var lista = this.manager.createQuery("SELECT u FROM Usuario u WHERE u.id = :id", Usuario.class)
                .setParameter("id", id)
                .getResultList();
        return lista.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe un Usuario con el Id " + id));
    }

    @Override
    public Set<Usuario> getAll() {
        return this.manager.createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<Usuario> getAllStrem() {
        return this.manager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultStream();
    }

}
