public abstract class State {

    public abstract void TomarOrden (Objeto objeto);

    public abstract void TerminarRevision (Objeto objeto);

    public abstract void Cancelar (Objeto objeto);

    public abstract void Pagar (Objeto objeto);

}