package maze.logic;



public class Ogre extends Character{

	private int oldX;
	private int oldY;

	private Weapon weaponOgre;


	Ogre(int x, int y) {
		super(x, y, 'O');
		// TODO Auto-generated constructor stub
		this.oldX=0;
		this.oldY=0;
		this.weaponOgre=new Weapon();

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
