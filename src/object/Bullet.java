package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import entity.GameObject;
import entity.ObjectID;
import window.Game;
import window.Handler;
import window.KeyInput;

public class Bullet extends GameObject {
	private final float SPEED = 5;
	private Handler handler;
	public int direction;
	private static final int BOARD_WIDTH=2000;

	public Bullet(float x, float y, ObjectID id, Handler handler, int direction) {
		super(x, y, id);
		this.handler = handler;
		this.direction = direction;
		this.visible=true;
	}
	public Bullet(float x, float y, ObjectID id, Handler handler,int mx,int my) {
		super(x, y, id);
		this.handler = handler;
		this.visible=true;
		velX=(mx-x)/10;
		velY=(my-y)/10;
	}

	@Override
	public void tick(ArrayList<GameObject> object) {
		for (GameObject objectt : handler.objects) {
			if (objectt.getID().equals(ObjectID.Player)) {
				if (!objectt.isAttacking()) {

					switch (direction) {
					case 1:

						x += SPEED;
						break;

					case -1:
						x -= SPEED;
						break;
					case 2:
						y -= SPEED;
						break;
					case -2:
						y += SPEED;
						break;

					// 1=right -1=left 2=up -2=down
					}
				
					if (x< 0 || x>2000 || y<0) {
						
						visible = false;
					}
					
				}
			}
		}

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, 10, 10);
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,32,32);
	}


}
