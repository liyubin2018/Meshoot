package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 大敌机
 * 
 * @author liyub
 *
 */
public class BigAirplane extends FlyingObject implements Enemy {
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
		speed = 2;
	}

	public void step() {
		y += speed;// 大敌机向下移动
	}

	@Override // 重写outOfBounds方法
	public boolean outOfBounds() {
		return this.y >= World.HEIGTH;

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

	/** 重写getScore方法 */
	public int getScore() {

		return 3;
	}

}
