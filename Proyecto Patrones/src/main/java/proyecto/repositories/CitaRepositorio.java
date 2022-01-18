package proyecto.repositories;

import java.util.List;

import proyecto.models.Cita;

public interface CitaRepositorio {
    void create(Cita item);

    Cita find(String id);

    List<Cita> findAll();

    Cita update(Cita post, String id);

    void delete(String id);
}
