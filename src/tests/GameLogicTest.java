package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import maze.logic.Game;
import maze.logic.Guard;
import maze.logic.Hero;
import maze.logic.Maze;
import maze.logic.Ogre;

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
		Game game = new Game(maze,2,1);
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
	public void testDrunkGuaro() {
		int level=1;
		Maze maze=new Maze(level);
		Game game = new Game(maze,3,1);
		game.updateGame("d");game.updateGame("d");
		game.updateGame("s");game.updateGame("s");game.updateGame("s");
		game.updateGame("d");game.updateGame("d");game.updateGame("d");game.updateGame("d");game.updateGame("d");




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
	public void testGuardmode() { 
		int level=1;

		int  rockiemode=1; 
		Maze maze=new Maze(level);
		Game game = new Game(maze,rockiemode,4);

		assertEquals('r', game.getMaze().getGuard().getName());

		int  suspicios=2; 
		Maze maze2=new Maze(level);
		Game game2= new Game(maze2,suspicios,4);

		assertEquals('G', game2.getMaze().getGuard().getName());

		int  drunk=3; 
		Maze maze3=new Maze(level);
		Game game3= new Game(maze3,drunk,4);

		assertEquals('d', game3.getMaze().getGuard().getName());

		maze3.getGuard().setMode(rockiemode);

		assertEquals('r', game3.getMaze().getGuard().getName());

		maze3.getGuard().setMode(suspicios);

		assertEquals('G', game3.getMaze().getGuard().getName());

		maze3.getGuard().setMode(drunk);

		assertEquals('d', game3.getMaze().getGuard().getName());

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




	@Test
	public void testNameWeaponOgre() { 
		int level=2;
		Maze maze=new Maze(level);
		Game game = new Game(maze);

		game.updateGame("a");

		assertEquals('*', game.getMaze().geTogres().get(0).getOgreWeapon().getNameWeapon());



	}



	@Test
	public void testOgrePosition() { 
		int level=2;
		Maze maze=new Maze(level);
		Game game = new Game(maze);

		game.updateGame("a");

		game.getMaze().geTogres().get(0).setPosition(2,4);
		game.getMaze().geTogres().get(0).getOgreWeapon().setWeapon(2,5);

		Point point2=new Point(game.getMaze().geTogres().get(0).getOgreWeapon().getXWeapon(),game.getMaze().geTogres().get(0).getOgreWeapon().getYWeapon());
		Point point=new Point(game.getMaze().geTogres().get(0).getPosX(),game.getMaze().geTogres().get(0).getPosY());

		assertEquals(new Point(2,4),point);
		assertEquals(new Point(2,5),point2);



	}




	@Test
	public void testDrunkGurardMove() { 

		int level=1;
		int drunkMode=3;
		Maze maze=new Maze(level);
		Game game = new Game(maze,drunkMode,1);


		int rand=game.getMaze().getGuard().randomNumber(6);
		game.getMaze().getGuard().turnGuardDrunkMode(maze,rand);

		if(game.getMaze().getGuard().getSleepTurn()>0){
			assertEquals(2,game.getMaze().getGuard().getSleepTurn());
		}


	}



	@Test
	public void testGuardCaptureHero() { 

		int Mode=1;
		Hero hero =new Hero(2, 5);
		Guard guard =new Guard(3, 5,Mode);


		assertTrue(guard.guardCaptureHero(hero));

		hero.setPosition(4, 5);
		assertTrue(guard.guardCaptureHero(hero));

		hero.setPosition(3, 6);
		assertTrue(guard.guardCaptureHero(hero));

		hero.setPosition(3, 4);
		assertTrue(guard.guardCaptureHero(hero));

		hero.setPosition(3, 5);
		assertTrue(guard.guardCaptureHero(hero));




	}



	@Test
	public void testGuarRandomNum() { 
		Guard guard=new Guard(1, 1, 3);

		int result=guard.randomNumber(5);

		if(result>0 || result>5){
			assertFalse(false);

		}

	}







	@Test
	public void testOgreWake() { 
		Ogre ogre=new Ogre(1,1);

		ogre.wakeOgre();

		assertFalse(ogre.getSleep());

		ogre.setSleep(true);
		ogre.setStopsleep(0);
		ogre.wakeOgre();
		System.out.println(ogre.getStopTurn());
		assertEquals(2, ogre.getStopTurn());

		ogre.setStopsleep(5);
		ogre.setSleep(true);
		ogre.wakeOgre();

		assertEquals(4, ogre.getStopTurn());




	}



	@Test
	public void testOgreKillHero() { 
		int level=2;
		Maze maze=new Maze(level);
		Game game = new Game(maze);

		game.updateGame("a");



		game.getMaze().geTogres().get(0).setPosition(2,4);
		game.getMaze().getHero().setPosition(2,4);

		System.out.println(game.getMaze().getHero().getIsArmed());
		assertTrue(game.getMaze().geTogres().get(0).ogreKillHero(game.getMaze()));

		game.getMaze().getHero().setPosition(1,4);
		assertTrue(game.getMaze().geTogres().get(0).ogreKillHero(game.getMaze()));

		game.getMaze().getHero().setPosition(3,4);
		assertTrue(game.getMaze().geTogres().get(0).ogreKillHero(game.getMaze()));

		game.getMaze().getHero().setPosition(2,5);
		assertTrue(game.getMaze().geTogres().get(0).ogreKillHero(game.getMaze()));

		game.getMaze().getHero().setPosition(2,3);
		assertTrue(game.getMaze().geTogres().get(0).ogreKillHero(game.getMaze()));


		game.updateGame("a");

		game.getMaze().getHero().setIsArmed(true);
		game.getMaze().geTogres().get(0).setPosition(2,4);
		game.getMaze().getHero().setPosition(2,4);


		assertTrue(game.getMaze().geTogres().get(0).ogreKillHero(game.getMaze()));

		game.getMaze().getHero().setPosition(1,4);
		assertFalse(game.getMaze().geTogres().get(0).ogreKillHero(game.getMaze()));

		game.getMaze().getHero().setPosition(3,4);
		assertFalse(game.getMaze().geTogres().get(0).ogreKillHero(game.getMaze()));

		game.getMaze().getHero().setPosition(2,5);
		assertFalse(game.getMaze().geTogres().get(0).ogreKillHero(game.getMaze()));

		game.getMaze().getHero().setPosition(2,3);
		assertFalse(game.getMaze().geTogres().get(0).ogreKillHero(game.getMaze()));


	}


	@Test
	public void testOgreArmed() { 

		Ogre ogre =new Ogre(1,1);

		ogre.armedOgre(3);
		assertEquals('*',ogre.getOgreWeapon().getNameWeapon());

	}



	@Test
	public void testEqualOgres(){

		Ogre ogre1 =new Ogre(1,1);
		Ogre ogre2 =new Ogre(1,1);

		assertTrue(ogre1.equals(ogre2)); 

		ogre1.setPosition(3, 4);

		assertFalse(ogre1.equals(ogre2)); 



	}
	
	@Test
	public void tesWakeOgre(){

		Ogre ogre1 =new Ogre(1,1);
		ogre1.setSleep(true);
		ogre1.setName('$');
		ogre1.setStopsleep(3);
		ogre1.wakeOgre();
		assertEquals('$', ogre1.getName());
		
		ogre1.setStopsleep(-1);
		ogre1.wakeOgre();
		assertEquals('O', ogre1.getName());
		

	}
	
	
	
	
	

	@Test
	public void testRandomArmedOgre(){

		Ogre ogre =new Ogre(3,3);

		ogre.armedOgre(1);
		assertEquals(2,ogre.getOgreWeapon().getYWeapon());

		ogre.armedOgre(2);
		assertEquals(4,ogre.getOgreWeapon().getYWeapon());

		ogre.armedOgre(3);
		assertEquals(2,ogre.getOgreWeapon().getXWeapon());

		ogre.armedOgre(4);
		assertEquals(4,ogre.getOgreWeapon().getXWeapon());

	}



	@Test
	public void testRandomMoveOgre(){

		int level=2;
		Ogre ogre =new Ogre(4,4);
		Maze maze=new Maze(level); 

		ogre.setSleep(true);

		assertEquals(4,ogre.getPosY());
		assertEquals(4,ogre.getPosX());


		ogre.setSleep(false);

		ogre.playRandomMovesOgre(maze,1);
		assertEquals(3,ogre.getPosY());
		assertEquals(4,ogre.getPosX());

		ogre.setPosition(4, 4);
		ogre.playRandomMovesOgre(maze,2);
		assertEquals(5,ogre.getPosY());
		assertEquals(4,ogre.getPosX());

		ogre.setPosition(4, 4);
		ogre.playRandomMovesOgre(maze,3);
		assertEquals(4,ogre.getPosY());
		assertEquals(3,ogre.getPosX());

		ogre.setPosition(4, 4);
		ogre.playRandomMovesOgre(maze,4);
		assertEquals(4,ogre.getPosY());
		assertEquals(5,ogre.getPosX());





	}
	
	

	@Test
	public void testRandomMoveOgrefaile(){

		int level=2;
		Ogre ogre =new Ogre(4,4);
		Maze maze=new Maze(level); 		

		ogre.setPosition(4, 4);
		maze.inser(5, 4,'X');
		ogre.playRandomMovesOgre(maze,4);
		assertEquals(4,ogre.getPosY());
		assertEquals(4,ogre.getPosX());

		ogre.setPosition(4, 4);
		maze.inser(5, 4,'S');
		ogre.playRandomMovesOgre(maze,4);
		assertEquals(4,ogre.getPosY());
		assertEquals(4,ogre.getPosX());

		ogre.setPosition(4, 4);
		maze.inser(5, 4,'I');
		ogre.playRandomMovesOgre(maze,4);
		assertEquals(4,ogre.getPosY());
		assertEquals(4,ogre.getPosX());

		ogre.setPosition(4, 4);
		maze.inser(5, 4,'*');
		ogre.playRandomMovesOgre(maze,4);
		assertEquals(4,ogre.getPosY());
		assertEquals(4,ogre.getPosX());

		ogre.setPosition(4, 4);
		maze.inser(5, 4,'k');
		ogre.playRandomMovesOgre(maze,4);
		assertEquals(4,ogre.getPosY());
		assertEquals(5,ogre.getPosX());
		assertEquals('$',ogre.getName());



		ogre.setPosition(4, 4);
		maze.getHero().setIsArmed(true);
		maze.getHero().setPosition(5, 4);

		ogre.playRandomMovesOgre(maze,4);
		assertEquals(4,ogre.getPosY());
		assertEquals(4,ogre.getPosX());



	}





	@Test
	public void testTryMoveHero(){ 
		int level=2;
		Hero hero =new Hero(4,4);
		Maze maze=new Maze(level);


		maze.inser(5, 4,'C');
		hero.playHero("d", maze);
		assertEquals(4,hero.getPosY());
		assertEquals(5,hero.getPosX());
		assertTrue(hero.getIsArmed());

		hero.setPosition(4, 4);
		hero.setIsArmed(false);
		maze.inser(5, 4,'X');
		hero.playHero("d", maze);
		assertEquals(4,hero.getPosY());
		assertEquals(4,hero.getPosX());
		assertFalse(hero.getIsArmed());

		maze.inser(5, 4,'I');
		hero.playHero("d", maze);
		assertEquals(4,hero.getPosY());
		assertEquals(4,hero.getPosX());

		hero.setName('K');
		maze.inser(5, 4,'S');
		hero.playHero("d", maze);
		assertTrue(hero.getWin());


	}



	@Test
	public void testTryMoveHero2(){

		int level=1;
		Hero hero =new Hero(4,4);
		Maze maze=new Maze(level);


		maze.inser(5, 4,'C');
		hero.setTakeLever(false);
		hero.playHero("d", maze);
		assertEquals(4,hero.getPosY());
		assertEquals(5,hero.getPosX());
		assertTrue(hero.getIsArmed());
		assertEquals('A',hero.getName());

		hero .setPosition(4, 4);
		maze.inser(5, 4,'C');
		hero.setTakeLever(true);
		hero.playHero("d", maze);
		assertEquals(4,hero.getPosY());
		assertEquals(5,hero.getPosX());
		assertTrue(hero.getIsArmed());

		hero .setPosition(4, 4);
		hero.setTakeLever(false);
		hero.setIsArmed(false);

		hero.setName('K');
		maze.inser(5, 4,'k');
		hero.playHero("d", maze);
		assertEquals(4,hero.getPosY());
		assertEquals(5,hero.getPosX());
		assertEquals('S',maze.getMatrix()[5][0]);








	}






	@Test
	public void testTryMoveSGuard(){ 
		int level=1;
		Maze maze=new Maze(level);

		Guard guard=new Guard(1, 1, 2);


		guard.turnGuardSuspiciousMode(maze,1);

		assertEquals(22, guard.getAddmove());

		guard.turnGuardSuspiciousMode(maze,2);

		assertEquals(23, guard.getAddmove());



	}




	@Test
	public void testMazeCreatOgre(){
		int level=1;
		Maze maze=new Maze(level);
		maze.creatOres();

		assertEquals(3,maze.geTogres().size());	



	}



	@Test
	public void testChangeMaze(){
		int level=1;
		Maze maze=new Maze(level);
		maze.changeMap();

		assertEquals(2,maze.numMap());	
		maze.changeMap();
		assertEquals(3,maze.numMap());	


	}


	@Test
	public void tescleanClub(){
		int level=1;
		Maze maze=new Maze(level);
		maze.inser(4, 4, '*');

		assertEquals('*',maze.getMatrix()[4][4]);	

		maze.cleannclub();

		assertEquals(' ',maze.getMatrix()[4][4]);	


	}
	
	
	
	@Test
	public void testMazePutLever(){
		
		int level=2;
		Maze maze=new Maze(level);
		Ogre ogre =new Ogre(3,3);
		
		assertFalse(ogre.putLever(maze));
		maze.getHero().setName('K');
		assertTrue(ogre.putLever(maze));
		
		
		
	}
	
	
	
	@Test
	public void testMazeMet(){
		int level=2;
		Maze maze=new Maze(level);
		maze.inser(4, 4, '*');

		assertEquals('*',maze.getMatrix()[4][4]);	
		
		maze.cleanCell(4, 4);
		assertEquals(' ',maze.getMatrix()[4][4]);
		
		maze.inser(4, 4, 'O');
		assertTrue(maze.isOgre(4, 4));
		maze.inser(4, 4, '8');
		assertTrue(maze.isOgre(4, 4));
		
		maze.cleanCell(4, 4);
		assertFalse(maze.isOgre(4, 4));
		
		
		maze.Level_2();
		
		assertEquals(8,maze.getHero().getPosX());
		
		assertEquals(2,maze.getHero().getPosY());
		assertFalse(maze.getHero().getTakeLever());
		assertEquals(null,maze.getGuard());
		
		



	}
	
	

	@Test
	public void testPosClubOgre(){
		int level=2;
		Maze maze=new Maze(level);
		Ogre ogre =new Ogre(3,3);
		maze.inser(3, 2, 'X');
		ogre.getOgreWeapon().setWeapon(0, 0);
		ogre.attackOgre(maze, 1);
		
		assertEquals('X',maze.getMatrix()[2][3]);
		
		maze.inser(3, 2, ' ');
		ogre.getOgreWeapon().setWeapon(0, 0);
		ogre.attackOgre(maze, 1);
		
		assertEquals('*',maze.getMatrix()[2][3]);
		
		maze.inser(3, 2, '*');
		ogre.getOgreWeapon().setWeapon(0, 0);
		ogre.attackOgre(maze, 1);
		
		assertEquals('*',maze.getMatrix()[2][3]);
		
		
		maze.inser(3, 2, 'I');
		ogre.getOgreWeapon().setWeapon(0, 0);
		ogre.attackOgre(maze, 1);
		
		assertEquals('I',maze.getMatrix()[2][3]);
		
		
		maze.inser(3, 2, 'C');
		ogre.getOgreWeapon().setWeapon(0, 0);
		ogre.attackOgre(maze, 1);
		
		assertEquals('C',maze.getMatrix()[2][3]);
		
		maze.inser(3, 2, 'S');
		ogre.getOgreWeapon().setWeapon(0, 0);
		ogre.attackOgre(maze, 1);
		
		assertEquals('S',maze.getMatrix()[2][3]);
		
		maze.inser(3, 2, 'k');
		ogre.getOgreWeapon().setWeapon(0, 0);
		ogre.attackOgre(maze, 1);
		
		assertEquals('k',maze.getMatrix()[2][3]);
		
		
		
	}
	
	
	
	
	
	
	
	









}
