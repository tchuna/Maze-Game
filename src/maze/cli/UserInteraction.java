package maze.cli;
import java.util.Scanner;

import maze.logic.*;

public class UserInteraction {



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
		Boolean exit=true;
		//chunaaaa

		
		
		while(exit != false){
			System.out.print("Move Direction : ");
			input=scan.next();
			scan.nextLine();
			input=input.toLowerCase();

			if(input.equals("q")){
				System.out.println("BYE BYE ");
				return ;
			}else if(input.equals("w")||input.equals("s")||
					input.equals("a")||input.equals("d")){
				
				maze.playPlayer(input);
				
				displayMaze( maze );

			}

		}
		


	}

}
