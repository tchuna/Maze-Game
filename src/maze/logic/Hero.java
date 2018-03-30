package maze.logic;

import java.io.Serializable;

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


 
	public Hero(int x,int y) {
		super(x,y,'H');
		this.isDead=false;
		this.win=false; 
	}





	public Boolean getIsDead(){
		return this.isDead;
	}



	public void  setIsDead() {
		this.isDead=true;
	}



	public Boolean getWin(){
		return this.win;
	}



	public void  setWin() {
		this.win=true;
	}



	public boolean isNear(int x, int y){
		if(x!=posX+1||y!=posY+1 ){
			return true;

		}

		return false;

	}




	public Boolean getIsArmed() {
		return isArmed;
	}




	public void setIsArmed(Boolean isArmed) {
		this.isArmed = isArmed;
	}




	public Boolean getTakeLever() {
		return takeLever;
	}




	public void setTakeLever(Boolean takeLever) {
		this.takeLever = takeLever;
	}





	public void moveHero(int x,int y,Maze maze) {

		maze.cleanCell(this.getPosX(), this.getPosY());
		this.moveCharacter(x,y);
		maze.inser(this.getPosX(), this.getPosY(),this.getName());

	}

	public Boolean heroArmed(int x, int y){

		if(this.posX==x && this.posY==y && this.isArmed==true){

			return true;
		}


		return false;
	}


	public int playHero(String input,Maze maze){



		int newXposition=0;
		int newYposition=0;

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