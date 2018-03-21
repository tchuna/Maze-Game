package maze.logic;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class Game  implements Serializable{


	
	
	
	private Maze maze;
	private int modeGuard;
	private int numOgres;
	private static final long serialVersionUID = 1L;


	public Game(Maze maze){

		this.maze=maze;
		

	}
	
	

	public Game(Maze maze,int modeGuard,int numOgre){

		this.maze=maze;
		this.modeGuard=modeGuard;
		this.numOgres=numOgre;
		
		

	}





	public void initializeVar(int modeGrd,int numOgre){
		maze.insertGuard(8, 1,modeGrd);
		maze.numOres=numOgre;
		maze.insertHero(1, 1);
	}

	
	
	public void StardGame(){
		initializeVar(this.modeGuard, this.numOgres);
		
	}


	public Maze getMaze() {
		return maze;
	}


	public void setMaze(Maze maze) {
		this.maze = maze;
	}




}








