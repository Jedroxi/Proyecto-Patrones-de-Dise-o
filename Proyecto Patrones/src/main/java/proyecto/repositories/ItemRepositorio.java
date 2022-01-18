package proyecto.repositories;

import java.util.List;

import proyecto.models.ItemService;

public interface ItemRepositorio {
    void create(ItemService item);

    ItemService find(String id);

    List<ItemService> findAll();

    ItemService update(ItemService post, String id);

    void delete(String id);
}
