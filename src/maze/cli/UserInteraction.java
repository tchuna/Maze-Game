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
	
	



	public void displayMaze(Game game ) {

		int matrixLength=game.getMaze().getMatrix().length;
		char matrix [][]=game.getMaze().getMatrix();

		System.out.print('\n');

		for(int i=0; i<matrixLength;i++){
			for(int j=0;j<matrixLength;j++ ){
				System.out.print(matrix[i][j]);
				System.out.print(' ');
			}
			System.out.print('\n');


		}
	}

	
	
	

	public void play(Game game){
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

				result=game.updateGame(input);
				displayMaze( game);

			}else {
				System.out.println("Invalid Direction ");
				
			}

		}

		scan.close();




		if(game.getMaze().getHero().getIsDead()==true){
			System.out.println("Game Over");
		}


		if(game.getMaze().getHero().getWin()==true){
			System.out.println("YOU  WIN ");

		}





	}

}