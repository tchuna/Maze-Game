package maze.logic;

public class Maze {
	//Attributes
	private char matrix[][];
	public static final char Door='I';
	public static final char Lever='k';

	Hero hero ;
	Guard guard;


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


	public void playPlayer(String input){

		if(input.equals("d")){

			if(isLever(hero.getPosX()+1,hero.getPosY())){

				//lever things 

			}else if(isWall(hero.getPosX()+1,hero.getPosY()) || isDoor(hero.getPosX()+1,hero.getPosY())){
				System.out.println("This Position is a Wall or a Close Door ");

			}else{

				matrix[hero.getPosY()][hero.getPosX()]=' ';

				this.hero.setPosition(hero.getPosX()+1, hero.getPosY());
				insertHero(hero.getPosX(), hero.getPosY());
			}

		}else if(input.equals("a")){


			if(isLever(hero.getPosX()-1,hero.getPosY())){

				//lever things 
				
			}else if(isWall(hero.getPosX()-1,hero.getPosY()) || isDoor(hero.getPosX()-1,hero.getPosY())){
				System.out.println("This Position is a Wall or a Close Door ");
			}else{
				matrix[hero.getPosY()][hero.getPosX()]=' ';

				this.hero.setPosition(hero.getPosX()-1, hero.getPosY());
				insertHero(hero.getPosX(), hero.getPosY());

			}

		}else if(input.equals("s")){


			if(isLever(hero.getPosX(),hero.getPosY()+1)){

				//lever things 

			}else if(isWall(hero.getPosX(),hero.getPosY()+1) || isDoor(hero.getPosX(),hero.getPosY()+1)){
				System.out.println("This Position is a Wall or a Close Door ");
			}else{
				matrix[hero.getPosY()][hero.getPosX()]=' ';

				this.hero.setPosition(hero.getPosX(), hero.getPosY()+1);
				insertHero(hero.getPosX(), hero.getPosY());

			}


		}else if(input.equals("w")){


			if(isLever(hero.getPosX(),hero.getPosY()-1)){

				//lever things 

			}else if(isWall(hero.getPosX(),hero.getPosY()-1) || isDoor(hero.getPosX(),hero.getPosY()-1)){
				System.out.println("This Position is a Wall or a Close Door ");
			}else{
				matrix[hero.getPosY()][hero.getPosX()]=' ';

				this.hero.setPosition(hero.getPosX(), hero.getPosY()-1);
				insertHero(hero.getPosX(), hero.getPosY());

			}

		}

	}


}




