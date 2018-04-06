package maze.gui;


import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import maze.logic.Game;

import maze.logic.Maze;

/**
 * Class for Panel in game 
 * 
 * */
public class Panel extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;

	int x=0,y=0;
	private char map[][];
	private JLabel back=new JLabel(); 
	JLabel[][] labels;
	boolean isarmed;
	Game game;
	int mode;
	int numOgre;
	Maze maze;

	
	private ImageIcon ground = new ImageIcon(getClass().getClassLoader().getResource("resource/b.png"));
	private ImageIcon wall = new ImageIcon(getClass().getClassLoader().getResource("resource/wall.png"));
	private ImageIcon floor = new ImageIcon(getClass().getClassLoader().getResource("resource/free.png"));
	private ImageIcon lever= new ImageIcon(getClass().getClassLoader().getResource("resource/key.png"));
	private ImageIcon opendoor = new ImageIcon(getClass().getClassLoader().getResource("resource/opendoor.png"));
	private ImageIcon closedoor = new ImageIcon(getClass().getClassLoader().getResource("resource/closedoor.png"));
	ImageIcon hero;
	private ImageIcon weapon = new ImageIcon(getClass().getClassLoader().getResource("resource/weapon.png"));
	private ImageIcon guard_rockie = new ImageIcon(getClass().getClassLoader().getResource("resource/rockie.png"));
	private ImageIcon guard_suspicios = new ImageIcon(getClass().getClassLoader().getResource("resource/suspicios.png"));
	private ImageIcon guard_drunk = new ImageIcon(getClass().getClassLoader().getResource("resource/drunk.png"));
	private ImageIcon guard_sleep = new ImageIcon(getClass().getClassLoader().getResource("resource/sleepguad.png"));

	private ImageIcon ogre = new ImageIcon(getClass().getClassLoader().getResource("resource/ogre.png"));
	private ImageIcon ogresleep = new ImageIcon(getClass().getClassLoader().getResource("resource/ogresleep.png"));
	private ImageIcon club = new ImageIcon(getClass().getClassLoader().getResource("resource/club.png"));
	private ImageIcon ogreKey = new ImageIcon(getClass().getClassLoader().getResource("resource/orgrekey.png"));







	
	

	/**
	 * Create  Panel 
	 * 
	 * */
	public Panel() {
		super(); 


		setBounds(20,70 ,350,350); 

		back.setIcon(ground);
		back.setBounds(0, 0, 300, 300); 
		this.add(back);
		addKeyListener(this);

		setRequestFocusEnabled(true);

	}





	
	/**
	 * Start the GuiGame  
	 * 
	 * */
	public void startGame(){

		this.removeAll();
		

		int leng=game.getMaze().getMatrix().length;
		this.setLayout(new GridLayout(leng,leng));
		creatMaze(game);
		revalidate();
		repaint();



	}


	
	/**
	 * Create a game 
	 * @param nOgres number ogres current game
	 * @param mode1 guard personality
	 * */
	public void CreatGame(int nOgres,int mode1){
		
		maze=new Maze(1);
		this.numOgre=nOgres;
		this.mode=mode1;
		game=new Game(maze,mode1,numOgre);
		startGame();
		
	}


	
	
	/**
	 * update state current game
	 * @param input value
	 * */
	public void  updateGame(String input ){
		game.updateGame(input);
		
		
	}
	
	
	/**
	 * Refresh current game
	 * 
	 * */
	public void refresh(){
		this.removeAll();

		creatMaze(game);

		repaint();
		revalidate();

	}




	
	/**
	 * Transform all the char in matrix game to images  
	 * 
	 * @param game current  games 
	 * */
	public void creatMaze(Game game){
		int leng=game.getMaze().getMatrix().length;
		map=game.getMaze().getMatrix();
		labels=new JLabel[leng][leng];
		ImageIcon image=new ImageIcon();

		isarmed=game.getMaze().getHero().getIsArmed();

		for(int i=0; i<10;i++){
			for(int j=0; j<10;j++){

				image=inserImage(map[i][j]);

				labels[i][j]=new JLabel();
				labels[i][j].setIcon(image);
				this.add(labels[i][j]);		
			}

		}
	}





	/**
	 * Transform the char in matrix game to images 
	 * @param  img  
	 * @return the result image
	 * */
	public  ImageIcon inserImage(char img){

		if(isarmed==true){
			hero = new ImageIcon(getClass().getClassLoader().getResource("resource/armedhero.png"));

		}else{
			hero = new ImageIcon(getClass().getClassLoader().getResource("resource/hero.png"));

		}


		ImageIcon result=new ImageIcon();
		switch (img) {
		case ' ':  result=floor;break;
		case 'X':  result=wall; break;
		case 'I':  result=closedoor;break;
		case 'H':  result=hero;break;
		case 'K':  result=hero;break;
		case 'G':  result=guard_suspicios;break;
		case 'k':  result=lever;break;
		case 'C':  result=weapon;break;
		case 'O':  result=ogre;break;
		case 'A':  result=hero;break;
		case '*':  result=club;break;
		case '$':  result= ogreKey;break;
		case 'S':  result=opendoor;break;
		case '8':  result=ogresleep;break;
		case 'd':  result=guard_drunk;break;
		case 'g':  result=guard_sleep;break;
		case 'r':  result=guard_rockie;break;
		}

		return result;
	}



	

	/**
	 * Verify is the current hero is a Winer
	 * 
	 * */
	public void heroWin(){

		if(game.getMaze().getHero().getWin()){

			JOptionPane.showMessageDialog(this,"You Win");

			int result=JOptionPane.showConfirmDialog(this, "Try again!!");

			if(result==JOptionPane.YES_OPTION){

				CreatGame(numOgre,mode);
			}else{

				System.exit(0);
			}

		}


	}




	/**
	 * Verify is the current hero is Dead
	 * 
	 * */
	public void heroDie(){

		if(game.getMaze().getHero().getIsDead()){

			JOptionPane.showMessageDialog(this,"Game Over");

			int result=JOptionPane.showConfirmDialog(this, "Try again!!");

			if(result==JOptionPane.YES_OPTION){

				CreatGame(numOgre,mode );
			}else{

				System.exit(0);
			}

		}


	}




	@Override
	public void keyTyped(KeyEvent e) {
	
	}



	
	/**
	 * Key press events 
	 * @param e keyEvent
	 * */
	@Override
	public void keyPressed(KeyEvent e) {


		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			game.updateGame("w");
			refresh();
			heroDie();
			heroWin();

			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			game.updateGame("s");
			refresh();
			heroDie();
			heroWin();

			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			game.updateGame("d");
			refresh();
			heroDie();
			heroWin();


			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			game.updateGame("a");
			refresh();
			heroDie();
			heroWin();

			break;
		default:
			return;
		}

	}



	@Override
	public void keyReleased(KeyEvent e) {
		

	}



}


