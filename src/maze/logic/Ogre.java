package maze.logic;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * Class for Ogre Character in Game 
 * @see Character
 * */
public class Ogre extends Character implements Serializable{
 


	private static final long serialVersionUID = 1L;
	private static final  int UP =1;
	private static final  int DOWN =2;
	private static final  int LEFT =3; 
	private static final  int RIGHT =4;


	private Weapon weaponOgre;
	private  Boolean sleep= false;
	private  int  stopTurn=2;


	/**
	 * Creates a Ogre
	 * @param x	Coordinate x of its initial position
	 * @param y	Coordinate y of its initial position
	 * */
	public Ogre(int x, int y) {
		super(x, y, 'O'); 
		this.weaponOgre=new Weapon();

	}




	/**
	 * Gets the variable to decide  if the ogre sleep  
	 * @return takeLever
	 */
	public Boolean getSleep() {
		return sleep;
	}



	
	/**
	 * Set the variable to decide  if the ogre sleep  
	 * @param sl
	 **/
	public void setSleep(Boolean sl) {
		this.sleep = sl;
	}



	/**
	 * Get the number turn the ogre need to sleep 
	 * @return weaponOgre
	 **
	 */
	public int getStopTurn() {
		return stopTurn;
	}





	/**
	 * Get the ogre weapon
	 * @return weaponOgre
	 **
	 */
	public Weapon getOgreWeapon() {
		return weaponOgre;

	}




	/**
	 * Make the ogre wake up
	 * 
	 **/
	public  void wakeOgre(){

		if(this.sleep==false){
			return;
		}


		stopTurn--;

		if(stopTurn<0 ){ 
			stopTurn=2;
			this.sleep=false;
			this.nameCh='O';
		}


	}


	

	/**
	 * Make the ogre sleep 
	 * @param tmaze current maze game
	 **/
	public void  ogreSleeped(Maze maze){ 
		this.nameCh='8';
		this.sleep=true;
		maze.inser(this.posX,this.posY, this.nameCh);
		maze.cleannclub();

	}



	/**
	 * Set the variable to decide  the number turn the ogre sleep
	 * @param sl
	 **/
	public void setStopsleep(int sl){
		this.stopTurn=sl;


	}



	/**
	 * generate a random number between 1-n
	 * 
	 * @param n 
	 * @return num  the random number generate 
	 */
	public int randomNumber(int n){	

		int num = (int) (Math.random() * (n-1) +1);
	

		return num;
	}




	/**
	 * verify  is two ogres is equals 
	 * @param objs the ogre to verify 
	 * 
	 * @return the result  
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Ogre){
			Ogre n=(Ogre)obj;

			return (this.posX==n.getPosX() && this.posY==n.getPosY());

		}
		return false;
	}




 
	/**
	 *  the direction the ogre attack 
	 *  
	 * @param randnum the random decision 
	 **/
	public void armedOgre(int randNum){

		this.getOgreWeapon().setNameWeapon('*');

		switch (randNum) {


		case UP: this.getOgreWeapon().setWeapon(this.posX,this.posY-1);break;

		case DOWN:this.getOgreWeapon().setWeapon(this.posX,this.posY+1);break;

		case LEFT:this.getOgreWeapon().setWeapon(this.posX-1,this.posY);break;

		case RIGHT:this.getOgreWeapon().setWeapon(this.posX+1,this.posY);break; 

		}
	}







	/**
	 * Move a Ogre to new position
	 * @param x	position
	 * @param y	position 
	 * @param maze current maze game 
	 * */
	public void moveOgre(int x,int y,Maze maze){

		maze.cleanCell(this.getPosX(), this.getPosY());
		this.moveCharacter(x,y);
		maze.inser(this.getPosX(),this.getPosY(), this.getName());

	}





