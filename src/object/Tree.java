package object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import entity.Camera;
import entity.GameObject;
import entity.ObjectID;
import window.Game;
import window.Texture;

public class Tree extends GameObject {

	Texture tex= Game.getInstance();
	int type;
			
	
	public Tree(float x, float y,int type, ObjectID id) {
		super(x, y, id);
		this.type=type;
	}

	@Override
	public void tick(ArrayList<GameObject> object) {
		
		
	}

	@Override
	public void render(Graphics g) {
		if ((this.x > -Camera.getX() + Game.WIDTH) || (this.x < -Camera.getX() - 32)
				|| (this.y > -Camera.getY() + Game.HEIGHT) || (this.y < -Camera.getY() - 32)) {
		} else {
			g.drawImage(tex.tree.get(type), (int) x, (int) y, null);
		}
		g.drawImage(tex.tree.get(type), (int) x, (int) y, null);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		 return new Rectangle((int) x, (int) y, 32, 32);
	}

}
