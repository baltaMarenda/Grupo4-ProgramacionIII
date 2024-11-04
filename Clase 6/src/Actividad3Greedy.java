import java.util.Arrays;

public class Actividad3Greedy {

    static int[] costos = {10, 15, 20, 25};
    static int[] beneficios = {100, 200, 150, 300};
    static int presupuesto = 40;

    public static void main(String[] args) {
        int n = costos.length;
        Proyecto[] proyectos = new Proyecto[n];


        for (int i = 0; i < n; i++) {
            proyectos[i] = new Proyecto(costos[i], beneficios[i]);
        }


        Arrays.sort(proyectos, (a, b) -> Double.compare(b.ratio(), a.ratio()));

        int costoActual = 0;
        int beneficioTotal = 0;


        for (int i = 0; i < n; i++) {
            if (costoActual + proyectos[i].costo <= presupuesto) {
                costoActual += proyectos[i].costo;
                beneficioTotal += proyectos[i].beneficio;
            }
        }

        System.out.println("El beneficio máximo obtenido es: " + beneficioTotal);
    }

    static class Proyecto {
        int costo;
        int beneficio;

        Proyecto(int costo, int beneficio) {
            this.costo = costo;
            this.beneficio = beneficio;
        }


        double ratio() {
            return (double) beneficio / costo;
        }
    }
}
//Complejidad: Tiempo: O(n log n) - principalmente debido a la necesidad de ordenar los
// proyectos según la relación beneficio-costo antes de seleccionarlos.
