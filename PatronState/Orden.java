public class Orden {

    pivate State state;

    public Orden () {
        this.setState (new StateA();)
    }

    protected void setState (State state){
        this.state = state;
    }

    public void TomarOrden(){
        state.TomarOrden(this);
    }

    public void TerminarRevision(){
        state.TerminarRevision(this);
    }

    public void Cancelar(){
        state.Cancelar(this);
    }

    public void Pagar(){
        state.Pagar(this);
    }

    @Override
    public String toString() {
        return "Objeto [" + state.toString() + "]";
    }


}