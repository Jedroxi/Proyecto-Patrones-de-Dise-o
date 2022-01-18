package proyecto.repositories;

import java.util.List;
import proyecto.models.Plan;

public interface PlanRepositorio {
    void create(Plan plan);

    Plan find(String id);

    List<Plan> findAll();

    Plan update(Plan post, String id);

    void delete(String id);
}
