package eightpuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nodo {
	public int[][] state;
	public List<Nodo> childs;
	public boolean visited;
	
	public Nodo(int [][] p) {
		this.state = p;
		this.childs = new ArrayList<Nodo>();
	}

	@Override
	public String toString() {
		String cadena="";
		for(int i=0; i<3; i++) {
			cadena = "";
			for(int j=0; j<3; j++) {
				cadena = cadena + this.state[i][j] + "  \n" ;
			}
		}
		return "Nodo: \n" + cadena;
	}
}
