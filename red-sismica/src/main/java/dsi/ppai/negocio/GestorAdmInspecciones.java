package dsi.ppai.negocio;

import java.util.ArrayList;
import java.util.List;

import dsi.ppai.entities.Empleado;
import dsi.ppai.entities.OrdenInspeccion;
import dsi.ppai.entities.Sesion;

public class GestorAdmInspecciones {

    // atributos

    private Empleado respInspLogueado;
    private Sesion sesionActiva;
    private List<OrdenInspeccion> ordenesInspeccion = new ArrayList<>();

    // metodos

    public void tomarOpCerrarOrdenInspeccion() {
        respInspLogueado = buscarRILogeado(sesionActiva);
        // ordenesInspeccion = buscarOrdenesInspeccion(respInspLogueado);
    }

    public Empleado buscarRILogeado(Sesion sesionActiva) {
        return sesionActiva.obtenerRILogueado();
    }

    // public List<OrdenInspeccion> buscarOrdenesInspeccion(Empleado
    // respInspLogueado) {
    // primero busco todas las ordenes de inspeccion asignadas al responsable de
    // inspeccion logueado
    // luego filtro las ordenes que esten en estado "En Inspeccion"
    // asigno el resultado a la lista ordenesInspeccion
    // List <OrdenInspeccion> ordenesDeRI = new ArrayList<>();

    // }

}
