package cn.tedu.shoot;

/**
 * 子弹
 * 
 * @author liyub
 *
 */
public class Bullet extends FlyingObject {
	private int speed;

	public Bullet(int x, int y) {
		super(8, 14, x, y);
		speed = 3;

	}
	public void step() {
		System.out.println("子弹的有坐标移动了："+speed);
	}
}
