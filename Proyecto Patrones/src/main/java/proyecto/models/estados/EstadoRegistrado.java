package proyecto.models.estados;

import proyecto.models.Cita;

public class EstadoRegistrado extends State {


    public EstadoRegistrado(){
        this.nombre = "REGISTRADO";
    }

    public void procesar(Cita c){
        super.procesar(c);
        registrar();
    }

}