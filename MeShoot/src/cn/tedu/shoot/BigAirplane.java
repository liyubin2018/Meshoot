package cn.tedu.shoot;

/**
 * 大敌机
 * 
 * @author liyub
 *
 */
public class BigAirplane extends FlyingObject {
	private int speed;// 移动速度

	public BigAirplane() {
		super(69, 99);
		speed = 1;
	}
	public void step() {
		System.out.println("大敌机的y坐标移动了:"+speed);
	}
}
