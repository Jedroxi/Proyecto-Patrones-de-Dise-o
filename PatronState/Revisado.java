public class Revisado extends State {

    @Override
    public void TomarOrden (Objeto objeto){
    }

    @Override
    public void TerminarRevision (Objeto objeto){
    }

    @Override
    public void Cancelar (Objeto objeto){
        Orden.setState(new Cancelado());
    }

    @Override
    public void Pagar (Objeto objeto){
        Orden.setState(new Pagado());
    } 

    @Override
    public String toSting(){
        return "Estado Revisado";
    }

}