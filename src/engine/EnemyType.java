package engine;

import java.util.ResourceBundle;

public class EnemyType extends Entity{

	private double speed;
	private double health;
	private double points;
	private double money;
	private String collisionEffect;

	
	public EnemyType() {
		//possible hold a resource file that has default values for an enemy
        super.setName(super.getResources().getString("EnemyName"));
		super.setImagePath(super.getResources().getString("EnemyImage"));
		speed = Double.parseDouble(super.getResources().getString("EnemySpeed"));
        health = Double.parseDouble(super.getResources().getString("EnemyHealth"));
        points = Double.parseDouble(super.getResources().getString("EnemyPoints"));
        money = Double.parseDouble(super.getResources().getString("EnemyMoney"));
        collisionEffect = super.getResources().getString("EnemyCollisionEffect");
//		speed = 5;
//		health = 10;
//		points = 50;
//		money = 50;
//        collisionEffect = "normal";

	}
	
	public EnemyType(String name, String imageLocation, double speed, 
			double health, double points, double money, String collisionEffect){
		
		super.setName(name);
		super.setImagePath(imageLocation);
		this.speed = speed; 
		this.health = health; 
		this.points = points; 
		this.money = money; 
		this.collisionEffect = collisionEffect; 
		
	}
	
	public String getName(){
		return super.getName();
	}
	
	public String getImageLocation(){
		return super.getImagePath() ;
	}
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getCollisionEffect() {
		return collisionEffect;
	}
	public void setCollisionEffect(String collisionEffect) {
		this.collisionEffect = collisionEffect;
	}
	
}
