package maze.cli;

import java.util.Scanner;

import maze.logic.*;

public class Main {




	public void Selected(){


	}




	public static void main(String[] args) {

		int  numMaze=1;
		int input;
		Maze maze=new Maze( numMaze);
		Game game;
		UserInteraction user =new UserInteraction();
		Scanner scan=new Scanner(System.in);
		boolean isDone=false;


		user.displayMenu();



		while(isDone==false){
			System.out.println("Select:");
			System.out.print(">");
			input=scan.nextInt();


			if(input==1){
				int modeGuard,numOg;

				System.out.println("Guard mode (1-Rockie)(2-Suspicius)(3-Drunk)");
				System.out.println("Select:");
				System.out.print(">");
				modeGuard=scan.nextInt();

				while(modeGuard!=1 && modeGuard!=2 && modeGuard!=3){
					System.out.println("Invalid Guard Mode");
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

				game.StardGame();user.displayMaze(maze);user.play(maze); isDone=true;
				break;


			}else if(input==2){

				System.out.println("Exit Game Bye Bye........."); isDone=true;System.exit(0);
			}else{

				System.out.println("Invalid Input::::::::::");
			}
			
			scan.close();





		}


	}
}