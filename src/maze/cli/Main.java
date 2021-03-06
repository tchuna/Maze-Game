package maze.cli;

import java.util.Scanner;

import maze.logic.*;
import maze.logic.Character;

/**
 * Class for Main
 * 
 * */
public class Main {


	public static void main(String[] args) {

		int  numMaze=1;
		String input;
		Maze maze=new Maze( numMaze);
		Game game;  
		UserInteraction user =new UserInteraction();
		Scanner scan=new Scanner(System.in);
		boolean isDone=false; 
		



		while(isDone==false){
 
			user.displayMenu();
			
			System.out.println("Select:"); 
			System.out.print(">");
			input=scan.next();
			input=input.toLowerCase();


			if(input.equals("p")){
				int modeGuard,numOg;

				System.out.println("Guard mode (1-Rockie)(2-Suspicius)(3-Drunk)");
				System.out.println("Select:");
				System.out.print(">");
				modeGuard=scan.nextInt();

				while(modeGuard!=1 && modeGuard!=2 && modeGuard!=3){
					System.out.println("Invalid Guard Mode \n");
					System.out.println("Guard mode (1-Rockie)(2-Suspicius)(3-Drunk)");
					System.out.println("Select:");
					System.out.print(">");
					modeGuard=scan.nextInt();
				}

				System.out.println("Number Ogres min:1  max:5");
				System.out.println("Select:");
				System.out.print(">");
				numOg=scan.nextInt();

				while(numOg<1 || numOg>5){
					System.out.println("Number Ogres min:1  max:5");
					System.out.println("Select:");
					System.out.print(">");
					numOg=scan.nextInt();


				}

				System.out.println("\n\n");
				System.out.println("Hero Direction (UP-w) (DOWN-s) (RIGHT-d) (LEFT-a) (EXIT-q)");


				game=new Game(maze, modeGuard, numOg);

				game.StardGame();game.getMaze().displayMaze(maze);;user.play(game); isDone=true;
				break;


			}else if(input.equals("e")){

				System.out.println("Exit Game Bye Bye........."); isDone=true;System.exit(0);
			}else{

				System.out.println("Invalid Input::::::::::");
			}


		}
		
		scan.close();


	}
}
