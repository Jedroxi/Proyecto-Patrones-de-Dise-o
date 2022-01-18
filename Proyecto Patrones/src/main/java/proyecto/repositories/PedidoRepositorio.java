package proyecto.repositories;

import java.util.List;

import proyecto.models.OrderService;

public interface PedidoRepositorio {
    
    void create(OrderService order);

    OrderService find(String id);

    List<OrderService> findAll();

    OrderService update(OrderService post, String id);

    void delete(String id);

    List<OrderService> findOrderByUser(String idUser);
}
