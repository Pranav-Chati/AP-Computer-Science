//package PongProj;
package pong;

import java.awt.Dimension;

import javax.swing.JFrame;
//import PongProj.render.ColorPanel;

public class Display implements Runnable{
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Pong";
	
	private Thread thread;
	private boolean running = false;
	private Game game;
	
	
	public Display() {
		Dimension size = new Dimension(WIDTH,HEIGHT);
		game = new Game(size);
	}
	
	private void start() {
		if (running)
			return;
		running = true;
		//game.setKillThread(new Kill());
		thread = new Thread(this);
		thread.start();
	}

	private void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	@Override
	public void run() {
		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;
		//boolean ticked = false;
		
		
		
		while(running) {
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			
			while (unprocessedSeconds > secondsPerTick) {
				unprocessedSeconds -= secondsPerTick;
				//game.tick();
				//ticked = true;
				tickCount++;
				if (tickCount % 60 == 0) {
					//System.out.println(frames + " fps");
					previousTime += 1000;
					frames = 0;
				}
			}
			game.render();
			frames++;
		}
	}
	
	public class Kill {
		public void killThread() {
			stop();
		}
	}
	
	public static void main(String[] args) {
		Display pong = new Display();
		JFrame frame = new JFrame();
		frame.add(pong.game);
		frame.pack();
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		System.out.println("Running");

		pong.game.setParentFrame(frame);
		frame.addKeyListener(pong.game);
		
		pong.start();
	}
}
