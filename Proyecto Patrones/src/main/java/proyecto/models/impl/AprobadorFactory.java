package proyecto.models.impl;

import proyecto.models.OrderService;
import proyecto.models.interfaces.IAprobadorFactory;
import proyecto.models.interfaces.IAprobadorPedido;

public class AprobadorFactory implements IAprobadorFactory {

    private OrderService order;
    public AprobadorFactory(OrderService order){
        this.order = order;
    }

    @Override
    public IAprobadorPedido getAprobador(String rol) {
        if(rol.toUpperCase().equals("SUPERVISOR")){
            return new AprobadorSupervisorAlmacen(order);
        }else if(rol.toUpperCase().equals("ADMINISTRADOR")){
            return new AprobadorAdministrador(order);
        }else if(rol.toUpperCase().equals("CLIENTE")){
            return new AprobadorCliente(order);
        }else{
            return null;
        }
    }
    
}
