package cn.tedu.shoot;

/**
 * 子弹
 * 
 * @author liyub
 *
 */
public class Bullet extends FlyingObject {
	int speed;

	Bullet(int x, int y) {
		super(8, 14, x, y);
		speed = 3;

	}
}