	/**
	 * Moves the ogre  weapon random position
	 * @param maze current maze game 
	 * @param rand the random decision 
	 **/
	public void attackOgre(Maze maze ,int rand){

		this.armedOgre(rand);

		if(maze.isWall(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isCloseDoor(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isClub(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isOgre(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isHeroArmed(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isHeroWeapon(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isOpenDoor(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isLever(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())){
			return;
		}




		maze.inser(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon(),this.getOgreWeapon().getNameWeapon());



	}



	public Boolean putLever(Maze maze){
		Ogre ogreinLever=new Ogre(4,4);

		Iterator<Ogre> iter = maze.geTogres().iterator();


		if(maze.getHero().getName()!='K'){

			if(maze.geTogres().contains(ogreinLever)!=true){
				maze.inser(ogreinLever.getPosX(), ogreinLever.getPosY(),'k');
				while (iter.hasNext()) {
					iter.next().setName('O');
				}
				return false;

			}
		}



		return true;
	}





	/**
	 *  Verify is the hero was killed
	 * @param hero to verify
	 * 
	 * @return result the verification  
	 */
	public Boolean ogreKillHero(Maze maze){

		if (maze.getHero().getIsArmed()==false && (this.getPosX() == maze.getHero().getPosX()+1 && this.getPosY() == maze.getHero().getPosY() || this.getPosX() == maze.getHero().getPosX()-1 && this.getPosY() == maze.getHero().getPosY()
				|| this.getPosY() == maze.getHero().getPosY()+1 && this.getPosX() == maze.getHero().getPosX() || this.getPosY() == maze.getHero().getPosY()-1 && this.getPosX() == maze.getHero().getPosX()) 
				|| this.getPosY() == maze.getHero().getPosY() && this.getPosX() == maze.getHero().getPosX()){
			return true ; }
		

		if(maze.getHero().getIsArmed()==true && (this.getPosX() == maze.getHero().getPosX()+1 && this.getPosY() == maze.getHero().getPosY() || this.getPosX() == maze.getHero().getPosX()-1 && this.getPosY() == maze.getHero().getPosY()
				|| this.getPosY() == maze.getHero().getPosY()+1 && this.getPosX() == maze.getHero().getPosX() || this.getPosY() == maze.getHero().getPosY() && this.getPosX() == maze.getHero().getPosX()
				|| this.getPosY() == maze.getHero().getPosY()-1 && this.getPosX() == maze.getHero().getPosX())){

			ogreSleeped(maze);
			return false; }

		if(this.getOgreWeapon().getXWeapon()== maze.getHero().getPosX()&& this.getOgreWeapon().getYWeapon()== maze.getHero().getPosY()){
			return true; }

		return false;

	}




	/**
	 * Moves the ogre random position
	 * @param maze current maze game 
	 * @param randnum the random decision 
	 **/
	public void playRandomMovesOgre(Maze maze,int randnum){ 


		int xlever=4;
		int lever=4;
		int rand=randomNumber(5);

		wakeOgre(); if(this.sleep==true)return;

		int newXposition=0;
		int newYposition=0;



		switch (randnum) {
		case RIGHT:newXposition++;
		break;
		case LEFT:newXposition--;
		break;
		case UP:newYposition--;
		break;
		case DOWN:newYposition++;
		break;}




		if (maze.isWall(this.getPosX()+newXposition,this.getPosY()+newYposition) 
				||maze.isCloseDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)
				||maze.isHeroWeapon(this.getPosX()+newXposition,this.getPosY()+newYposition)
				||maze.isOpenDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)
				||maze.isClub(this.getPosX()+newXposition,this.getPosY()+newYposition)
				||maze .isHeroArmed(this.getPosX()+newXposition,this.getPosY()+newYposition)){

			this.attackOgre(maze,rand);

			return;

		}




		if(maze.isLever(this.getPosX()+newXposition,this.getPosY()+newYposition)==false){
			this.setName('O');
			moveOgre(newXposition,newYposition, maze);
			maze.inser(this.getPosX(),this.getPosY() ,this.getName());
			this.attackOgre(maze,rand);
			return;


		}


		if(maze.isLever(this.getPosX()+newXposition,this.getPosY()+newYposition)){
			this.setName('$');
			moveOgre(newXposition,newYposition, maze);
			maze.inser(this.getPosX(),this.getPosY() ,this.getName());
			this.attackOgre(maze,rand);
			return;


		}

	}







}
