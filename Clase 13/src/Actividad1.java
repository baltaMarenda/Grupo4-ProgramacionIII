import java.util.ArrayList;
import java.util.List;

class AccionAtacante {
    String nombre;

    public AccionAtacante(String nombre) {
        this.nombre = nombre;
    }
}

class FuncionSistema {
    String nombre;

    public FuncionSistema(String nombre) {
        this.nombre = nombre;
    }
}

class SistemaDeteccion {
    List<AccionAtacante> accionesAtacantes;
    List<FuncionSistema> funcionesSistema;

    public SistemaDeteccion() {
        accionesAtacantes = new ArrayList<>();
        funcionesSistema = new ArrayList<>();
    }

    public void agregarAccionAtacante(AccionAtacante accion) {
        accionesAtacantes.add(accion);
    }

    public void agregarFuncionSistema(FuncionSistema funcion) {
        funcionesSistema.add(funcion);
    }

    public void mostrarSistema() {
        System.out.println("Acciones posibles del atacante:");
        for (AccionAtacante accion : accionesAtacantes) {
            System.out.println("- " + accion.nombre);
        }
        System.out.println("Funciones del sistema de detección:");
        for (FuncionSistema funcion : funcionesSistema) {
            System.out.println("- " + funcion.nombre);
        }
    }
}

public class Actividad1 {
    public static void main(String[] args) {
        SistemaDeteccion sistema = new SistemaDeteccion();

        sistema.agregarAccionAtacante(new AccionAtacante("Retirar dinero"));
        sistema.agregarAccionAtacante(new AccionAtacante("Cambiar dirección"));
        sistema.agregarAccionAtacante(new AccionAtacante("Transferencia inusual"));

        sistema.agregarFuncionSistema(new FuncionSistema("Monitorear transacciones grandes"));
        sistema.agregarFuncionSistema(new FuncionSistema("Detectar cambios en la dirección"));
        sistema.agregarFuncionSistema(new FuncionSistema("Monitorear transferencias internacionales"));

        sistema.mostrarSistema();
    }
}
