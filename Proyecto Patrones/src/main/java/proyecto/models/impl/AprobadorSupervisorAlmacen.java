package proyecto.models.impl;

import proyecto.models.OrderService;

public class AprobadorSupervisorAlmacen extends AprobadorBase{
    
    public AprobadorSupervisorAlmacen(OrderService order){
        this.order = order;
    }

    @Override
    public void aprobar(Boolean continuar,String idProxAprob){
        if(continuar){
            order.addIdAprobador(order.idAprobadorSiguiente);
            if(DisponibleEnInventario()){
                order.setIdAprobadorSiguiente(order.getIdCliente());
            }else{
                order.setIdAprobadorSiguiente(idProxAprob);
            }
            
        }else{
            order.setIdAprobadorSiguiente("");
        }
    }

    private Boolean DisponibleEnInventario(){
        return true;
    }
}
