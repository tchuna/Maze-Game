package maze.cli;

import maze.logic.*;

public class Main {

	public static void main(String[] args) {

		int numMaze=1;
		Maze maze=new Maze(numMaze);
		
		
		if(numMaze==1){
			maze.insertGuard(8, 1);
			maze.insertHero(1, 1);
			
		}else if(numMaze==2){
			maze.insertHero(1, 1);
			maze.setGuard();
			maze.insertOgre(4,1);
			
		}
		


		UserInteraction user =new UserInteraction();




		user.displayMaze(maze);
		user.play(maze);

		//maze.printexit();
		//System.out.println(maze.getHero().getPosX());
		//System.out.println(maze.getHero().getPosY());


	}

}
