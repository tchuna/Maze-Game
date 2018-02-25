package maze.logic;

import java.awt.Point;

public class Maze {
	//maps
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
		{'I',' ',' ',' ',' ',' ',' ',' ','k','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X'},
	};



	//Attributes
	private char matrix[][];
	public static final char Door='I';
	public static final char Lever='k';

	Hero hero ;
	Guard guard;
	Point exit1 =new Point(0, 5);
	Point exit2 =new Point(0, 6);
	Point exit1Map2=new Point(0, 1);
	static int add=0;




	//Methods

	public Maze( ){


		this.matrix=map1;

	}


	public Maze(char matrix[][]) {
		this.matrix=matrix;
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

	public void insertHero(int x, int y){
		hero =new Hero(x, y);

		this.matrix[hero.getPosY()][hero.getPosX()]=hero.getName();

	}

	public void insertGuard(int x, int y){
		guard =new Guard(x, y);
		//guard.insertPositionMoves();
		this.matrix[guard.getPosY()][guard.getPosX()]=guard.getName();

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


	void openDoor(){

		this.matrix[exit1.y][exit1.x]='S';
		this.matrix[exit2.y][exit2.x]='S';


	}

	void cleanCell(int x,int y){
		matrix[y][x]=' ';

	}

	public void changeMap(int map){
		if(map==1){
			this.matrix=map2;
			hero.setPosition(1, 1);
			this.matrix[hero.getPosX()][hero.getPosY()]=hero.getName();
			guard=null;
		}

	}


	public Boolean guardCaptureHero(){

		if (guard.getPosX() == hero.getPosX()+1 && guard.getPosY() == hero.getPosY()
				|| guard.getPosX() == hero.getPosX()-1 && guard.getPosY() == hero.getPosY()
				|| guard.getPosY() == hero.getPosY()+1 && guard.getPosX() == hero.getPosX()
				|| guard.getPosY() == hero.getPosY()-1 && guard.getPosX() == hero.getPosX()){

			return true ;
		}else{
			return false;
		}

	}




	public void moveGuard(int i){
		Point newPOint=new Point();
		newPOint=guard.getguardPositions()[i];
		this.matrix[guard.getPosY()][guard.getPosX()]=' ';
		guard.setPosition(newPOint.x, newPOint.y);
		this.matrix[guard.getPosY()][guard.getPosX()]=guard.getName();



	}

	public void moveHero(int x,int y) {
		hero.moveCharacter(x,y);
		this.matrix[hero.getPosY()][hero.getPosX()]=hero.getName();

	}

	public int playHero(String input){



		int newXposition=0;
		int newYposition=0;
		add++;

		if(add==24){
			add=0;
		}


		switch (input) {
		case "d":newXposition++;
		break;
		case "a":newXposition--;
		break;
		case "w":newYposition--;
		break;
		case "s":newYposition++;
		break;}


		if(isOpenDoor(hero.getPosX()+newXposition,hero.getPosY()+newYposition)){
			changeMap(1);
		}


		if (isWall(hero.getPosX()+newXposition,hero.getPosY()+newYposition) ||
				isCloseDoor(hero.getPosX()+newXposition,hero.getPosY()+newYposition)){
			if(guard!=null){
				moveGuard(add);
			}

			return 1;

		}


		if(isLever(hero.getPosX()+newXposition,hero.getPosY()+newYposition)){
			cleanCell(hero.getPosX(), hero.getPosY());
			if(guard!=null){
				moveGuard(add);
			}
			//moveGuard(add);
			openDoor();
			moveHero(newXposition, newYposition);
			return 1;
		}

		if(guard!=null){
			if(guardCaptureHero()==true){
				System.out.println("Game Over");
				return 0;
			}
		}




		cleanCell(hero.getPosX(), hero.getPosY());

		if(guard!=null){
			moveGuard(add);
		}
		//moveGuard(add);
		moveHero(newXposition, newYposition);


		return 1;


	}


}




