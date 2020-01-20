package entity;

public abstract class Weapon {
	
	
	protected float x,y;
	protected float damage;
	protected float defense;
	protected boolean attacking=false;
	protected boolean visible;
	protected WeaponID id;
	protected String name;
	
	public Weapon(String name,float x, float y,WeaponID id) {
		this.name=name;
		this.x=x;
		this.y=y;
		this.id=id;
		
	}
	
	
	
	
}
