package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class GameObject {

	protected float x, y;
	protected boolean jumping = false, falling = false;
	protected float velX, velY;
	protected ObjectID ID;
	protected int facing=1;
	protected boolean attacking=false, visible;
	protected float hp;
	protected boolean remove=false;

	public GameObject(float x, float y, ObjectID id) {
		this.x = x;
		this.y = y;
		this.ID = id;

	}

	// abstract methods to us in subclass
	//////////////////////////////////////////////////
	public abstract void tick(ArrayList<GameObject> object);

	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();
	///////////////////////////////////////////////////
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public boolean isRunning() {
		return falling;
	}

	public void setRunning(boolean falling) {
		this.falling = falling;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public ObjectID getID() {
		return ID;
	}

	public void setID(ObjectID iD) {
		ID = iD;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public int getFacing() {
		return facing;
	}

	public void setFacing(int facing) {
		this.facing = facing;
	}

	public boolean isAttacking() {
		return attacking;
	}

	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}



	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}


}
