package maze.logic;

import java.awt.Point;
import java.util.Random;


public class Guard  extends Character{
	
	private int numTypeGuard;
	private int mode;
	private int sleepTurn;

	private   Point[] guardPositions = new Point[24];



	public Guard(int x,int y,int m){
		super(x, y, 'G');
		this.setMode(0);
		switch (m) {
		case 1:this.setName('G');break;
		case 2:this.setName('L');break;
		case 3:this.setName('R');break;
		}
		
		this.sleepTurn=0;
		insertPositionMoves();
		this.numTypeGuard=0;
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
	
	
	
	public static int randomNumber(int n)	//gera num aleatorio de 1 a n-1
	{
		int num = (int) (Math.random() * (n-1) +1);
		if(num<0)
		{
			num=num*(-1);
		}
		return num;
	}
	
	
	
	public void slepp(){
		 sleepTurn=randomNumber(5);
		
	}
	
	public void sleepGuard(){
		
		
	}
	
	public Point[] getguardPositions(){
		
		return this.guardPositions;
	}


	public int getNumTypeGuard() {
		return numTypeGuard;
	}


	public void setNumTypeGuard(int numTypeGuard) {
		this.numTypeGuard = numTypeGuard;
	}


	public int getMode() {
		return mode;
	}


	public void setMode(int mode) {
		this.mode = mode;
	}


	public int getSleepTurn() {
		return sleepTurn;
	}


	public void setSleepTurn(int sleepTurn) {
		this.sleepTurn = sleepTurn;
	}
}
