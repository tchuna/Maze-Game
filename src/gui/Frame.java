package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import maze.logic.Maze;

import javax.swing.JTextField;
import java.awt.Toolkit;
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

	JLabel imgLabel = new JLabel(new ImageIcon("src/resource/star.png"));

	JButton btnUp = new JButton("UP");

	JButton btnLeft = new JButton("LEFT");

	JButton btnDown = new JButton("DOWN");

	JButton btnRight = new JButton("RIGHT");

	JButton btnNewGame = new JButton("New Game") ;

	JButton btnExit = new JButton("Exit");

	JLabel numberOres = new JLabel("Number of Ogres :");

	JLabel currentGame = new JLabel("You cant Start a New Game");

	JTextPane textPane = new JTextPane();

	JLabel lblGuardPersonality = new JLabel("Guard Personality :");

	String[] guardPers = { "Rockie", "Suspicios", "Drunk"};

	Integer[] nOgre = { 1,2,3,4,5};

	JComboBox<String>comboBox = new JComboBox<String> (guardPers);

	JComboBox<?>comboBoxOgre = new JComboBox<Integer> (nOgre);


	JTextArea textArea = new JTextArea();

	Panel mainPanel = new Panel();

	Maze maze =new Maze(1);

	Boolean fristTime=true;




	public Frame() {

		initComponests();

		configButtons();
		creatEvents();
	}






	private void initComponests(){


		setTitle("Maze Game");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/resource/star.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);

		addComponests();

		pack();




	}



	public void addComponests(){
		mainPanel.setLayout(null);


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


		textArea.setBounds(12, 70, 360, 360);
		textArea.setEditable(false);
		textArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

		numberOres.setBounds(12,10, 150, 20);
		comboBoxOgre.setBounds(160,10 , 50, 20);

		lblGuardPersonality.setBounds(12, 35, 150, 20);
		comboBox.setBounds(160, 35, 100, 20);


		currentGame.setFont(new Font("Serif", Font.BOLD,10));
		currentGame.setBounds(12,432,210,20);



		mainPanel.add(btnNewGame);
		mainPanel.add(btnExit);
		mainPanel.add(btnDown);
		mainPanel.add(btnUp);
		mainPanel.add(btnLeft);
		mainPanel.add(btnRight);


		mainPanel.add(textArea);
		mainPanel.add(numberOres);
		mainPanel.add(currentGame);

		mainPanel.add(textPane);

		mainPanel.add(lblGuardPersonality);
		mainPanel.add(comboBox);
		mainPanel.add(comboBoxOgre);


	}




	public void  configButtons(){




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
					
				}

			}
		});



		btnDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(mainPanel.dir("s",textArea)){
					JOptionPane.showMessageDialog(getRootPane(),"Game Over");
					
				}



			}
		});



		btnRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(mainPanel.dir("d",textArea)){
					currentGame.setText("You Die");
					JOptionPane.showMessageDialog(getRootPane(),"Game Over");
					
				}



			}
		});



		btnLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(mainPanel.dir("a",textArea)){
					currentGame.setText("You Die");
					JOptionPane.showMessageDialog(getRootPane(),"Game Over");
					
				}

			}
		});





	}








	private void creatEvents(){



	}
}






