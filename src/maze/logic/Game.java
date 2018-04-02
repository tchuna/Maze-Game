package maze.logic;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Game  implements Serializable{

	
	private Maze maze;
	private int modeGuard;
	private int numOgres;
	private static final long serialVersionUID = 1L; 
 

	public Game(Maze maze){
 
		this.maze=maze;
		this.modeGuard=1;
		this.numOgres=1; 
		
		
		initializeVarCli(modeGuard,numOgres);
		//StardGame();
		

	} 
	
	
	
	

	public Game(Maze maze,int modeGuard,int numOgre){
 
		this.maze=maze;
		this.modeGuard=modeGuard;
		this.numOgres=numOgre; 
		
		
		StardGame();

	}



	
	public void initializeVarCli(int modeGrd,int numOgre){
	//maze.insertGuard(8, 1,modeGrd);
		maze.numOres=numOgre;
		maze.modeGuard=modeGrd; 
		//maze.insertHero(1, 1);
	}


	public void initializeVar(int modeGrd,int numOgre){
		maze.insertGuard(8, 1,modeGrd);//OBSSSS
		maze.numOres=numOgre;
		maze.modeGuard=modeGrd;
		maze.insertHero(1, 1);//OBSSSSSS
	} 
 
	
	
	public void StardGame(){
		initializeVar(this.modeGuard, this.numOgres);
		
	}

	
	
	public int updateGame(String input) {
		
		return maze.updateTime(input);

	}

	public Maze getMaze() {
		return maze;
	}


	public void setMaze(Maze maze) {
		this.maze = maze;
	}




}








