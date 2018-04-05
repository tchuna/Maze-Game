package gui;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import maze.logic.Game;
import maze.logic.Maze;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;


public class Frame extends JFrame{


	private static final long serialVersionUID = 1L;



	private JButton btnUp,btnLeft,btnDown, btnRight,btnNewGame,btnExit;

	private JLabel numberOgres, currentGame,lblGuardPersonality;

	private String[] guardPers = { "Rockie", "Suspicios", "Drunk"};

	private JTextPane jOgres;

	private JComboBox<String>guardMode;

	private boolean invalidnOgres=false;

	private Boolean fristTime=true;
	private JPanel mainPanel;
	private JFrame Window;
	private Game game;
	private Maze maze=new Maze(1);





	public Frame() {

		initFrame();
		
	}



	public void  initFrame(){


		builtFrame();
		addComponets();
		actionsButtons();
	}




	public void initCompon(){
		Window=new JFrame();
		mainPanel = new Panel();


		btnUp = new JButton("UP");
		btnLeft = new JButton("LEFT");
		btnDown = new JButton("DOWN");
		btnRight = new JButton("RIGHT");
		btnNewGame = new JButton("New Game") ;
		btnExit = new JButton("Exit");
		numberOgres = new JLabel(" Number of Ogres :");
		currentGame = new JLabel("You cant Start a New Game");
		lblGuardPersonality = new JLabel(" Guard Personality :");
		guardMode= new JComboBox<String> (guardPers);
		jOgres= new JTextPane();

	}


	private void builtFrame(){
		initCompon();

		Window.setTitle("Maze Game");
		Window.setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/resource/hero.png")));
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setBounds(100, 100, 600, 450);
		Window.setResizable(false);

		Window.setVisible(true);

		setupComponests();
		pack();

	}



	public void setupComponests(){ 

		btnNewGame.setBounds(435,80,109, 20);
		btnExit.setBounds(435,364,109, 20);

		btnDown.setBounds(450,259,80, 20);
		btnDown.setEnabled(false);

		btnUp.setBounds(450,185,80, 20);
		btnUp.setEnabled(false);

		btnLeft.setBounds(390,222,80, 20);
		btnLeft.setEnabled(false);

		btnRight.setBounds(510,222,80, 20);
		btnRight.setEnabled(false);



		numberOgres.setBounds(12,5, 140, 20);

		jOgres.setBounds(160,5 , 50, 20);

		lblGuardPersonality.setBounds(12, 28, 145, 20);

		guardMode.setBounds(160, 28, 100, 20);
		



		currentGame.setFont(new Font("Serif", Font.BOLD,10));
		currentGame.setBounds(12,432,210,20);

		jOgres.setBorder(BorderFactory.createLineBorder(Color.black));
		
		


	}


	public void addComponets() {
		Window.getContentPane().setLayout(null);
		Window.getContentPane().add(mainPanel);
		Window.getContentPane().add(btnNewGame);
		Window.getContentPane().add(btnExit);
		Window.getContentPane().add(btnDown);
		Window.getContentPane().add(btnUp);
		Window.getContentPane().add(btnLeft);
		Window.getContentPane().add(btnRight);
		Window.getContentPane().add(numberOgres);
		Window.getContentPane().add(currentGame);
		Window.getContentPane().add(jOgres);
		Window.getContentPane().add(lblGuardPersonality);
		Window.getContentPane().add(guardMode);

	}



	public void disableButton(boolean disable){

		btnRight.setEnabled(disable);
		btnLeft.setEnabled(disable);
		btnUp.setEnabled(disable);
		btnDown.setEnabled(disable);

	}




	public Game  creatGame(){

		int numberOgres=catchNumberOgres();
		if(numberOgres!=0){
			maze=new Maze(1);
			game=new Game(maze,guardMode.getSelectedIndex()+1,numberOgres);

			((Panel) mainPanel).startGame(game);

			mainPanel.setFocusable(true);
			mainPanel.requestFocusInWindow();

			return game;
		}



		return null;

	}





