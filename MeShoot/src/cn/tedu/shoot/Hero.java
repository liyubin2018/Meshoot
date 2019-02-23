package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 
 * @author liyub 英雄机
 */
public class Hero extends FlyingObject {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[6];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("hero" + i + ".png");
		}
	}
	private int life;// 生命
	private int doublefire;

	public Hero() {
		super(97, 124, 140, 400);
		this.life = 3;
		this.doublefire = 0;
	}

	/**
	 * 英雄机随着鼠标的移动，鼠标的坐标x，y；
	 * 
	 * @param x
	 * @param y
	 */
	public void moveTo(int x, int y) {
		System.out.println("英雄机移动了!");
	}

	public void step() {
		System.out.println("英雄机切换图片啦");
	}

	private int index = 0;// 活着的下标
	private int deadIndex = 2;// 死了的下标

	/** 重写getImage()方法，获取图片 */
	public BufferedImage getImage() {
		if (isLife()) {// 如果活着，切换两张图片
			return images[index++ % 2];
		} else if (isDead()) {// 如果死亡
			BufferedImage img = images[deadIndex++];
			if (deadIndex == images.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;
	}

}