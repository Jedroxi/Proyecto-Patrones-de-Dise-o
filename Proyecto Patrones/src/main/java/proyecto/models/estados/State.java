package proyecto.models.estados;

import java.util.Date;

import proyecto.models.Cita;
import proyecto.repositories.impl.EstadoRepoImpl;

public class State {

    protected String id;
    protected String nombre;
    protected String idCita;
    protected Date fechaCreacion;
    protected int codigo;

    public State(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void registrar(){
        EstadoRepoImpl miRepo = new EstadoRepoImpl();
        miRepo.create(this);
    }
    public void procesar(Cita c){
        this.idCita = c.getId();
    }

}