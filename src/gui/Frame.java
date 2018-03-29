package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import maze.logic.Game;
import maze.logic.Maze;

import javax.swing.JTextField;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Frame extends JFrame {


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
		actionsButtons();

	}



	public void updateGame(){



	}



	public void actionMoves() {
		// Print map
		mainPanel.requestFocusInWindow();

		//graphicssetMap(game.getCurrentMap());

		mainPanel.repaint();
		mainPanel.revalidate();

		/*if (game.isOver()) {
			setDirectionButtons(false);
			if (game.getGameStatus() == Game.GameStat.LOSE) {
				lblInstructions.setText("You Lost! Select Ogre Number and Guard Type to Play.");
			} else if (game.getGameStatus() == Game.GameStat.WIN) {
				lblInstructions.setText("You Won! Select Ogre Number and Guard Type to Play.");
			}
		}*/
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
		numberOgres = new JLabel("Number of Ogres :");
		currentGame = new JLabel("You cant Start a New Game");
		lblGuardPersonality = new JLabel("Guard Personality :");
		guardMode= new JComboBox<String> (guardPers);
		jOgres= new JTextPane();


	}


	private void builtFrame(){
		initCompon();

		Window.setTitle("Maze Game");
		Window.setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/resource/ogre6.png")));
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setBounds(100, 100, 600, 450);
		
		Window.setResizable(false);

		setupComponests();
		addComponets();
		Window.setVisible(true);
		requestFocus();
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



		numberOgres.setBounds(12,10, 150, 20);
		jOgres.setBounds(160,10 , 50, 20);

		lblGuardPersonality.setBounds(12, 35, 150, 20);
		guardMode.setBounds(160, 35, 100, 20);


		currentGame.setFont(new Font("Serif", Font.BOLD,10));
		currentGame.setBounds(12,432,210,20);

		mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
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
							currentGame.setText("You cant Pla Now");
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
								currentGame.setText("You cant Pla Now"); 
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



	}


	public void actionsButtons(){
		bntDirectionsAction();
		btnNewGameAction();
		btnExitAction();

	}




	/*public void  configButtons(){




		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String exit=" (Exit) Are you Sure ?";
				int result=JOptionPane.showConfirmDialog(rootPane, exit);

				if(result==JOptionPane.YES_OPTION){
					System.exit(0);


				}
			}
		});





		btnNewGame.addMouseListener(new MouseAdapter(){

			public void mouseClicked (MouseEvent e){
				if(e.getClickCount()==2){
					if(fristTime==true){

						btnRight.setEnabled(true);
						btnLeft.setEnabled(true);
						btnUp.setEnabled(true);
						btnDown.setEnabled(true);
						currentGame.setText("You cant Pla Now");
						mainPanel.initGame(textArea, comboBox.getSelectedIndex()+1,comboBoxOgre.getSelectedIndex()+1);
						fristTime=false;

					}else{

						String stard="Are you Sure  ?";
						int result=JOptionPane.showConfirmDialog(rootPane, stard);

						if(result==JOptionPane.YES_OPTION){
							btnRight.setEnabled(true);
							btnLeft.setEnabled(true);
							btnUp.setEnabled(true);
							btnDown.setEnabled(true);
							currentGame.setText("You cant Pla Now");

							mainPanel.initGame(textArea, comboBox.getSelectedIndex()+1,comboBoxOgre.getSelectedIndex()+1);

						}
					}
				}
			}
		});





		btnUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(mainPanel.dir("w",textArea)){
					currentGame.setText("You Die");
					JOptionPane.showMessageDialog(getRootPane(),"Game Over");
					currentGame.setText("You cant Pla Now");
					mainPanel.initGame(textArea, comboBox.getSelectedIndex()+1,comboBoxOgre.getSelectedIndex()+1);



				}

			}
		});



		btnDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(mainPanel.dir("s",textArea)){
					JOptionPane.showMessageDialog(getRootPane(),"Game Over");
					currentGame.setText("You cant Pla Now");
					mainPanel.initGame(textArea, comboBox.getSelectedIndex()+1,comboBoxOgre.getSelectedIndex()+1);

				}



			}
		});



		btnRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
				if(mainPanel.dir("d",textArea)){
					currentGame.setText("You Die");
					JOptionPane.showMessageDialog(getRootPane(),"Game Over");
					currentGame.setText("You cant Pla Now");
					mainPanel.initGame(textArea, comboBox.getSelectedIndex()+1,comboBoxOgre.getSelectedIndex()+1);

				}



			}
		});



		btnLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(mainPanel.dir("a",textArea)){
					currentGame.setText("You Die");
					JOptionPane.showMessageDialog(getRootPane(),"Game Over");
					currentGame.setText("You cant Pla Now");
					mainPanel.initGame(textArea, comboBox.getSelectedIndex()+1,comboBoxOgre.getSelectedIndex()+1);

				}

			}
		});





	}*/

}






