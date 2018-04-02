package maze.logic;


public class Weapon {

	private int x;
	private int y;//weaponPosition;

	private char nameWeapon;


	public Weapon() {
		
		
		
		this.nameWeapon ='*';
		this.x=0;
		this.y=0;
		
	}
 
 

	public char getNameWeapon(){

		return this.nameWeapon;
	}

	public int  getXWeapon(){

		return this.x;
	}

	
	
	public int  getYWeapon(){

		return this.y;
	}


	public void setWeapon(int x,int y){

		this.x=x;
		this.y=y;
	}

	public void setNameWeapon(char name ){

		this.nameWeapon=name;
	}

}
