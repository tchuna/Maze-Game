package gui;

import java.awt.EventQueue;

public  class GuiMain  {
	
	
	public static void main(String[] args) {
		final Frame window=new Frame();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setVisible(true);;
				} catch (Exception ex){
				}finally{
					
				}
			}
		}); 
		
		
	
	}
	
	
	
	
	
}
