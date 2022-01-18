package proyecto.controllers.impl;

import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;
import proyecto.controllers.OrderController;
import proyecto.models.OrderService;
import proyecto.models.impl.AprobadorFactory;
import proyecto.models.interfaces.IAprobadorPedido;
import proyecto.repositories.PedidoRepositorio;
public class OrderControllerImpl implements OrderController {
    private static final String ID = "id";

    private PedidoRepositorio orderRepository;

    public OrderControllerImpl(PedidoRepositorio orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(Context context) {
        OrderService miOrder = context.bodyAsClass(OrderService.class);
        orderRepository.create(miOrder);
        context.json(miOrder);
    }

    public void find(Context context) {
        String id = context.pathParam(ID);

        OrderService order = orderRepository.find(id);

        if (order == null) {
            throw new NotFoundResponse(String.format("A order with id '%s' is not found", id));
        }
        context.json(order);

    }

    public void update(Context context) {
        OrderService order = context.bodyAsClass(OrderService.class);
        String id = context.pathParam(ID);

        if (order.getId() != null && !order.getId().toString().equals(id)) {
            throw new BadRequestResponse("Id update is not allowed");
        }

        orderRepository.update(order, id);

    }

    public void findAll(Context context) {
        context.json(orderRepository.findAll());
    }

    public void proxAprobador(Context context) {

        String id = context.formParam("id");
        String rol = context.formParam("rol");
        String proxAprob = context.formParam("next");
        OrderService order = orderRepository.find(id);
        if (order != null) {
            IAprobadorPedido miApPe = new AprobadorFactory(order).getAprobador(rol);
            if (context.formParam("seAprobo").equals("1")) {
                miApPe.aprobar(true, proxAprob);
            } else if (context.formParam("seAprobo").equals("0")) {
                miApPe.aprobar(false, proxAprob);
            }
        }
        orderRepository.update(order, id);
    }

    public void findOrdersByUser(Context context) {
        String idUser = context.formParam("idUser");
        context.json(orderRepository.findOrderByUser(idUser));
    }

    @Override
    public void delete(Context context) {
        orderRepository.delete(context.pathParam(ID));
    }
}
