package maze.logic;

import java.io.Serializable;


/**
 * Abstract Class for the Character in Game
 *
 */
public abstract class Character implements Serializable {




	private static final long serialVersionUID = 1L;
	protected int posX=-1;
	protected int posY=-1;
	protected char nameCh;


	/**
	 * Creates a Character
	 * @param x	position x of its initial position
	 * @param y	position y of its initial position
	 * @param name  Character name
	 * */
	Character(int x, int y,char name) {
		this.posX=x;
		this.posY=y;
		this.nameCh=name;

	}


	/**
	 * Move a Character to position (x,y)
	 * @param x	position
	 * @param y	position 
	 * */
	public void  moveCharacter(int x,int y){
		this.posX+=x;
		this.posY+=y;

	}


	/**
	 * Get x  Character position
	 * @return Return x position
	 */
	public int getPosX(){

		return this.posX;

	}


	/**
	 * Get y  Character position
	 * @return Return  position
	 */
	public int getPosY(){

		return this.posY;

	}


	/**
	 * Get  Character name 
	 * @return Return name
	 */
	public char getName(){
		return this.nameCh;
	}



	/**
	 * Set  Character name
	 * @param name  new character name
	 * */
	public void setName(char name){
		this.nameCh=name;

	}


	/**
	 * Set  Character Position
	 * @param x new x character position
	 * @param y new y character position
	 * */
	public void setPosition(int x, int y){
		this.posX=x;
		this.posY=y;

	}








}