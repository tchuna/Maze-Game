package maze.logic;

import java.awt.Point;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Guard  extends Character{

	private   Point[] guardPositions = new Point[24];



	public Guard(int x,int y){
		super(x, y, 'G');

		/*for(int i=0;i<this.guardPositions.length;i++){
			guardPositions[i]=new Point(7,4);

		}*/	
		insertPositionMoves();
	}
	
	
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
	
	public Point[] getguardPositions(){
		
		return this.guardPositions;
	}
}
