package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 大敌机
 * 
 * @author liyub
 *
 */
public class BigAirplane extends FlyingObject {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("bigplane" + i + ".png");
		}
	}
	private int speed;// 移动速度

	public BigAirplane() {
		super(69, 99);
		speed = 1;
	}

	public void step() {
		System.out.println("大敌机的y坐标移动了:" + speed);
	}

	/** 重写getImage()方法，获取图片 */
	private int deadIndex = 1;

	public BufferedImage getImage() {
		if (isLife()) {
			return images[0];
		} else if (isDead()) {
			BufferedImage img = images[deadIndex++];
			if (deadIndex == images.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;
	}

}
