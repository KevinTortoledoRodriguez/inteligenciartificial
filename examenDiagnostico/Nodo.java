package examenDiagnostico;

public class Nodo {
	private int nombre;
	private Nodo izquierdo;
	private Nodo derecho;
	
	public Nodo(int nombre, Nodo izquierdo, Nodo derecho) {
		this.nombre =  nombre;
		this.padre = padre;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getPadre() {
		return padre;
	}

	public void setPadre(int padre) {
		this.padre = padre;
	}

	@Override
	public String toString() {
		return "Nodo [nombre=" + nombre + ", padre=" + padre + "]";
	}
	
}
