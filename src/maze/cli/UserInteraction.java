package maze.cli;
import java.util.Scanner;

import maze.logic.*;

public class UserInteraction {
	
	
	
	
	public void displayMenu(){
		

		System.out.print('\n');
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+          Welcome to the Maze Game          +");
		System.out.println("+                 P---Play                   +");
		System.out.println("+                 E---Exit                   +");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		
		
	}
	
	



	public void displayMaze(Maze maze ) {

		int matrixLength=maze.getMatrix().length;
		char matrix [][]=maze.getMatrix();

		System.out.print('\n');

		for(int i=0; i<matrixLength;i++){
			for(int j=0;j<matrixLength;j++ ){
				System.out.print(matrix[i][j]);
				System.out.print(' ');
			}
			System.out.print('\n');


		}
	}

	
	
	

	public void play(Maze maze){
		String input;
		Scanner scan=new Scanner(System.in);	
		
		
		int result=1;

		while(result!= 0){
			System.out.print("Move Direction : ");
			input=scan.next();
			scan.nextLine();
			input=input.toLowerCase();

			if(input.equals("q")){
				System.out.println("BYE BYE ");
				System.exit(0);
				return ;
			}else if(input.equals("w")||input.equals("s")||
					input.equals("a")||input.equals("d")){

				result=maze.updateTime(input);
				displayMaze( maze );

			}else {
				System.out.println("Invalid Direction ");
				
			}

		}

		scan.close();




		if(maze.getHero().getIsDead()==true){
			System.out.println("Game Over");
		}


		if(maze.getHero().getWin()==true){
			System.out.println("YOU  WIN ");

		}





	}

}