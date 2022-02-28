package eightpuzzle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main {
	int filas = 3, columnas = 3;
	int [][] puzzle = new int[filas][columnas];
	int [][] objetive = {{0,1,2},{3,4,5},{6,7,8}};
	ArrayList <int[][]> states = new ArrayList<int[][]>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main m = new main();
		ingresarDatos(m.puzzle, m.filas, m.columnas);
		System.out.println("Puzzle desordenado");
		imprimir(m.puzzle, m.filas, m.columnas);
		int [][] solve = m.puzzle8(m.puzzle, m.states, m.filas, m.columnas);
		System.out.println("Puzzle ordenado");
		imprimir(solve, m.filas, m.columnas);
	}
	
	public static void imprimir(int[][]puzzle, int filas, int columnas) {
		String cadena;
		for(int i=0; i<filas; i++) {
			cadena = "";
			for(int j=0; j<columnas; j++) {
				cadena = cadena + puzzle[i][j] + "  ";
			}
			System.out.println(cadena);
		}
	}
	
	public static void ingresarDatos(int[][]puzzle, int filas, int columnas) {
		Scanner s = new Scanner(System.in);
		for(int i=0; i<filas; i++) {
			for(int j=0; j<columnas; j++) {
				System.out.println("Introduce un numero.");
				puzzle[i][j]= s.nextInt();
			}
		}
	}
	
	private int[][] puzzle8 (int[][] puzzle, ArrayList<int[][]> states, int filas, int columnas) {
		//states.add(puzzle);
		Queue<int[][]> Q = new LinkedList<>();
		Q.add(puzzle);
		while(Q.size() > 0) {
			int [][] p = Q.remove();
			states.add(p);
			if(isSolve(p, filas, columnas)) {
				return puzzle;
			}
			for(int i=0; i<filas; i++) {
				for(int j=0; j<columnas; j++) {
					if(p[i][j] == 0) {
						if((i==0 && j==0) || (i==0 && j==2) || (i==2 && j==0) || (i==2 && j==2)) {
							//Corner
							if(i==0 && j==0) {
								Q.add(rigth(p, i, j));
								Q.add(down(p, i, j));
								break;
							}
							if(i==0 && j==2) {
								Q.add(left(p, i, j));
								Q.add(down(p, i, j));
								break;
							}
							if(i==2 && j==0) {
								Q.add(rigth(p, i, j));
								Q.add(up(p, i, j));
								break;
							}
							if(i==2 && j==2) {
								Q.add(left(p, i, j));
								Q.add(up(p, i, j));
								break;
							}
						}
						if((i==0 && j==1) || (i==1 && j==0) || (i==1 && j==2) || (i==2 && j==1)) {
							//Edge
							if(i==0 && j==1) {
								Q.add(rigth(p, i, j));
								Q.add(left(p, i, j));
								Q.add(down(p, i, j));
								break;
							}
							if(i==1 && j==0) {
								Q.add(rigth(p, i, j));
								Q.add(down(p, i, j));
								Q.add(up(p, i, j));
								break;
							}
							if(i==1 && j==2) {
								Q.add(left(p, i, j));
								Q.add(up(p, i, j));
								Q.add(down(p, i, j));
								break;
							}
							if(i==2 && j==1) {
								Q.add(left(p, i, j));
								Q.add(up(p, i, j));
								Q.add(rigth(p, i, j));
								break;
							}
						}
						if((i==1 && j==1)) {
							//Center
							Q.add(left(p, i, j));
							Q.add(rigth(p, i, j));
							Q.add(up(p, i, j));
							Q.add(down(p, i, j));
							break;
						}
					}
				}
			}
		}
		return null;
	}
	
	boolean isSolve(int[][] p, int filas, int columnas) {
		boolean equals = true;
		for(int i=0; i<filas; i++) {
			for(int j=0; j<columnas; j++) {
				if(p[i][j] != objetive[i][j]) {
					equals = false;
					break;
				}
			}
		}
		if(equals){
			System.out.println("si");
			return true;
		}
		return false;
	}
	
	public int[][] left(int[][]p, int x, int y) {
		System.out.println("left");
		p[x][y] = p[x][y-1];
		p[x][y-1] = 0;
		imprimir(p,3,3);
		return p;
	}
	
	public int[][] rigth(int[][]p, int x, int y) {
		System.out.println("rigth");
		p[x][y] = p[x][y+1];
		p[x][y+1] = 0;
		imprimir(p,3,3);
		return p;
	}
	
	public int [][] up(int[][]p, int x, int y) {
		System.out.println("up");
		p[x][y] = p[x+1][y];
		p[x+1][y] = 0;
		imprimir(p,3,3);
		return p;
	}
	
	public int [][] down(int[][]p, int x, int y) {
		System.out.println("down");
		p[x][y] = p[x-1][y];
		p[x-1][y] = 0;
		imprimir(p,3,3);
		return p;
	}
	
}
