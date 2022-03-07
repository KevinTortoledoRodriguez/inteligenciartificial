package eightpuzzle;

import java.util.ArrayList;
import java.util.Arrays;

public class Nodo implements Comparable<int [][]>{
	private int[][] state;
	public ArrayList<Nodo> childs;
	Nodo father;
	public boolean visited;
	
	public Nodo(int [][] p) {
		this.state = p;
		this.childs = new ArrayList<Nodo>();
	}
	
	
	public int[][] getState() {
		return state;
	}


	public void setState(int[][] state) {
		this.state = state;
	}
	
	public ArrayList<Nodo> getChilds(){
		return childs;
	}
	
	public void setChilds(ArrayList<Nodo> childs){
		this.childs = childs;
		if(childs!=null) {
			for(Nodo n : childs) 
				n.father = this;
		}
	}
	
	public Nodo getFather() {
		return father;
	}

	public void setFather(Nodo father) {
		this.father = father;
	}


	@Override
	public String toString() {
		return "Nodo [state=" + Arrays.toString(state) + ", childs=" + childs + ", father=" + father + ", visited="
				+ visited + "]";
	}


	@Override
	public int compareTo(int [][] o) {
		boolean igual = true;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(this.state[i][j] != o[i][j]) {
					igual = false;
				}
			}
		}
		return igual ? 1 : 0;
	}

	
}
