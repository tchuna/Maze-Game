package maze.logic;

import java.awt.Point;

public class Maze {
	//Attributes
	private char matrix[][];
	public static final char Door='I';
	public static final char Lever='k';

	Hero hero ;
	Guard guard;
	Point exit1 =new Point(0, 5);
	Point exit2 =new Point(0, 6);




	//Methods

	public Maze(){

		char matrix[][]=new char[][]{
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

		this.matrix=matrix;

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
		this.matrix[guard.getPosY()][guard.getPosX()]=guard.getName();

	}

	public Boolean isDoor(int x , int y){

		if (this.matrix[y][x]=='I'){
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




	public int playHero(String input){

		int newXposition=0;
		int newYposition=0;


		switch (input) {
		case "d":newXposition++;
		break;
		case "a":newXposition--;
		break;
		case "w":newYposition--;
		break;
		case "s":newYposition++;
		break;}


		if (matrix[hero.getPosY()+newYposition][hero.getPosX()+newXposition] =='X' ||
				matrix[hero.getPosY()+newYposition][hero.getPosX()+newXposition] =='I'){
			return 1;

		}

		if(matrix[hero.getPosY()+newYposition][hero.getPosX()+newXposition] =='k'){
			cleanCell(hero.getPosX(), hero.getPosY());
			openDoor();
			hero.moveCharacter(newXposition, newYposition);
			insertHero(hero.getPosX(), hero.getPosY());
			return 1;
		}

		if(guardCaptureHero()==true){
			System.out.println("Game Over");
			return 0;
		}



		cleanCell(hero.getPosX(), hero.getPosY());
		hero.moveCharacter(newXposition, newYposition);
		insertHero(hero.getPosX(), hero.getPosY());

		return 1;


	}


}




