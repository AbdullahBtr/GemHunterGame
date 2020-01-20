package window;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entity.Camera;
import entity.GameObject;
import entity.ObjectID;
import object.Bullet;

public class MouseInput extends MouseAdapter {
	
	private Handler handler;
	private Camera camera;
	
	public MouseInput(Handler handler,Camera camera) {
		this.handler=handler;
		this.camera=camera;
	}
	
	public void mousePressed(MouseEvent e) {
	int mx= (int)(e.getX()+camera.getX());	
	int my= (int)(e.getY()+camera.getY());	
	
	for (GameObject object : handler.objects) {
		if (object.getID().equals(ObjectID.Player)) {

			handler.addBullet(new Bullet(object.getX() + 16, object.getY() + 16, ObjectID.Bow, handler,mx,my));
		}
	}
	}

}
