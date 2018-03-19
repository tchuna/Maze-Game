package maze.logic;

import java.awt.Point;
import java.util.ArrayList;

public class Maze {





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
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
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
	//private Point exit1 =new Point(0, 5);
	//private Point exit2 =new Point(0, 6);
	//private Point exit1Map2=new Point(0, 1);
	private Ogre[] arrogre=new Ogre[numOres];
	private ArrayList<Ogre>ogres=new ArrayList<Ogre>();
	private int numberMap;





	//Methods

	public Maze(int map){

		switch (map) {
		case 1:matrix=map1;break;
		case 2:matrix=map2;break;
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


	public void insertOgre(int x, int y){

		this.matrix[x][y]='O';

	}


	public void  inser(int x, int y, char name) {
		this.matrix[y][x]=name;
	}



	public Boolean isCloseDoor(int x , int y){

		if (this.matrix[y][x]=='I'){
			return true ;

		}else {
			return false ;
		}


	}



	public Boolean isOpenDoor(int x , int y){

		if (this.matrix[y][x]=='S'){
			return true ;

		}else {
			return false ;
		}


	}




	public Boolean isWall(int x , int y){

		if (this.matrix[y][x]=='X'){
			return true ;

		}else {
			return false ;
		}


	}

	public Boolean isLever(int x , int y){

		if (this.matrix[y][x]=='k'){
			return true ;

		}else {
			return false ;
		}


	}


	public Boolean isClub(int x , int y){

		if (this.matrix[y][x]=='*'){
			return true ;

		}else {
			return false ;
		}


	}

	public Boolean isOgre(int x , int y){

		if (this.matrix[y][x]=='O'){
			return true ;

		}else {
			return false ;
		}


	}


	public void cleanCell(int x,int y){
		matrix[y][x]=' ';

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
					matrix[i][j]='S';
			}
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
				System.out.println(randX);
				System.out.println(randY);
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
		case 1:guard.turnGuardRoockieMode(this);break;
		case 2:guard.turnGuardSuspiciousMode(this);break;
		case 3:guard.turnGuardDrunkMode(this);break;
		}


	}



	public void Level_2(){


		guard=null;
		this.matrix=map2;
		hero.setPosition(1, 1);
		inser(hero.getPosX(),hero.getPosY(),hero.getName());//this.matrix[hero.getPosX()][hero.getPosY()]=hero.getName();
		creatOres();
		
		for(int i=0;i<arrogre.length;i++){
			inser(arrogre[i].getPosX(),arrogre[i].getPosY(),arrogre[i].getName());
			
			
		}

		System.out.println(arrogre.length);
		


	}


	public void logical_level_2(){

		cleannclub();

		for(int i=0;i<arrogre.length;i++){

			arrogre[i].playRandomMovesOgre(this);
			
			arrogre[i].attackOgre(this);

			if(arrogre[i].ogreKillHero(this)==true){ 
				hero.setIsDead();
			}
		}
		
		
		


	}


	


	public int updateTime(String input){
		int result;

		result=hero.playHero(input, this);
		
		

		switch (numberMap) {
		case 1:Level_1();break;
		case 2:logical_level_2();break;//;break;
		}


		if(hero.getWin()==true || hero.getIsDead()==true){
			return 0;
		}


		return result;


	}









}



