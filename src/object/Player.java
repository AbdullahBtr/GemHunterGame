package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import entity.Camera;
import entity.GameObject;
import entity.ObjectID;
import entity.ObjectStats;
import window.Animation;
import window.Game;
import window.Handler;
import window.Texture;

public class Player extends GameObject {

	// bereite und höhe des Rechtecks der das Object umhüllt für Collisin in
	// getBounds
	private float width = 32, height = 64;
	private float gravity = 0.02f;
	private Handler handler;
	private Texture tex = Game.getInstance();
	private Animation playerA, playerD, playerW, playerS;
	public static int score=0;
	ObjectStats stat;

	public Player(float x, float y, Handler handler, ObjectID id) {
		super(x, y, id);
		this.handler = handler;
		playerW = new Animation(10, tex.playerW.get(1), tex.playerW.get(2));
		playerS = new Animation(10, tex.playerS.get(1), tex.playerS.get(2));
		playerA = new Animation(10, tex.playerA.get(1), tex.playerA.get(2));
		playerD = new Animation(10, tex.playerD.get(1), tex.playerD.get(2));
		stat= new ObjectStats();


	}


	@Override
	public void tick(ArrayList<GameObject> object) {
		facingFigur();
		playerMovement();
		collisionGem();
		collision(object);

		playerW.runAnimation();
		playerS.runAnimation();
		playerA.runAnimation();
		playerD.runAnimation();

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		if ((this.x > -Camera.getX() + Game.WIDTH) || (this.x < -Camera.getX() - 32)
				|| (this.y > -Camera.getY() + Game.HEIGHT) || (this.y < -Camera.getY() - 32)) {
		} else {
			if (velX != 0 || velY != 0) {
				switch (facing) {

				case 1:
					playerD.drawAnimation(g, (int) x, (int) y, 24, 32);
					break;
				case -1:
					playerA.drawAnimation(g, (int) x, (int) y, 24, 32);
					break;
				case 2:
					playerW.drawAnimation(g, (int) x, (int) y, 24, 32);
					break;
				case -2:
					playerS.drawAnimation(g, (int) x, (int) y, 24, 32);
					break;
				}
			} else {

				switch (facing) {

				case 1:
					g.drawImage(tex.playerD.get(0), (int) x, (int) y, null);
					break;
				case -1:
					g.drawImage(tex.playerA.get(0), (int) x, (int) y, null);
					break;
				case 2:
					g.drawImage(tex.playerW.get(0), (int) x, (int) y, null);
					break;
				case -2:
					g.drawImage(tex.playerS.get(0), (int) x, (int) y, null);
					break;
				}

			}
		}

	}

	

	public void playerMovement() {
		x += velX;
		y += velY;

		if (jumping || falling) {
			velY += gravity;

		}

	}
	
	// Collision

	private void collision(List<GameObject> object) {

		for (GameObject objectt : handler.objects) {

			if (objectt.getID().equals(ObjectID.Tree) || objectt.getID().equals(ObjectID.Block)) {

				if (getBoundsTOP().intersects(objectt.getBounds())) {
					y = objectt.getY() + (height / 2);
					velY = 0;

				}

				if (getBounds().intersects(objectt.getBounds())) {
					y = objectt.getY() - height;
					velY = 0;

				} else {

				}

				if (getBoundsRIGHT().intersects(objectt.getBounds())) {
					x = objectt.getX() - width;

				}
				if (getBoundsLEFT().intersects(objectt.getBounds())) {
					x = objectt.getX() + width;

				}

			}

		}

	}

	private void collisionGem() {
		for (GameObject objectt : handler.items) {
			if (objectt.getID().equals(ObjectID.Gem)) {
				if (getBoundsTOP().intersects(objectt.getBounds())) {
					score+=50;
					
					objectt.setRemove(true);
				}
			}

		}
	}
	


	public void facingFigur() {
		if (velX < 0) {
			facing = -1;
		} else if (velX > 0) {
			facing = 1;
		}

		if (velY < 0) {
			facing = 2;
		} else if (velY > 0) {
			facing = -2;
		}

	}
	


	public Rectangle getBounds() {
		return new Rectangle((int) ((int) x + (width / 2) - width / 4), (int) ((int) y + (height / 2)), (int) width / 2,
				(int) height / 2);
	}

	public Rectangle getBoundsTOP() {
		return new Rectangle((int) ((int) x + (width / 4)), (int) y, (int) width / 2, (int) height / 2);
	}

	public Rectangle getBoundsRIGHT() {
		return new Rectangle((int) ((int) x + width - 5), (int) y + 5, (int) 5, (int) height - 10);
	}

	public Rectangle getBoundsLEFT() {
		return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);
	}

}
