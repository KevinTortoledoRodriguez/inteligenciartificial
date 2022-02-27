package busquedaAnchura;

public class Camino {
	public Nodo destino;
	public int costo;
	
	public Camino (Nodo n, int costo) {
		this.destino = n;
		this.costo = costo;
	}
}
