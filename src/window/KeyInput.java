package window;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import entity.GameObject;
import entity.ObjectID;
import object.Bullet;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	public int direction;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (GameObject object : handler.objects) {
			if (object.getID().equals(ObjectID.Player)) {
				if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
					object.setVelX(2);
					direction = 1;
				}

				if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
					object.setVelX(-2);
					direction = -1;
				}

				if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
					object.setVelY(-2);
					direction = 2;
				}
				if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
					object.setVelY(2);
					direction = -2;
				}

				if (key == KeyEvent.VK_SPACE) {
					handler.addBullet(
							new Bullet(object.getX() + 7, object.getY() + 10, ObjectID.Bow, handler, direction));

				}
			}
		}
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(-1);
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (GameObject object : handler.objects) {
			if (key == KeyEvent.VK_D || 
					key == KeyEvent.VK_RIGHT && object.getVelX() > 0)
				object.setVelX(0);

			if (key == KeyEvent.VK_A || 
					key == KeyEvent.VK_LEFT && object.getVelX() < 0)
				object.setVelX(0);

			if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W && object.getVelY() < 0) {
				object.setVelY(0);
			}
			if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S && object.getVelY() > 0) {
				object.setVelY(0);
			}

		}
	}
	
}

	

	