package entity;

import java.awt.Component;

import window.Game;

public class Camera {

	private static float x;
	private static float y;

	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void tick(Object player) {
		// smooth camera linear alghorithm
		if (player instanceof GameObject) {
			int targetX = (int) (-((GameObject) player).getX() + Game.WIDTH / 2 + 16);
			int targetY = (int) (-((GameObject) player).getY() + Game.HEIGHT / 2 + 64);

			// 0.1 constant factor experiment with it to change the effect!!!!
			x += (targetX - x) * 0.1;
			y += (targetY - y) * 0.1;
		} 

	}

	public static float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public static float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
