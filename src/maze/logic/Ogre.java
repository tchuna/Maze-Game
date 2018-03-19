package maze.logic;

import java.awt.Point;
import java.util.ArrayList;

public class Ogre extends Character{


	private Weapon weaponOgre;
	private ArrayList<Ogre>ogres=new ArrayList<Ogre>();
	int lev=0;


	Ogre(int x, int y) {
		super(x, y, 'O');
		this.weaponOgre=new Weapon();

	}



	public void moveOgre(int x,int y,Maze maze){

		maze.cleanCell(this.getPosX(), this.getPosY());
		this.moveCharacter(x,y);
		maze.inser(this.getPosX(),this.getPosY(), this.getName());

	}


	public void CopyOgres(Maze maze){

		this.ogres=maze.geTogres();
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




		maze.inser(this.getOgreWeapon().getXWeapon(),this.getOgreWeapon().getYWeapon(),this.getOgreWeapon().getNameWeapon());






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
				||maze.isClub(this.getPosX()+newXposition,this.getPosY()+newYposition)
				||maze.isLever(this.getPosX()+newXposition,this.getPosY()+newYposition)){

			return;

		}




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



	public int geTlev(){
		return this.lev;
	}

	public void seTlev(int set){
		this.lev=set;
	}



	public void putLever(Maze maze){

		Point leverPosition=new Point(4,4);
		Ogre og=new Ogre(leverPosition.x, leverPosition.y);

		if(this.lev==0){
			maze.inser(leverPosition.x, leverPosition.y, 'k');
		}

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
