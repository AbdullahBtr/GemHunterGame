package window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import entity.Camera;
import entity.GameObject;
import entity.ObjectStats;
import entity.ObjectID;
import object.Block;
import object.Enemy;
import object.EnemyA;
import object.Gems;
import object.Ground;
import object.Player;
import object.Tree;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean running = false;
	private Thread thread;
	private static Handler handler;
	Random rand = new Random();
	public static int WIDTH, HEIGHT;
	private Camera cam;
	BufferedImage level1 = null, level2 = null, level3 = null;
	private static Texture tex;
	private  ObjectStats life;
	private int frames;
	

	private void init() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		tex = new Texture();
		BufferedImageLoader loader = new BufferedImageLoader();
		level1 = loader.loadImage("/level1.png");

		handler = new Handler();
		cam = new Camera(0, 0);
		// handler.addObject(new Player(100,100,handler,ObjectID.Player));
		// handler.createLevel();
		this.addKeyListener(new KeyInput(handler));
		// this.addMouseListener(new MouseInput(handler,cam));
		loadImageLevel(level1);

	}

	public synchronized void start() {

		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		this.requestFocus();
		init();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 100) {
				timer += 1000;
				System.out.println("FPS " + frames + " Ticks " + updates);
				frames = 0;
				updates = 0;

			}

		}

	}

	private void tick() {
		handler.tick();
		for (GameObject object : handler.objects) {
			if (object.getID().equals(ObjectID.Player))
				cam.tick(object);
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		// zeichnen der componenten
		///////////////////////////////

		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());

		g2d.translate(cam.getX(), cam.getY());

		handler.render(g);

		g2d.translate(-cam.getX(), -cam.getY());

		//////////////////////////////
		// cause the buffer that you just drew to become the current buffer for the
		////////////////////////////// JFrame
		//////////////////////////////
		g.setColor(Color.GRAY);
		g.fillRect(10, 10, 200, 32);
		g.setColor(Color.GREEN);
		g.fillRect(10, 10, ObjectStats.HEALTH, 32);
		g.setColor(Color.WHITE);
		g.drawRect(10, 10, 200, 32);
		g.setColor(Color.white);
		g.drawString("Score: "+Player.score+" ", 20, 60);
		g.dispose();
		bs.show();
		

	}

	private void loadImageLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int pixel = image.getRGB(i, j);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;

				// Rand
				if (red == 255 && green == 255 && blue == 255) {

					handler.addObject(new Block(i * 32, j * 32, 0, ObjectID.Block));
				}
				if (red == 0 && green == 255 && blue == 0) {

					handler.addObject(new Block(i * 32, j * 32, 1, ObjectID.Block));
				}

				// Player
				if (red == 255 && green == 0 && blue == 170) {
					handler.addObject(new Player(i * 32, j * 32, handler, ObjectID.Player));
				}
				// Tree
				if (red == 0 && green == 255 && blue == 33) {
					handler.addObject(new Tree(i * 32, j * 32, 0, ObjectID.Tree));
				}
				// Ground
				if (red == 0 && green == 150 && blue == 200) {
					handler.addObject(new Ground(i * 32, j * 32, 2, ObjectID.Ground));
				}
				if (red == 100 && green == 100 && blue == 0) {
					handler.addObject(new Ground(i * 32, j * 32, 0, ObjectID.Ground));
				}
				if (red == 0 && green == 100 && blue == 100) {
					handler.addObject(new Ground(i * 32, j * 32, 1, ObjectID.Ground));
				}

				// Gems
				if (red == 0 && green == 0 && blue == 255) {
					handler.addItem(new Gems(i * 32, j * 32, ObjectID.Gem));
				}
				
				//Enemy
				if (red == 255 && green == 0 && blue == 0) {
					handler.addObject(new EnemyA(i * 32, j * 32, ObjectID.Enemy,handler,1));
				}
			}

		}
	}

	// methode damit health bar wenns wneiger wird nicht aus rechteck geht
	public static int clamp(int variable, int min, int max) {

		if (variable >= max) {
			return variable = max;
		} else if (variable <= min) {
			return variable = min;
		} else {
			return variable;
		}
	}

	public static Texture getInstance() {

		return tex;
	}



	public static float distance(float x1, float y1, float x2, float y2) {

		double x = x2 - x1;
		double y = y2 - y1;

		return (float) Math.sqrt((x * x) + (y * y));

	}
	

	public static void main(String[] args) {
		Window window = new Window(1200, 600, new Game());

	}

}
