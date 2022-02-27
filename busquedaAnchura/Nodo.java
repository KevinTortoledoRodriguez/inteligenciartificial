package busquedaAnchura;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	public String dato;
	public List<Camino> caminos;
	public boolean visitado;
	
	public Nodo(String dato) {
		this.dato = dato;
		this.caminos = new ArrayList<Camino>();
	}

	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", caminos=" + caminos + ", visitado=" + visitado + "]";
	}
}