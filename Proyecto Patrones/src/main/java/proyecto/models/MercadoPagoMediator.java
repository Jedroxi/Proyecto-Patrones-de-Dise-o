package proyecto.models;

import proyecto.integrations.MercadoPagoImpl;
import proyecto.models.interfaces.IMediatorCheckOut;

public class MercadoPagoMediator implements IMediatorCheckOut{

    private MercadoPagoImpl miMP;

    public MercadoPagoMediator(MercadoPagoImpl miMP){
        this.miMP = miMP;
    }

    @Override
    public String obtenerUrlPago(ItemService item) {
        return miMP.ObtenerSandboxPoint(item.getNombre(), 1, item.getPrecioUnitario().floatValue());
    }
    
}
