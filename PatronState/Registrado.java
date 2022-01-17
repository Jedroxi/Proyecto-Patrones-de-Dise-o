public class Registrado extends State {

    @Override
    public void TomarOrden (Objeto objeto){
        Orden.setState(new EnRevision());
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
        return "Estado Registrado";
    }
}