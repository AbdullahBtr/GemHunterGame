package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import entity.GameObject;
import entity.ObjectID;
import entity.Util;
import window.Game;
import window.Handler;
import window.Texture;

public class Enemy extends GameObject {

	protected Handler handler;
	protected Texture tex = Game.getInstance();
	protected GameObject target;
	protected int type;
	protected static final float DAMPING = 0.2f;// speed of enemy
	protected static final float MELEE_RANGE = 20f;
	protected static final float RANGED_RANGE = 96f;

	public Enemy(float x, float y, ObjectID id, Handler handler, int type) {
		super(x, y, id);
		this.handler = handler;
		this.type = type;
		target = null;
	}

	@Override
	public void tick(ArrayList<GameObject> object) {
		if (target == null) {
			observe();
		} else {

			if (Util.LineOfSight(this, target)
					&& Game.distance(x, y, target.getX(), target.getY()) <= this.MELEE_RANGE) {
				attack();
			} else {
				chase();
			}
			
		}
		death();

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, 32, 32);
	}

	protected void attack() {

	}

	protected void observe() {

	}

	protected void chase() {
		// TODO Auto-generated method stub

	}

	protected ArrayList<GameObject> sphiereCollide(float x, float y, float radius) {
		ArrayList<GameObject> result = new ArrayList<GameObject>();

		for (GameObject object : handler.objects) {
			if (object.getID().equals(ObjectID.Player)) {
				if (Game.distance(object.getX(), object.getY(), x, y) < radius) {
					result.add(object);

				}
			}
		}

		return result;
	}

	protected void death() {


	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, 32, 32);
	}

}
