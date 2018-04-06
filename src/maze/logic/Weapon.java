package maze.logic;

/**
 * Class for Weapon
 * 
 * */
public class Weapon {

	private int x;
	private int y;

	private char nameWeapon;

	

	/**
	 * Create a default weapon 
	 * 
	 * */
	public Weapon() {
		
		
		
		this.nameWeapon ='*';
		this.x=0;
		this.y=0;
		
	}
 
 

	/**
	 * Get  Weaponr name 
	 * @return Return name
	 */
	public char getNameWeapon(){

		return this.nameWeapon;
	}

	
	/**
	 * Get x Weapon position
	 * @return Return  position
	 */
	public int  getXWeapon(){

		return this.x;
	}

	
	
	/**
	 * Get y Weapon position
	 * @return Return  position
	 */
	public int  getYWeapon(){

		return this.y;
	}


	/**
	 * Set Weapon Position
	 * @param x new x Weapon position
	 * @param y new y Weapon position
	 * */
	public void setWeapon(int x,int y){

		this.x=x;
		this.y=y;
	}

	
	/**
	 * Set  Weapon name
	 * @param name  new weapon name
	 * */
	public void setNameWeapon(char name ){

		this.nameWeapon=name;
	}

}
