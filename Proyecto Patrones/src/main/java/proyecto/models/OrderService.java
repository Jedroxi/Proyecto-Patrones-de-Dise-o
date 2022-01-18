package proyecto.models;

import java.util.List;

public class OrderService {
    public String id;
    public String nombreProducto;
    public Integer cantidad;
    public Double precioUnitario;
    public List<String> idAprobadores;
    public String idAprobadorSiguiente;
    public String idIniciador;
    private String idCliente;

    public OrderService(String nomP, Integer qty, Double unitPrice){
        this.nombreProducto = nomP;
        this.cantidad = qty;
        this.precioUnitario = unitPrice;
    }

    public OrderService(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public List<String> getIdAprobadores() {
        return idAprobadores;
    }

    public void setIdAprobadores(List<String> idAprobadores) {
        this.idAprobadores = idAprobadores;
    }

    public String getIdAprobadorSiguiente() {
        return idAprobadorSiguiente;
    }

    public void setIdAprobadorSiguiente(String idAprobadorSiguiente) {
        this.idAprobadorSiguiente = idAprobadorSiguiente;
    }

    public String getIdIniciador() {
        return idIniciador;
    }

    public void setIdIniciador(String idIniciador) {
        this.idIniciador = idIniciador;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void addIdAprobador(String idAprobador) {
        this.idAprobadores.add(idAprobador);
    }

    
    
}
