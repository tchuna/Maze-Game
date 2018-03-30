package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import maze.logic.Game;
import maze.logic.Maze;

public class GameLogicTest {
	
	/*maze teste map1 
	 * 
	 *  {'X','X','X','X','X','X','X','X','X','X'},
		{'X',' ',' ',' ','I',' ','X',' ',' ','X'},
		{'X','X','X',' ','X','X','X',' ',' ','X'},
		{'X',' ','I',' ','I',' ','X',' ',' ','X'},
		{'X','X','X',' ','X','X','X',' ',' ','X'},
		{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X','X','X',' ','X','X','X','X',' ','X'},
		{'X',' ','I',' ','I',' ','X','k',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X'},
		
	 * */
	
	
	/*maze teste map2
	 * 
	 *  {'X','X','X','X','X','X','X','X','X','X'},
		{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X','C',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ','k',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X'},
		
	 * */
	

	@Test
	public void testMveHeroFreeCell() {
		int level=1;
		
		
		
		Maze maze=new Maze(level);
		Game game = new Game(maze,1,1);
		game.updateGame("d");
		
		Point point=new Point(game.getMaze().getHero().getPosX(),game.getMaze().getHero().getPosY());
		
		assertEquals(new Point(2,1),point );
		
	}
	
	@Test
	public void testMoveHerowall() {
		int level=1;
		Maze maze=new Maze(level);
		Game game = new Game(maze,1,1);
		game.updateGame("w");
		
		Point point=new Point(game.getMaze().getHero().getPosX(),game.getMaze().getHero().getPosY());
		
		assertEquals(new Point(1,1),point );
		
	}
	
	
	@Test
	public void testMoveHercloseDoor() {
		int level=1;
		Maze maze=new Maze(level);
		Game game = new Game(maze,1,1);
		game.updateGame("d");
		game.updateGame("d");
		game.updateGame("d");
		
		Point point=new Point(game.getMaze().getHero().getPosX(),game.getMaze().getHero().getPosY());
		
		assertEquals(new Point(3,1),point );
		
	}
	
	@Test
	public void testGuardcapturHero() {
		int level=1;
		Maze maze=new Maze(level);
		Game game = new Game(maze,1,1);
		game.updateGame("d");game.updateGame("d");
		game.updateGame("s");game.updateGame("s");game.updateGame("s");
		game.updateGame("d");game.updateGame("d");game.updateGame("d");game.updateGame("d");game.updateGame("d");

		assertTrue(game.getMaze().getHero().getIsDead());
		
		
	}
	
	
	@Test
	public void testHeroinLever() {
		int level=1;
		Maze maze=new Maze(level);
		Game game = new Game(maze,1,1);
		
		game.getMaze().getHero().setPosition(8, 8);game.updateGame("a");
		assertTrue(game.getMaze().getHero().getTakeLever());
		
		
	}
	
	@Test
	public void testHeroOpenDoor() { 
		int level=1;
		Maze maze=new Maze(level);
		Game game = new Game(maze,1,1);
		
		game.getMaze().getHero().setPosition(8, 8);game.updateGame("a");
		game.getMaze().getHero().setPosition(1, 6);game.updateGame("a");
		
		assertEquals(2, game.getMaze().numMap());
		
		
	}
	
	
	@Test
	public void testHerocloseDoor() { 
		int level=1;
		Maze maze=new Maze(level);
		Game game = new Game(maze,1,1);
		game.getMaze().getHero().setPosition(1, 6);game.updateGame("a");
		
		assertEquals(1, game.getMaze().numMap());
		
		
	}
	
	
	@Test
	public void testHeroArmed() { 
		int level=1;
		Maze maze=new Maze(level);
		Game game = new Game(maze,1,1);
		
		game.getMaze().inser(2, 1, 'C');
		game.updateGame("d");
		
		assertTrue(game.getMaze().getHero().getIsArmed());
		
		
	}
	
	
	
	
	
	@Test
	public void testRockieGmode() { 
		int level=1;
		int  rockiemode=1; 
		Maze maze=new Maze(level);
		Game game = new Game(maze,rockiemode,4);
		
		assertEquals('r', game.getMaze().getGuard().getName());
		
		
	}
	

	
	@Test
	public void testSuspGmode() { 
		int level=1;
		int  suspicmode=2;
		Maze maze=new Maze(level);
		Game game = new Game(maze,suspicmode,4);
		
		assertEquals('G', game.getMaze().getGuard().getName());
		
		
	}
	

	@Test
	public void testDrunkGmode() { 
		int level=1;
		int  drunkmode=3;
		Maze maze=new Maze(level);
		Game game = new Game(maze,drunkmode,4);
		
		assertEquals('d', game.getMaze().getGuard().getName());
		
		
	}
	
	
	
	
	
	@Test
	public void testHerotakeKey() { 
		int level=2;
		Maze maze=new Maze(level);
		Game game = new Game(maze);
		
		game.getMaze().inser(7, 2, 'k');
		game.updateGame("a");
		
		
		assertTrue(game.getMaze().getHero().getTakeLever());
		
		
	}
	
	
	
	/*@Test
	public void test() { 
		int level=2;
		Maze maze=new Maze(level);
		Game game = new Game(maze);
		
		game.getMaze().inser(7, 2, 'k');
		game.updateGame("a");
		
		
		assertTrue(game.getMaze().getHero().getTakeLever());
		
		
	}*/
	
	
	
	
	
	
	
	
	
	
	

}
