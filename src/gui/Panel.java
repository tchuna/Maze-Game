package gui;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import maze.logic.*;


public class Panel extends JPanel {

	
	
	private static final long serialVersionUID = 1L;
	
	private int numMaze=1;
	private Image backround;
	private Image wall;
	private Image freeCell;
	private Image lever;
	private Image key;
	private Image openDoor;
	private Image closeDoor;
	private Game game=null;
	private Boolean sho=true;
	//Graphics e;
	
	
	

    public Panel() { 

        initPanel();
    }
    
    public void initPanel() {
        
        loadImage();
         
        int w =backround.getWidth(this);
        int h =backround.getHeight(this);
        setPreferredSize(new Dimension(w, h));        
    }
    
    private void loadImage() {
        
        ImageIcon temp = new ImageIcon("src/resource/b.png");
        backround = temp.getImage();  
        
        
        
        
    }
  
    
    public void startNewGame(){
    	
    	
    	
    }
    
 
    public void initGame(JTextArea text,int modGuard ,int nuOgre){
    	game=null;
    	Maze maze=new Maze(numMaze);
    	game=new Game(maze, modGuard,nuOgre); 
    	game.StardGame();
   	
    	
    	text.setText(game.getMaze().toString());
    	requestFocus();
    	
    }
    
    

    
    
    
    
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	if(sho==true){
    		 g.drawImage(backround, 0, 0, null);
    	}

       
    }
    

	public Game getGame() {
		return game;
	}

	public void setGame( Game game ) {
		this.game = game;
	}

	public void updateD(ActionEvent e) {
		
		
	}

	public Boolean  dir(String string,JTextArea text) {
		Boolean result;
		game.updateGame(string);
		text.setText(game.getMaze().getSrtingMatrix());
		
		
		result=game.getMaze().getHero().getIsDead();
		
		repaint();
		
		return result;
		
		
		
		
	}

	

}
