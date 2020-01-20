package object;

import java.util.ArrayList;

import entity.GameObject;
import entity.ObjectStats;
import entity.ObjectID;
import entity.Util;
import window.Game;
import window.Handler;

public class EnemyA extends Enemy {

	public EnemyA(float x, float y, ObjectID id, Handler handler, int type) {
		super(x, y, id, handler, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void observe() {

		ArrayList<GameObject> objects = sphiereCollide(x, y, 120);
		for (GameObject object : objects) {
			if (object.getID().equals(ObjectID.Player)) {
				target = object;
			}
		}
	}

	@Override
	protected void chase() {

		float speedX = target.getX() - x;
		float speedY = target.getY() - y;

		// damping speed of enemy
		float maxSpeed = 5 * DAMPING;

		if (speedX > maxSpeed) {
			speedX = maxSpeed;
		}
		if (speedX < -maxSpeed) {
			speedX = -maxSpeed;
		}
		if (speedY > maxSpeed) {
			speedY = maxSpeed;
		}
		if (speedY < -maxSpeed) {
			speedY = -maxSpeed;
		}

		x += speedX;
		y += speedY;
	}

	@Override
	protected void attack() {
		if (Util.LineOfSight(this, target) && Game.distance(x, y, target.getX(), target.getY()) <= Enemy.MELEE_RANGE) {

			ObjectStats.HEALTH--;

		}

	}

	@Override
	protected void death() {
		for (GameObject object : handler.bullets) {
			if (object.getID().equals(ObjectID.Bow)) {
				if (Game.distance(object.getX(), object.getY(), x, y) < 15f) {
					remove = true;

				}
			}
		}

	}

}
