package eightpuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nodo {
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

	
}
