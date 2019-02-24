package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 子弹
 * 
 * @author liyub
 *
 */
public class Bullet extends FlyingObject {
	private static BufferedImage image;
	static {
		image = loadImage("bullet.png");
	}
	private int speed=3;

	public Bullet(int x, int y) {
		super(8, 14, x, y);
		speed = 3;

	}
	
	/**子弹移动*/
	public void step() {
		y-=speed;//向上移动
	}

	/** 重写getImage()方法，获取图片 */
	public BufferedImage getImage() {
		if (isLife()) {
			return image;
		} else if (isDead()) {
			state = REMOVE;
		}
		return null;
	}
}
