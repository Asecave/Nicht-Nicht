package nichtNicht;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener, KeyListener{
	
	int timer = 10;
	Timer tm = new Timer(timer, this);
	
	static int width = 800;
	static int height = 800;
	
	boolean start = false;
	
	int level = 4;
	int time = 600;
	int speed = 3;
	int command = 0;
	
	boolean set_command = true;
	int position1 = ((int)(Math.random()*400)), position2 = ((int)(Math.random()*400));
	
	int score = 0;
	
	boolean up = false, down = false, left = false, right = false;
	
	int accuracy = 0;
	
	public Game() {
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		//Loop
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Visitor TT2 BRK", Font.PLAIN, 48));
		
		if (start) {
			if (set_command) {
				command = (int)(Math.random() * level);
				position1 = ((int)(Math.random()*400));
				position2 = ((int)(Math.random()*400));
				set_command = false;
			}
			
			if ((command == 0 && up) || 
					(command == 1 && down) || 
					(command == 2 && left) || 
					(command == 3 && right) || 
					(command == 4 && (down || left || right)) || 
					(command == 5 && (up || left || right)) || 
					(command == 6 && (up || down || right)) || 
					(command == 7 && (up || down || left)) || 
					(command == 8 && up) || 
					(command == 9 && down) || 
					(command == 10 && left) || 
					(command == 11 && right) || 
					(command == 12 && (down || left || right)) || 
					(command == 13 && (up || left || right)) || 
					(command == 14 && (up || down || right)) || 
					(command == 15 && (up || down || left)) || 
					(command == 16 && up) || 
					(command == 17 && down) || 
					(command == 18 && left) || 
					(command == 19 && right)) {
				score++;
				if (time > 500) {
					score++;
					accuracy = 6;
				}else if (time > 400){
					accuracy = 5;
				}else if (time > 300) {
					accuracy = 4;
				}else if (time > 200) {
					accuracy = 3;
				}else if (time > 100) {
					accuracy = 2;
				}else {
					accuracy = 1;
				}
				set_command = true;
				time = 600;
				up = false; down = false; left = false; right = false;
			}
			
			if ((command == 0 && (down || left || right)) || 
					(command == 1 && (up || left || right)) || 
					(command == 2 && (up || down || right)) || 
					(command == 3 && (up || left || down)) || 
					(command == 4 && up) || 
					(command == 5 && down) || 
					(command == 6 && left) || 
					(command == 7 && right) || 
					(command == 8 && (down || left || right)) || 
					(command == 9 && (up || left || right)) || 
					(command == 10 && (up || down || right)) || 
					(command == 11 && (up || left || down)) || 
					(command == 12 && up) || 
					(command == 13 && down) || 
					(command == 14 && left) || 
					(command == 15 && right) || 
					(command == 16 && (down || left || right)) || 
					(command == 17 && (up || left || right)) || 
					(command == 18 && (up || down || right)) || 
					(command == 19 && (up || left || down))) {
				start = false;
			}
			
			if (score >= 30 && level < 8) {
				level = 8;
			}else if (score >= 60 && level < 12) {
				level = 12;
			}else if (score >= 90 && speed < 4) {
				speed = 4;
			}else if (score >= 120 && level < 16) {
				level = 16;
			}else if (score >= 150 && speed < 5) {
				speed = 5;
			}else if (score >= 180 && speed < 6) {
				speed = 6;
			}
			System.out.println(command);
			switch (command) {
			case 0:
				g2d.drawString("HOCH", 352, 390);
				break;
			case 1:
				g2d.drawString("RUNTER", 328, 390);
				break;
			case 2:
				g2d.drawString("LINKS", 340, 390);
				break;
			case 3:
				g2d.drawString("RECHTS", 328, 390);
				break;
			case 4:
				g2d.drawString("NICHT", 340, 361);
				g2d.drawString("HOCH", 352, 390);
				break;
			case 5:
				g2d.drawString("NICHT", 340, 361);
				g2d.drawString("RUNTER", 328, 390);
				break;
			case 6:
				g2d.drawString("NICHT", 340, 361);
				g2d.drawString("LINKS", 340, 390);
				break;
			case 7:
				g2d.drawString("NICHT", 340, 361);
				g2d.drawString("RECHTS", 328, 390);
				break;
			case 8:
				g2d.drawString("NICHT", 340, 332);
				g2d.drawString("NICHT", 340, 361);
				g2d.drawString("HOCH", 352, 390);
				break;
			case 9:
				g2d.drawString("NICHT", 340, 332);
				g2d.drawString("NICHT", 340, 361);
				g2d.drawString("RUNTER", 328, 390);
				break;
			case 10:
				g2d.drawString("NICHT", 340, 332);
				g2d.drawString("NICHT", 340, 361);
				g2d.drawString("LINKS", 340, 390);
				break;
			case 11:
				g2d.drawString("NICHT", 340, 332);
				g2d.drawString("NICHT", 340, 361);
				g2d.drawString("RECHTS", 328, 390);
				break;
			case 12:
				g2d.drawString("NICHT", 280, 200 + position1);
				g2d.drawString("HOCH", 420, 200 + position2);
				break;
			case 13:
				g2d.drawString("NICHT", 280, 200 + position1);
				g2d.drawString("RUNTER", 420, 200 + position2);
				break;
			case 14:
				g2d.drawString("NICHT", 280, 390 + position1);
				g2d.drawString("LINKS", 420, 200 + position2);
				break;
			case 15:
				g2d.drawString("NICHT", 280, 200 + position1);
				g2d.drawString("RECHTS", 420, 200 + position2);
				break;
			case 16:
				g2d.drawString("NICHT", 280, 200 + position1);
				g2d.drawString("NICHT", 408, 171 + position2);
				g2d.drawString("HOCH", 420, 200 + position2);
				break;
			case 17:
				g2d.drawString("NICHT", 280, 200 + position1);
				g2d.drawString("NICHT", 432, 171 + position2);
				g2d.drawString("RUNTER", 420, 200 + position2);
				break;
			case 18:
				g2d.drawString("NICHT", 280, 200 + position1);
				g2d.drawString("NICHT", 420, 171 + position2);
				g2d.drawString("LINKS", 420, 200 + position2);
				break;
			case 19:
				g2d.drawString("NICHT", 280, 200 + position1);
				g2d.drawString("NICHT", 432, 171 + position2);
				g2d.drawString("RECHTS", 420, 200 + position2);
			}
			
			switch (accuracy) {
			case 6:
				g2d.drawString("PERFEKT!", 98, 734);
				break;
			case 5:
				g2d.drawString("GUT!", 98, 734);
				break;
			case 4:
				g2d.drawString("OK", 98, 734);
				break;
			case 3:
				g2d.drawString("NAH", 98, 734);
				break;
			case 2:
				g2d.drawString("NICHT GUT...", 98, 734);
				break;
			case 1:
				g2d.drawString("SCHLECHT.", 98, 734);
			}
			
			g2d.drawRect(98, 758, 603, 13);
			g2d.fillRect(100, 760, time, 10);
			
			if (time > 0) {
				time -= speed;
			}else {
				start = false;
			}
		}else {
			g2d.drawString("TEST YOUR MIND", 230, 200);
			g2d.drawString("Drücke Enter zum starten", 130, 390);
		}
		g2d.drawString("SCORE: "+score, 10, 30);
	}
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (start == false) {
				score = 0;
				time = 600;
				start = true;
				level = 4;
				speed = 3;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			start = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_P) {
			score += 20;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public static void main(String[] args) {
		Game r = new Game();
		JFrame jf = new JFrame();
		jf.setTitle("Nicht Nicht");
		jf.setSize(width + 6, height + 32);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.add(r);
	}
}