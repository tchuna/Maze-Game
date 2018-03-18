package maze.logic;

import java.awt.Point;

public class Ogre extends Character{

	private int oldX;
	private int oldY;

	private Weapon weaponOgre;


	Ogre(int x, int y) {
		super(x, y, 'O');
		this.oldX=0;
		this.oldY=0;
		this.weaponOgre=new Weapon();

	}



	public void moveOgre(int x,int y,Maze maze){

		maze.cleanCell(this.getPosX(), this.getPosY());
		this.moveCharacter(x,y);
		maze.inser(this.getPosX(),this.getPosY(), this.getName());
		//this.matrix[ogre.getPosY()][ogre.getPosX()]=ogre.getName();

	}





	public void attackOgre(Maze maze){

		Point leverPosition=new Point(4,4);


		this.armedOgre();

		if(maze.getHero().getName()=='K'){
			leverPosition=new Point(0,0);

		}

		if(maze.isWall(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isCloseDoor(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isClub(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isOgre(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isOpenDoor(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())
				|| maze.isLever(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon())){
			return;
		}




		/*if((leverPosition.x!=ogre.getPosX() && leverPosition.x!=ogre.getOgreWeapon().getXWeapon())||
				(leverPosition.y!=ogre.getOgreWeapon().getYWeapon() && leverPosition.y !=ogre.getPosY())){


			if(leverPosition.x!=0){
				System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
				matrix[leverPosition.y][leverPosition.x]='k';
			}


		}


		if(leverPosition.x!=ogre.getOgreWeapon().getXWeapon() && leverPosition.y!=ogre.getOgreWeapon().getYWeapon()
				&& leverPosition.x!=ogre.getPosX() && leverPosition.y!=ogre.getPosY() ){


			matrix[ogre.getOgreWeapon().getYWeapon()][ogre.getOgreWeapon().getXWeapon()]=ogre.getOgreWeapon().getNameWeapon();
			if(leverPosition.x!=0){
				matrix[leverPosition.y][leverPosition.x]='k';
			}

			return;

		}



		if(leverPosition.x==ogre.getOgreWeapon().getXWeapon() && leverPosition.y==ogre.getOgreWeapon().getYWeapon() &&ogre.getOgreWeapon().getNameWeapon()=='*'){

			ogre.getOgreWeapon().setNameWeapon('$');

			matrix[ogre.getOgreWeapon().getYWeapon()][ogre.getOgreWeapon().getXWeapon()]=ogre.getOgreWeapon().getNameWeapon();
			return;
		}*/





		maze.inser(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon(),this.getOgreWeapon().getNameWeapon());

		//matrix[ogre.getOgreWeapon().getYWeapon()][ogre.getOgreWeapon().getXWeapon()]=ogre.getOgreWeapon().getNameWeapon();




	}

	public Boolean ogreKillHero(Maze maze){



		if (this.getPosX() == maze.getHero().getPosX()+1 && this.getPosY() == maze.getHero().getPosY()
				|| this.getPosX() == maze.getHero().getPosX()-1 && this.getPosY() == maze.getHero().getPosY()
				|| this.getPosY() == maze.getHero().getPosY()+1 && this.getPosX() == maze.getHero().getPosX()
				|| this.getPosY() == maze.getHero().getPosY()-1 && this.getPosX() == maze.getHero().getPosX()){

			return true ;



		}else if(this.getOgreWeapon().getXWeapon()== maze.getHero().getPosX()+1 && this.getOgreWeapon().getYWeapon()== maze.getHero().getPosY()
				|| this.getOgreWeapon().getXWeapon()== maze.getHero().getPosX()-1 && this.getOgreWeapon().getYWeapon()== maze.getHero().getPosY()
				|| this.getOgreWeapon().getXWeapon()== maze.getHero().getPosX()  && this.getOgreWeapon().getYWeapon()== maze.getHero().getPosY()+1
				|| this.getOgreWeapon().getXWeapon()== maze.getHero().getPosX() && this.getOgreWeapon().getYWeapon()== maze.getHero().getPosY()-1){


			return true;


		}else return false;




	}





	public void playRandomMovesOgre(Maze maze){ 


		int random=randomNumber(5);
		Point leverPosition=new Point(4,4);

		int newXposition=0;
		int newYposition=0;



		switch (random) {
		case 4:newXposition++;
		break;
		case 3:newXposition--;
		break;
		case 2:newYposition--;
		break;
		case 1:newYposition++;
		break;}


		if(maze.getHero().getName()=='K'){
			leverPosition=new Point(0, 0);

		}




		if (maze.isWall(this.getPosX()+newXposition,this.getPosY()+newYposition) // verifica se a nova posicao do ogre e parede ou porta fecahdo 
				||maze.isCloseDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)
				||maze.isOpenDoor(this.getPosX()+newXposition,this.getPosY()+newYposition)
				||maze.isOgre(this.getPosX()+newXposition,this.getPosY()+newYposition)
				|| maze.isClub(this.getPosX()+newXposition,this.getPosY()+newYposition)
				|| maze.isLever(this.getPosX()+newXposition,this.getPosY()+newYposition)){

			return;

		}


		/*if(leverPosition.x!=this.getPosX()+newXposition && leverPosition.y!=this.getPosY()+newYposition){

			this.setName('O');
			moveOgre(newXposition,newYposition,maze);
			return;

		}





		if( leverPosition.x==this.getPosX()+newXposition && leverPosition.y==this.getPosY()+newYposition ){

			this.setName('$');
			maze.inser(this.getPosX()+newXposition, this.getPosY()+newYposition,'S' );
			moveOgre(newXposition,newYposition,maze);
			return;
		}*/



		moveOgre(newXposition,newYposition, maze);



	}




	public static int randomNumber(int n)	//gera num aleatorio de 1 a n-1
	{
		int num = (int) (Math.random() * (n-1) +1);
		if(num<0)
		{
			num=num*(-1);
		}
		return num;
	}



	public int getleverXogre(){

		return this.oldX;

	}

	public int getleverYogre(){

		return this.oldY;

	}


	public void setleverPogre(int x, int y){
		this.oldX=x;
		this.oldY=y;

	}


	public Weapon getOgreWeapon() {
		return weaponOgre;

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


		case 1: this.getOgreWeapon().setWeapon(this.posX,this.posY-1);break;

		case 2:this.getOgreWeapon().setWeapon(this.posX,this.posY+1);break;

		case 3:this.getOgreWeapon().setWeapon(this.posX-1,this.posY);break;

		case 4:this.getOgreWeapon().setWeapon(this.posX+1,this.posY);break;

		}
	}


}
