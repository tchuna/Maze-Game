package maze.logic;



import java.io.Serializable;
import java.nio.channels.NetworkChannel;
import java.util.ArrayList;

public class Maze  implements Serializable{


	private static final long serialVersionUID = 1L;





	public static int randomNumberog(int n)	{
		int num = (int) (Math.random() * (n-1) +3);
		if(num<0)
		{
			num=num*(-1);
		} 
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






	public Maze(int map){

		switch (map) {
		case 1:matrix=map1;insertHero(1, 1);break;
		case 2:matrix=map2; insertHero(8, 2);notlevel1=true;break;
		}

		this.numberMap=map;



	}

	public int numMap(){
		return this.numberMap;
	}


	public Maze(char matrix[][]) {
		this.matrix=matrix;
		this.numberMap=1;
	}



	public char[][] getMatrix(){

		return this.matrix;
	}

	public Hero getHero(){

		return this.hero;
	}


	public Guard getGuard(){

		return this.guard;
	}

	public void setGuard(){

		this.guard=null;
	}

	public ArrayList<Ogre> geTogres(){
		return ogres;
	}


	public void insertHero(int x, int y){
		hero =new Hero(x, y);

		this.matrix[hero.getPosY()][hero.getPosX()]=hero.getName();

	}

	public void insertGuard(int x, int y,int mode){
		guard =new Guard(x, y,mode);
		this.matrix[guard.getPosY()][guard.getPosX()]=guard.getName();

	}


	public void insertOgre(Ogre ogre){

		this.matrix[ogre.getPosY()][ogre.getPosX()]=ogre.getName();

	}


	public void  inser(int x, int y, char name) {
		this.matrix[y][x]=name;
	}



	public Boolean isCloseDoor(int x , int y){

		if (this.matrix[y][x]==CLOSEDOOR){
			return true ;

		}else {
			return false ;
		}


	}



	public Boolean isOpenDoor(int x , int y){

		if (this.matrix[y][x]==EXIT){
			return true ;

		}else {
			return false ;
		}


	}




	public Boolean isWall(int x , int y){

		if (this.matrix[y][x]==WALL){
			return true ;

		}else {
			return false ;
		}


	}

	public Boolean isLever(int x , int y){

		if (this.matrix[y][x]==LEVER){
			return true ;

		}else {
			return false ;
		}


	}


	public Boolean isClub(int x , int y){

		if (this.matrix[y][x]==CLUB){
			return true ;

		}else {
			return false ;
		}


	}

	public Boolean isOgre(int x , int y){

		if (this.matrix[y][x]==OGRE || this.matrix[y][x]==SLEEPOGRE){
			return true ;

		}else {
			return false ;
		}


	}


	public Boolean isHeroWeapon(int x , int y){

		if (this.matrix[y][x]==HEROWEAPON){
			return true ;

		}else {
			return false ;
		}


	}


	public Boolean isHeroArmed(int x , int y){

		if(this.getHero().getIsArmed()==true && this.getHero().getPosX()==x && this.getHero().getPosY()==y){

			return true;
		}



		return false;
	}





	public void cleanCell(int x,int y){
		inser(x, y, FREECELL);

	}



	public void cleannclub(){
		for(int i=0;i<matrix.length; i++){
			for(int j=0; j<matrix.length; j++){
				if(matrix[i][j]=='*')
					matrix[i][j]=' ';
			}
		}
	}



	public void change_CloseDoor_To_OpenDoor(){

		for(int i=0;i<matrix.length; i++){
			for(int j=0; j<matrix.length; j++){
				if(matrix[i][j]=='I')
					matrix[i][j]='S'; } 
		}
	}





	public void creatOres(){
		int randX, randY;
		Ogre ogre;



		for(int i=0;i<numOres;i++){
			randX=randomNumberog(8);
			randY=randomNumberog(8);

			ogre=new Ogre(randX, randY);


			while(ogres.contains(ogre) || isCloseDoor(randX, randY)
					|| isLever(randX,randY) || isWall(randX, randY)){
				randX=randomNumberog(8);
				randY=randomNumberog(8);
				ogre=new Ogre(randX, randY);

			}

			ogres.add(ogre);

		}

		this.arrogre=ogres.toArray(new Ogre[ogres.size()]);


	}



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

	public void changeMap(){

		numberMap++;



		if(numberMap==2|| numberMap==3){
			Level_2();
			displayMaze(this);
		}

	}




	public void Level_1(){

		switch (guard.getMode()) {
		case ROCKIE:guard.turnGuardRoockieMode(this);break;
		case SUSPICIOS:guard.turnGuardSuspiciousMode(this);break;
		case DRUNK:guard.turnGuardDrunkMode(this);break;
		}


	}



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


	public void logical_level_2(){

		cleannclub();

		for(int i=0;i<arrogre.length;i++){

			arrogre[i].playRandomMovesOgre(this);

			if(arrogre[i].ogreKillHero(this)==true){ 
				hero.setIsDead();
			}
		}


		arrogre[0].putLever(this);




	}


	public void logical_crlevel(){



	}





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
		case 3:logical_crlevel();break;
		}



		this.srtingMatrix=toString();

		if(hero.getWin()==true || hero.getIsDead()==true){

			this.srtingMatrix=toString();
			return 0;
		}



		return result;


	}




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



	public String getSrtingMatrix() {
		return srtingMatrix;
	}

	public void setSrtingMatrix(String srtingMatrix) {
		this.srtingMatrix = srtingMatrix;
	}

	public char Verifica(int i, int j) {

		return matrix[j][i];
	}














}



