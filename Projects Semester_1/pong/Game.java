package pong;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


//import aight.pong.Display.Kill;
//import aight.pong.objects.Ball;
//import aight.pong.objects.Paddle;
//import aight.pong.render.ColorPanel;

public class Game extends ColorPanel {
	private static final long serialVersionUID = 1L;

	private Ball ball;
	private Paddle paddleP1;
	private Paddle paddleP2;
	private double tickCount;
	private Dimension size;
	private int p1;
	private int p2;
	//private LeaderboardGUI leaderboard;
	private Timer timer;
	private JFrame parent;
	//private Kill kill;

	public Game(Dimension size) {
		super(Color.BLACK);
		verbose = false;
		this.size = new Dimension(size);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		ball = new Ball(new Point(size.width / 2, size.height / 2), 3);
		paddleP1 = new Paddle(new Point(20, 100), KeyEvent.VK_W, KeyEvent.VK_S, 4);
		paddleP2 = new Paddle(new Point(size.width - 30, 100), 4);
		this.drawList.add(ball);
		this.drawList.add(paddleP1);
		this.drawList.add(paddleP2);
		tickCount = 0;
		ball.setDirection(45);
		p1 = 0;
		p2 = 0;
		background = Toolkit.getDefaultToolkit().getImage("src\\Background.png");
		//leaderboard = new LeaderboardGUI("src\\leadeboard.txt");
		timer = new Timer(5, this);
		timer.start();
	}
	
	public void reset() {
		ball = new Ball(new Point(size.width / 2, size.height / 2), 4);
		paddleP1 = new Paddle(new Point(20, 100), KeyEvent.VK_W, KeyEvent.VK_S, 4);
		paddleP2 = new Paddle(new Point(size.width - 30, 100), KeyEvent.VK_UP, KeyEvent.VK_DOWN, 4);
		tickCount = 0;
		this.drawList.clear();
		this.drawList.add(ball);
		this.drawList.add(paddleP1);
		this.drawList.add(paddleP2);
		ball.setDirection(45);
		p1 = 0;
		p2 = 0;
		timer.start();
	}

	public void setParentFrame(JFrame parent) {
		this.parent = parent;
	}
	
	public void render() {
		this.repaint();
	}

	public void tick() {
		
		tickCount++;

		paddleP1.move();
		paddleP2.move();
		ball.move();

		if (paddleP1.getLocation().y < 0) {
			paddleP1.getLocation().y = 0;
		}

		if (paddleP1.getLocation().y + paddleP1.getSize().height > size.height) {
			paddleP1.getLocation().y = size.height - paddleP1.getSize().height;
		}

		if (paddleP2.getLocation().y < 0) {
			paddleP2.getLocation().y = 0;
		}

		if (paddleP2.getLocation().y + paddleP1.getSize().height > size.height) {
			paddleP2.getLocation().y = size.height - paddleP1.getSize().height;
		}

		if (ball.getCenter().getX() - ball.getRadius() < 0) {
			ball.setDirection(ball.getReflectorAngle(90, 0));
			ball.setCenter(new Point(size.width / 2, size.height / 2));
			p2++;
			//Sound.playSound("src\\ping_pong_8bit_beeep.wav");
		}
		if (ball.getCenter().getX() + ball.getRadius() > size.width) {
			ball.setDirection(ball.getReflectorAngle(90, 0));
			ball.setCenter(new Point(size.width / 2, size.height / 2));
			p1++;
			//Sound.playSound("src\\ping_pong_8bit_beeep.wav");
		}
		if (ball.getCenter().getY() - ball.getRadius() < 0) {
			ball.setDirection(ball.getReflectorAngle(0, 0));
			ball.move(new Point(0, -(ball.getCenter().y - ball.getRadius())));
			//Sound.playSound("src\\ping_pong_8bit_plop.wav");
		}
		if (ball.getCenter().getY() + ball.getRadius() > size.height) {
			ball.setDirection(ball.getReflectorAngle(0, 0));
			ball.move(new Point(0, size.height - (ball.getCenter().y + ball.getRadius())));
			//Sound.playSound("src\\ping_pong_8bit_plop.wav");
		}

		paddleP1.calcCollision(ball);
		paddleP2.calcCollision(ball);

		if (p1 >= 5 || p2 >= 5) {
			//Sound.playSound("src\\ping_pong_8bit_peeeeeep.wav");
			timer.stop();
			if (p1 > p2) {
				String name = JOptionPane.showInputDialog("Player 1 Wins! What is your name?");
				//leaderboard.addPlayer(new Player(name, (int) tickCount));
			} else if (p2 > p1) {
				String name = JOptionPane.showInputDialog("Player 2 Wins! What is your name?");
				//leaderboard.addPlayer(new Player(name, (int) tickCount));
			}
			//leaderboard.display(parent);
			String[] options = {"Yes", "No"};
			int playAgain = JOptionPane.showOptionDialog(parent, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (playAgain == JOptionPane.YES_OPTION) {
				reset();
			} else {
				//kill.killThread();
				parent.dispose();
				
				 
		
				  
				
				System.out.println("1)Pranav\n"
						+ "2)John\n"
						+ "3)Funboi\n"
						+ "4)Kummer\n"
						+ "5)Kevin\n"
						+ "6)Arav\n"
						+ "7)JimBo\n"
						+ "8)Keshav\n"
						+ "9)WatchMan\n"
						+ "10)Timer");
			}
		}
	}
	
//	public void setKillThread(Kill kill) {
//		this.kill = kill;
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tick();
	}
}