package proyecto.models;

import java.sql.Date;

import proyecto.models.estados.EstadoRegistrado;
import proyecto.models.estados.State;


public class Cita {
    private String id;
    private Date fechaProgramada;
    private String idCliente;
    private String idEstado;
    private Boolean finalizado;
    private Boolean costo;

    public Cita(){
        
    }

    public void iniciarEstado(){
        State estado = new EstadoRegistrado();
        estado.procesar(this);
        idEstado = estado.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }   
    
}
