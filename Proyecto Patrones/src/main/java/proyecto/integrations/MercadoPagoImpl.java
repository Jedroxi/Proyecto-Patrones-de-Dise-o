package proyecto.integrations;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;

/*PATRONES*/

/*
1. Singleton : Aplicado para trabajar unicamente con una instancia de Mercado Pago.
2. Builder: Se aplica en el método ObtenerSandBoxPoint, al momento de crear la preferencia.
3. Mediator: Se aplicará al tener un intermediario entre las diversas clases que puedan necesitar generar un SandBoxPoint y MercadoPago.
*/

public class MercadoPagoImpl {
    public static MercadoPagoImpl MercadoP;

    public static MercadoPagoImpl getInstance(){
        if(MercadoP == null){
            MercadoP = new MercadoPagoImpl();
        }
        return MercadoP;
    }

    private MercadoPagoImpl(){
        try {
            MercadoPago.SDK.setAccessToken("TEST-4240682358803950-011714-647e45a82f9323c8c26d525de41bbd51-388838619");
        } catch (MPConfException e) {
            e.printStackTrace();
        }        
    }

    public String ObtenerSandboxPoint(String titulo,Integer cantidad, Float precioUnitario){
        
        Preference preference = new Preference();

        Item item = new Item();
        item.setTitle(titulo)
            .setQuantity(cantidad)
            .setUnitPrice(precioUnitario);
        preference.appendItem(item);
        try {
            preference.save();
        } catch (MPException e) {
            e.printStackTrace();
        }

        return preference.getSandboxInitPoint();
    }
    
}
