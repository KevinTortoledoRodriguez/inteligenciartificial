package examenDiagnostico;

import java.util.ArrayList;
import java.util.Scanner;

public class Arbol {
	private Nodo raiz;
	public static Scanner in = new Scanner(System.in);
	
	public Arbol() {
		this.raiz = null;
	}
	
	public boolean vacio() {
		return this.raiz == null;
	}
	
	
	public void buscarNodo(int nodo) { 
		/*preorden(nodo)
		  si nodo == nulo entonces retorna
		  imprime nodo.valor
		  preorden(nodo.izquierda)
		  preorden(nodo.derecha)
		*/
		if(vacio()) {
			System.out.println("El arbol se cuentra vacio");
			return;
		}
		
		if(this.raiz.getNombre() == nodo) {
			System.out.println("Se ha encontrado el nodo: " + nodo);
			return;
		}
		
		if(this.raiz.getIzquierdo() == null && this.raiz.getDerecho() == null) {
			System.out.println("No se ha encontrado el nodo porque no hay mas nodos para buscar.");
			return;
		}
		
		if(this.raiz.getIzquierdo() != null) buscarNodo(this.raiz.getIzquierdo(), nodo);
		if(this.raiz.getDerecho() != null) buscarNodo(this.raiz.getDerecho(), nodo);
		return;
	}
	
	public void buscarNodo(Nodo padre, int nodo) { 
		if(padre == null) {
			System.out.println("No hay datos en este nodo");
			return;
		}
		if(padre.getNombre() == nodo) {
			System.out.println("Se ha encontrado el nodo: " + nodo);
		}
		
		if(padre.getIzquierdo() != null) buscarNodo(padre.getIzquierdo(), nodo);
		if(padre.getDerecho() != null) buscarNodo(padre.getDerecho(), nodo);
		return;
	}
	
	public void insertarNodo(int nodo) {
		if(this.raiz == null) {
			this.raiz = new Nodo(nodo);
			return;
		}
		insertarNodo(this.raiz, nodo);
		return;
	}
	
	public void insertarNodo(Nodo padre, int nodo) {
		if(nodo == padre.getNombre()) {
			System.out.println("El nodo ya se encuentra registrado, por lo tanto no se guardo el nodo");
			return;
		}
		if(nodo > padre.getNombre()) {
			if(padre.getDerecho() == null) {
				padre.setDerecho(new Nodo(nodo));
				return;
			}
			insertarNodo(padre.getDerecho(), nodo);
			return;
		}
		if(padre.getIzquierdo() == null) {
			padre.setIzquierdo(new Nodo(nodo));
			return;
		}
		insertarNodo(padre.getIzquierdo(), nodo);
		return;
	}
	
	public void imprimirArbol(Nodo arbol) {
		if(arbol == null) {
			System.out.println("El arbol esta vacio.");
			return;
		} 
		System.out.println("El arbol es: ");
		System.out.println(arbol.getNombre());
		imprimirArbol(arbol.getIzquierdo());
		imprimirArbol(arbol.getDerecho());
	}
	
	public static void menu() {
		System.out.println("Que operacion desea realizar?");
		System.out.println("1.- Verificar si esta vacio el arbol");
		System.out.println("2.- Imprimir el arbol");
		System.out.println("3.- Insertar un nodo");
		System.out.println("4.- Buscar un nodo");
		System.out.println("5.- Salir");
	}
	
	public static void main(String []a) {
		Arbol arbol = new Arbol();
		boolean bandera = true;
		while(bandera) {
			int opcion = 0;
			menu();
			
			opcion = in.nextInt();
			
			switch(opcion) {
			case 1:
				System.out.println("El arbol esta vacio: " + arbol.vacio());
				break;
			case 2:
				arbol.imprimirArbol(arbol.raiz);
				break;
			case 3:
				System.out.println("Teclee el numero desea ingresar");
				arbol.insertarNodo(in.nextInt());
				break;
			case 4:
				System.out.println("Teclee el numero que desea buscar");
				arbol.buscarNodo(in.nextInt());
				break;
			case 5:
				bandera = false;
				break;
			default:
				System.out.println("Teclee una opcion correcta");
				break;
			}
		}
	}
}

//Kevin Andres Tortoledo Rodriguez.
