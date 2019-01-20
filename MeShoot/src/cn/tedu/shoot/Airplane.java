package cn.tedu.shoot;

/**
 * 小敌机
 * 
 * @author liyub
 *
 */
public class Airplane extends FlyingObject {
	private int speed;// 移动速度

	public Airplane() {
		super(49, 36);
		speed = 1;
	}
	public void step() {
		System.out.println("小敌机的y坐标移动了：！"+speed);
	}

}
