package proyecto.repositories;

import proyecto.models.estados.State;

public interface EstadoRepositorio {
    void create(State estado);

    State find(String id);
}
