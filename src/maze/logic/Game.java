package maze.logic;


import java.io.Serializable;

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
		
		

	} 
	
	
	
	

	public Game(Maze maze,int modeGuard,int numOgre){
 
		this.maze=maze;
		this.modeGuard=modeGuard;
		this.numOgres=numOgre; 
		
		
		StardGame();

	}



	
	public void initializeVarCli(int modeGrd,int numOgre){
	
		maze.numOres=numOgre;
		maze.modeGuard=modeGrd; 
		
	}


	public void initializeVar(int modeGrd,int numOgre){
		maze.insertGuard(8, 1,modeGrd);
		maze.numOres=numOgre;
		maze.modeGuard=modeGrd;
		maze.insertHero(1, 1);
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





}








