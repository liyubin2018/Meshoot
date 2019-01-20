package cn.tedu.shoot;

/**
 * 天空
 * 
 * @author liyub
 *
 */
public class Sky extends FlyingObject {
	private int y1;// y1坐标(图片轮换)
	private int speed;

	public Sky() {
		super(400, 700, 0, 0);
		speed = 1;
		y1 = -height;
	}
	public void step() {
		System.out.println("天空移动了："+speed);
	}
}
