package cn.tedu.shoot;

/**
 * 小敌机
 * 
 * @author liyub
 *
 */
public class Airplane extends FlyingObject {
	int speed;// 移动速度

	Airplane() {
		super(49, 36);
		speed = 1;
	}
	void step() {
		System.out.println("小敌机的y坐标移动了：！"+speed);
	}

}
