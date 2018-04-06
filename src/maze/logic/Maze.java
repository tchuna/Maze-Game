package maze.logic;



import java.io.Serializable;
import java.util.ArrayList;



/**
 * Class for Maze game 
 * 
 * */
public class Maze  implements Serializable{

	private static final long serialVersionUID = 1L; 


 



	/**
	 * generate a random number between 1-n
	 * 
	 * @param n 
	 * @return num  the random number generate 
	 */
	public static int randomNumberog(int n)	{
		int num = (int) (Math.random() * (n-1) +3);
		return num;
	} 



	char map1[][]=new char[][]{
		{'X','X','X','X','X','X','X','X','X','X'},
		{'X',' ',' ',' ','I',' ','X',' ',' ','X'},
		{'X','X','X',' ','X','X','X',' ',' ','X'},
		{'X',' ','I',' ','I',' ','X',' ',' ','X'},
		{'X','X','X',' ','X','X','X',' ',' ','X'},
		{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X','X','X',' ','X','X','X','X',' ','X'},
		{'X',' ','I',' ','I',' ','X','k',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X'},
	};


	char map2[][]=new char[][]{
		{'X','X','X','X','X','X','X','X','X','X'},
		{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X','C',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ','k',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X'},
	};



	//Attributes
	private char matrix[][];

	int numOres=3;




	private Hero hero ;
	private Guard guard;

	private static final int ROCKIE=1;
	private static final int SUSPICIOS=2;
	private static final int DRUNK=3;
	private static final char HEROWEAPON ='C';
	private static final char CLUB ='*';
	private static final char WALL ='X';
	private static final char EXIT='S';
	private static final char LEVER ='k'; 
	private static final char CLOSEDOOR='I';
	private static final char FREECELL =' '; 
	private static final char OGRE ='O';
	private static final char SLEEPOGRE ='8';
	private Ogre[] arrogre=new Ogre[numOres];
	private ArrayList<Ogre>ogres=new ArrayList<Ogre>();
	private int numberMap;
	private String srtingMatrix =null;
	public int modeGuard;
	private boolean notlevel1=false;







	/**
	 * Creates Maze
	 * @param map level  map 
	 * 
	 * */
	public Maze(int map){

		switch (map) {
		case 1:matrix=map1;insertHero(1, 1);break;
		case 2:matrix=map2; insertHero(8, 2);notlevel1=true;break;
		}

		this.numberMap=map;



	}

	
	/**
	 * Get the current map level 
	 * @return numberMap
	 */
	public int numMap(){
		return this.numberMap;
	}



	
	/**
	 * Get the current matrix in game  
	 * @return matrix
	 */
	public char[][] getMatrix(){

		return this.matrix;
	}

	
	/**
	 * Get the Hero in Game 
	 * @return hero  
	 */
	public Hero getHero(){

		return this.hero;
	}


	/**
	 * Get the Guard in Game 
	 * @return guard 
	 */
	public Guard getGuard(){

		return this.guard;
	}

	
	/**
	 * Set  the guard  in Game  to null 
	 * 
	 **/
	public void setGuard(){

		this.guard=null;
	}

	
	/**
	 * Get the ArrayList of ogres in Game  
	 * @return ogres 
	 */
	public ArrayList<Ogre> geTogres(){
		return ogres;
	}


	
	/**
	 * Insert the hero in maze Game 
	 * @param x hero x position  
	 * @param y hero y position 
	 **/
	public void insertHero(int x, int y){
		hero =new Hero(x, y);

		this.matrix[hero.getPosY()][hero.getPosX()]=hero.getName();

	}

	

	/**
	 * Insert the guard in maze Game 
	 * @param x guard  x position  
	 * @param y guard  y position 
	 **/
	public void insertGuard(int x, int y,int mode){
		guard =new Guard(x, y,mode);
		this.matrix[guard.getPosY()][guard.getPosX()]=guard.getName();

	}


	

	/**
	 * Insert the ogre in maze Game 
	 * @param x ogre x position  
	 * @param y ogre y position 
	 **/
	public void insertOgre(Ogre ogre){

		this.matrix[ogre.getPosY()][ogre.getPosX()]=ogre.getName();

	}


	

	/**
	 * Insert a element in matrix Game 
	 * @param x  position  
	 * @param y  position 
	 **/
	public void  inser(int x, int y, char name) {
		this.matrix[y][x]=name;
	}


	
	

	/**
	 * Verify is a position a close door  
	 * @param x  position  
	 * @param y  position
	 *  
	 *@return result 
	 */
	public Boolean isCloseDoor(int x , int y){

		if (this.matrix[y][x]==CLOSEDOOR){
			return true ;

		}else {
			return false ;
		}


	}
	
	/**
	 * Verify is a position a close door  
	 * @param x  position  
	 * @param y  position
	 *  
	 *@return result 
	 */
	public Boolean isHero(int x , int y){

		if (this.matrix[y][x]=='H'){
			return true ;

		}else {
			return false ;
		}


	}



	/**
	 * Verify is a position a open door  
	 * @param x  position  
	 * @param y  position
	 *  
	 *@return result 
	 */
	public Boolean isOpenDoor(int x , int y){

		if (this.matrix[y][x]==EXIT){
			return true ;

		}else {
			return false ;
		}


	}




	/**
	 * Verify is a position a wall 
	 * @param x  position  
	 * @param y  position
	 *  
	 *@return result 
	 */
	public Boolean isWall(int x , int y){

		if (this.matrix[y][x]==WALL){
			return true ;

		}else {
			return false ;
		}


	}

	
	/**
	 * Verify is a position a lever  
	 * @param x  position  
	 * @param y  position
	 *  
	 *@return result 
	 */
	public Boolean isLever(int x , int y){

		if (this.matrix[y][x]==LEVER){
			return true ;

		}else {
			return false ;
		}


	}


	/**
	 * Verify is a position a club  
	 * @param x  position  
	 * @param y  position
	 *  
	 *@return result 
	 */
	public Boolean isClub(int x , int y){

		if (this.matrix[y][x]==CLUB){
			return true ;

		}else {
			return false ;
		}


	}

	
	/**
	 * Verify is a position a ogre 
	 * @param x  position  
	 * @param y  position
	 *  
	 *@return result 
	 */
	public Boolean isOgre(int x , int y){

		if (this.matrix[y][x]==OGRE || this.matrix[y][x]==SLEEPOGRE){
			return true ;

		}else {
			return false ;
		}


	}


	
	/**
	 * Verify is a position weapon 
	 * @param x  position  
	 * @param y  position
	 *  
	 *@return result 
	 */
	public Boolean isHeroWeapon(int x , int y){

		if (this.matrix[y][x]==HEROWEAPON){
			return true ;

		}else {
			return false ;
		}


	}


	
	/**
	 * Verify is a Armed hero 
	 * @param x  position  
	 * @param y  position
	 *  
	 *@return result 
	 */
	public Boolean isHeroArmed(int x , int y){

		if(this.getHero().getIsArmed()==true && this.getHero().getPosX()==x && this.getHero().getPosY()==y){

			return true;
		}



		return false;
	}




	
	

	/**
	 * Clean a cell in matrix game   
	 * @param x  position  
	 * @param y  position
	 *  
	 **/
	public void cleanCell(int x,int y){
		inser(x, y, FREECELL);

	}



	
	/**
	 * Clean every club  in matrix game   
	 * 
	 *  
	 **/
	public void cleannclub(){
		for(int i=0;i<matrix.length; i++){
			for(int j=0; j<matrix.length; j++){
				if(matrix[i][j]=='*')
					matrix[i][j]=' ';
			}
		}
	}



	
	/**
	 * change every close door in open door
	 * 
	 *  
	 **/
	public void change_CloseDoor_To_OpenDoor(){

		for(int i=0;i<matrix.length; i++){
			for(int j=0; j<matrix.length; j++){
				if(matrix[i][j]=='I')
					matrix[i][j]='S'; } 
		}
	}




	
	

	/**
	 * Create  every ogres in game 
	 * 
	 *  
	 **/
	public void creatOres(){
		int randX,randY;
		Ogre ogre;

		for(int i=0;i<numOres;i++){
			randX=randomNumberog(8); randY=randomNumberog(8);

			ogre=new Ogre(randX, randY);

			while(ogres.contains(ogre) || isCloseDoor(randX, randY)|| isLever(randX,randY) || isWall(randX, randY) || isHero(randX, randY) ){
				randX=randomNumberog(8); randY=randomNumberog(8);
				ogre=new Ogre(randX, randY);
			}

			ogres.add(ogre);
		}
		this.arrogre=ogres.toArray(new Ogre[ogres.size()]);
	}



	
	/**
	 * Display a matrix game in current maze
	 * @param current maze
	 *  
	 **/
	public void displayMaze(Maze maze ) {

		int matrixLength=maze.getMatrix().length;
		char matrix [][]=maze.getMatrix();

		System.out.print('\n');

		for(int i=0; i<matrixLength;i++){
			for(int j=0;j<matrixLength;j++ ){
				System.out.print(matrix[i][j]); 
				System.out.print(' ');
			}
			System.out.print('\n');


		} 
	}

	
	/**
	 * Change the map in maze game 
	 * 
	 *  
	 **/
	public void changeMap(){

		numberMap++;



		if(numberMap==2|| numberMap==3){
			Level_2();
			displayMaze(this);
		}

	}




	
	
	/**
	 * level 1 logical game 
	 * 
	 *  
	 **/
	public void Level_1(){

		int randD=randomNumberog(6);
		int randS=randomNumberog(3);

		switch (guard.getMode()) {
		case ROCKIE:guard.turnGuardRoockieMode(this);break;
		case SUSPICIOS:guard.turnGuardSuspiciousMode(this,randS);break;
		case DRUNK:guard.turnGuardDrunkMode(this,randD);break;
		}


	}


	

	/**
	 * level 2 logical game 
	 * 
	 *  
	 **/
	public void Level_2(){


		guard=null;
		this.matrix=map2;
		hero.setPosition(8,2);
		hero.setTakeLever(false);
		inser(hero.getPosX(),hero.getPosY(),hero.getName());
		creatOres();

		for(int i=0;i<arrogre.length;i++){
			inser(arrogre[i].getPosX(),arrogre[i].getPosY(),arrogre[i].getName());


		}




	}


	
	/**
	 * level 2 logical game 
	 * 
	 *  
	 **/
	public void logical_level_2(){ 

		int random=0;
		cleannclub();

		for(int i=0;i<arrogre.length;i++){

			random=arrogre[i].randomNumber(5);
			arrogre[i].playRandomMovesOgre(this,random);

			if(arrogre[i].ogreKillHero(this)==true){ 
				hero.setIsDead();
			}
		}


		arrogre[0].putLever(this);




	}



	
	
	/**
	 * Update the current Maze game 
	 * 
	 * @param input  
	 
	 * @return  the result  
	 * 
	 */
	public int updateTime(String input){
		int result;
		if(notlevel1==true){

			Level_2();
			displayMaze(this);
			notlevel1=false;
		}

		result=hero.playHero(input, this);




		switch (numberMap) {
		case 1:Level_1();break;
		case 2:logical_level_2();break;
		case 3:logical_level_2();break;
		}



		this.srtingMatrix=toString();

		if(hero.getWin()==true || hero.getIsDead()==true){

			this.srtingMatrix=toString();
			return 0;
		}



		return result;


	}




	
	/** 
	 * convert the matrix char in game 
	 * to string
	 *  
	 **/
	public String toString(){
		String result ="" ;


		for(int i=0; i<matrix.length;i++){

			for(int j=0; j<matrix.length;j++){
				result+=String.valueOf(matrix[i][j])+ " ";
			}

			result+="\n";
		}

		return result;
	}














}



