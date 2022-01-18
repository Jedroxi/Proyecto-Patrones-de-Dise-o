package proyecto.models.impl;

import proyecto.models.OrderService;

public class AprobadorCliente extends AprobadorBase{
    
    public AprobadorCliente(OrderService order){
        this.order = order;
    }
    
    @Override
    public void aprobar(Boolean continuar, String idProxAprobador) {

        order.addIdAprobador(order.getIdCliente());
        order.setIdAprobadorSiguiente("");
        if(continuar){
            //Servicio.programarServicio(order.getId());
        }
        
    }
    
}
