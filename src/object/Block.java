package object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import entity.Camera;
import entity.GameObject;
import entity.ObjectID;
import window.Game;
import window.Texture;

public class Block extends GameObject {
	
	Texture tex=Game.getInstance();
	int type;

	public Block(float x, float y,int type, ObjectID id) {
		super(x, y, id);
		this.type=type;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(ArrayList<GameObject> object) {

	}

	@Override
	public void render(Graphics g) {
		// Cull blocks outside the screen to increase FPS
		if ((this.x > -Camera.getX() + Game.WIDTH) || (this.x < -Camera.getX() - 32)
				|| (this.y > -Camera.getY() + Game.HEIGHT) || (this.y < -Camera.getY() - 32)) {
		} else {
			g.drawImage(tex.block.get(type), (int) x, (int) y, null);
		}
		g.drawImage(tex.block.get(type), (int) x, (int) y, null);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, 32, 32);
	}

}
