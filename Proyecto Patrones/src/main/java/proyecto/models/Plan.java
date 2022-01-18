package proyecto.models;

public class Plan {
    private String nombre;
    private Double precioPlan;
    private String sandboxpoint;
    private String id;

    public Plan(){}

    public Plan(String nombre, Double precioPlan, String sandboxpoint){
        this.nombre = nombre;
        this.precioPlan = precioPlan;
        this.sandboxpoint = sandboxpoint;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioPlan() {
        return precioPlan;
    }

    public void setPrecioPlan(Double precioPlan) {
        this.precioPlan = precioPlan;
    }

    public String getSandboxpoint() {
        return sandboxpoint;
    }

    public void setSandboxpoint(String sandboxpoint) {
        this.sandboxpoint = sandboxpoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}
