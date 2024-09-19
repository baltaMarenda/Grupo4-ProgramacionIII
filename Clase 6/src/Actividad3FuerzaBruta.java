public class Actividad3FuerzaBruta {

    static int[] costos = {10, 15, 20, 25};
    static int[] beneficios = {100, 200, 150, 300};
    static int presupuesto = 40;

    public static void main(String[] args) {
        int n = costos.length;
        int maxBeneficio = seleccionProyectos(0, 0, 0, n);
        System.out.println("El beneficio máximo obtenido es: " + maxBeneficio);
    }


    static int seleccionProyectos(int indice, int costoActual, int beneficioActual, int n) {
        if (indice == n) {
            return beneficioActual;
        }


        int sinTomar = seleccionProyectos(indice + 1, costoActual, beneficioActual, n);


        int conTomar = 0;
        if (costoActual + costos[indice] <= presupuesto) {
            conTomar = seleccionProyectos(indice + 1, costoActual + costos[indice], beneficioActual + beneficios[indice], n);
        }


        return Math.max(sinTomar, conTomar);
    }
}
//Complejidad: Tiempo: O(2^n) - donde n es el número de proyectos.
// Esto se debe a que exploramos cada posible combinación de proyectos.