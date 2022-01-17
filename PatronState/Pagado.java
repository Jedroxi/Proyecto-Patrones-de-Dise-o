public class Pagado extends State {

    @Override
    public void TomarOrden (Objeto objeto){
    }

    @Override
    public void TerminarRevision (Objeto objeto){
    }

    @Override
    public void Cancelar (Objeto objeto){
    }

    @Override
    public void Pagar (Objeto objeto){
    } 

    @Override
    public String toSting(){
        return "Estado Pagado";
    }

}