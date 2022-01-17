public class EnRevision extends State {

    @Override
    public void TomarOrden (Objeto objeto){
    }

    @Override
    public void TerminarRevision (Objeto objeto){
        Orden.setState(new Revisado());
    }

    @Override
    public void Cancelar (Objeto objeto){

    }

    @Override
    public void Pagar (Objeto objeto){

    } 

    @Override
    public String toSting(){
        return "Estado en Revision";
    }

}