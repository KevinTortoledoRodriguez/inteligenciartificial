package examenDiagnostico;

import java.util.ArrayList;

public class Arbol {
	private ArrayList<Nodo> arbol;
	
	public Arbol () {
		this.arbol = new ArrayList<Nodo>();
	}
	
	public boolean vacio() {
		return arbol.isEmpty();
	}
	
	public Nodo buscarNodo(Nodo n) { 
		/*preorden(nodo)
		  si nodo == nulo entonces retorna
		  imprime nodo.valor
		  preorden(nodo.izquierda)
		  preorden(nodo.derecha)
		  */
		Nodo nodo = new Nodo(1,1);
		return nodo;
	}
	
}
