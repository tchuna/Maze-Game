package gui;

import java.awt.EventQueue;

public  class GuiMain  {
	
	
	public static void main(String[] args) {
		final Frame window=new Frame();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setVisible(true);
					//System.out.println("System");
				} catch (Exception ex){
					//System.out.println("JVM Default");
				}finally{
					
				}
			}
		});
		
		
	
	}
	
	
	
	
	
}


	/*private static final long serialVersionUID = 1L;

	//Frame
	private JButton btnUp = new JButton("UP");

	private JButton btnLeft = new JButton("LEFT");

	private JButton btnDown = new JButton("DOWN");

	private JButton btnRight = new JButton("RIGHT");

	private JButton btnNewGame = new JButton("New Game") ;

	private JButton btnExit = new JButton("Exit");

	private JLabel numberOres = new JLabel("Number of Ogres :");

	private JLabel currentGame = new JLabel("You cant Start a New Game");

	private JTextPane textPane = new JTextPane();

	private JLabel lblGuardPersonality = new JLabel("Guard Personality :");

	private String[] guardPers = { "Rockie", "Suspicios", "Drunk"};

	private Integer[] nOgre = { 1,2,3,4,5};

	private JComboBox<String>comboBox = new JComboBox<String> (guardPers);

	private JComboBox<?>comboBoxOgre = new JComboBox<Integer> (nOgre);

	private JFrame gameWindow;
	private JPanel mainPanel;
	private JLabel gridLabel=new JLabel();



	//JPanel

	private int numMaze=1;
	private Image backround;
	private Game game=null;
	private Boolean sho=true;

	private ImageIcon hero_1 = new ImageIcon(getClass().getClassLoader().getResource("resource/left.png"));

	private ImageIcon maze_wall = new ImageIcon(getClass().getClassLoader().getResource("resource/wall.jpg"));
	private ImageIcon maze_free = new ImageIcon(getClass().getClassLoader().getResource("resource/caminho.png"));
	private ImageIcon maze_closedoor = new ImageIcon(getClass().getClassLoader().getResource("resource/closedoor.png"));
	private ImageIcon maze_opendoor = new ImageIcon(getClass().getClassLoader().getResource("resource/opendoor.png"));
	private ImageIcon maze_key= new ImageIcon(getClass().getClassLoader().getResource("resource/wall.jpg"));
	private ImageIcon maze_lever = new ImageIcon(getClass().getClassLoader().getResource("resource/wall.jpg"));


	private ImageIcon rockei_guard= new ImageIcon(getClass().getClassLoader().getResource("resource/rockie.png"));
	private ImageIcon susp_guad= new ImageIcon(getClass().getClassLoader().getResource("resource/suspicios.png"));
	private ImageIcon drunk_guard= new ImageIcon(getClass().getClassLoader().getResource("resource/drunk.png"));
	private ImageIcon ogre= new ImageIcon(getClass().getClassLoader().getResource("resource/ogre1.png"));

	private JLabel[][] labels;
	private Maze maze;
	static BufferedImage hero;
	Boolean fristTime=true;

	



	public GuiMain() {

		initGame();

		//bulitFrame();

	}


	public void initFrame(){




	}









	public void  initGame(){


		loadListeners();
		bulitFrame();

	}


	public void startGame(){



	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // limpa fundo ...		
		g.setColor(Color.BLUE);
		g.drawImage(hero, 23, 23, 23, 23, 0, 0, hero.getWidth(), hero.getHeight(), null);
	//	g.drawImage(hero, x1, y1, x2, y2, 0, 0, hero.getWidth(), hero.getHeight(), null);//x2 - x1 + 1, y2 - y1 + 1);
		//g.fillOval(x1, y1, x2 - x1 + 1, y2 - y1 + 1);
	}
	
	
	public void loadListeners(){

		URL urlHeroi = this.getClass().getClassLoader().getResource("resource/left.png");

		try {
			hero =  ImageIO.read(urlHeroi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void bulitFrame(){
		
		gameWindow= new JFrame();
		mainPanel = new JPanel();
		gameWindow.setTitle("Maze Game");
		gameWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/resource/rockie.png")));

		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setBounds(100, 100, 600, 450);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		configFrame();
		gameWindow.add(mainPanel);
		gameWindow.setContentPane(mainPanel);
		gameWindow.setVisible(true);	
		 configButtons();
		
		//gameWindow.addKeyListener(this);
		
		
	}
	


	public void configFrame(){
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

		numberOres.setBounds(12,10, 150, 20);
		comboBoxOgre.setBounds(160,10 , 50, 20);

		lblGuardPersonality.setBounds(12, 35, 150, 20);
		comboBox.setBounds(160, 35, 100, 20);


		currentGame.setFont(new Font("Serif", Font.BOLD,10));
		currentGame.setBounds(12,432,210,20);
		
		
		//repaint();



		mainPanel.add(btnNewGame);
		mainPanel.add(btnExit);
		mainPanel.add(btnDown);
		mainPanel.add(btnUp);
		mainPanel.add(btnLeft);
		mainPanel.add(btnRight);


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
				int result=JOptionPane.showConfirmDialog(getRootPane(), exit);

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
						fristTime=false;
						
						gridLabel.setIcon(ogre);
						gridLabel.setBounds(12, 200, 50, 50);
						
						mainPanel.add(gridLabel);
						
						mainPanel.repaint();
						
						
						

					}else{

						String stard="Are you Sure  ?";
						int result=JOptionPane.showConfirmDialog(getRootPane(), stard);

						if(result==JOptionPane.YES_OPTION){
							btnRight.setEnabled(true);
							btnLeft.setEnabled(true);
							btnUp.setEnabled(true);
							btnDown.setEnabled(true);
							currentGame.setText("You cant Pla Now");


						}
					}
				}
			}
		});





		btnUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//mainPanel.add(gridLabel);

			}
		});



		btnDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

		



			}
		});



		btnRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				



			}
		});



		btnLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				

			}
		});





	}




	public void KeyAction(){




	}

	public void MouseAction(){




	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}



	public static void main(String[] args) {
		final GuiMain window=new GuiMain();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setVisible(true);
					//System.out.println("System");
				} catch (Exception ex){
					//System.out.println("JVM Default");
				}finally{
					
				}
			}
		});
		
		
	
	}
	
	
	
	/*	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});*/
	
	
	







