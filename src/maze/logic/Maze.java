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


	private Hero hero ;
	private Guard guard;
	private Ogre ogre;
	private Point exit1 =new Point(0, 5);
	private Point exit2 =new Point(0, 6);
	private Point exit1Map2=new Point(0, 1);
	private static int add=0;
	private static int numberMap=0;





	//Methods

	public Maze(int map){

		switch (map) {
		case 1:this.matrix=map1;break;
		case 2:this.matrix=map2;break;
		}



	}


	public Maze(char matrix[][]) {
		this.matrix=matrix;
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


	public char[][] getMatrix(){

		return this.matrix;
	}

	public Hero getHero(){

		return this.hero;
	}

	public Ogre getOgre(){

		return this.ogre;
	}

	public Guard getGuard(){

		return this.guard;
	}

	public void setGuard(){

		this.guard=null;
	}

	public void insertHero(int x, int y){
		hero =new Hero(x, y);

		this.matrix[hero.getPosY()][hero.getPosX()]=hero.getName();

	}

	public void insertGuard(int x, int y){
		guard =new Guard(x, y);
		this.matrix[guard.getPosY()][guard.getPosX()]=guard.getName();

	}


	public void insertOgre(int x, int y){
		ogre =new Ogre(x, y);
		this.matrix[ogre.getPosY()][ogre.getPosX()]=ogre.getName();

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


	public void openDoorMap1(){

		switch (numberMap) {
		case 0:
			this.matrix[exit1.y][exit1.x]='S';
			this.matrix[exit2.y][exit2.x]='S'; break;

		}




	}

	public void openDoorMap2(){

		this.matrix[exit1Map2.y][exit1Map2.x]='S';

	}

	public void cleanCell(int x,int y){
		matrix[y][x]=' ';

	}

	public void changeMap(){
		numberMap++;

		if(numberMap==1){
			this.matrix=map2;
			hero.setPosition(1, 1);
			this.matrix[hero.getPosX()][hero.getPosY()]=hero.getName();
			guard=null;

			insertOgre(4,1);
		}

	}


	public Boolean guardCaptureHero(Character character){

		if(character!=null){

			if (character.getPosX() == hero.getPosX()+1 && character.getPosY() == hero.getPosY()
					|| character.getPosX() == hero.getPosX()-1 && character.getPosY() == hero.getPosY()
					|| character.getPosY() == hero.getPosY()+1 && character.getPosX() == hero.getPosX()
					|| character.getPosY() == hero.getPosY()-1 && character.getPosX() == hero.getPosX()){

				return true ;



			}else return false;

		}else return false;


	}




	public void moveGuard(int i){

		add++;

		if(this.guard==null){

			return ;
		}

		if(add==24){
			add=0;
		}

		Point newPOint=new Point();
		newPOint=guard.getguardPositions()[i];
		this.matrix[guard.getPosY()][guard.getPosX()]=' ';
		guard.setPosition(newPOint.x, newPOint.y);
		this.matrix[guard.getPosY()][guard.getPosX()]=guard.getName();



	}





	public void moveHero(int x,int y) {

		cleanCell(hero.getPosX(), hero.getPosY());
		hero.moveCharacter(x,y);
		this.matrix[hero.getPosY()][hero.getPosX()]=hero.getName();

	}





	public Point randomMovesOgre(){



		int random=randomNumber(5);


		int newXposition=0;
		int newYposition=0;

		switch (random) {

		case 4: if(this.matrix[this.ogre.getPosY()][this.ogre.getPosX()+1]==' ' || this.matrix[this.ogre.getPosY()][this.ogre.getPosX()+1]=='k'){
			newXposition++;  //right
		}break;

		case 1:if(this.matrix[this.ogre.getPosY()][this.ogre.getPosX()-1]==' '  || this.matrix[this.ogre.getPosY()][this.ogre.getPosX()-1]=='k'){
			newXposition--; //left
		}break;

		case 3:
			if(this.matrix[this.ogre.getPosY()-1][this.ogre.getPosX()]==' ' || this.matrix[this.ogre.getPosY()-1][this.ogre.getPosX()]=='k'){
				newYposition--; //up
			}break;

		case 2:
			if(this.matrix[this.ogre.getPosY()+1][this.ogre.getPosX()]==' ' || this.matrix[this.ogre.getPosY()+1][this.ogre.getPosX()]=='k'){
				newYposition++;//down
			}break;

		}

		Point result=new Point(newXposition,newYposition);

		return result;


	}



	public void moveOgre(){

		Point result=new Point();

		result=randomMovesOgre();

		cleanCell(ogre.getPosX(), ogre.getPosY());
		ogre.moveCharacter(result.x,result.y);


		if(isLever(ogre.getPosX(), ogre.getPosY())){

			this.matrix[ogre.getPosY()][ogre.getPosX()]='$';

			ogre. setleverPogre(ogre.getPosX(), ogre.getPosY());}


		else if (ogre.getPosX()==ogre.getleverXogre()&& ogre.getPosY()==ogre.getleverYogre()){


			this.matrix[ogre.getPosY()][ogre.getPosX()]='$';


		}else if(hero.getName()=='K'){

			if(hero.getPosY()==ogre.getleverYogre() && hero.getPosX()==ogre.getleverXogre()){

				this.matrix[ogre.getleverYogre()][ogre.getleverXogre()]=hero.getName();

			}else{

				this.matrix[ogre.getleverYogre()][ogre.getleverXogre()]=' ';
			}


			this.matrix[ogre.getPosY()][ogre.getPosX()]=ogre.getName();

		}else{


			this.matrix[ogre.getleverYogre()][ogre.getleverXogre()]='k';

			this.matrix[ogre.getPosY()][ogre.getPosX()]=ogre.getName();

		}

	}




	public int playTime(String input){
		int result;


		result=playHero(input);

		if(numberMap==0){

			moveGuard(add);
			if(guardCaptureHero(guard)==true){ 
				hero.setIsDead();
				return 0;
			}

		}



		if(numberMap==1){

			moveOgre();
			if(guardCaptureHero(ogre)==true){ 
				hero.setIsDead();
				return 0;
			}

		}


		if(hero.getWin()==true){
			return 0;
		}





		return result;


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


		if(hero.getName()=='K' && isCloseDoor(hero.getPosX()+newXposition,hero.getPosY()+newYposition)){

			openDoorMap2();
			return 1;

		}


		if(hero.getName()=='K' && isOpenDoor(hero.getPosX()+newXposition,hero.getPosY()+newYposition)){

			hero.setWin();
		}



		if(isOpenDoor(hero.getPosX()+newXposition,hero.getPosY()+newYposition)){
			changeMap();
		}


		if (isWall(hero.getPosX()+newXposition,hero.getPosY()+newYposition) ||
				isCloseDoor(hero.getPosX()+newXposition,hero.getPosY()+newYposition)){

			return 1;

		}



		if(isLever(hero.getPosX()+newXposition,hero.getPosY()+newYposition)){
			//cleanCell(hero.getPosX(), hero.getPosY());


			if(numberMap==1){
				this.hero.setName('K');
			}

			openDoorMap1();
			moveHero(newXposition, newYposition);

			return 1;
		}




		moveHero(newXposition, newYposition);

		return 1;


	}


}




