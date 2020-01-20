package object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import entity.Camera;
import entity.GameObject;
import entity.ObjectID;
import window.Game;
import window.Texture;

public class Gems extends GameObject {
	Texture tex = Game.getInstance();

	public Gems(float x, float y, ObjectID id) {
		super(x, y, id);

	}

	@Override
	public void tick(ArrayList<GameObject> object) {

	}

	@Override
	public void render(Graphics g) {
		// Cut blocks outside the screen to increase FPS
		if ((this.x > -Camera.getX() + Game.WIDTH) || (this.x < -Camera.getX() - 32)
				|| (this.y > -Camera.getY() + Game.HEIGHT) || (this.y < -Camera.getY() - 32)) {
		} else {// hier background ändern können
			g.drawImage(tex.ground.get(0), (int) x, (int) y, null);
		}
		g.drawImage(tex.gems.get(0), (int) x, (int) y, null);

	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, 32, 32);
	}


}
