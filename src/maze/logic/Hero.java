package maze.logic;

import java.io.Serializable;


/**
 * Class for Hero Character in Game 
 * @see Character
 * */
public class Hero extends Character implements Serializable{


	private static final long serialVersionUID = 1L;
	private static final  String UP ="w";
	private static final  String DOWN ="s";
	private static final  String LEFT ="a";
	private static final  String RIGHT ="d";


	private Boolean isDead;
	private Boolean win; 
	private Boolean isArmed =false;
	private Boolean takeLever=false;



	/**
	 * Creates a Hero
	 * @param x	Coordinate x of its initial position
	 * @param y	Coordinate y of its initial position
	 * */
	public Hero(int x,int y) {
		super(x,y,'H');
		this.isDead=false;
		this.win=false;  
	}





	/**
	 * Gets the variable to decide  is a hero  alive 
	 * @return isDead
	 */
	public Boolean getIsDead(){
		return this.isDead;
	}



	/**
	 *Make die the hero 
	 * 
	 **/
	public void  setIsDead() {
		this.isDead=true;
	}


	

	/**
	 * Gets the variable to decide  is a hero  win
	 * @return win
	 */
	public Boolean getWin(){
		return this.win;
	}



	/**
	 *Make win the hero 
	 * 
	 **/
	public void  setWin() {
		this.win=true;
	}




	/**
	 * Gets the variable to decide  is a hero  armed
	 * @return isArmed
	 */
	public Boolean getIsArmed() {
		return isArmed;
	}



	/**
	 * Set the variable to decide  is a hero  armed
	 * @param isArmed
	 */
	public void setIsArmed(Boolean isArmed) {
		this.isArmed = isArmed;
	}




	/**
	 * Gets the variable to decide  is a hero  have a key 
	 * @return takeLever
	 */
	public Boolean getTakeLever() {
		return takeLever;
	}




	/**
	 * Set the variable to decide  is a hero  has a key
	 * @param takeLever
	 **/
	public void setTakeLever(Boolean takeLever) {
		this.takeLever = takeLever;
	}





	/**
	 * Move a Hero to new position
	 * @param x	position
	 * @param y	position 
	 * @param maze current maze game 
	 * */
	public void moveHero(int x,int y,Maze maze) {

		maze.cleanCell(this.getPosX(), this.getPosY());
		this.moveCharacter(x,y);
		maze.inser(this.getPosX(), this.getPosY(),this.getName());

	}



	
	/**
	 * Moves the hero based on the user input
	 * @param input  
	 * @param maze current maze game  
	 * @return  the result 
	 * 
	 */
	public int playHero(String input,Maze maze){
		int newXposition=0,newYposition=0;

		switch (input) {
		case RIGHT:newXposition++;break;
		case LEFT:newXposition--;break;
		case UP:newYposition--;break;
		case DOWN:newYposition++;break;  }


	

		if(maze.isHeroWeapon(this.getPosX()+newXposition,this.getPosY()+newYposition) && this.getTakeLever()==true){

			this.setIsArmed(true);
			moveHero(newXposition, newYposition,maze);

			return 1;

		}

		if(maze.isHeroWeapon(this.getPosX()+newXposition,this.getPosY()+newYposition) && this.getTakeLever()==false){

			this.setName('A');
			this.setIsArmed(true);
			moveHero(newXposition, newYposition,maze);

			return 1;

		}



		if(this.getName()=='K' && maze.isCloseDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)){

			maze.change_CloseDoor_To_OpenDoor();

			return 1;
		}


		if(this.getName() =='K' && maze.isOpenDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)){

			this.setWin();

			moveHero(newXposition, newYposition,maze);

			return 1;
		}



		if(maze.isOpenDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)){

			if(maze.numMap()==2){
				this.win=true;

			}
			maze.changeMap();
			return 2;
		}






		if(maze.isLever(this.getPosX()+newXposition,this.getPosY()+newYposition)){


			if(maze.numMap()==2){
				maze.getHero().setName('K');
				this.takeLever=true;
				moveHero(newXposition, newYposition,maze);

				return 1;
			} 

			maze.change_CloseDoor_To_OpenDoor();
			this.takeLever=true;
			moveHero(newXposition, newYposition,maze);

			return 1;
		}




		if (maze.isWall(this.getPosX()+newXposition,this.getPosY()+newYposition) 
				||maze.isCloseDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)
				|| maze.isOgre(this.getPosX()+newXposition,this.getPosY()+newYposition)){

			return 1;

		}





		moveHero(newXposition, newYposition,maze);

		return 1;


	}


}