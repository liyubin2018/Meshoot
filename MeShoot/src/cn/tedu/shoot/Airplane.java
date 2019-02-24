package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 小敌机
 * 
 * @author liyub
 *
 */
public class Airplane extends FlyingObject {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("airplane" + i + ".png");
		}
	}
	private int speed;// 移动速度

	public Airplane() {
		super(49, 36);
		speed = 1;
	}

	public void step() {
		y+=speed;//小敌机向下移动
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
