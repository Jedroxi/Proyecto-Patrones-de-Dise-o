package proyecto.models;

public class ItemService {
    
    private String id;
    private String codigo;
    private String nombre;
    private Double precioUnitario;
    private Integer cantidad;
    private String sandboxpoint;
    
    public ItemService(String codigo, String nombre, Double precioUnitario){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = 0;
    }

    public ItemService(){}
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getSandboxpoint() {
        return sandboxpoint;
    }

    public void setSandboxpoint(String sandboxpoint) {
        this.sandboxpoint = sandboxpoint;
    }

    
}
