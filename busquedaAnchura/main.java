package busquedaAnchura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class main {
	//Coleccion de nodos
	//Coleccion de String, List
	HashMap<String, Nodo> hasMap = new HashMap<String, Nodo>();
	static ArrayList<Nodo> recorrido = new ArrayList<Nodo>();
	String objetivo = "Los Mochis";
	
	List<Nodo> obtenerSucesores(Nodo x) {
		List<Nodo> nodos = new ArrayList<>();
		for(Camino c: x.caminos) {
			nodos.add(c.destino);
		}
		return nodos;
	}

	boolean encontroObjetivo(Nodo n) {
		if(objetivo.equals(n.dato)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nodo n1 = new Nodo("Mazatlan");
		Nodo n2 = new Nodo("Los Mochis");
		Nodo n3 = new Nodo("Guasave");
		Nodo n4 = new Nodo("Culiacan");
		Nodo n5 = new Nodo("Navolato");
		Nodo n6 = new Nodo("Elota");
		
		List<Camino> c1 = new ArrayList<Camino>();
		c1.add(new Camino(n4, 200));  // mazatlan  -- culiacan
		c1.add(new Camino(n6, 100));  // mazatlan  -- elota
		
		List<Camino> c2 = new ArrayList<Camino>();
		c2.add(new Camino(n5, 35));  //  culiacan  -- navolato
		c2.add(new Camino(n3, 150)); //  culiacan  -- guasave
		
		List<Camino> c3 = new ArrayList<Camino>();
		c3.add(new Camino(n2, 80));  //  guasave  --  mochis
		
		n1.caminos = c1;
		n4.caminos = c2;
		n3.caminos = c3;
		
		main m = new main();
		Nodo nodo = m.BFS(n4);
		
		System.out.println("Nodo encontrado: " + nodo);
		for(int i=0; i<recorrido.size(); i++) {
			System.out.println(recorrido.get(i));
		}
	}
	
	private Nodo BFS(Nodo inicio) {
		Queue<Nodo> Q = new LinkedList<>();
		inicio.visitado = true;
		Q.add(inicio);
		while (Q.size() > 0) {
			Nodo v = Q.remove();
			recorrido.add(v);
			if(encontroObjetivo(v)) {
				return v;
			}
			for (Nodo w: obtenerSucesores(v)) {
				if(!w.visitado) {
					w.visitado = true;
					Q.add(w);
				}
			}
		}
		return null;
	}
}
