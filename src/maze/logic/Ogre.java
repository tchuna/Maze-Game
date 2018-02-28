package maze.logic;

public class Ogre extends Character{

	private int oldX;
	private int oldY;

	Ogre(int x, int y) {
		super(x, y, 'O');
		// TODO Auto-generated constructor stub
		this.oldX=0;
		this.oldY=0;
	}



	public int getleverXogre(){

		return this.oldX;

	}

	public int getleverYogre(){

		return this.oldY;

	}


	public void setleverPogre(int x, int y){
		this.oldX=x;
		this.oldY=y;

	}


}
