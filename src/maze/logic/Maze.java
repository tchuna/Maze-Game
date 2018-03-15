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


	private Hero hero ;
	private Guard guard;
	private Ogre ogre;
	private Point exit1 =new Point(0, 5);
	private Point exit2 =new Point(0, 6);
	private Point exit1Map2=new Point(0, 1);

	private static int add_less=23;
	private static int add_plus=24;
	private int numberMap;





	//Methods

	public Maze(int map){

		switch (map) {
		case 1:matrix=map1;break;
		case 2:matrix=map2;break;
		}

		this.numberMap=map;



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

	public void insertGuard(int x, int y,int mode){
		guard =new Guard(x, y,mode);
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


	public Boolean isClub(int x , int y){

		if (this.matrix[y][x]=='*'){
			return true ;

		}else {
			return false ;
		}


	}



	public void cleannclub(){
		for(int i=0;i<matrix.length; i++){
			for(int j=0; j<matrix.length; j++){
				if(matrix[i][j]=='*')
					matrix[i][j]=' ';
			}
		}
	}







	public void openDoorMap1(){

		switch (numberMap) {
		case 1:
			matrix[exit1.y][exit1.x]='S';
			matrix[exit2.y][exit2.x]='S'; break;

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

		if(numberMap==2){
			this.matrix=map2;
			hero.setPosition(1, 1);
			this.matrix[hero.getPosX()][hero.getPosY()]=hero.getName();
			guard=null;

			insertOgre(4,1);
		}

	}




	public void ogreAttack(){

		this.ogre.armedOgre();

		this.matrix[this.ogre.getOgreWeapon().getYWeapon()][this.ogre.getOgreWeapon().getXWeapon()]=this.ogre.getOgreWeapon().getNameWeapon();

	}



	public Boolean ogreKillHero(Character ogre){

		if(ogre!=null){

			if (ogre.getPosX() == hero.getPosX()+1 && ogre.getPosY() == hero.getPosY()
					|| ogre.getPosX() == hero.getPosX()-1 && ogre.getPosY() == hero.getPosY()
					|| ogre.getPosY() == hero.getPosY()+1 && ogre.getPosX() == hero.getPosX()
					|| ogre.getPosY() == hero.getPosY()-1 && ogre.getPosX() == hero.getPosX()){

				return true ;



			}else if(this.ogre.getOgreWeapon().getXWeapon()== hero.getPosX()+1 && this.ogre.getOgreWeapon().getYWeapon()== hero.getPosY()
					|| this.ogre.getOgreWeapon().getXWeapon()== hero.getPosX()-1 && this.ogre.getOgreWeapon().getYWeapon()== hero.getPosY()
					|| this.ogre.getOgreWeapon().getXWeapon()== hero.getPosX()  && this.ogre.getOgreWeapon().getYWeapon()== hero.getPosY()+1
					|| this.ogre.getOgreWeapon().getXWeapon()== hero.getPosX() && this.ogre.getOgreWeapon().getYWeapon()== hero.getPosY()-1){


				return true;


			}else return false;

		}else return false;


	}

	
	

	public Boolean guardCaptureHero(Character character){

		if(character!=null){
			if(guard.getName()=='G'){
				if (character.getPosX() == hero.getPosX()+1 && character.getPosY() == hero.getPosY()
						|| character.getPosX() == hero.getPosX()-1 && character.getPosY() == hero.getPosY()
						|| character.getPosY() == hero.getPosY()+1 && character.getPosX() == hero.getPosX()
						|| character.getPosY() == hero.getPosY()-1 && character.getPosX() == hero.getPosX()
						|| character.getPosX() == hero.getPosX() && character.getPosY() == hero.getPosY()){

					return true ;



				}else return false;


			}else if( character.getPosX() == hero.getPosX() && character.getPosY() == hero.getPosY()){
				return true;
				
			}else{
				
				return false;
			}


		}else return false;

	}



	

	public void moveGuard_less(int i){

		add_less--;

		if(this.guard==null){

			return ;
		}

		if(add_less<0){
			add_less=23;
		}

		Point newPOint=new Point();
		newPOint=guard.getguardPositions()[i];
		this.matrix[guard.getPosY()][guard.getPosX()]=' ';
		guard.setPosition(newPOint.x, newPOint.y);
		this.matrix[guard.getPosY()][guard.getPosX()]=guard.getName();






	}





	public void moveGuard_plus(int i){

		add_less++;

		if(this.guard==null){

			return ;
		}

		if(add_less>23){
			add_less=0;
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


	public void moveOgre(int x,int y){

		cleanCell(ogre.getPosX(), ogre.getPosY());
		ogre.moveCharacter(x,y);
		this.matrix[ogre.getPosY()][ogre.getPosX()]=ogre.getName();

	}





	public void playRandomMovesOgre(){ 


		int random=randomNumber(3);
		Point leverPosition=new Point(4,4);

		int newXposition=0;
		int newYposition=0;



		switch (random) {
		case 4:newXposition++;
		break;
		case 3:newXposition--;
		break;
		case 2:newYposition--;
		break;
		case 1:newYposition++;
		break;}




		if (isWall(ogre.getPosX()+newXposition,ogre.getPosY()+newYposition) || // verifica se a nova posicao do ogre e parede ou porta fecahdo 
				isCloseDoor(ogre.getPosX()+newXposition,ogre.getPosY()+newYposition)){

			return;

		}



		if( leverPosition.x==ogre.getPosX()+newXposition && leverPosition.y==ogre.getPosY()+newYposition ){

			ogre.setName('$');
			moveOgre(newXposition,newYposition);
			return;
		}




		if(ogre.getName()=='$' && (ogre.getPosY()+newYposition!=leverPosition.y ||ogre.getPosX()+newXposition!=leverPosition.x)){ // verefica se o ogre ja nao encontra na alavanca 
			ogre.setName('O');
			moveOgre(newXposition,newYposition);
			matrix[leverPosition.y][leverPosition.x]='k';
			return;

		}





		moveOgre(newXposition,newYposition);


		/*if(isLever(ogre.getPosX()+newXposition,ogre.getPosY()+newYposition)){ // verifica se a nova posicao do ogre e a alavanca ou num club do ogre
		//	|| isClub(ogre.getPosX()+newXposition,ogre.getPosY()+newYposition)
			ogre.setName('$');
			moveOgre(newXposition,newYposition);
			return;
		}*/




	}







	public void attackOgre(){

		Point leverPosition=new Point(4,4);

		cleannclub();
		ogre.armedOgre();

		if((leverPosition.x!=ogre.getPosX() && leverPosition.x!=ogre.getOgreWeapon().getXWeapon())||
				(leverPosition.y!=ogre.getOgreWeapon().getYWeapon() && leverPosition.y !=ogre.getPosY())){
			

			matrix[leverPosition.y][leverPosition.x]='k';

		}


		if(leverPosition.x!=ogre.getOgreWeapon().getXWeapon() && leverPosition.y!=ogre.getOgreWeapon().getYWeapon()
				&& leverPosition.x!=ogre.getPosX() && leverPosition.y!=ogre.getPosY() ){


			matrix[ogre.getOgreWeapon().getYWeapon()][ogre.getOgreWeapon().getXWeapon()]=ogre.getOgreWeapon().getNameWeapon();
			matrix[leverPosition.y][leverPosition.x]='k';
			return;

		}

		if(isWall(ogre.getOgreWeapon().getXWeapon(),ogre.getOgreWeapon().getYWeapon())
				|| isCloseDoor(ogre.getOgreWeapon().getXWeapon(),ogre.getOgreWeapon().getYWeapon())){
			return;
		}


		if(leverPosition.x==ogre.getOgreWeapon().getXWeapon() && leverPosition.y==ogre.getOgreWeapon().getYWeapon() &&ogre.getOgreWeapon().getNameWeapon()=='*'){

			ogre.getOgreWeapon().setNameWeapon('$');

			matrix[ogre.getOgreWeapon().getYWeapon()][ogre.getOgreWeapon().getXWeapon()]=ogre.getOgreWeapon().getNameWeapon();
			return;
		}






		matrix[ogre.getOgreWeapon().getYWeapon()][ogre.getOgreWeapon().getXWeapon()]=ogre.getOgreWeapon().getNameWeapon();




	}




	public void  turnGuardRoockieMode(){

		if(numberMap==1){

			moveGuard_plus(add_less);
			if(guardCaptureHero(guard)==true){ 
				hero.setIsDead();
			}
		}




	}




	public void turnGuardDrunkMode(){

		int rand=randomNumber(6);




		if(numberMap==1){

			if(guard.getSleepTurn()<=0){




				if(randomNumber(4)==1){
					guard.setName('g');
					this.matrix[guard.getPosY()][guard.getPosX()]=guard.getName();
					guard.slepp();

				}

			}



			if(guard.getSleepTurn()>0){

				guard.setSleepTurn(guard.getSleepTurn()-1);

			}else if (guard.getSleepTurn()==0){

				guard.setName('G');
				if(rand==1){

					moveGuard_less(add_less);
				}else{
					moveGuard_plus(add_less);

				}



			}




			if(guardCaptureHero(guard)==true){ 
				hero.setIsDead();
			}



		}
	}




	public void turnGuardSuspiciousMode(){


		int rand=randomNumber(3);

		if(rand==1){
			if(numberMap==1){

				moveGuard_less(add_less);
				if(guardCaptureHero(guard)==true){ 
					hero.setIsDead();
				}
			}

		}else{
			if(numberMap==1){

				moveGuard_plus(add_less);
				if(guardCaptureHero(guard)==true){ 
					hero.setIsDead();
				}
			}

		}


	}



	public void Level_1(){

		switch (guard.getMode()) {
		case 1:turnGuardRoockieMode(); break;
		case 2:turnGuardDrunkMode(); break;
		}


	}



	public void Level_2(){


		playRandomMovesOgre();
		attackOgre();

		if(ogreKillHero(ogre)==true){ 
			hero.setIsDead();
		}


	}







	public int playTime(String input){
		int result;

		result=playHero(input);

		switch (numberMap) {
		case 1:Level_1();break;
		case 2:Level_2();break;
		}


		if(hero.getWin()==true || hero.getIsDead()==true){
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


			if(numberMap==2){
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



