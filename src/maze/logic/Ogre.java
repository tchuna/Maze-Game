package maze.logic;

import java.io.Serializable;


public class Ogre extends Character implements Serializable{



	private static final long serialVersionUID = 1L;
	private static final  int UP =1;
	private static final  int DOWN =2;
	private static final  int LEFT =3;
	private static final  int RIGHT =4;
	
	
	private Weapon weaponOgre;
	private int lev=0;
	private  Boolean sleep= false;
	private static int  stopTurn=2;


	Ogre(int x, int y) {
		super(x, y, 'O');
		this.weaponOgre=new Weapon();

	}







	public Boolean getSleep() {
		return sleep;
	}



	public void setSleep(Boolean sl) {
		this.sleep = sl;
	}



	public int getStopTurn() {
		return stopTurn;
	}


	public int geTlev(){
		return this.lev;
	}

	public void seTlev(int set){
		this.lev=set;
	}



	public Weapon getOgreWeapon() {
		return weaponOgre;

	}



	public  void wakeOgre(){

		if(this.sleep==false){
			return;
		}


		stopTurn--;

		if(stopTurn<0 ){
			stopTurn=2;
			this.sleep=false;
			this.setName('O');
		}


	}



	public void  ogreSleeped(Maze maze){
		this.setName('8');
		this.sleep=true;
		maze.inser(this.getPosX(),this.getPosY(), this.getName());
		maze.cleannclub();

	}




	public static int randomNumber(int n){	//gera num aleatorio de 1 a n-1

		int num = (int) (Math.random() * (n-1) +1);
		if(num<0){

			num=num*(-1); }

		return num;
	}




	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Ogre){
			Ogre n=(Ogre)obj;

			return (this.getPosX()==n.getPosX() && this.getPosY()==n.getPosY());

		}
		return false;
	}





	public void armedOgre(){


		int num=randomNumber(5);

		this.getOgreWeapon().setNameWeapon('*');

		switch (num) {


		case UP: this.getOgreWeapon().setWeapon(this.posX,this.posY-1);break;

		case DOWN:this.getOgreWeapon().setWeapon(this.posX,this.posY+1);break;

		case LEFT:this.getOgreWeapon().setWeapon(this.posX-1,this.posY);break;

		case RIGHT:this.getOgreWeapon().setWeapon(this.posX+1,this.posY);break;

		}
	}







	public void moveOgre(int x,int y,Maze maze){

		maze.cleanCell(this.getPosX(), this.getPosY());
		this.moveCharacter(x,y);
		maze.inser(this.getPosX(),this.getPosY(), this.getName());

	}





	public void attackOgre(Maze maze){


		this.armedOgre();

		if(maze.isWall(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isCloseDoor(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isClub(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isOgre(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isOpenDoor(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isLever(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())){
			return;
		}




		maze.inser(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon(),this.getOgreWeapon().getNameWeapon());



	}





	public Boolean ogreKillHero(Maze maze){



		if (maze.getHero().getIsArmed()==false && (this.getPosX() == maze.getHero().getPosX()+1 && this.getPosY() == maze.getHero().getPosY()
				|| this.getPosX() == maze.getHero().getPosX()-1 && this.getPosY() == maze.getHero().getPosY()
				|| this.getPosY() == maze.getHero().getPosY()+1 && this.getPosX() == maze.getHero().getPosX()
				|| this.getPosY() == maze.getHero().getPosY()-1 && this.getPosX() == maze.getHero().getPosX())
				|| this.getPosY() == maze.getHero().getPosY() && this.getPosX() == maze.getHero().getPosX()){

			return true ; }



		if(maze.getHero().getIsArmed()==true && (this.getPosX() == maze.getHero().getPosX()+1 && this.getPosY() == maze.getHero().getPosY()
				|| this.getPosX() == maze.getHero().getPosX()-1 && this.getPosY() == maze.getHero().getPosY()
				|| this.getPosY() == maze.getHero().getPosY()+1 && this.getPosX() == maze.getHero().getPosX()
				|| this.getPosY() == maze.getHero().getPosY()-1 && this.getPosX() == maze.getHero().getPosX())){


			ogreSleeped(maze);

			return false; }



		if(this.getOgreWeapon().getXWeapon()== maze.getHero().getPosX()&& this.getOgreWeapon().getYWeapon()== maze.getHero().getPosY()){
			return true; }



		return false;




	}




	public void playRandomMovesOgre(Maze maze){ 


		wakeOgre(); if(this.sleep==true)return;



		int random=randomNumber(5);
		int newXposition=0;
		int newYposition=0;



		switch (random) {
		case RIGHT:newXposition++;
		break;
		case LEFT:newXposition--;
		break;
		case UP:newYposition--;
		break;
		case DOWN:newYposition++;
		break;}



		if (maze.isWall(this.getPosX()+newXposition,this.getPosY()+newYposition) // verifica se a nova posicao do ogre e parede ou porta fecahdo 
				||maze.isCloseDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)
				||maze.isOpenDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)
				||maze.isClub(this.getPosX()+newXposition,this.getPosY()+newYposition)
				||maze.isLever(this.getPosX()+newXposition,this.getPosY()+newYposition)
				){

			this.attackOgre(maze);

			return;

		}



		moveOgre(newXposition,newYposition, maze);
		this.attackOgre(maze);

	}









}
