package proyecto.models.impl;

import proyecto.models.OrderService;

public class AprobadorAdministrador extends AprobadorBase{

    public AprobadorAdministrador(OrderService order){
        this.order = order;
    }

    @Override
    public void aprobar(Boolean continuar, String idProxAprobador) {
        if(continuar){
            order.addIdAprobador(order.idAprobadorSiguiente);
            order.setIdAprobadorSiguiente(order.getIdCliente());
        }else{
            order.setIdAprobadorSiguiente("");
        }
    }
    
}
