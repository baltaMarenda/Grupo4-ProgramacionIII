public class ConjuntoA implements ConjuntoTDA {
    private int[] a; // El contenido del conjunto
    private int cant; // La cantidad de elementos

    public void InicializarConjunto() {
        a = new int[100];
        cant = 0;
    }

    public void Agregar(int x) {
        if (!this.Pertenece(x)) { // Verificación de no pertenencia
            a[cant] = x;
            cant++; // Nuevo elemento
        }
    }

    public boolean ConjuntoVacio() {
        return cant == 0;
    }

    public int Elegir() {
        return a[cant - 1]; // Esto es arbitrario; podría ser cualquiera
    }

    public boolean Pertenece(int x) {
        int i = 0;
        while (i < cant && a[i] != x) {
            i++;
        }
        return i < cant;
    }

    public void Sacar(int x) {
        int i = 0;
        while (i < cant && a[i] != x) {
            i++;
        }
        if (i < cant) { // Elemento encontrado
            a[i] = a[cant - 1];
            cant--;
        }
    }
}
