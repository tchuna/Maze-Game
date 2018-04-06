package maze.logic;


import java.io.Serializable;


/**
 * Class for the Game Instruction
 *
 */
public class Game  implements Serializable{


	private Maze maze;
	private int modeGuard;
	private int numOgres;
	private static final long serialVersionUID = 1L; 


	/**
	 * Creates a Game
	 * @param maze 
	 * */
	public Game(Maze maze){

		this.maze=maze;
		this.modeGuard=1;
		this.numOgres=1; 


		initializeVarCli(modeGuard,numOgres);



	} 





	/**
	 * Creates a Game
	 * @param maze
	 * @param modeGuard  the guard personality 
	 * @param numOgres number ogres in game 
	 * */
	public Game(Maze maze,int modeGuard,int numOgre){

		this.maze=maze;
		this.modeGuard=modeGuard;
		this.numOgres=numOgre; 


		StardGame();

	}




	 
	/**
	 * Initialize variables  
	 * @param modeGrd to modeGrd in Game
	 * @param numOgre to numOgres in Game ogres 
	 * */
	public void initializeVarCli(int modeGrd,int numOgre){

		maze.numOres=numOgre;
		maze.modeGuard=modeGrd; 

	}


	/**
	 * Initialize variables  
	 * @param modeGrd to modeGrd in Game
	 * @param numOgre to numOgres in Game ogres 
	 * */
	public void initializeVar(int modeGrd,int numOgre){
		maze.insertGuard(8, 1,modeGrd);
		maze.numOres=numOgre;
		maze.modeGuard=modeGrd;
		maze.insertHero(1, 1);
	} 


	
	/**
	 * Start the Game 
	 * 
	 * */
	public void StardGame(){
		initializeVar(this.modeGuard, this.numOgres);

	}



	/**
	 * Update the Game 
	 * @param input the value direction to move the hero  position
	 * */
	public int updateGame(String input) {

		return maze.updateTime(input);

	}

	
	/**
	 * Get the  Maze Game
	 * @return maze
	 * */
	public Maze getMaze() {
		return maze;
	}





}








