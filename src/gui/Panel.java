package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import maze.logic.Game;
import maze.logic.Maze;


public class Panel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	int x=0,y=0;
	private char map[][];
	private JLabel myLabel= new JLabel();
	private JLabel back=new JLabel();
	JLabel[][] labels;
	
	private ImageIcon ground = new ImageIcon(getClass().getClassLoader().getResource("resource/b.png"));
	private ImageIcon wall = new ImageIcon(getClass().getClassLoader().getResource("resource/wall.png"));
	private ImageIcon floor = new ImageIcon(getClass().getClassLoader().getResource("resource/free.png"));
	
	private ImageIcon hero = new ImageIcon(getClass().getClassLoader().getResource("resource/ogre6.png"));
	private ImageIcon guard_rockie = new ImageIcon(getClass().getClassLoader().getResource("resource/rockie.png"));
	
	private ImageIcon guard_suspicios = new ImageIcon(getClass().getClassLoader().getResource("resource/suspicios.png"));
	private ImageIcon guard_drunk = new ImageIcon(getClass().getClassLoader().getResource("resource/drunk.png"));
	private ImageIcon ogre = new ImageIcon(getClass().getClassLoader().getResource("resource/ogre.png"));
	private ImageIcon key = new ImageIcon(getClass().getClassLoader().getResource("resource/caminho.png"));
	private ImageIcon lever= new ImageIcon(getClass().getClassLoader().getResource("resource/caminho.png"));
	private ImageIcon weapon = new ImageIcon(getClass().getClassLoader().getResource("resource/caminho.png"));
	private ImageIcon club = new ImageIcon(getClass().getClassLoader().getResource("resource/caminho.png"));
	private ImageIcon opendoor = new ImageIcon(getClass().getClassLoader().getResource("resource/opendoor.png"));
	private ImageIcon closedoor = new ImageIcon(getClass().getClassLoader().getResource("resource/closedoor.png"));
	
	
	

	public Panel() {
		super();
		setBounds(20,70 ,350,350); 
		
		//this.setLayout(new GridLayout(10,10));
		
		back.setIcon(ground);
		back.setBounds(0, 0, 350, 350);
		this.add(back);
		
		//map=game.getMaze().getMatrix();
		//creatMaze();
		//this.add(myLabel);
		//map=maze.getMatrix();
		//repaint();
		
	}
	
	
	
	
	
	public void startGame(Game game){
		int leng=game.getMaze().getMatrix().length;
		
		this.setLayout(new GridLayout(leng,leng));
		this.remove(back);
		creatMaze(game);
		repaint();
		
		
		
	}
	
	
	public void creatMaze(Game game){
		int leng=game.getMaze().getMatrix().length;
		map=game.getMaze().getMatrix();
		labels=new JLabel[leng][leng];
		ImageIcon image=new ImageIcon();
		
		
		for(int i=0; i<10;i++){
			for(int j=0; j<10;j++){
				
				image=inserImage(map[i][j]);
				
				labels[i][j]=new JLabel();
				labels[i][j].setIcon(image);
				//labels[i][j].setBounds(x,y,12,12);
				this.add(labels[i][j]);
				//x=+20;
				
			}
			//y+=20;
			//x=0;
			
		}
	}
	
	
	
	
	
	public  ImageIcon inserImage(char img){
		ImageIcon result=new ImageIcon();
		switch (img) {
		case ' ':  result=floor;break;
		case 'X':  result=wall; break;
		case 'I':  result=closedoor;break;
		case 'H':  result=hero;break;
		case 'G':  result=guard_rockie;break;
		case 'k':  result=lever;break;
		case 'S':  result=opendoor;break;
		
		default:
			break;
		}
		
		return result;
	}
	
	



}
















/*try{


	/*images.put('X', ImageIO.read(new File("resource/wall1.png")));
images.put('I', ImageIO.read(new File("resource/closedoor.png")));
images.put('S', ImageIO.read(new File("resource/opendoor.png")));
//images.put('*', ImageIO.read(new File("resource/club.png")));
//images.put('k', ImageIO.read(new File("imgs/key.png")));
images.put('H', ImageIO.read(new File("resource/down.png")));
//images.put('A', ImageIO.read(new File("imgs/hero_shield.png")));
//images.put('K', ImageIO.read(new File("imgs/hero_shield_key.png")));
images.put('G', ImageIO.read(new File("imgs/rockie.png")));
//images.put('g', ImageIO.read(new File("imgs/guardian_sleeping.png")));
//images.put('O', ImageIO.read(new File("imgs/ogre.png")));
//images.put('8', ImageIO.read(new File("imgs/ogre_stunned.png")));
//images.put('&', ImageIO.read(new File("imgs/ogre_key.png")));
//images.put('$', ImageIO.read(new File("imgs/club_key.png")));
images.put(' ', ImageIO.read(new File("imgs/caminho.png")));
} catch (IOException e){
return;
}*/
