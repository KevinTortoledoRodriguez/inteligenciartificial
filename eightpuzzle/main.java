import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class main {
	Nodo puzzle;
	int [][] objetive = {{1,2,3},{4,5,6},{7,8,0}};
	ArrayList <Nodo> states = new ArrayList<Nodo>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main m = new main();
		m.puzzle = new Nodo(ingresarDatos());
		System.out.println("Puzzle desordenado");
		imprimir(m.puzzle.getState());
		Nodo solve = m.puzzle8(m.puzzle, m.states);
		System.out.println("Nodos generados: ");
		for(Nodo x: m.states) {
			imprimir(x.getState());
			System.out.println("");
		}
		System.out.println("Tamaño de la lista de estados generados: " + m.states.size());
	}
	
	public static void imprimir(int[][]puzzle) {
		String cadena;
		for(int i=0; i<3; i++) {
			cadena = "";
			for(int j=0; j<3; j++) {
				cadena = cadena + puzzle[i][j] + "  ";
			}
			System.out.println(cadena);
		}
	}
	
	public static int[][] ingresarDatos() {
		Scanner s = new Scanner(System.in);
		int [][] p = new int[3][3]; 
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.println("Introduce un numero.");
				p[i][j]= s.nextInt();
			}
		}
		return p;
	}
	
	private Nodo puzzle8 (Nodo puzzle, ArrayList <Nodo> states) {
		Queue<Nodo> Q = new LinkedList<>();
		Q.add(puzzle);
		while(Q.size() > 0) {
			Nodo p = Q.remove();
			states.add(p);
			if(isSolve(p.getState())) {
				return p;
			}
			p.visited=true;
			for(Nodo w: obtenerSucesores(p, states)) {
				if(!w.visited) {
					w.visited = true;
					Q.add(w);
				}
			}
		}
		return null;
	}
	
	List<Nodo> obtenerSucesores(Nodo p, ArrayList<Nodo> states) {
		ArrayList<Nodo> nodos = new ArrayList<>();
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(p.getState()[i][j] == 0) {
					Nodo hijo = new Nodo(clonar(p.getState()));
					if((i==0 && j==0) || (i==0 && j==2) || (i==2 && j==0) || (i==2 && j==2)) {
						//Corner
						if(i==0 && j==0) {
							rigth(hijo, i, j);
							// if(!buscarHijos(states, hijo)){
							// 	nodos.add(hijo);
							// };
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(down(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							break;
						}
						if(i==0 && j==2) {
							nodos.add(left(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(down(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							break;
						}
						if(i==2 && j==0) {
							nodos.add(rigth(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(up(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							break;
						}
						if(i==2 && j==2) {
							nodos.add(left(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(up(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							break;
						}
					}
					if((i==0 && j==1) || (i==1 && j==0) || (i==1 && j==2) || (i==2 && j==1)) {
						//Edge
						if(i==0 && j==1) {
							nodos.add(rigth(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(left(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(down(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							break;
						}
						if(i==1 && j==0) {
							nodos.add(rigth(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(down(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(up(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							break;
						}
						if(i==1 && j==2) {
							nodos.add(left(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(up(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(down(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							break;
						}
						if(i==2 && j==1) {
							nodos.add(left(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(up(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							nodos.add(rigth(hijo, i, j));
							hijo = new Nodo(clonar(p.getState()));
							break;
						}
					}
					if((i==1 && j==1)) {
						//Center
						nodos.add(left(hijo, i, j));
						hijo = new Nodo(clonar(p.getState()));
						nodos.add(rigth(hijo, i, j));
						hijo = new Nodo(clonar(p.getState()));
						nodos.add(up(hijo, i, j));
						hijo = new Nodo(clonar(p.getState()));
						nodos.add(down(hijo, i, j));
						
						break;
					}
				}
			}
		}
		p.setChilds(nodos);
		return nodos;
	}
	
	boolean isSolve(int[][] p) {
		boolean equals = true;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(p[i][j] != objetive[i][j]) {
					equals = false;
					break;
				}
			}
		}
		if(equals){
			return true;
		}
		return false;
	}
	

	
	public Nodo left(Nodo p, int x, int y) {
		Nodo actualState = p;
		actualState.getState()[x][y] = actualState.getState()[x][y-1];
		actualState.getState()[x][y-1] = 0;
		return actualState;
	}
	
	public Nodo rigth(Nodo p, int x, int y) {
		Nodo actualState = p;
		actualState.getState()[x][y] = actualState.getState()[x][y+1];
		actualState.getState()[x][y+1] = 0;
		return actualState;
	}
	
	public Nodo up(Nodo p, int x, int y) {
		Nodo actualState = p;
		actualState.getState()[x][y] = actualState.getState()[x-1][y];
		actualState.getState()[x-1][y] = 0;
		return p;
	}
	
	public Nodo down(Nodo p, int x, int y) {
		Nodo actualState = p;
		actualState.getState()[x][y] = actualState.getState()[x+1][y];
		actualState.getState()[x+1][y] = 0;
		return p;
	}
	
	public int[][] clonar(int[][] estado) {
		int[][] clon = new int[estado.length][estado.length]; 
		for(int i  = 0 ; i < estado.length ; i++) {
			for(int j  = 0 ; j < estado.length ; j++) {
				clon[i][j] = estado[i][j];
			}
		}
		return clon;
	}

	public boolean buscarHijos(ArrayList<Nodo>states, Nodo hijo) {
		boolean exists = false;
		for (Nodo nodo : states) {
			boolean x = false;
			for(int i=0; i<3; i++) {
				if(x)
				for(int j=0; j<3; j++) {
					if(nodo.getState()[i][j] != hijo.getState()[i][j]) {
						break;
					}
				}
			}
		}
		return exists;
	}
}
