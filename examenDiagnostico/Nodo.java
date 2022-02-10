package examenDiagnostico;

public class Nodo {
	private int nombre;
	private Nodo izquierdo;
	private Nodo derecho;
	
	public Nodo() {
	}
	
	public Nodo(int nombre) {
		this.nombre =  nombre;
		this.izquierdo = null;
		this.derecho = null;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public Nodo getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Nodo izquierdo) {
		this.izquierdo = izquierdo;
	}

	public Nodo getDerecho() {
		return derecho;
	}

	public void setDerecho(Nodo derecho) {
		this.derecho = derecho;
	}

	@Override
	public String toString() {
		return "Nodo [nombre=" + nombre + "]";
	}
	
}


//Kevin Andres Tortoledo Rodriguez.