import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game  extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	
	private boolean isRunning = false;
	private Thread thread;

	public Game() {
		new Window(1000, 563, "Jeu2D", this);
		start();
	}
	
	public void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfThicks = 60.0;
		double ns = 1000000000 / amountOfThicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				thick();
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	
	public void thick() {
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		/////////////////////////////////
		
		g.setColor(Color.red);
		g.fillRect(0, 0, 1000, 563);
		
		/////////////////////////////////
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game();
	}

}
