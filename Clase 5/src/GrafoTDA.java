public interface GrafoTDA {
    public void InicializarGrafo();
    public void AgregarVertice(int x);
    public void EliminarVertice(int x);
    public void AgregarArista(int x, int y, int w);
    public void EliminarArista(int x, int y);
    public int PesoArista(int x, int y);
    public boolean ExisteArista (int x, int y);
    public ConjuntoTDA Vertices();
}