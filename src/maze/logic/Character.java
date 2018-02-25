package maze.logic;

public class Character {

	//Attributes
	protected int posX=-1;
	protected int posY=-1;
	protected char nameCh;


	Character(int x, int y,char name) {
		this.posX=x;
		this.posY=y;
		this.nameCh=name;

	}
	
	
	public void  moveCharacter(int x,int y){
		this.posX+=x;
		this.posY+=y;
		
	}

	public int getPosX(){

		return this.posX;

	}

	public int getPosY(){

		return this.posY;

	}
	
	public char getName(){
		return this.nameCh;
	}

	
	public void setName(char name){
		this.nameCh=name;
		
	}
	
	public void setPosition(int x, int y){
		this.posX=x;
		this.posY=y;
		
	}
	
	
	
	



}
