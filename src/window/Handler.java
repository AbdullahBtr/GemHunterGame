package window;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import entity.GameObject;
import entity.ObjectID;

public class Handler {

	public ArrayList<GameObject> objects = new ArrayList<GameObject>();
	public ArrayList<GameObject> bullets = new ArrayList<GameObject>();
	public ArrayList<GameObject> items = new ArrayList<GameObject>();
	public ArrayList<GameObject> objectToAdd = new ArrayList<GameObject>();
	// public ArrayList<GameObject> enemy = new ArrayList<GameObject>();
	private GameObject tempObject;

	public void tick() {
		// damit kein concurrentmodification exception kommt
		this.bullets.addAll(objectToAdd);
		this.objectToAdd.clear();
		for (GameObject bulletss : bullets) {
			bulletss.tick(bullets);
		}

		for (GameObject objectt : objects) {
			objectt.tick(objects);
		}

		for (GameObject objectt : items) {
			objectt.tick(items);
		}

		for (GameObject element : new ArrayList<GameObject>(objects)) {
			if (element.getID().equals(ObjectID.Enemy))
				if (element.isRemove() == true) {
					objects.remove(element);
				}

		}

		for (GameObject element : new ArrayList<GameObject>(bullets)) {
			if (element.isVisible() == false) {

				bullets.remove(element);
			}
		}
		for (GameObject element : new ArrayList<GameObject>(items)) {
			if (element.getID().equals(ObjectID.Gem))
				if (element.isRemove() == true) {
					items.remove(element);
				}
		}

	}

	public void render(Graphics g) {

		for (GameObject o : objects) {
			o.render(g);

		}
		for (GameObject o : items) {
			o.render(g);

		}

		for (int i = 0; i < bullets.size(); i++) {
			tempObject = bullets.get(i);
			tempObject.render(g);

			/**
			 * andere variante for(GameObject o: object){ o.render(g);
			 */

		}

	}

	public void addObject(GameObject object) {

		this.objects.add(object);

	}

	public void addBullet(GameObject object) {

		this.objectToAdd.add(object);
	}

	public void addItem(GameObject object) {
		this.items.add(object);
	}

	public void removeAll() {
		this.objects.clear();
	}

	public int sizeOfObject(ObjectID id) {
		int count = 0;
		for (GameObject object : objects) {
			if (object.getID().equals(id)) {
				count++;
			}
		}
		return count;
	}

	// public void createLevel() {
	//
	// for (int xx = 0; xx < Game.WIDTH + 32; xx += 32)
	//
	// addObject(new Tree(xx, Game.HEIGHT - 32, ObjectID.Tree));
	// for (int yy = 0; yy < Game.WIDTH + 32; yy += 32)
	// addObject(new Tree(Game.HEIGHT + 166, yy, ObjectID.Tree));
	// for (int zz = 0; zz < Game.WIDTH + 32; zz += 32)
	// addObject(new Tree(Game.HEIGHT - 609, zz, ObjectID.Tree));
	// for (int ww = 192; ww < Game.WIDTH - 256; ww += 32)
	// addObject(new Tree(ww, Game.HEIGHT - 192, ObjectID.Tree));
	//
	// }

	/*
	 * for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
	 * String value = iterator.next(); if (value.length() > 5) { iterator.remove();
	 * } }
	 */

}