	public int catchNumberOgres(){
		int ogres = 0;
		try {
			ogres= Integer.parseInt(jOgres.getText());
		} catch (NumberFormatException e) {

			currentGame.setText("Invalid type Number of Ogres.");
			JOptionPane.showMessageDialog(Window,"Invalid  Type in Number Ogres");
			this.invalidnOgres=true;
			return 1;
		}


		if(ogres<=0 || ogres>5){

			JOptionPane.showMessageDialog(Window,"Invalid Number Ogres (1-5 ogres)");
			this.invalidnOgres=true;
			return 1;
		}


		this.invalidnOgres=false;

		return ogres;
	}






	public void btnNewGameAction(){

		btnNewGame.addMouseListener(new MouseAdapter(){

			public void mouseClicked (MouseEvent e){
				if(e.getClickCount()==2){

					if(fristTime==true){

						catchNumberOgres();
						if(invalidnOgres==false){
							disableButton(true);
							currentGame.setText("Escape the Maze Moved the Hero");
							fristTime=false;
							creatGame();
						}else{

							JOptionPane.showMessageDialog(Window,"Enter correct values (Ogres)");

						}

					}else{

						String stard="Are you Sure  ?";
						int result=JOptionPane.showConfirmDialog(Window, stard);

						if(result==JOptionPane.YES_OPTION){
							catchNumberOgres();
							if(invalidnOgres==false){
								disableButton(true);
								currentGame.setText("Escape the Maze Moved the Hero"); 
								creatGame();
							}else{

								JOptionPane.showMessageDialog(Window,"Enter correct values (Ogres)");

							}

						}

					}

				}

			}
		});


	}






	public void btnExitAction(){

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String exit=" (Exit) Are you Sure ?";
				int result=JOptionPane.showConfirmDialog(Window, exit);

				if(result==JOptionPane.YES_OPTION){
					System.exit(0);


				}
			}
		});

	}







	public void bntDirectionsAction(){

		btnUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setFocusable(true);
				mainPanel.requestFocusInWindow();

				currentGame.setText("Escape the Maze Moved the Hero");

				game.updateGame("w");
				((Panel) mainPanel).updateGame(game);

				heroDie();
				heroWin();
			}
		});



		btnDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setFocusable(true);
				mainPanel.requestFocusInWindow();

				currentGame.setText("Escape the Maze Moved the Hero");
				game.updateGame("s");
				((Panel) mainPanel).updateGame(game);

				heroDie();
				heroWin();
			}
		});



		btnRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
				mainPanel.setFocusable(true);
				mainPanel.requestFocusInWindow();

				currentGame.setText("Escape the Maze Moved the Hero");
				game.updateGame("d");
				((Panel) mainPanel).updateGame(game);
				heroDie();
				heroWin();

			}
		});



		btnLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainPanel.setFocusable(true);
				mainPanel.requestFocusInWindow();

				currentGame.setText("Escape the Mave Moved the Hero");
				game.updateGame("a");
				((Panel) mainPanel).updateGame(game);
				heroDie();
				heroWin();

			}
		});









	}


	public void actionsButtons(){
		
		
		bntDirectionsAction();
		btnNewGameAction();
		btnExitAction();


	}


	public void heroWin(){

		if(game.getMaze().getHero().getWin()){

			currentGame.setText("You Win");
			JOptionPane.showMessageDialog(Window,"You Win");

			int result=JOptionPane.showConfirmDialog(mainPanel, "Try again!!");

			if(result==JOptionPane.YES_OPTION){

				creatGame();
			}else{

				System.exit(0);
			}

		}


	}


	public void heroDie(){

		if(game.getMaze().getHero().getIsDead()){

			currentGame.setText("You Lose");
			JOptionPane.showMessageDialog(Window,"Game Over");

			int result=JOptionPane.showConfirmDialog(mainPanel, "Try again!!");

			if(result==JOptionPane.YES_OPTION){

				creatGame();
			}else{

				System.exit(0);
			}

		}


	}


}






