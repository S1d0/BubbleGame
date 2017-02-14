package com.bubble.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

public class BubblePanel extends JPanel {

	//Array of bubbles
	private ArrayList<Bubble> bubblesList;
	private Timer timer;
	private int size = 30; 
	
	//ms for delay of 33 ms
	private final int DELAY = 33; 
	
	public BubblePanel() {
		
		this.bubblesList = new ArrayList<Bubble>();
		addMouseListener(new BubbleListener());
		addMouseMotionListener(new BubbleListener());
		addMouseWheelListener(new BubbleListener());
		timer = new Timer(DELAY,  new BubbleListener());
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(450, 250));
		
		timer.start();
	}
	
	public void paintComponent(Graphics page){
		//pass page to the Jpanel
		super.paintComponent(page);
		
		//draw all the Bubbles from the bubblesList;
		
		for(Bubble bubble : bubblesList){
			page.setColor(bubble.color);
			page.fillOval(bubble.x -bubble.size,
							bubble.y - bubble.size,
							bubble.size, bubble.size);
		}
		//write a number of bubbles on a screen
		page.setColor(Color.GREEN);
		page.drawString("Number of bubbles "+ bubblesList.size(), 5, 15);
		
	}
	
	private class BubbleListener implements MouseListener, 
											MouseMotionListener,
											MouseWheelListener,
											ActionListener{

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			
			//add to bubbleList mouse location 
			bubblesList.add(new Bubble(e.getX(), e.getY(), size));
			repaint();
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		//mouse 		

		@Override
		public void mouseDragged(java.awt.event.MouseEvent e) {
			
			bubblesList.add(new Bubble(e.getX(),e.getY(),size));
			repaint();
		}

		@Override
		public void mouseMoved(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			
			size -= e.getWheelRotation(); 
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//update the location of each buble
			for(Bubble bubble: bubblesList){
				bubble.update();
			}
			//repaint the screen
			repaint();
		}
	}

	private class Bubble{
		//Bubble needs an x,y locations and size 
		public int  x,
					y,
					size;
		private Color color;
		private int xSpeed,
					ySpeed; 			
		private final int MAX_SPEED = 3;
		
		public Bubble(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			color = new Color((float)Math.random(),
								(float)Math.random(),
								(float)Math.random());
			
			xSpeed = (int)(Math.random()*MAX_SPEED*2-MAX_SPEED);
			ySpeed = (int)(Math.random()*MAX_SPEED*2-MAX_SPEED);
			if(xSpeed == 0 && ySpeed == 0){
				xSpeed = 1;
				ySpeed = 1;
					
			}
			
		}

		public void update() {
			// update the position of the bubble
			
			x += xSpeed;
			System.out.println("x "+x);
			y += ySpeed; 
			System.out.println("y "+y);
			
			//collision detection action
			if(x < 0 || x > getWidth())	xSpeed = -1 *xSpeed;
			
			if(y < 0 || y > getHeight()) ySpeed = -1 * ySpeed;
		}		
	}
	

}
