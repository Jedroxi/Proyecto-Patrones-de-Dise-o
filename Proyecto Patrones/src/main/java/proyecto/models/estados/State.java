package proyecto.models.estados;

public abstract class State {

    public abstract void TomarOrden (Object objeto);

    public abstract void TerminarRevision (Object objeto);

    public abstract void Cancelar (Object objeto);

    public abstract void Pagar (Object objeto);

}