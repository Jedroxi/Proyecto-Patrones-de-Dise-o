package proyecto.models.impl;

import proyecto.models.OrderService;
import proyecto.models.interfaces.IAprobadorPedido;

public abstract class AprobadorBase implements IAprobadorPedido {

    protected IAprobadorPedido aprobadorSiguiente;
    protected OrderService order;
    
}
