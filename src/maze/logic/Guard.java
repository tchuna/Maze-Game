package maze.logic;

import java.awt.Point;
import java.io.Serializable;



/**
 * Class for Guard Character in Game 
 * @see Character
 * 
 * */
public class Guard  extends Character implements Serializable{


	private static final long serialVersionUID = 1L;
	private static final int ROCKIE=1; 
	private static final int SUSPICIOS=2;
	private static final int DRUNK=3;



	private  int  add_move=23;
	private int mode; 
	private int sleepTurn=0;

	private   Point[] guardPositions = new Point[24];



	/**
	 * Creates a Guard
	 * @param x	Coordinate x of its initial position
	 * @param y	Coordinate y of its initial position
	 * @param mode  the guard personality
	 * */
	public Guard(int x,int y,int m){
		super(x, y, ' ');
		this.mode=m;
		switch (m) {
		case ROCKIE: this.setName('r');break;
		case SUSPICIOS: this.setName('G');break;
		case DRUNK: this.setName('d');break;
		}


		insertPositionMoves();

	}




	/**
	 * insert the positions for guard moves 
	 *
	 * */
	public void insertPositionMoves(){
		this.guardPositions[0]=new Point(7,1);
		this.guardPositions[1]=new Point(7,2);
		this.guardPositions[2]=new Point(7,3);
		this.guardPositions[3]=new Point(7,4);
		this.guardPositions[4]=new Point(7,5);
		this.guardPositions[5]=new Point(6,5);
		this.guardPositions[6]=new Point(5,5);
		this.guardPositions[7]=new Point(4,5);
		this.guardPositions[8]=new Point(3,5);
		this.guardPositions[9]=new Point(2,5);
		this.guardPositions[10]=new Point(1,5);
		this.guardPositions[11]=new Point(1,6);
		this.guardPositions[12]=new Point(2,6);
		this.guardPositions[13]=new Point(3,6);
		this.guardPositions[14]=new Point(4,6);
		this.guardPositions[15]=new Point(5,6);
		this.guardPositions[16]=new Point(6,6);
		this.guardPositions[17]=new Point(7,6);
		this.guardPositions[18]=new Point(8,6);
		this.guardPositions[19]=new Point(8,5);
		this.guardPositions[20]=new Point(8,4);
		this.guardPositions[21]=new Point(8,3);
		this.guardPositions[22]=new Point(8,2);
		this.guardPositions[23]=new Point(8,1);

	} 




	/**
	 * Make guard sleep  turns
	 * 
	 *
	 * */
	public void slepp(){
		this.sleepTurn=3;

	}




	public int getAddmove(){

		return this.add_move;
	}



	/**
	 * Get guard  default positions
	 * 
	 * @return guardPositions
	 */
	public Point[] getguardPositions(){

		return this.guardPositions;
	}



	/**
	 * Get guard personality
	 * 
	 * @return mode
	 */
	public int getMode() {
		return mode;
	}



	/**
	 * Set guard  personality
	 * @param mode mode personality 
	 * 
	 * */
	public void setMode(int mode) {
		switch (mode) {
		case 1:this.setName('r');break;
		case 2:this.setName('G');break;
		case 3:this.setName('d');break;
		default:
			break;
		}
		this.mode = mode;
	}


	/**
	 * Get the number turn the guard need to sleep
	 * 
	 * @return sleepTurn
	 */
	public int getSleepTurn() {
		return sleepTurn;
	}


	/**
	 * Set  guard  sleep turn
	 * 
	 * @param sleep new sleepTurn
	 * */
	public void setSleepTurn(int sleep) {
		this.sleepTurn = sleep;
	}



	/**
	 * generate a random number between 1-n
	 * 
	 * @param n 
	 * @return num  the random number generate 
	 */
	public int randomNumber(int n){	
		int num = (int) (Math.random() * (n-1) +1);

		return num;
	}





	/**
	 * Move guard in decrement position
	 * @param i position move
	 * @param maze the current maze game 
	 * */
	public void moveGuard_less(int i ,Maze maze){

		add_move--;



		if(add_move<0){
			add_move=23;
		}



		Point newPOint=new Point();
		newPOint=this.getguardPositions()[i];
		maze.inser(this.getPosX(),this.getPosY(),' ');
		this.setPosition(newPOint.x, newPOint.y);
		maze.inser(this.getPosX(),this.getPosY(),this.getName());



	}




	/**
	 * Move guard in increment position
	 * @param i position move
	 * @param maze the current maze 
	 * */
	public void moveGuard_plus(int i,Maze maze){

		add_move++;

		if(add_move>23){
			add_move=0;
		}

		Point newPOint=new Point();
		newPOint=this.getguardPositions()[i];
		maze.inser(this.getPosX(),this.getPosY(),' ');
		this.setPosition(newPOint.x, newPOint.y);
		maze.inser(this.getPosX(),this.getPosY(),this.getName());

	}



	/**
	 * Moves the guardian  whit roockie personality to its next position
	 * @param maze current maze game 
	 * 
	 **/
	public void  turnGuardRoockieMode(Maze maze){


		moveGuard_plus(add_move,maze); 
		if(guardCaptureHero(maze.getHero())==true){ 
			maze.getHero().setIsDead();
		}


	}

	

	/**
	 * Moves the guardian  whit suspicious personality to its next position
	 * @param maze current maze game 
	 * @param rand the random decision 
	 **/
	public void turnGuardSuspiciousMode(Maze maze, int rand){



		if(rand==3 || rand==1){

			moveGuard_less(add_move,maze);
			if(guardCaptureHero(maze.getHero())==true){ 
				maze.getHero().setIsDead();
			}

		}else{


			moveGuard_plus(add_move,maze);
			if(guardCaptureHero(maze.getHero())==true){ 
				maze.getHero().setIsDead();

			}

		}


	}





	
	/**
	 * Moves the guardian  whit drunk personality to its next position
	 * @param maze current maze game 
	 * @param rd the random decision 
	 **/
	public void turnGuardDrunkMode(Maze maze,int rd){

		int rand=randomNumber(6);



		if(this.getSleepTurn()<=0){

			int r=randomNumber(4);
			if(r==1){
				this.setName('g');
				maze.inser(this.getPosX(),this.getPosY(),this.getName());
				this.slepp();

			}

		}



		if(this.getSleepTurn()>0){

			this.setSleepTurn(this.getSleepTurn()-1);

		}else if (this.getSleepTurn()==0){

			this.setName('d');
			if(rand==1){

				moveGuard_less(add_move, maze);
			}else{
				moveGuard_plus(add_move,maze);

			}
		}


		if(guardCaptureHero(maze.getHero())==true){ 
			maze.getHero().setIsDead();
		}

	}






	/**
	 *  Verify is the hero was capture 
	 * @param hero to verify
	 * 
	 * @return result the verification  
	 */
	public Boolean guardCaptureHero(Character hero){

		if(this.nameCh=='g'){
			return false;
		}

		if (this.getPosX() == hero.getPosX()+1 && this.getPosY() == hero.getPosY()
				|| this.getPosX() == hero.getPosX()-1 && this.getPosY() == hero.getPosY()
				|| this.getPosY() == hero.getPosY()+1 && this.getPosX() == hero.getPosX()
				|| this.getPosY() == hero.getPosY()-1 && this.getPosX() == hero.getPosX()
				|| this.getPosX() == hero.getPosX() && this.getPosY() == hero.getPosY()){

			return true ;
		}

		return false;
	}






}