package maze.logic;



public class Hero extends Character{
	
	private Boolean isDead;
	private Boolean win;

	public Hero(int x,int y) {
		super(x,y,'H');
		this.isDead=false;
		this.win=false;
	}
	
	
	
	
	public void moveHero(int x,int y,Maze maze) {

		maze.cleanCell(this.getPosX(), this.getPosY());
		this.moveCharacter(x,y);
		maze.inser(this.getPosX(), this.getPosY(),this.getName());

	}
	
	
	public int playHero(String input,Maze maze){



		int newXposition=0;
		int newYposition=0;

		switch (input) {
		case "d":newXposition++;
		break;
		case "a":newXposition--;
		break;
		case "w":newYposition--;
		break;
		case "s":newYposition++;
		break;}


		if(this.getName()=='K' && maze.isCloseDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)){

			maze.change_CloseDoor_To_OpenDoor();
			moveHero(newXposition, newYposition,maze);
			this.win=true;
			return 1;

		}


		if(this.getName()=='K' && maze.isOpenDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)){

			this.setWin();
		}



		if(maze.isOpenDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)){
			maze.changeMap();
			return 2;
		}


		if (maze.isWall(this.getPosX()+newXposition,this.getPosY()+newYposition) ||
				maze.isCloseDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)){

			return 1;

		}



		if(maze.isLever(this.getPosX()+newXposition,this.getPosY()+newYposition)){


			if(maze.numMap()==2){
				maze.getHero().setName('K');
				moveHero(newXposition, newYposition,maze);
				return 1;
			}

			//openDoorMap1();
			maze.change_CloseDoor_To_OpenDoor();
			moveHero(newXposition, newYposition,maze);

			return 1;
		}




		moveHero(newXposition, newYposition,maze);

		return 1;


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
	
	
	
}