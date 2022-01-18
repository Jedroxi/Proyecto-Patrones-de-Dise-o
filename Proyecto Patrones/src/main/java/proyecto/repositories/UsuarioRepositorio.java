package proyecto.repositories;

import java.util.List;

import proyecto.models.Usuario;

public interface UsuarioRepositorio {
    
    void create(Usuario order);

    Usuario find(String id);

    List<Usuario> findAll();

    Usuario update(Usuario post, String id);

    void delete(String id);

    Usuario login(String id,String password);
}
