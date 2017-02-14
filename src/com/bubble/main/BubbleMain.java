package com.bubble.main;

import javax.swing.JFrame;

public class BubbleMain extends JFrame {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("BubbleDrawe App");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.getContentPane().add(new BubblePanel());
		
		frame.pack();
		
		frame.setVisible(true);
	}

}
