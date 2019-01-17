package cn.tedu.shoot;

/**
 * 天空
 * 
 * @author liyub
 *
 */
public class Sky extends FlyingObject {
	int y1;// y1坐标(图片轮换)
	int speed;

	Sky() {
		super(400, 700, 0, 0);
		speed = 1;
		y1 = -height;
	}
}
